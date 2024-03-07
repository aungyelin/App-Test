package dev.yelinaung.apptest.taskandbackstack

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.ActivityTwoBinding

class TwoActivity : BaseTaskAndBackStackActivity<ActivityTwoBinding>() {

    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, TwoActivity::class.java)
        }

    }

    override val pageTitle: String get() = "Activity Two"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityTwoBinding {
        return ActivityTwoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.buttonActivityOne.setOnClickListener {
            this.goToActivityOne()
        }

        binding.buttonActivityTwo.setOnClickListener {
            this.goToActivityTwo()
        }

        binding.buttonActivityThree.setOnClickListener {
            this.goToActivityThree()
        }

        binding.buttonActivityFour.setOnClickListener {
            this.goToActivityFour()
        }
    }

}