package com.android.myapplication.network

import com.android.myapplication.ui.user.model.CommonResponse
import retrofit2.Response

/**
 *Created by Nivetha S on 09-05-2021.
 */
interface ApiHelper {

    suspend fun getUsers(): Response<CommonResponse>

}