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

class SheetsActivity : BaseActivity<ActivitySheetsBinding>() {

    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, SheetsActivity::class.java)
        }

    }

    override val pageTitle: String get() = "Sheets Activity"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivitySheetsBinding {
        return ActivitySheetsBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setupStandardBottomSheet()

        binding.btnShowStandard.setOnClickListener {
            val standardBottomSheetBehavior = BottomSheetBehavior.from(binding.standardBottomSheet)
            standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }
        binding.btnShowModal.setOnClickListener {  }
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

}