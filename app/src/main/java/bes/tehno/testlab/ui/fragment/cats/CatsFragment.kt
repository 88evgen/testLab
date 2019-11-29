package bes.tehno.testlab.ui.fragment.cats

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import bes.tehno.testlab.R
import bes.tehno.testlab.databinding.FragmentCatsBinding
import bes.tehno.testlab.ui.activity.MainRouter
import bes.tehno.testlab.ui.base.BaseMvvmFragment

class CatsFragment: BaseMvvmFragment<CatsViewModel, MainRouter, FragmentCatsBinding>(){

    override fun provideLayoutId(): Int = R.layout.fragment_cats
    override fun provideViewModel(): CatsViewModel {
        return ViewModelProviders.of(this).get(CatsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.layoutManager = LinearLayoutManager(this.activity)
        binding.recyclerview.adapter = viewModel.adapter

    }

}