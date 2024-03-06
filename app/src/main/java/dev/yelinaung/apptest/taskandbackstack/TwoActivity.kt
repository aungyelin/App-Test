package dev.yelinaung.apptest.taskandbackstack

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.ActivityTwoBinding

class TwoActivity : BaseActivity<ActivityTwoBinding>() {

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
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Toast.makeText(this, "onNewIntent", Toast.LENGTH_LONG).show()
    }

    private fun goToActivityOne() {
        val intent = OneActivity.getInstance(this)
        startActivity(intent)
    }

    private fun goToActivityTwo() {
        val intent = getInstance(this)
        startActivity(intent)
    }

}