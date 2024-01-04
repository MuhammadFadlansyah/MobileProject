package com.fadlan.seiproject.Login

import com.fadlan.seiproject.Model.User

data class LoginRespons(
    val error: Boolean,
    val message:String,
    val user: User
)
