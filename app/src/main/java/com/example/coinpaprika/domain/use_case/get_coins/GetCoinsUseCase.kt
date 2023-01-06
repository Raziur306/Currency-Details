package com.example.coinpaprika.domain.use_case.get_coins

import com.example.coinpaprika.common.Resource
import com.example.coinpaprika.data.remote.dto.toCoin
import com.example.coinpaprika.domain.model.Coin
import com.example.coinpaprika.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.Response
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins()?.map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: IOException) {
            emit(Resource.Error("Check your internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}