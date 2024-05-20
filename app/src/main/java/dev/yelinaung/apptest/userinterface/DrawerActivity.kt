package dev.yelinaung.apptest.userinterface

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.databinding.ActivityDrawerBinding

class DrawerActivity : BaseActivity<ActivityDrawerBinding>() {

    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, DrawerActivity::class.java)
        }

    }

    override val pageTitle: String = "Drawer"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityDrawerBinding {
        return ActivityDrawerBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        binding.btnOpen.setOnClickListener {
            binding.drawerLayout.open()
        }

        binding.navigationView.setNavigationItemSelectedListener { menu ->
            menu.setChecked(true)
            true
        }
    }

}