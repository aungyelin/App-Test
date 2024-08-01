package dev.yelinaung.apptest.database

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.yelinaung.apptest.database.entity.Product
import dev.yelinaung.apptest.databinding.FragmentAddProductBinding
import dev.yelinaung.apptest.helper.MyApp
import dev.yelinaung.apptest.helper.NoTitleBar
import dev.yelinaung.apptest.userinterface.fragments.BaseFragment
import kotlin.random.Random

class AddProductFragment : BaseFragment<FragmentAddProductBinding>(), NoTitleBar {

    companion object {
        fun getInstance(): AddProductFragment {
            return AddProductFragment()
        }
    }

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentAddProductBinding {
        return FragmentAddProductBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnInsertProduct.setOnClickListener { addProduct() }
    }

    private fun addProduct() {
        val name = binding.edtProductName.text.toString()
        val desc = binding.edtProductDesc.text.toString()
        val price = Random.nextInt(500, 1000).toDouble()
        val brand = "My Brand"

        val product = Product(
            id = 0,
            name = name,
            description = desc,
            price = price,
            brand = brand
        )

        AsyncTask.execute {
            (requireActivity().application as MyApp).db.productDAO().insert(product)
            requireActivity().runOnUiThread { parentFragmentManager.popBackStackImmediate() }
            (requireActivity() as? DatabaseActivity)?.getProducts()
        }

    }

}