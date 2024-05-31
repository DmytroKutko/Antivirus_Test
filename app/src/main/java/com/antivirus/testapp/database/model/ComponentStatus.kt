package com.antivirus.testapp.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ComponentStatus(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val type: String,
    val problemsCounter: Int,
)
