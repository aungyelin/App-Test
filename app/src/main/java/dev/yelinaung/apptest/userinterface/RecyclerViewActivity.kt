package dev.yelinaung.apptest.userinterface

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.databinding.ActivityRecyclerViewBinding
import dev.yelinaung.apptest.databinding.RecyclerViewItemBinding

class RecyclerViewActivity : BaseActivity<ActivityRecyclerViewBinding>() {

    companion object {
        fun getInstance(context: Context): Intent {
            return Intent(context, RecyclerViewActivity::class.java)
        }
    }

    override val pageTitle: String = "RecyclerView"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityRecyclerViewBinding {
        return ActivityRecyclerViewBinding.inflate(layoutInflater)
    }

    private val adapter = MyAdapter()


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.btnFruits.setOnClickListener {
            val fruits = listOf("apple", "banana", "orange", "grape", "mango", "kiwi", "pear", "watermelon", "peach", "cherry", "strawberry", "blueberry", "blackberry", "raspberry", "pineapple", "avocado", "kiwi", "pear", "watermelon", "peach", "cherry", "strawberry", "blueberry", "blackberry", "raspberry", "pineapple", "avocado")
            adapter.items = fruits
            adapter.notifyDataSetChanged()
        }

        binding.btnCountries.setOnClickListener {
            val countries = listOf("Thailand", "Malaysia", "Singapore", "Vietnam", "Philippines")
            adapter.items = countries
            adapter.notifyDataSetChanged()
        }

        // To Test - Layout Manager
        // To Test - Decoration
        // To Test - Notify Data Changes
    }

    private class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {

        var items = listOf<String>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(
                RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
            Log.d("TAG", "onBindViewHolder: $position")
        }

    }

    private class MyViewHolder(val binding: RecyclerViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun setupData(value: String) {
            binding.tvTitle.text = value
            binding.tvDesc.text = "This is $value"
        }

        @SuppressLint("SetTextI18n")
        fun clearData() {
            binding.tvTitle.text = "Title"
            binding.tvDesc.text = "Description"
        }

    }

}