package dev.yelinaung.apptest.sharepreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.databinding.ActivitySharePreferenceBinding
import dev.yelinaung.apptest.helper.showToast

class SharePreferenceActivity : BaseActivity<ActivitySharePreferenceBinding>() {

    companion object {
        private const val NAME = "name"

        fun getInstance(context: Context): Intent {
            return Intent(context, SharePreferenceActivity::class.java)
        }

    }

    override val pageTitle: String = "Share Preference"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivitySharePreferenceBinding {
        return ActivitySharePreferenceBinding.inflate(layoutInflater)
    }

    private val sharePreferences: SharedPreferences by lazy {
        getSharedPreferences("my_preference", Context.MODE_PRIVATE)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnSave.setOnClickListener { saveData() }

        loadData()
    }

    private fun loadData() {
        val name = sharePreferences.getString(NAME, null)
        binding.edtName.setText(name)
    }

    private fun saveData() {
        val name = binding.edtName.text.toString()
        val myEdit: SharedPreferences.Editor = sharePreferences.edit()
        myEdit.putString(NAME, name)
        myEdit.apply()

        showToast("Successfully Saved")
    }

}