package dev.yelinaung.apptest.userinterface

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.ActivityFragmentDemoBinding

class FragmentDemoActivity : BaseActivity<ActivityFragmentDemoBinding>() {

    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, FragmentDemoActivity::class.java)
        }

    }

    override val pageTitle: String = "Fragments"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityFragmentDemoBinding {
        return ActivityFragmentDemoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}