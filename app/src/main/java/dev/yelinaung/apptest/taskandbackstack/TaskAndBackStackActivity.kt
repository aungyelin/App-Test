package dev.yelinaung.apptest.taskandbackstack

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import dev.yelinaung.apptest.databinding.ActivityTaskAndBackStackBinding

class TaskAndBackStackActivity : BaseTaskAndBackStackActivity<ActivityTaskAndBackStackBinding>() {

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

        val menu = binding.menuLayoutBase

        this.listenButtonClick(
            menu.buttonActivityOne,
            menu.buttonActivityTwo,
            menu.buttonActivityThree,
            menu.buttonActivityFour,
            menu.buttonActivityFive,
            menu.buttonActivitySix,
        )
    }

}