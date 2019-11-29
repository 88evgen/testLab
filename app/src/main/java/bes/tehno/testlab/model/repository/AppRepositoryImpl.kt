package bes.tehno.testlab.model.repository

import bes.tehno.testlab.model.data.RestService
import bes.tehno.testlab.model.data.response.AnimalResponse
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(private val apiService: RestService): AppRepository {
    override suspend fun getAnimalsApi(animalsType: String): List<AnimalResponse> {
        return apiService.getAnimals(animalsType)
    }
}