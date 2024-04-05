package dev.yelinaung.apptest.userinterface

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.databinding.ActivityDialogsBinding
import dev.yelinaung.apptest.databinding.CustomDialogBinding
import java.util.Calendar
import java.util.Date

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
        binding.btnCustom.setOnClickListener { this.showCustomDialog() }
        binding.btnDatePicker.setOnClickListener { this.showDatePicker() }
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

    private fun showCustomDialog() {
        val dialogBinding = CustomDialogBinding.inflate(layoutInflater)

        val dialog = AlertDialog.Builder(this)
            .setView(dialogBinding.root)
            .setOnCancelListener {
                Log.d("Test", "Cancelled Custom Dialog")
            }
            .setOnDismissListener {
                Log.d("Test", "Dismissed Custom Dialog")
            }
            .setCancelable(false)
            .create()

        dialog.show()

        dialogBinding.btnShow.setOnClickListener {
            Toast.makeText(this, dialogBinding.edtMessage.text.toString(), Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }
        dialogBinding.btnClear.setOnClickListener {
            dialogBinding.edtMessage.text?.clear()
        }
    }

    private fun showDatePicker() {
        val dialog = DatePickerDialog(this)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)

        dialog.datePicker.updateDate(year, month, 1)
        dialog.datePicker.maxDate = c.time.time

        c.set(Calendar.YEAR, year - 1)
        c.add(Calendar.YEAR, -1)
        dialog.datePicker.minDate = c.time.time

        dialog.setOnDateSetListener { datePicker, y, m, d ->
            c.set(Calendar.YEAR, y)
            c.set(Calendar.MONTH, m)
            c.set(Calendar.DATE, d)
            Toast.makeText(this, c.time.toString(), Toast.LENGTH_LONG).show()
        }

        dialog.show()
    }

}