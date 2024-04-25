package dev.yelinaung.apptest.userinterface.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import dev.yelinaung.apptest.databinding.FragmentStepThreeBinding

class StepThreeFragment : BaseFragment<FragmentStepThreeBinding>() {

    companion object {
        fun getInstance(): StepThreeFragment {
            return StepThreeFragment()
        }
    }

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentStepThreeBinding {
        return FragmentStepThreeBinding.inflate(inflater, container, false)
    }

}