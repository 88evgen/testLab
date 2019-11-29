package bes.tehno.testlab.ui.fragment.dogs

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import bes.tehno.testlab.R
import bes.tehno.testlab.databinding.FragmentDogsBinding
import bes.tehno.testlab.ui.activity.MainRouter
import bes.tehno.testlab.ui.base.BaseMvvmFragment

class DogsFragment : BaseMvvmFragment<DogsViewModel, MainRouter, FragmentDogsBinding>(){

    override fun provideLayoutId(): Int = R.layout.fragment_dogs
    override fun provideViewModel(): DogsViewModel {
        return ViewModelProviders.of(this).get(DogsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.layoutManager = LinearLayoutManager(this.activity)
        binding.recyclerview.adapter = viewModel.adapter

    }

}