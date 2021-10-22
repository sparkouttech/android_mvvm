package com.android.myapplication.ui.job.ui.user

import com.android.myapplication.network.ApiHelper
import javax.inject.Inject

/**
 *Created by Nivetha S on 09-05-2021.
 */
class UserRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {

    suspend fun getUsers() = apiHelper.getUsers()
}