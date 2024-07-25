package dev.yelinaung.apptest.database

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.room.Room
import dev.yelinaung.apptest.BaseActivity
import dev.yelinaung.apptest.database.entity.Product
import dev.yelinaung.apptest.databinding.ActivityDatabaseBinding
import kotlin.random.Random

class DatabaseActivity : BaseActivity<ActivityDatabaseBinding>() {

    private lateinit var db: MyDatabase

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

        this.initDatabase()
        this.setupUI()
    }

    private fun initDatabase() {
        this.db = Room.databaseBuilder(
            applicationContext,
            MyDatabase::class.java,
            "my-database"
        )
            .allowMainThreadQueries()
            .build()
    }

    private fun setupUI() {

        binding.btnInsertProduct.setOnClickListener { this.addProduct() }

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

        this.db.productDAO().insert(product)
    }

}