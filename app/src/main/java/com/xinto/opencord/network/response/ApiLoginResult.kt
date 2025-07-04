package com.xinto.opencord.network.response

import com.google.gson.annotations.SerializedName
import com.xinto.opencord.network.response.base.ApiResponse

data class ApiLoginResult(
    @SerializedName("token") val token: String,
    @SerializedName("mfa") val mfa: Boolean = false,
    @SerializedName("settings") val user_settings: ApiLoginUserSettingsResult,
) : ApiResponse
