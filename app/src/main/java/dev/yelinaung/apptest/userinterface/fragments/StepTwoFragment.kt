package dev.yelinaung.apptest.userinterface.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import dev.yelinaung.apptest.databinding.FragmentStepTwoBinding

class StepTwoFragment : BaseFragment<FragmentStepTwoBinding>() {

    companion object {
        fun getInstance(): StepTwoFragment {
            return StepTwoFragment()
        }
    }

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentStepTwoBinding {
        return FragmentStepTwoBinding.inflate(inflater, container, false)
    }

}