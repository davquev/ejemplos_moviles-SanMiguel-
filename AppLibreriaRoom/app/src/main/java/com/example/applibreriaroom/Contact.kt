package com.example.applibreriaroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact (
    //requisito tener PK
    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    @ColumnInfo
    var name: String?,

    @ColumnInfo
    var telephone: String?
)