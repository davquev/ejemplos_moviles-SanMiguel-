package com.example.apppersistenciasharedpref

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = SharedPreferences(this)

        btnSave.setOnClickListener {
            val name = etName.text.toString()

            //grabo ese texto en el SharePref.
            sharedPreferences.save("name", name)

            Toast.makeText(this, "Data stored", Toast.LENGTH_LONG).show()
        }

        btnRetrieve.setOnClickListener {
            if (sharedPreferences.getValue("name") != null){
                tvRetrieve.setText(sharedPreferences.getValue("name"))
            }
        }
    }
}
