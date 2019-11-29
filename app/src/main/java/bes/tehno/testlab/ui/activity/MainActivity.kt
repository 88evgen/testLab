package bes.tehno.testlab.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProviders
import bes.tehno.testlab.R
import bes.tehno.testlab.databinding.ActivityMainBinding
import bes.tehno.testlab.ui.Screens
import bes.tehno.testlab.ui.Screens.CATS
import bes.tehno.testlab.ui.Screens.DOGS
import bes.tehno.testlab.ui.base.BaseMvvmActivity
import bes.tehno.testlab.ui.fragment.detail.DetailFragment
import java.util.*

class MainActivity : BaseMvvmActivity<MainViewModel, MainRouter, ActivityMainBinding>() {

    override fun provideRouter(): MainRouter = MainRouter(this)
    override fun provideLayoutId(): Int = R.layout.activity_main
    override fun provideViewModel(): MainViewModel {
        return ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null)  selectTab(CATS)
        bottomNavigation()
    }

    private fun bottomNavigation() {
        binding.navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_btn_cat -> selectTab(CATS)
                R.id.menu_btn_dog -> selectTab(DOGS)
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun selectTab(tab: String) {
        val fm = supportFragmentManager
        var currentFragment: Fragment? = null
        val fragments = fm.fragments

        if (fragments != null) {
            for (f: Fragment in fragments) {
                if (f.isVisible) {
                    currentFragment = f
                    break
                }
            }
        }

        val newFragment: Fragment? = fm.findFragmentByTag(tab)
        if (currentFragment != null && newFragment != null && currentFragment == newFragment) return

        val transaction: FragmentTransaction = fm.beginTransaction()
        if (newFragment == null) {
            transaction.add(R.id.mainFragment, Screens.tabScreen(tab), tab)
        }

        if (currentFragment != null) {
            transaction.hide(currentFragment)
        }

        if (newFragment != null) {
            transaction.show(newFragment)
        }
        transaction.commitNow()
    }

}
