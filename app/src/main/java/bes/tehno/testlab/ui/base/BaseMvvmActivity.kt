package bes.tehno.testlab.ui.base

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.os.Bundle
import bes.tehno.testlab.BR


/**
 * @author Evgeny Butov
 * @created 13.04.2019
 */
abstract class BaseMvvmActivity<VM : BaseViewModel<R>, R : BaseRouter<*>, B : ViewDataBinding> : BaseActivity() {

    protected open lateinit var viewModel: VM
    protected lateinit var binding: B
    open lateinit var router: R

    abstract fun provideViewModel(): VM
    abstract fun provideLayoutId(): Int
    abstract fun provideRouter(): R

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = provideViewModel()
        binding = DataBindingUtil.setContentView(this, provideLayoutId())
        binding.setVariable(BR.viewModel, viewModel)
        router = provideRouter()
    }

    override fun onResume() {
        super.onResume()
        viewModel.addRouter(router)
        viewModel.onResume()
    }

    override fun onPause() {
        super.onPause()
        viewModel.removeRouter()
    }
}