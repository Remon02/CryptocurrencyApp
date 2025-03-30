package eu.myapplication.domain.use_case.get_coins

import eu.myapplication.common.Resource
import eu.myapplication.data.remote.dto.toCoin
import eu.myapplication.data.remote.dto.toCoinDetail
import eu.myapplication.domain.model.Coin
import eu.myapplication.domain.model.CoinDetail
import eu.myapplication.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {

            emit(Resource.Error<CoinDetail>(e.localizedMessage?:"An unexpected error occured "))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server . check your internet connection "))

        }
    }
}