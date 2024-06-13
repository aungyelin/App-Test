package dev.yelinaung.apptest.resources

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.LocaleList
import android.view.LayoutInflater
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.ActivityResourcesBinding
import dev.yelinaung.apptest.helper.showToast
import java.util.Locale

class ResourcesActivity : BaseActivity<ActivityResourcesBinding>() {

    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, ResourcesActivity::class.java)
        }

    }

    override val pageTitle: String get() = getString(R.string.resources)

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityResourcesBinding {
        return ActivityResourcesBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*setupUI()*/
        binding.tvDynamicString.text = getString(
            R.string.label_dynamic_string,
            "Mg Mg", "apples", "bananas", 5, 3
        )

        binding.btnChangeLanguage.setOnClickListener { changeLanguage() }
        binding.btnChangeTheme.setOnClickListener { changeTheme() }
    }

    /*override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        setupUI()
    }

    private fun setupUI() {
        binding.tvLocalizedString.text = getString(R.string.label_localized_string)
    }*/

    private fun changeLanguage() {
        val currentLanguage = resources.configuration.locales.get(0).language
        val newLanguage = if (currentLanguage == "en") "my" else "en"
        showToast("$currentLanguage to $newLanguage")
        val locale = Locale(newLanguage)

        /*Locale.setDefault(locale)
        resources.configuration.setLocale(locale)
        resources.updateConfiguration(resources.configuration, resources.displayMetrics)*/

        val localeListToSet = LocaleList(locale)
        LocaleList.setDefault(localeListToSet)
        resources.configuration.setLocales(localeListToSet)
        @Suppress("DEPRECATION")
        resources.updateConfiguration(resources.configuration, resources.displayMetrics)

        recreate()
    }

    private fun changeTheme() {

    }

}