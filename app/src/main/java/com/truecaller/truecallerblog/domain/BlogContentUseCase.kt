package com.truecaller.truecallerblog.domain

import com.truecaller.truecallerblog.contract.Repository
import com.truecaller.truecallerblog.contract.UseCase
import com.truecaller.truecallerblog.di.IoDispatcher
import com.truecaller.truecallerblog.utils.DataState
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

/**
 * @Details BlogContentUseCase
 * @Author Roshan Bhagat
 * { @link https://developer.android.com/kotlin/coroutines/coroutines-best-practices}
 * @property repository
 * @property ioDispatcher
 * @constructor Create Blog content use case
 */
@ViewModelScoped
class BlogContentUseCase @Inject constructor(
    override val repository: Repository<DataState>,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : UseCase<DataState> {

    /**
     * Get blog content
     *
     * In parallel, fetch tenthCharacter , everyTenthChar and distinctWordCount and return
     * when all requests complete and the data is ready
     */
    override suspend fun getBlogContent(): Flow<DataState> = flow {
        supervisorScope {
            emit(DataState.Loading)
            val tenthCharacter = async(ioDispatcher) {
                repository.getTenthCharacter()

            }
            val everyTenthChar = async(ioDispatcher) {
                repository.getEveryTenthCharacter()
            }
            val distinctWordCount = async(ioDispatcher) {
                repository.getDistinctWordCount()
            }

            emit(tenthCharacter.await())
            emit(everyTenthChar.await())
            emit(distinctWordCount.await())
        }
    }

}