package dev.yelinaung.apptest.taskandbackstack

import android.app.ActivityManager
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.viewbinding.ViewBinding
import dev.yelinaung.apptest.BaseActivity

abstract class BaseTaskAndBackStackActivity<VB : ViewBinding> : BaseActivity<VB>() {

    override fun onResume() {
        super.onResume()

        this.logTaskAndActivity()
    }

    private fun logTaskAndActivity() {
        val activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        val tasks = activityManager.appTasks

        Log.d("TAG", "Task Count = ${tasks.count()}")

        tasks.forEachIndexed { index, appTask ->
            Log.d("TAG", "Activity Count of Task ${index + 1} = ${appTask.taskInfo.numActivities}")
        }

        Log.d("TAG", "----------------------------------------------------------------")
    }

    protected fun listenButtonClick(
        buttonOne: View,
        buttonTwo: View,
        buttonThree: View,
        buttonFour: View,
        buttonFive: View,
        buttonSix: View,
    ) {
        buttonOne.setOnClickListener { goToActivityOne() }
        buttonTwo.setOnClickListener { goToActivityTwo() }
        buttonThree.setOnClickListener { goToActivityThree() }
        buttonFour.setOnClickListener { goToActivityFour() }
        buttonFive.setOnClickListener { goToActivityFive() }
        buttonSix.setOnClickListener { goToActivitySix() }
    }

    private fun goToActivityOne() {
        val intent = OneActivity.getInstance(this)
        startActivity(intent)
    }

    private fun goToActivityTwo() {
        val intent = TwoActivity.getInstance(this)
        startActivity(intent)
    }

    private fun goToActivityThree() {
        val intent = ThreeActivity.getInstance(this)
        startActivity(intent)
    }

    private fun goToActivityFour() {
        val intent = FourActivity.getInstance(this)
        startActivity(intent)
    }

    private fun goToActivityFive() {
        val intent = FiveActivity.getInstance(this)
        //intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    private fun goToActivitySix() {
        val intent = SixActivity.getInstance(this)
        startActivity(intent)
    }

}