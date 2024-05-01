package dev.yelinaung.apptest.userinterface

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetBehavior
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.databinding.ActivitySheetsBinding
import dev.yelinaung.apptest.userinterface.sheets.ModalSheet

class SheetsActivity : BaseActivity<ActivitySheetsBinding>(), ModalSheet.ModalSheetCallback {

    companion object {
        fun getInstance(context: Context): Intent {
            return Intent(context, SheetsActivity::class.java)
        }
    }

    override val pageTitle: String get() = "Sheets Activity"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivitySheetsBinding {
        return ActivitySheetsBinding.inflate(layoutInflater)
    }

    private var dialog: ModalSheet? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setupStandardBottomSheet()

        binding.btnShowStandard.setOnClickListener {
            val standardBottomSheetBehavior = BottomSheetBehavior.from(binding.standardBottomSheet)
            standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }
        binding.btnShowModal.setOnClickListener {
            this.showModalBottomSheet()
        }
    }

    private fun setupStandardBottomSheet() {
        val standardBottomSheetBehavior = BottomSheetBehavior.from(binding.standardBottomSheet)
        standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                val state = when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> "Collapsed"
                    BottomSheetBehavior.STATE_EXPANDED -> "Expanded"
                    BottomSheetBehavior.STATE_HIDDEN -> "Hidden"
                    BottomSheetBehavior.STATE_DRAGGING -> "Dragging"
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> "Half Expanded"
                    BottomSheetBehavior.STATE_SETTLING -> "Setting"
                    else -> "Others"
                }
                Log.d("Test", "State changed to - $state")
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                //Log.d("Test", "Sliding - $slideOffset")
            }
        }

        standardBottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback)
        //standardBottomSheetBehavior.removeBottomSheetCallback(bottomSheetCallback)
    }

    private fun showModalBottomSheet() {
        /*dialog = ModalSheet.getInstance(object : ModalSheet.ModalSheetCallback {
            override fun showMessage(msg: String) {

            }
        })*/
        dialog = ModalSheet()
        dialog?.show(this.supportFragmentManager, null)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        dialog?.dismiss()
    }

}