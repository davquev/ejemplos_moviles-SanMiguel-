package com.example.applibreriaroom

import androidx.room.*

@Dao
interface ContactDao {
    @Query("select * from Contact")
    fun getAll(): List<Contact>

    @Insert
    fun insertContact(vararg contact: Contact)

    @Delete
    fun deleteContact(vararg contact: Contact)

    @Update
    fun updateContact(vararg contact: Contact)
}