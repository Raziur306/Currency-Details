package com.example.coinpaprika.presentation.coin_detail

import com.example.coinpaprika.domain.model.CoinDetail


data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val errorMessage: String = ""
)
