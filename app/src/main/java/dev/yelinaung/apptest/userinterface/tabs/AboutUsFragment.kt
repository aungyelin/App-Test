package dev.yelinaung.apptest.userinterface.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import dev.yelinaung.apptest.databinding.FragmentAboutUsBinding
import dev.yelinaung.apptest.userinterface.fragments.BaseFragment

class AboutUsFragment : BaseFragment<FragmentAboutUsBinding>() {

    override var pageTitle: String? = "About Us"

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentAboutUsBinding {
        return FragmentAboutUsBinding.inflate(inflater, container, false)
    }

}