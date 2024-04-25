package dev.yelinaung.apptest.userinterface.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.FragmentStepFourBinding

class StepFourFragment : BaseFragment<FragmentStepFourBinding>() {

    companion object {
        fun getInstance(): StepFourFragment {
            return StepFourFragment()
        }
    }

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentStepFourBinding {
        return FragmentStepFourBinding.inflate(inflater, container, false)
    }


}