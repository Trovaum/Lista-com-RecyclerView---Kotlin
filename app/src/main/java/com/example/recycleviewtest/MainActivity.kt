package com.example.recycleviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val mList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }
    private val adapter = ContactAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindView()
        updateList()
    }

    private fun bindView() {
        mList.adapter = adapter
        mList.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList() {
        adapter.updateList(
            arrayListOf(
                Contact(
                    "Ricardo",
                    "123456789",
                    "img.png"
                ),
                Contact(
                    "Ricardo",
                    "123456789",
                    "img.png"
                ),
                Contact(
                    "Ricardo",
                    "123456789",
                    "img.png"
                )

            )
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_menu_1 -> {
                showToast("Item 1 selecionado!")
                true
            }
            R.id.item_menu_2 -> {
                showToast("item 2 selecionado!")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}