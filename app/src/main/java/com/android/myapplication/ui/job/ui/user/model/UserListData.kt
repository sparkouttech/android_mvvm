package com.android.myapplication.ui.job.ui.user.model

import com.google.gson.annotations.SerializedName

class UserListData {
    @SerializedName("first_name")
    var firstName: String = ""
    @SerializedName("last_name")
    var lastName: String = ""
    @SerializedName("email")
    var email: String = ""

}
