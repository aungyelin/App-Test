package dev.yelinaung.apptest.taskandbackstack

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.ActivityEightBinding

class EightActivity : BaseTaskAndBackStackActivity<ActivityEightBinding>() {

    companion object {

        private const val VALUE_RESULT = "value_result"

        fun getInstance(context: Context, valueResult: Int): Intent {
            return Intent(context, EightActivity::class.java).also {
                it.putExtra(VALUE_RESULT, valueResult)
            }
        }

    }

    override val pageTitle: String get() = "Activity Eight"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityEightBinding {
        return ActivityEightBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val result: Int = intent.getIntExtra(VALUE_RESULT, 0)

        binding.txtResult.text = result.toString()

        binding.btnFinish.setOnClickListener {
            finishCalculationPages()
        }

        this.onBackPressedDispatcher.addCallback {
            finishCalculationPages()
        }
    }

    private fun finishCalculationPages() {
        finishAffinity()
    }

}