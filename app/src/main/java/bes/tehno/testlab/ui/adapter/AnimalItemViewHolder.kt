package bes.tehno.testlab.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import bes.tehno.testlab.databinding.ItemAnimalBinding
import bes.tehno.testlab.model.entity.Animal
import bes.tehno.testlab.ui.base.adapter.BaseViewHolder

class AnimalItemViewHolder (binding: ItemAnimalBinding, viewModel: AnimalItemViewModel):
    BaseViewHolder<Animal, AnimalItemViewModel, ItemAnimalBinding>(binding, viewModel) {
    companion object {
        fun create(parent: ViewGroup, viewModel: AnimalItemViewModel): AnimalItemViewHolder {
            val binding = ItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return AnimalItemViewHolder(binding, viewModel)
        }
    }
}