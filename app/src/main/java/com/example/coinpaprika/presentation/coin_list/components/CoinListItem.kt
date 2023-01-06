package com.example.coinpaprika.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.coinpaprika.domain.model.Coin

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(20.dp),

        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "${coin.rank}. ${coin.name} (${coin.symbol})", overflow = TextOverflow.Ellipsis)
        Text(
            text = if (coin.is_active) "Active" else "Inactive",
            color = if (coin.is_active) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.align(alignment = Alignment.CenterVertically)
        )
    }
}