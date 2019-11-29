package bes.tehno.testlab.ui.fragment.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import bes.tehno.testlab.R
import bes.tehno.testlab.databinding.FragmentDetailBinding
import bes.tehno.testlab.ui.activity.MainRouter
import bes.tehno.testlab.ui.base.BaseMvvmFragment

class DetailFragment : BaseMvvmFragment<DetailViewModel, MainRouter, FragmentDetailBinding>(){

    companion object {
        const val TAG = "DetailFragment"
        private const val ID_TITLE = "ID_TITLE"
        private const val ID_IMAGE = "ID_IMAGE"

        fun getInstance(image: String, title: String): Fragment {
            val fragment = DetailFragment()
            val bundle = Bundle()
            bundle.putString(ID_IMAGE, image)
            bundle.putString(ID_TITLE, title)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun provideLayoutId(): Int = R.layout.fragment_detail
    override fun provideViewModel(): DetailViewModel {
        return ViewModelProviders.of(this).get(DetailViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.arguments?.let {
            viewModel.title.set(it.getString(ID_TITLE, ""))
            viewModel.image.set(it.getString(ID_IMAGE, ""))
        }
    }

}