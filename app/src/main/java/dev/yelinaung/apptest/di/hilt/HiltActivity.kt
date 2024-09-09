package dev.yelinaung.apptest.di.hilt

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ActivityContext
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.database.MyDatabase
import dev.yelinaung.apptest.databinding.ActivityHiltBinding
import javax.inject.Inject

@AndroidEntryPoint
class HiltActivity : AppCompatActivity() {

    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, HiltActivity::class.java)
        }

    }

    @Inject
    lateinit var car: HiltCar

    private lateinit var binding: ActivityHiltBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHiltBinding.inflate(layoutInflater)
        setContentView(binding.root)

        car.drive()
    }

}