package bes.tehno.testlab.ui.adapter

import android.view.ViewGroup
import bes.tehno.testlab.model.entity.Animal
import bes.tehno.testlab.ui.base.adapter.BaseRecyclerAdapter

class AnimalsAdapter  : BaseRecyclerAdapter<Animal, AnimalItemViewModel>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): AnimalItemViewHolder {
        return AnimalItemViewHolder.create(viewGroup,  AnimalItemViewModel())
    }
}