package com.example.coinpaprika.presentation.coin_list

import com.example.coinpaprika.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val coinList: List<Coin> = emptyList()
)
