package bes.tehno.testlab.ui.fragment.dogs

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import bes.tehno.testlab.model.entity.Animal
import bes.tehno.testlab.model.useCase.GetAnimalsUseCase
import bes.tehno.testlab.ui.App
import bes.tehno.testlab.ui.activity.MainRouter
import bes.tehno.testlab.ui.adapter.AnimalsAdapter
import bes.tehno.testlab.ui.base.BaseViewModel
import bes.tehno.testlab.ui.base.adapter.ItemClick
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DogsViewModel : BaseViewModel<MainRouter>() {

    val adapter: AnimalsAdapter = AnimalsAdapter()
    @Inject lateinit var getAnimalsUseCase: GetAnimalsUseCase
    private val onClickAdapter: Observer<ItemClick<Animal>> = Observer { itemClick -> onClickItem(itemClick) }

    init {
        App.appComponent.runInject(this)
        adapter.onClickItemSubject().observeForever(onClickAdapter)
        getData()
    }


    override fun onCleared() {
        adapter.onClickItemSubject().removeObserver(onClickAdapter)
        super.onCleared()
    }

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            getAnimalsUseCase.execute(Animal.DOGS){
                onComplete { adapter.setItems(it) }
            }
        }
    }

    private fun onClickItem(item: ItemClick<Animal>){
        router?.openDetailFragment(item.item.url, item.item.title)
    }
}