package com.example.almacentienda

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_name")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String
)