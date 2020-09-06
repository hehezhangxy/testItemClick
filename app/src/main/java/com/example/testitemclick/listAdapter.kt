package com.example.testitemclick

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class listAdapter(activity: Activity,  val resourceId: Int, data: List<String>) : ArrayAdapter<String>(activity, resourceId , data) {
    lateinit var item: String

    inner class ViewHolder (val name: TextView, val edit: Button, val delete:Button, var rename: Button)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            val name: TextView = view.findViewById(R.id.text)
            val edit: Button = view.findViewById(R.id.edit)
            val delete: Button = view.findViewById(R.id.delete)
            val rename: Button = view.findViewById(R.id.rename)
            viewHolder  = ViewHolder(name, edit, delete, rename)
            view.tag = viewHolder

        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        val item = getItem(position)
        if (item != null) {
            this.item = item
        }
        if (item != null) {
            viewHolder.name.text = item
        }
        viewHolder.edit.setOnClickListener {
            if (::editLam.isInitialized) {
                if (item != null) {
                    editLam(item)
                }
            }
        }
        viewHolder.rename.setOnClickListener {
            if (::renameLam.isInitialized) {
                if (item != null) {
                    renameLam(item)
                }
            }
        }
        return view
    }
    lateinit var editLam: ((String) -> Unit)
    fun setedit(e: (String) -> Unit) {
        this.editLam = e

    }
    lateinit var renameLam: ((String) -> Unit)
    fun setrename(e: (String) -> Unit) {
        this.renameLam = e
    }



}