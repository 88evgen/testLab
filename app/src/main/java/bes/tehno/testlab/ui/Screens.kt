package bes.tehno.testlab.ui

import androidx.fragment.app.Fragment
import bes.tehno.testlab.ui.fragment.cats.CatsFragment
import bes.tehno.testlab.ui.fragment.dogs.DogsFragment

/**
 * @author Evgeny Butov
 * @created 27.08.2019
 */
object Screens {

    const val CATS = "CATS"
    const val DOGS = "DOGS"

    fun tabScreen(tab: String): Fragment {
        return when (tab) {
            DOGS -> DogsFragment()
            else -> CatsFragment()
        }
    }

}