package bes.tehno.testlab.ui.activity

import bes.tehno.testlab.R
import bes.tehno.testlab.ui.base.BaseRouter
import bes.tehno.testlab.ui.fragment.detail.DetailFragment

class MainRouter (activity: MainActivity) : BaseRouter<MainActivity>(activity) {

    fun openDetailFragment(image: String, title: String) {
        replaceFragment(
            activity.supportFragmentManager,
            DetailFragment.getInstance(image, title),
            DetailFragment.TAG,
            R.id.detailFragment,
            true
        )
    }
}