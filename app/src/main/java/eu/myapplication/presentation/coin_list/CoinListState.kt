package eu.myapplication.presentation.coin_list

import eu.myapplication.domain.model.Coin

data class CoinListState(
    val isLoading:Boolean =false,
    val coins : List<Coin> =emptyList(),
    val error:String = ""
)
