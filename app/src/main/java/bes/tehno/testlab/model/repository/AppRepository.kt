package bes.tehno.testlab.model.repository

import bes.tehno.testlab.model.data.response.AnimalResponse

interface AppRepository {
    suspend fun getAnimalsApi(animalsType: String): List<AnimalResponse>
}