package dev.yelinaung.apptest.userinterface

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.databinding.ActivityListviewBinding
import dev.yelinaung.apptest.databinding.ListviewItemBinding
import dev.yelinaung.apptest.helper.showToast

class ListviewActivity : BaseActivity<ActivityListviewBinding>() {

    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, ListviewActivity::class.java)
        }

    }

    override val pageTitle: String = "Listview"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityListviewBinding {
        return ActivityListviewBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupCustomAdapter()
    }

    private fun setupSimpleAdapter() {
        val fruits =
            listOf("apple", "banana", "orange", "grape", "mango", "kiwi", "pear", "watermelon")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            fruits
        )

        binding.listview.adapter = adapter
    }

    private fun setupCustomAdapter() {
        val fruits = listOf(
            Pair("Apple", 1),
            Pair("Banana", 2),
            Pair("Orange", 3),
            Pair("Grape", 4),
            Pair("Mango", 5),
            Pair("Kiwi", 6),
            Pair("Pear", 7),
            Pair("Watermelon", 8)
        )

        val adapter = CustomAdapter(fruits)

        binding.listview.setOnItemClickListener { _, _, position, _ ->
            val item = adapter.getItem(position) as? Pair<*, *>
            val name = item?.first as? String ?: "Unknown"
            this@ListviewActivity.showToast(name)
        }

        binding.listview.adapter = adapter
    }

    private class CustomAdapter(val items: List<Pair<String, Int>>) : BaseAdapter() {

        override fun getCount(): Int {
            return items.count()
        }

        override fun getItem(p0: Int): Any {
            return items[p0]
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        @SuppressLint("ViewHolder")
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val binding = ListviewItemBinding.inflate(LayoutInflater.from(p2?.context))
            binding.name.text = items[p0].first
            return binding.root
        }

    }

}