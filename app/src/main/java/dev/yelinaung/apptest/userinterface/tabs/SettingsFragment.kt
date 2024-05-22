package dev.yelinaung.apptest.userinterface.tabs

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.FragmentSettingsBinding
import dev.yelinaung.apptest.userinterface.TabsActivity
import dev.yelinaung.apptest.userinterface.fragments.BaseFragment

class SettingsFragment : FirstLevelFragment<FragmentSettingsBinding>() {

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSettingsBinding {
        return FragmentSettingsBinding.inflate(inflater, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLanguageChange.setOnClickListener {
            (requireActivity() as? TabsActivity)?.navigateToLanguageSettings()
        }

        binding.btnThemeChange.setOnClickListener {
            (requireActivity() as? TabsActivity)?.navigateToThemeSettings()
        }
    }

}