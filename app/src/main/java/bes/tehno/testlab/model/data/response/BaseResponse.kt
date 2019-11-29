package bes.tehno.testlab.model.data.response

import com.google.gson.annotations.SerializedName

data class BaseResponse<TResponse>(
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: TResponse
)