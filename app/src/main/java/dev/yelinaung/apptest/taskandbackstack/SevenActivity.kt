package dev.yelinaung.apptest.taskandbackstack

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import dev.yelinaung.apptest.databinding.ActivitySevenBinding

class SevenActivity : BaseTaskAndBackStackActivity<ActivitySevenBinding>() {

    companion object {

        private const val VALUE_ONE = "value_one"
        private const val VALUE_TWO = "value_two"

        fun getInstance(context: Context, valueOne: Int, valueTwo: Int): Intent {
            return Intent(context, SevenActivity::class.java).also {
                it.putExtra(VALUE_ONE, valueOne)
                it.putExtra(VALUE_TWO, valueTwo)
            }
        }

    }

    override val pageTitle: String get() = "Activity Seven"

    private val pageSubtitle: String get() = "Choose operation"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivitySevenBinding {
        return ActivitySevenBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.subtitle = pageSubtitle

        val valueOne = intent.getIntExtra(VALUE_ONE, 0)
        val valueTwo = intent.getIntExtra(VALUE_TWO, 0)

        binding.btnPlus.setOnClickListener { showResult(valueOne + valueTwo) }
        binding.btnMinus.setOnClickListener { showResult(valueOne - valueTwo) }
        binding.btnMultiply.setOnClickListener { showResult(valueOne * valueTwo) }
        binding.btnDivision.setOnClickListener { showResult(valueOne / valueTwo) }
    }

    private fun showResult(result: Int) {
        val intent = EightActivity.getInstance(this, result)
        startActivity(intent)
    }

}