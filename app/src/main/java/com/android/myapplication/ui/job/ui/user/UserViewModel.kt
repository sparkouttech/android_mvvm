package com.android.myapplication.ui.job.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.myapplication.network.Resource
import com.android.myapplication.ui.job.ui.user.model.CommonResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

/**
 *Created by Nivetha S on 09-05-2021.
 */
@HiltViewModel
class UserViewModel @Inject constructor(
    private val mainRepository: UserRepository
) : ViewModel() {

    private val _res = MutableLiveData<Resource<CommonResponse>>()

    val res: LiveData<Resource<CommonResponse>>
        get() = _res

    fun getUsers() = CoroutineScope(Dispatchers.IO).launch {
        _res.postValue(Resource.loading(null))
        mainRepository.getUsers().let {
            if (it.isSuccessful) {
                _res.postValue(Resource.success(it.body()))
            } else {
                _res.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }

    }


}