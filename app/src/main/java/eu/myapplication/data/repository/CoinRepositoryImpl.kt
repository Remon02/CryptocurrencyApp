package eu.myapplication.data.repository

import eu.myapplication.data.remote.CoinPaprikaApi
import eu.myapplication.data.remote.dto.CoinDetailDto
import eu.myapplication.data.remote.dto.CoinDto
import eu.myapplication.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}