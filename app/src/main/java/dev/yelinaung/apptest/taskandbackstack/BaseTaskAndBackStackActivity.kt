package dev.yelinaung.apptest.taskandbackstack

import android.app.ActivityManager
import android.util.Log
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
            Log.d("TAG", "Activity Count of Task ${index+1} = ${appTask.taskInfo.numActivities}")
        }

        Log.d("TAG", "----------------------------------------------------------------")
    }

    protected fun goToActivityOne() {
        val intent = OneActivity.getInstance(this)
        startActivity(intent)
    }

    protected fun goToActivityTwo() {
        val intent = TwoActivity.getInstance(this)
        startActivity(intent)
    }

    protected fun goToActivityThree() {
        val intent = ThreeActivity.getInstance(this)
        startActivity(intent)
    }

    protected fun goToActivityFour() {
        val intent = FourActivity.getInstance(this)
        startActivity(intent)
    }

}