package dev.yelinaung.apptest

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.result.contract.ActivityResultContracts
import dev.yelinaung.apptest.databinding.ActivityIntentBinding


class IntentActivity : BaseActivity<ActivityIntentBinding>() {

    companion object {

        private const val MESSAGE = "message from main"

        fun getInstance(context: Context, msg: String): Intent {
            return Intent(context, IntentActivity::class.java).also {
                it.putExtra(MESSAGE, msg)
            }
        }

    }

    override val pageTitle: String get() = "Intent"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityIntentBinding {
        return ActivityIntentBinding.inflate(layoutInflater)
    }

    private val fileChooserContract =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let { binding.imageView.setImageURI(it) }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val message = intent.getStringExtra(MESSAGE)
        binding.tvMessage.text = message

        binding.btnOpenLink.setOnClickListener { this.openLink() }
        binding.btnPhoneCall.setOnClickListener { this.callPhoneNumber() }
        binding.btnShareContent.setOnClickListener { this.shareContent() }
        binding.btnOpenMap.setOnClickListener { this.openMap() }
        binding.btnTakePicture.setOnClickListener { this.takePicture() }
    }

    private fun openLink() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
        startActivity(intent)
    }

    private fun callPhoneNumber() {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+959253366392"))
        startActivity(intent)
    }

    private fun shareContent() {

    }

    private fun openMap() {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.google.com/maps/@12.9594868,100.8906177,16z?entry=ttu")
        )
        startActivity(intent)
    }

    private fun takePicture() {
        fileChooserContract.launch("image/*")
    }

}