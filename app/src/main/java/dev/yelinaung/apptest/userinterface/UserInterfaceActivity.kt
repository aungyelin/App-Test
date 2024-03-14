package dev.yelinaung.apptest.userinterface

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doBeforeTextChanged
import androidx.core.widget.doOnTextChanged
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.R
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

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }
        }
        binding.edtOne.addTextChangedListener(textWatcher)
        binding.edtOne.removeTextChangedListener(textWatcher)

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
            val toast = Toast.makeText(this@UserInterfaceActivity, text, Toast.LENGTH_LONG)
            toast.show()
        }
    }

}