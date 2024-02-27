package dev.yelinaung.apptest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import dev.yelinaung.apptest.broadcast.BroadcastActivity
import dev.yelinaung.apptest.databinding.ActivityMainBinding
import dev.yelinaung.apptest.lifecycle.LifecycleActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val pageTitle: String get() = "Main Menu"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnLifecycle.setOnClickListener {
            this.goToLifecycleScreen()
        }

        binding.btnBroadcast.setOnClickListener {
            this.goToBroadcastScreen()
        }
    }

    private fun goToLifecycleScreen() {
        val intent = LifecycleActivity.getInstance(this)
        startActivity(intent)
    }

    private fun goToBroadcastScreen() {
        val intent = BroadcastActivity.getInstance(this)
        startActivity(intent)
    }

}