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
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.ActivitySixBinding

class SixActivity : BaseTaskAndBackStackActivity<ActivitySixBinding>() {

    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, SixActivity::class.java)
        }

    }

    override val pageTitle: String get() = "Activity Six"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivitySixBinding {
        return ActivitySixBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnNext.setOnClickListener { this.goToChooseOperation() }
    }

    private fun goToChooseOperation() {
        val valeOne = binding.edtOne.text.toString().toIntOrNull()
        val valeTwo = binding.edtTwo.text.toString().toIntOrNull()

        if (valeOne != null && valeTwo != null) {
            val intent = SevenActivity.getInstance(this, valeOne, valeTwo)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Invalid Value", Toast.LENGTH_LONG).show()
        }
    }

}