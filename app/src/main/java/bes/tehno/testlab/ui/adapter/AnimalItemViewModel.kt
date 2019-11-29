package bes.tehno.testlab.ui.adapter

import androidx.databinding.ObservableField
import bes.tehno.testlab.model.entity.Animal
import bes.tehno.testlab.ui.base.adapter.BaseItemViewModel

class AnimalItemViewModel : BaseItemViewModel<Animal>() {

    val title: ObservableField<String> = ObservableField<String>()
    val image: ObservableField<String> = ObservableField<String>()

    override fun bindItem(item: Animal, position: Int) {
        title.set(item.title)
        image.set(item.url)
    }
}