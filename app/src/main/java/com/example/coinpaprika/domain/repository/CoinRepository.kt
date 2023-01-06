package com.example.coinpaprika.domain.repository

import com.example.coinpaprika.data.remote.dto.CoinDetailDto
import com.example.coinpaprika.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): List<CoinDetailDto>
}