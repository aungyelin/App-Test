package dev.yelinaung.apptest.userinterface.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.FragmentMenuBinding

class MenuFragment : BaseFragment<FragmentMenuBinding>() {

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentMenuBinding {
        return FragmentMenuBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOne.setOnClickListener { showFragment(StepOneFragment.getInstance()) }
        binding.btnTwo.setOnClickListener { showFragment(StepTwoFragment.getInstance()) }
        binding.btnThree.setOnClickListener { }
        binding.btnFour.setOnClickListener { }
    }

    private fun showFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .add(R.id.container_one, fragment)
            .commit()
    }

}