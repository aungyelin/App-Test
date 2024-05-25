package dev.yelinaung.apptest.userinterface

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.widget.Toast
import androidx.activity.addCallback
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.ActivityTabsBinding
import dev.yelinaung.apptest.helper.showDialogFragment
import dev.yelinaung.apptest.userinterface.tabs.AboutUsFragment
import dev.yelinaung.apptest.userinterface.tabs.FirstLevelFragment
import dev.yelinaung.apptest.userinterface.tabs.HomeFragment
import dev.yelinaung.apptest.userinterface.tabs.LanguageFragment
import dev.yelinaung.apptest.userinterface.tabs.NotificationsFragment
import dev.yelinaung.apptest.userinterface.tabs.SettingsFragment
import dev.yelinaung.apptest.userinterface.tabs.ThemeFragment

class TabsActivity : BaseActivity<ActivityTabsBinding>() {

    companion object {
        fun getInstance(context: Context): Intent {
            return Intent(context, TabsActivity::class.java)
        }
    }

    override val pageTitle: String get() = "Tabs Activity"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityTabsBinding {
        return ActivityTabsBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onBackPressedDispatcher.addCallback(this) { handleBackPress() }

        this.supportActionBar?.hide()
        this.setupTabs()
    }

    private val homeFragment: HomeFragment by lazy { HomeFragment() }
    private val notiFragment: NotificationsFragment by lazy { NotificationsFragment() }
    private val settingsFragment: SettingsFragment by lazy { SettingsFragment() }

    private fun setupTabs() {
        binding.bottomNavigation.menu.clear()

        Tabs.entries.forEach {
            binding.bottomNavigation.menu.add(
                Menu.NONE,
                it.id,
                Menu.NONE,
                it.title
            ).icon = ResourcesCompat.getDrawable(resources, it.icon, null)
        }

        binding.bottomNavigation.setOnItemSelectedListener {
            selectedTab = Tabs.getTabByItemId(it.itemId)
            true
        }

        binding.bottomNavigation.setOnItemReselectedListener {
            selectedTab?.let {
                getFragmentByTab(it).clearBackStack()
            }
        }

        selectedTab = Tabs.entries.first()
    }

    private var selectedTab: Tabs? = null
        set(value) {
            if (field == value || value == null) return

            binding.bottomNavigation.menu.findItem(value.id).isChecked = true

            field?.let { hideFragment(getFragmentByTab(it)) }
            showFragment(getFragmentByTab(value))

            Log.d("TAG", "Set selectedTab: $value")
            field = value
        }
        get() {
            Log.d("TAG", "Get selectedTab: $field")
            return field
        }

    private fun getFragmentByTab(tab: Tabs): FirstLevelFragment<*> {
        return when (tab) {
            Tabs.HOME -> homeFragment
            Tabs.NOTIFICATIONS -> notiFragment
            Tabs.SETTINGS -> settingsFragment
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.findFragmentByTag(fragment.javaClass.name)?.let {
            supportFragmentManager
                .beginTransaction()
                .show(it)
                .commit()
        } ?: run {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, fragment, fragment.javaClass.name)
                .commit()
        }
    }

    private fun hideFragment(fragment: Fragment) {
        supportFragmentManager.findFragmentByTag(fragment.javaClass.name)?.let {
            supportFragmentManager
                .beginTransaction()
                .hide(it)
                .commit()
        }
    }

    private enum class Tabs(val id: Int, val title: Int, val icon: Int) {
        HOME(1, R.string.tab_home, R.drawable.ic_home),
        NOTIFICATIONS(2, R.string.tab_notifications, R.drawable.ic_notification),
        SETTINGS(50, R.string.tab_settings, R.drawable.ic_settings);

        companion object {
            fun getTabByItemId(itemId: Int): Tabs? {
                return Tabs.entries.find { it.id == itemId }
            }
        }

        /*val title = Tabs.HOME.getTitleString(this)

        fun getTitleString(context: Context): String {
            return context.getString(title)
        }*/
    }

    private fun handleBackPress() {
        if (popBackFragment()) {
            /** So it popped the dialog fragment back stack. */
        } else if (popBackChildFragment()) {
            /** So it popped the child fragment back stack. */
        } else if (selectedTab != Tabs.entries.first()) {
            selectedTab = Tabs.entries.first()
        } else {
            finish()
        }
    }

    private fun popBackFragment(tag: String? = null): Boolean {
        return tag?.let {
            supportFragmentManager.popBackStackImmediate(
                it,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
        } ?: run {
            supportFragmentManager.popBackStackImmediate()
        }
    }

    private fun popBackChildFragment(tag: String? = null): Boolean {
        return selectedTab?.let {
            getFragmentByTab(it).let { firstLevelFrag ->
                firstLevelFrag.isVisible && firstLevelFrag.onBackPressed(tag)
            }
        } ?: false
    }

    fun navigateToLanguageSettings() {
        selectedTab?.let {
            (getFragmentByTab(it)).showFragment(LanguageFragment())
        }
    }

    fun navigateToThemeSettings() {
        selectedTab?.let {
            (getFragmentByTab(it)).showFragment(ThemeFragment())
        }
    }

    fun navigateToAboutUs() {
        this.showDialogFragment(AboutUsFragment())
    }

    fun navigateBack(tag: String? = null) {
        if (tag == null) {
            onBackPressedDispatcher.onBackPressed()
        } else if (popBackFragment(tag)) {
            /** So it popped the dialog fragment back stack with tag. */
        } else if (popBackChildFragment(tag)) {
            /** So it popped the child fragment back stack with tag. */
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }

}