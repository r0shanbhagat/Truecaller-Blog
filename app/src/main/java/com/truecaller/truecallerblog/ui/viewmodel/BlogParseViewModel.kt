package com.truecaller.truecallerblog.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.truecaller.truecallerblog.contract.UseCase
import com.truecaller.truecallerblog.core.BaseViewModel
import com.truecaller.truecallerblog.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Details Blog parse view model : Viewmodel to handle all the business logic
 * @Author Roshan Bhagat
 * @property blogContentUseCase: A bridge object to communicate b/w your repo and data source
 * @constructor
 */
@HiltViewModel
class BlogParseViewModel @Inject constructor(
    private val blogContentUseCase: UseCase<DataState>
) : BaseViewModel() {

    private val _dataState: MutableLiveData<DataState> by lazy {
        MutableLiveData<DataState>()
    }

    val dataState: LiveData<DataState> = _dataState


    /**
     * Set state intent
     *
     * @param mainStateEvent
     */
    fun setStateIntent(mainStateEvent: BlogParseEvent) {
        when (mainStateEvent) {
            is BlogParseEvent.GetBlogContent -> {
                getBlogContent()
            }

            is BlogParseEvent.None -> {
                //TODO will work on New flow
            }
        }
    }

    /*
     * getBlogContent return the blog parsed data using flow that continuously emit the value
     */
    private fun getBlogContent() {
        viewModelScope.launch {
            blogContentUseCase.getBlogContent()
                .onEach { flowData ->
                    _dataState.value = flowData
                }
                .launchIn(viewModelScope)
        }
    }

    /**
     * Call 5 service synchronously
     */
    //    private fun tempSynchronousCall() {
//        repeat(5) {
//            val job = viewModelScope.launch {
//                when (val response = respository.getWeatherInfo()) {
//                    is NetworkResult.Success -> {
//                        _dataState.postValue(response)
//                    }
//                }
//            }
//            job.join() //ensure the serial execution
//        }
//    }

    /**
     * Call 5 service async and merge the result
     */
//    private fun tempASynchronousCall() {
//        val deferedJobs = ArrayList<Deferred<NetworkResult.Response>>()
//
//        repeat(5) {
//            val deferredJob = async(Dispatchers.IO) {
//                respository.getWeatherInfo()
//            }
//            deferedJobs.add(deferredJob)
//        }
//
//        deferedJobs.awaitAll().foreach { response ->
//            when (response) {
//                is NetworkResult.Success -> {
//                    _dataState.postValue(response)
//                }
//            }
//        }
//
//    }

}


/**
 * Blog parse event
 *
 * @constructor Create Blog parse event
 */
sealed class BlogParseEvent {
    object GetBlogContent : BlogParseEvent()
    object None : BlogParseEvent()
}