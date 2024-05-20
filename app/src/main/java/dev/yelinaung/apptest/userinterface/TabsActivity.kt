package dev.yelinaung.apptest.userinterface

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.ActivityTabsBinding
import dev.yelinaung.apptest.userinterface.fragments.BaseFragment
import dev.yelinaung.apptest.userinterface.tabs.HomeFragment
import dev.yelinaung.apptest.userinterface.tabs.LanguageFragment
import dev.yelinaung.apptest.userinterface.tabs.NotificationsFragment
import dev.yelinaung.apptest.userinterface.tabs.SettingsFragment

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

    private fun getFragmentByTab(tab: Tabs): Fragment {
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

    fun navigateToLanguageSettings() {
        selectedTab?.let {
            (getFragmentByTab(it) as? BaseFragment<*>)?.showFragment(LanguageFragment())
        }
    }

}