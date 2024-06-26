package dev.yelinaung.apptest.userinterface

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.app.ActivityOptionsCompat
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.ActivityUserInterfaceBinding

class UserInterfaceActivity : BaseActivity<ActivityUserInterfaceBinding>() {

    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, UserInterfaceActivity::class.java)
        }

    }

    override val pageTitle: String get() = "User Interface"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityUserInterfaceBinding {
        return ActivityUserInterfaceBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnBasicView.setOnClickListener { this.goToBasicViews() }
        binding.btnLayouts.setOnClickListener { this.goToLayoutActivity() }
        binding.btnConstraintLayouts.setOnClickListener { this.goToConstraintLayoutActivity() }
        binding.btnDialogs.setOnClickListener { this.goToDialogsActivity() }
        binding.btnSheets.setOnClickListener { this.goToSheetsActivity() }
        binding.btnFragments.setOnClickListener { this.goToFragmentsActivity() }
        binding.btnDrawer.setOnClickListener { this.goToDrawerActivity() }
        binding.btnTab.setOnClickListener { this.goToTabsActivity() }
        binding.btnListview.setOnClickListener { this.goToListview() }
        binding.btnRecyclerview.setOnClickListener { this.goToRecyclerview() }
    }

    private fun goToBasicViews() {
        val intent = BasicViewActivity.getInstance(this)
        startActivity(intent)
    }

    private fun goToLayoutActivity() {
        val intent = LayoutActivity.getInstance(this)
        startActivity(intent)
    }

    private fun goToConstraintLayoutActivity() {
        val intent = ConstraintLayoutActivity.getInstance(this)
        startActivity(intent)
    }

    private fun goToDialogsActivity() {
        val intent = DialogsActivity.getInstance(this)
        startActivity(intent)
    }

    private fun goToSheetsActivity() {
        val intent = SheetsActivity.getInstance(this)
        startActivity(intent)
    }

    private fun goToFragmentsActivity() {
        val intent = FragmentDemoActivity.getInstance(this)
        startActivity(intent)
    }

    private fun goToDrawerActivity() {
        val intent = DrawerActivity.getInstance(this)
        startActivity(intent)
    }

    private fun goToTabsActivity() {
        val intent = TabsActivity.getInstance(this)
        startActivity(intent)
    }

    private fun goToListview() {
        val intent = ListviewActivity.getInstance(this)
        startActivity(intent)
    }

    private fun goToRecyclerview() {
        val intent = RecyclerViewActivity.getInstance(this)
        startActivity(intent)
    }

}