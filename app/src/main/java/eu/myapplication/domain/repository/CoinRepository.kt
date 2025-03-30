package eu.myapplication.domain.repository

import eu.myapplication.data.remote.dto.CoinDetailDto
import eu.myapplication.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId:String):CoinDetailDto
}