package dev.yelinaung.apptest.intent

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import dev.yelinaung.apptest.BaseActivity
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

    private var imageUri: Uri? = null

    private val fileChooserContract = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            imageUri = it
            binding.btnShareContent.visibility = View.VISIBLE
            binding.imageView.setImageURI(imageUri)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val message = intent.getStringExtra(MESSAGE)
        binding.tvMessage.text = message

        binding.btnShareContent.visibility = View.GONE

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
        this.imageUri?.let {
            val intent = Intent(Intent.ACTION_SEND)
            intent.setType("image/*")
            intent.putExtra(Intent.EXTRA_STREAM, it)
            startActivity(intent)
        }
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