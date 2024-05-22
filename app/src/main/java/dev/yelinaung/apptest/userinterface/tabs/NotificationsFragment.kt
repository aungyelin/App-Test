package dev.yelinaung.apptest.userinterface.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.FragmentNotificationsBinding
import dev.yelinaung.apptest.userinterface.fragments.BaseFragment

class NotificationsFragment : FirstLevelFragment<FragmentNotificationsBinding>() {

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentNotificationsBinding {
        return FragmentNotificationsBinding.inflate(inflater, container, false)
    }

}