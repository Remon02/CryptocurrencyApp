package eu.myapplication.domain.use_case.get_coin

import eu.myapplication.common.Resource
import eu.myapplication.data.remote.dto.toCoin
import eu.myapplication.domain.model.Coin
import eu.myapplication.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map{it.toCoin()}
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {

            emit(Resource.Error<List<Coin>>(e.localizedMessage?:"An unexpected error occured "))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server . check your internet connection "))

        }
    }
}