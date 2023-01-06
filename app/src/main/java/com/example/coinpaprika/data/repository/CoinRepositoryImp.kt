package com.example.coinpaprika.data.repository

import com.example.coinpaprika.data.remote.Api
import com.example.coinpaprika.data.remote.dto.CoinDetailDto
import com.example.coinpaprika.data.remote.dto.CoinDto
import com.example.coinpaprika.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(private val api: Api) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): List<CoinDetailDto> {
        return api.getCoinById(coinId)
    }
}