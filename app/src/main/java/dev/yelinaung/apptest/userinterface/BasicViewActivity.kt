package dev.yelinaung.apptest.userinterface

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doBeforeTextChanged
import androidx.core.widget.doOnTextChanged
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.ActivityBasicViewBinding

class BasicViewActivity : BaseActivity<ActivityBasicViewBinding>() {

    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, BasicViewActivity::class.java)
        }

    }

    override val pageTitle: String get() = "Basic Views"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityBasicViewBinding {
        return ActivityBasicViewBinding.inflate(layoutInflater)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.edtOne.doBeforeTextChanged { text, start, count, after ->  }
        binding.edtOne.doOnTextChanged { text, start, before, count ->  }
        binding.edtOne.addTextChangedListener {
            if (it.toString().count() >= 8) {
                binding.tvOne.text = it
            } else {
                binding.tvOne.text = "Invalid Text Input"
            }
        }

        binding.btnShowToast.setOnClickListener {
            val button = it as Button
            val text = button.text
            val toast = Toast.makeText(this@BasicViewActivity, text, Toast.LENGTH_LONG)
            toast.show()
        }
    }

}