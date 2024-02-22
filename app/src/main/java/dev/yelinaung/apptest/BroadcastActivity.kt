package dev.yelinaung.apptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.yelinaung.apptest.databinding.ActivityBroadcastBinding

class BroadcastActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBroadcastBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBroadcastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Broadcast Receiver"
    }

}