package com.example.coinpaprika.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coinpaprika.CoinpaprikaApplication
import com.example.coinpaprika.presentation.coin_detail.CoinDetailViewModel
import com.example.coinpaprika.presentation.coin_detail.components.CoinDetailScreen
import com.example.coinpaprika.presentation.coin_list.CoinListScreen
import com.example.coinpaprika.presentation.coin_list.CoinListViewModel
import com.example.coinpaprika.presentation.theme.CoinpaprikaTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var coinListViewModel: CoinListViewModel

    @Inject
    lateinit var coinDetailViewModel: CoinDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inject
        (applicationContext as CoinpaprikaApplication).applicationComponent.inject(this)

        setContent {
            CoinpaprikaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController, coinListViewModel)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route+"/{coinId}"
                        ) {
                           CoinDetailScreen(viewModel = coinDetailViewModel)
                        }
                    }
                }
            }
        }
    }
}

