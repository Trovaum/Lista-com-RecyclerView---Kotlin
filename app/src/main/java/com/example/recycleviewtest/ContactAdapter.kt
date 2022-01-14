package com.example.recycleviewtest

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(var listener: ClickContactListener) :
    RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {
    private val list1: MutableList<Contact> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view, list1, listener)
    }

    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list1[position])
    }

    override fun getItemCount(): Int {
        return list1.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Contact>) {
        this.list1.clear()
        this.list1.addAll(list)
        notifyDataSetChanged()
    }

    class ContactAdapterViewHolder(
        itemView: View,
        var list: List<Contact>,
        var listener: ClickContactListener
    ) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.textName)
        private val tvPhone: TextView = itemView.findViewById(R.id.textPhone)
        private val ivPhoto: ImageView = itemView.findViewById(R.id.imageViewPhoto)

        init {
            itemView.setOnClickListener {
                listener.clickItemContact(list[adapterPosition])
            }
        }

        fun bind(contact: Contact) {
            tvName.text = contact.name
            tvPhone.text = contact.phone
        }
    }
}