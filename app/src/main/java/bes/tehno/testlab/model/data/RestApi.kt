package bes.tehno.testlab.model.data

import bes.tehno.testlab.model.data.response.AnimalResponse
import bes.tehno.testlab.model.data.response.BaseResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("xim/api.php?")
    fun getCatsAsync(
        @Query("query") animalType: String
    ): Deferred<BaseResponse<List<AnimalResponse>>>
}