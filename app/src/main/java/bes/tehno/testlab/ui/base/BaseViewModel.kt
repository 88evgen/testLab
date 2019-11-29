package bes.tehno.testlab.ui.base

import androidx.lifecycle.ViewModel

/**
 * @author Evgeny Butov
 * @created 13.04.2019
 */
abstract class BaseViewModel<R : BaseRouter<*>> : ViewModel() {

    protected var router: R? = null

    fun addRouter(router: R?){
        this.router = router
    }

    fun removeRouter() {
        this.router = null
    }


    open fun onResume() {
    }
}