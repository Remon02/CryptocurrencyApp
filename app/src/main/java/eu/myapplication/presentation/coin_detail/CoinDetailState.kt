package eu.myapplication.presentation.coin_detail

import eu.myapplication.domain.model.Coin
import eu.myapplication.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
