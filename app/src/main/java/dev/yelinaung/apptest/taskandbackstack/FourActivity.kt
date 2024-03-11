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
import dev.yelinaung.apptest.databinding.ActivityFourBinding

class FourActivity : BaseTaskAndBackStackActivity<ActivityFourBinding>() {

    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, FourActivity::class.java)
        }

    }

    override val pageTitle: String get() = "Activity Four"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityFourBinding {
        return ActivityFourBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val menu = binding.menuLayoutFour

        this.listenButtonClick(
            menu.buttonActivityOne,
            menu.buttonActivityTwo,
            menu.buttonActivityThree,
            menu.buttonActivityFour,
            menu.buttonActivityFive,
        )
    }

}