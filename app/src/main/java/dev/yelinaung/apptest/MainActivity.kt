package dev.yelinaung.apptest

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import dev.yelinaung.apptest.databinding.ActivityMainBinding
import java.util.Date

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Main Menu"

        binding.btnLifecycle.setOnClickListener {
            this.goToLifecycleScreen()
        }

        binding.btnBroadcast.setOnClickListener {
            this.goToBroadcastScreen()
        }
    }

    private fun goToLifecycleScreen() {
        val intent = Intent(this, LifecycleActivity::class.java)
        startActivity(intent)
    }

    private fun goToBroadcastScreen() {
        val intent = Intent(this, BroadcastActivity::class.java)
        startActivity(intent)
    }

}