package bes.tehno.testlab.ui.base.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<Entity, VM : BaseItemViewModel<Entity>>
    (private var itemList: MutableList<Entity> = mutableListOf<Entity>()) : RecyclerView.Adapter<BaseViewHolder<Entity, VM, *>>() {

    private val clickItemSubject = MutableLiveData<ItemClick<Entity>>()
    fun onClickItemSubject(): LiveData<ItemClick<Entity>> = clickItemSubject

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: BaseViewHolder<Entity, VM, *>, position: Int) {
        holder.bind(itemList[position], holder.adapterPosition)
    }

    open fun setItems(items: List<Entity>) {
        this.itemList = items as MutableList<Entity>
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: BaseViewHolder<Entity, VM, *>) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            val pos = holder.adapterPosition
            clickItemSubject.value = ItemClick(itemList[pos], pos)
            holder.viewModel.onItemClick()
        }
    }

    override fun onViewDetachedFromWindow(holder: BaseViewHolder<Entity, VM, *>) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.setOnClickListener(null)
    }
}