package com.example.coinpaprika.domain.use_case.get_coin

import com.example.coinpaprika.common.Resource
import com.example.coinpaprika.data.remote.dto.toCoinDetail
import com.example.coinpaprika.domain.model.CoinDetail
import com.example.coinpaprika.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<List<CoinDetail>>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).map { it.toCoinDetail() }
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Check your internet connection"))
        }
    }
}