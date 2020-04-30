package com.example.appagenda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.protoype_contact.view.*

class ContactAdapter(var contacts: ArrayList<Contact>): RecyclerView.Adapter<ContactPropotype>() {
    // crea el prototipo (ViewHolder) para c/fila
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactPropotype {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.protoype_contact, parent, false)

        return  ContactPropotype(view)
    }

    // Devuelve la cantidad de elementos
    override fun getItemCount(): Int {
        return contacts.size
    }

    // Conecta la información de la vista para c/fila
    override fun onBindViewHolder(contactPrototype: ContactPropotype, position: Int) {
        contactPrototype.bind(contacts.get(position))
    }

}

class ContactPropotype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvName = itemView.tvName
    val tvTelephone = itemView.tvTelephone

    fun bind(contact: Contact){
        tvName.text = contact.name
        tvTelephone.text = contact.telephone
    }
}
