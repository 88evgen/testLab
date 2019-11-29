package bes.tehno.testlab.ui.fragment.detail

import androidx.databinding.ObservableField
import bes.tehno.testlab.ui.activity.MainRouter
import bes.tehno.testlab.ui.base.BaseViewModel

class DetailViewModel : BaseViewModel<MainRouter>() {

    val title: ObservableField<String> =  ObservableField<String>()
    val image: ObservableField<String> =  ObservableField<String>()
}