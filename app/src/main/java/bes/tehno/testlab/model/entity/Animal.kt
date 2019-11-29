package bes.tehno.testlab.model.entity

data class Animal(
    val url: String,
    val title: String
){
    companion object {
        const val CATS = "cat"
        const val DOGS = "dog"
    }
}