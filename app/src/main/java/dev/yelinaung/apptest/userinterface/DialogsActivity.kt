package dev.yelinaung.apptest.userinterface

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.databinding.ActivityDialogsBinding

class DialogsActivity : BaseActivity<ActivityDialogsBinding>() {

    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, DialogsActivity::class.java)
        }

    }

    override val pageTitle: String get() = "Dialogs Activity"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityDialogsBinding {
        return ActivityDialogsBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnAlert.setOnClickListener {
            this.showAlertDialog(
                "This is a test dialog.",
                "Test Dialog",
                Pair("OK", {})
            )
        }
    }

    private fun showAlertDialog(
        message: String,
        title: String? = null,
        positive: Pair<String, () -> Unit>? = null
    ) {
        AlertDialog.Builder(this).apply {
            setTitle(title)
            setMessage(message)
            setNegativeButton("Cancel") { _, _ ->
                Toast.makeText(this@DialogsActivity, "Negative", Toast.LENGTH_LONG).show()
            }
            setOnDismissListener {
                Log.d("Test", "On Dismiss Dialog")
            }
            setCancelable(true)

            positive?.let {
                setPositiveButton(it.first) { _, _ ->
                    it.second.invoke()
                }
            }

            create()
            show()
        }
    }

}