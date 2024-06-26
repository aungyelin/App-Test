package dev.yelinaung.apptest.userinterface.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.FragmentLanguageBinding
import dev.yelinaung.apptest.userinterface.TabsActivity
import dev.yelinaung.apptest.userinterface.fragments.BaseFragment

class LanguageFragment : BaseFragment<FragmentLanguageBinding>() {

    override var pageTitle: String? = "Language Change"

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentLanguageBinding {
        return FragmentLanguageBinding.inflate(inflater, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnThemeChange.setOnClickListener {
            (requireActivity() as? TabsActivity)?.navigateToThemeSettings()
        }
    }

}