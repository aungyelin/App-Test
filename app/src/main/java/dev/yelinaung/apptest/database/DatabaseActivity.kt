package dev.yelinaung.apptest.database

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.R
import dev.yelinaung.apptest.database.entity.Product
import dev.yelinaung.apptest.databinding.ActivityDatabaseBinding
import dev.yelinaung.apptest.databinding.ProductItemBinding
import dev.yelinaung.apptest.helper.MyApp
import dev.yelinaung.apptest.helper.ScreenAnimation
import dev.yelinaung.apptest.helper.showDialogFragment
import dev.yelinaung.apptest.helper.showToast

class DatabaseActivity : BaseActivity<ActivityDatabaseBinding>() {

    private val db by lazy { (application as MyApp).db }

    private val adapter = MyAdapter(this::onClickEdit, this::onClickDelete)

    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, DatabaseActivity::class.java)
        }

    }

    override val pageTitle: String = "Database"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityDatabaseBinding {
        return ActivityDatabaseBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setupUI()
        this.getProducts()
    }

    private fun setupUI() {
        binding.rvProduct.adapter = adapter
        binding.rvProduct.layoutManager = LinearLayoutManager(this)

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing = false
            this.getProducts()
        }

        binding.floatingActionButton.setOnClickListener {
            showDialogFragment(
                AddProductFragment.getInstance(),
                animation = ScreenAnimation.ENTER_UP_EXIT_STAY
            )
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getProducts() {
        AsyncTask.execute { // Insert Data
            val products = this.db.productDAO().getAllProducts()
            runOnUiThread {
                adapter.items = products
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun onClickEdit(product: Product) {
        showToast("Clicked Edit for ${product.name}")
    }

    private fun onClickDelete(product: Product) {
        showToast("Clicked Delete for ${product.name}")
    }

    private class MyAdapter(
        private val onClickEdit: (Product) -> Unit,
        private val onClickDelete: (Product) -> Unit
    ) : RecyclerView.Adapter<MyViewHolder>() {

        var items = listOf<Product>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(
                ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
                onClickEdit, onClickDelete
            )
        }

        override fun getItemCount(): Int {
            return items.count()
        }

        override fun onViewRecycled(holder: MyViewHolder) {
            super.onViewRecycled(holder)
            holder.clearData()
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.setupData(items[position])
        }

    }

    private class MyViewHolder(
        val binding: ProductItemBinding,
        private val onClickEdit: (Product) -> Unit,
        private val onClickDelete: (Product) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun setupData(product: Product) {
            binding.tvTitle.text = product.name
            binding.tvDesc.text = product.description
            binding.tvPrice.text = "${product.price} MMK"

            itemView.setOnLongClickListener {
                val menu = PopupMenu(itemView.context, binding.tvTitle, Gravity.END)
                menu.inflate(R.menu.product_item_menu)
                menu.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.edit -> {
                            onClickEdit.invoke(product)
                            true
                        }
                        R.id.delete -> {
                            onClickDelete.invoke(product)
                            true
                        }
                        else -> {
                            false
                        }
                    }
                }
                menu.show()
                true
            }
        }

        @SuppressLint("SetTextI18n")
        fun clearData() {
            binding.tvTitle.text = "Product Name"
            binding.tvDesc.text = "Description"
            binding.tvPrice.text = "0 MMK"
        }

    }

}