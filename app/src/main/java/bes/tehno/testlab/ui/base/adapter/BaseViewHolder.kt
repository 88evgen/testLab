package bes.tehno.testlab.ui.base.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import bes.tehno.testlab.BR

abstract class BaseViewHolder<Entity, VM:BaseItemViewModel<Entity>, Binding: ViewDataBinding>
    (val binding: Binding, val viewModel: VM): RecyclerView.ViewHolder(binding.root)
{
    init {
        binding.setVariable(BR.viewModel, viewModel)
    }
    fun bind(item: Entity, position: Int){
        viewModel.bindItem(item, position)
        binding.executePendingBindings()
    }
}