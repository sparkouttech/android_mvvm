package com.android.myapplication.network

import com.android.myapplication.ui.user.model.CommonResponse
import retrofit2.Response
import javax.inject.Inject

/**
 *Created by Nivetha S on 09-05-2021.
 */
class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {

    override suspend fun getUsers(): Response<CommonResponse> = apiService.getUsers()


}