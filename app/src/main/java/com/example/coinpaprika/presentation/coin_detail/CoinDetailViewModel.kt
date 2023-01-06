package com.example.coinpaprika.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinpaprika.common.Constants.PARAM_COIN_ID
import com.example.coinpaprika.common.Resource
import com.example.coinpaprika.domain.model.CoinDetail
import com.example.coinpaprika.domain.use_case.get_coin.GetCoinUseCase
import com.example.coinpaprika.presentation.coin_list.CoinListState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CoinDetailViewModel @Inject constructor(
    private val coinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {
    private val _state = mutableStateOf<CoinDetailState>(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        coinUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = result.data)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(
                        errorMessage = result.message ?: "An unexpected error occurred."
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}