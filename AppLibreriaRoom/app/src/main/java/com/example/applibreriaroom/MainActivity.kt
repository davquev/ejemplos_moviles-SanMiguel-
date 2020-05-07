package com.example.applibreriaroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnItemClickListener {
    override fun onItemClicked(contact: Contact) {

        val intent = Intent(this, ContactActivity::class.java)
        val gson = Gson()
        intent.putExtra("contact", gson.toJson(contact))
        startActivity(intent)
    }

    lateinit var contacts: List<Contact>
    lateinit var contactAdapter: ContactAdapter

    //este metodo se llama solo 1 vez
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()

        loadContacts()

        contactAdapter = ContactAdapter(contacts, this)
        rvContact.adapter = contactAdapter
        rvContact.layoutManager = LinearLayoutManager(this)
    }

    private fun loadContacts() {
        // puedo hacer esto xq declare la clase AppDatabase como ABSTRACTA
        contacts = AppDatabase.getInstance(this).getDao().getAll()
    }

    //CTRL + O
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.itemAdd ->{
                val intent = Intent(this, ContactActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }


    }
}
