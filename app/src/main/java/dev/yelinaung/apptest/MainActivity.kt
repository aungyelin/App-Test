package dev.yelinaung.apptest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.yelinaung.apptest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvGreeting.text = "Hi"
    }

}