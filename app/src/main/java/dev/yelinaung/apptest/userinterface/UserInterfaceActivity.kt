package dev.yelinaung.apptest.userinterface

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import dev.yelinaung.apptest.BaseActivity
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
    }

    private fun goToBasicViews() {
        val intent = BasicViewActivity.getInstance(this)
        startActivity(intent)
    }

    private fun goToLayoutActivity() {
        val intent = LayoutActivity.getInstance(this)
        startActivity(intent)
    }

}