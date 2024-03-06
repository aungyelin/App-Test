package dev.yelinaung.apptest.taskandbackstack

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
import dev.yelinaung.apptest.databinding.ActivityTaskAndBackStackBinding
import dev.yelinaung.apptest.lifecycle.LifecycleActivity

class TaskAndBackStackActivity : BaseActivity<ActivityTaskAndBackStackBinding>() {

    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, TaskAndBackStackActivity::class.java)
        }

    }

    override val pageTitle: String get() = "Task and Back Stack"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityTaskAndBackStackBinding {
        return ActivityTaskAndBackStackBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.buttonActivityOne.setOnClickListener {
            this.goToActivityOne()
        }

        binding.buttonActivityTwo.setOnClickListener {
            this.goToActivityTwo()
        }
    }

    private fun goToActivityOne() {
        val intent = OneActivity.getInstance(this)
        startActivity(intent)
    }

    private fun goToActivityTwo() {
        val intent = TwoActivity.getInstance(this)
        startActivity(intent)
    }

}