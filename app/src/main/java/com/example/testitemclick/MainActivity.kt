package com.example.testitemclick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val data = listOf("apple", "orange", "mango")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = listAdapter(this, R.layout.list_item, data)
        listView.adapter = adapter
        adapter.setedit { position -> Toast.makeText(this, "$position", Toast.LENGTH_SHORT).show()}
        adapter.setrename {string ->
            AlertDialog.Builder(this).apply {
                val view: View = layoutInflater.inflate(R.layout.dialogtext, null)
                val name: EditText = view.findViewById(R.id.intext)
                setTitle("请重命名")
                setView(view)
                setCancelable(false)
                setPositiveButton("ok") {_, _ ->
                    Toast.makeText(this@MainActivity, "${name.text}", Toast.LENGTH_SHORT).show()
                }
                setNegativeButton("cancel") {_, _ ->

                }
                show()
            }

        }
    }
}