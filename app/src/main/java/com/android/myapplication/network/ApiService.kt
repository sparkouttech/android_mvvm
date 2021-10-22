package com.android.myapplication.network

import com.android.myapplication.ui.job.ui.user.model.CommonResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 *Created by Nivetha S on 09-05-2021.
 */
interface ApiService {

    @GET(ApiNames.GET.USER)
    suspend fun getUsers(): Response<CommonResponse>

}