package com.example.applibreriaroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.prototype_contact.view.*

class ContactAdapter(val contacts: List<Contact>, val itemClickListener: OnItemClickListener):
    RecyclerView.Adapter<ContactPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_contact, parent, false)

        return ContactPrototype(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(contactPrototype: ContactPrototype, position: Int) {
        contactPrototype.bind(contacts.get(position), itemClickListener)
    }

}

class ContactPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvName = itemView.tvName
    val tvTelephone = itemView.tvTelephone
    val cvContact = itemView.cvContact

    fun bind(contact: Contact, itemClickListener: OnItemClickListener){
        tvName.text = contact.name
        tvTelephone.text = contact.telephone

        cvContact.setOnClickListener {
            itemClickListener.onItemClicked(contact)
        }
    }

}

interface OnItemClickListener{
    fun onItemClicked(contact: Contact)
}