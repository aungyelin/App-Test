package dev.yelinaung.apptest.userinterface

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.databinding.ActivitySheetsBinding

class SheetsActivity : BaseActivity<ActivitySheetsBinding>() {

    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, SheetsActivity::class.java)
        }

    }

    override val pageTitle: String get() = "Sheets Activity"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivitySheetsBinding {
        return ActivitySheetsBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}