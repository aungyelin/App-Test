package dev.yelinaung.apptest.userinterface.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.FragmentHomeBinding
import dev.yelinaung.apptest.userinterface.fragments.BaseFragment
import java.util.Date

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}