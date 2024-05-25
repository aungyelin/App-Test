package dev.yelinaung.apptest.userinterface.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.FragmentThemeBinding
import dev.yelinaung.apptest.userinterface.TabsActivity
import dev.yelinaung.apptest.userinterface.fragments.BaseFragment

class ThemeFragment : BaseFragment<FragmentThemeBinding>() {

    override var pageTitle: String? = "Theme Change"

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentThemeBinding {
        return FragmentThemeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            (requireActivity() as? TabsActivity)?.navigateBack(LanguageFragment::class.java.name)
        }
    }

}