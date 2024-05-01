package dev.yelinaung.apptest.userinterface.sheets

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dev.yelinaung.apptest.databinding.ModalSheetBinding
import dev.yelinaung.apptest.userinterface.SheetsActivity

class ModalSheet : BottomSheetDialogFragment() {

    private lateinit var binding: ModalSheetBinding

    private var callback: ModalSheetCallback? = null

    companion object {
        fun getInstance(callback: ModalSheetCallback): ModalSheet {
            val sheet = ModalSheet()
            sheet.callback = callback
            return sheet
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as? ModalSheetCallback
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ModalSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnShow.setOnClickListener {
            callback?.showMessage(binding.edtInput.text.toString())
        }
    }

    interface ModalSheetCallback {
        fun showMessage(msg: String)
    }

}