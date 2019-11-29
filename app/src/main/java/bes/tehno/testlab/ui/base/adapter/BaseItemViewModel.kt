package bes.tehno.testlab.ui.base.adapter

abstract class BaseItemViewModel<Entity> {
    abstract fun bindItem(item: Entity, position: Int)
    open fun onItemClick() {}
}