package dev.yelinaung.apptest.userinterface

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.ActivityUserInterfaceBinding
import dev.yelinaung.apptest.taskandbackstack.EightActivity

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

        val textView: View = binding.textViewOne

        binding.textViewOne.text = "Testing"
        binding.textViewOne.alpha = 0.7f

        textView.alpha = 0.5f
    }

}