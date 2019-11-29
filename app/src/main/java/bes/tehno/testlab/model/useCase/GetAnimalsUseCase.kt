package bes.tehno.testlab.model.useCase

import bes.tehno.testlab.model.entity.Animal
import bes.tehno.testlab.model.entity.transformAnimal
import bes.tehno.testlab.model.repository.AppRepository
import bes.tehno.testlab.model.useCase.base.BaseUseCaseParams
import javax.inject.Inject

class GetAnimalsUseCase @Inject constructor (private val appRepository: AppRepository
) : BaseUseCaseParams<String, List<Animal>>() {
    override suspend fun executeOnBackground(params: String): List<Animal> {
        return appRepository.getAnimalsApi(params).map { it.transformAnimal() }
    }


}