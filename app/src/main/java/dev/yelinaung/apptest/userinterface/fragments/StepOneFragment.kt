package dev.yelinaung.apptest.userinterface.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import dev.yelinaung.apptest.databinding.FragmentStepOneBinding
import dev.yelinaung.apptest.userinterface.FragmentDemoActivity

class StepOneFragment : BaseFragment<FragmentStepOneBinding>() {

    companion object {
        fun getInstance(): StepOneFragment {
            return StepOneFragment()
        }
    }

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentStepOneBinding {
        return FragmentStepOneBinding.inflate(inflater, container, false)
    }

}