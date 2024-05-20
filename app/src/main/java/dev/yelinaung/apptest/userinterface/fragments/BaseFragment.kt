package dev.yelinaung.apptest.userinterface.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.FragmentBaseBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    protected lateinit var binding: VB

    abstract fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = setupViewBinding(inflater, container, savedInstanceState)

        val baseFragmentBinding = FragmentBaseBinding.inflate(inflater, container, false)
        baseFragmentBinding.baseFragmentContainer.removeAllViews()
        baseFragmentBinding.baseFragmentContainer.addView(binding.root)

        return baseFragmentBinding.root
    }

    fun showFragment(
        fragment: Fragment,
        replace: Boolean = false,
        addToBackStack: Boolean = true
    ) {
        val transaction = childFragmentManager.beginTransaction().apply {
            if (addToBackStack) { addToBackStack(fragment.javaClass.name) }
        }
        if (replace) {
            transaction.replace(R.id.base_fragment_container, fragment)
        } else {
            transaction.add(R.id.base_fragment_container, fragment)
        }
        transaction.commit()
    }

}