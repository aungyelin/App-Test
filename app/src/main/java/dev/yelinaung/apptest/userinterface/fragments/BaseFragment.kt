package dev.yelinaung.apptest.userinterface.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.FragmentNoTitleBinding
import dev.yelinaung.apptest.databinding.FragmentWithTitleBinding
import dev.yelinaung.apptest.helper.NoTitleBar
import dev.yelinaung.apptest.userinterface.TabsActivity
import dev.yelinaung.apptest.userinterface.tabs.FirstLevelFragment

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    protected lateinit var binding: VB
    protected open var pageTitle: String? = null

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

        if (this is FirstLevelFragment || this is NoTitleBar) {
            val baseFragmentBinding = FragmentNoTitleBinding.inflate(inflater, container, false)
            baseFragmentBinding.fragmentContainer.removeAllViews()
            baseFragmentBinding.fragmentContainer.addView(binding.root)
            return baseFragmentBinding.root
        } else {
            val baseFragmentBinding = FragmentWithTitleBinding.inflate(inflater, container, false)
            baseFragmentBinding.fragmentContainer.removeAllViews()
            baseFragmentBinding.fragmentContainer.addView(binding.root)
            baseFragmentBinding.toolbar.title = pageTitle
            baseFragmentBinding.toolbar.setNavigationIcon(R.drawable.ic_back_arrow)
            baseFragmentBinding.toolbar.setNavigationOnClickListener {
                (requireActivity() as? TabsActivity)?.navigateBack()
            }
            return baseFragmentBinding.root
        }
    }

}