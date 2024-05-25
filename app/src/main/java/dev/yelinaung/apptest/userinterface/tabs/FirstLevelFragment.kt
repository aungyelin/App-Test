package dev.yelinaung.apptest.userinterface.tabs

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.helper.ScreenAnimation
import dev.yelinaung.apptest.userinterface.fragments.BaseFragment

abstract class FirstLevelFragment<VB : ViewBinding> : BaseFragment<VB>() {

    fun showFragment(
        fragment: Fragment,
        replace: Boolean = false,
        addToBackStack: Boolean = true,
        animation: ScreenAnimation? = ScreenAnimation.DEFAULT
    ) {
        val transaction = childFragmentManager.beginTransaction().apply {
            if (addToBackStack) {
                addToBackStack(fragment.javaClass.name)
            }
            animation?.let {
                setCustomAnimations(it.enter, it.exit, it.popEnter, it.popExit)
            }
        }
        if (replace) {
            transaction.replace(R.id.fragment_container, fragment)
        } else {
            transaction.add(R.id.fragment_container, fragment)
        }
        transaction.commit()
    }

    fun onBackPressed(tag: String? = null): Boolean {
        return tag?.let {
            childFragmentManager.popBackStackImmediate(
                it,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
        } ?: run {
            childFragmentManager.popBackStackImmediate()
        }
    }

    fun clearBackStack() {
        requireActivity().runOnUiThread {
            for (i in 0 until childFragmentManager.backStackEntryCount) {
                childFragmentManager.popBackStack()
            }
        }
    }

}