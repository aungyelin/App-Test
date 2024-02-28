package dev.yelinaung.apptest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import dev.yelinaung.apptest.broadcast.BroadcastActivity
import dev.yelinaung.apptest.databinding.ActivityIntentBinding
import java.util.Date

class IntentActivity : BaseActivity<ActivityIntentBinding>() {

    companion object {

        private const val MESSAGE = "message from main"

        fun getInstance(context: Context, msg: String): Intent {
            return Intent(context, IntentActivity::class.java).also {
                it.putExtra(MESSAGE, msg)
            }
        }

    }

    override val pageTitle: String get() = "Intent"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityIntentBinding {
        return ActivityIntentBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val message = intent.getStringExtra(MESSAGE)
        binding.tvMessage.text = message
    }

}