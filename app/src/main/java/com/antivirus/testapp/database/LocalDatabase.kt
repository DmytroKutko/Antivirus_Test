package com.antivirus.testapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.antivirus.testapp.database.model.ComponentStatus

@Database(entities = [ComponentStatus::class], version = 1, exportSchema = true)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun issueDao(): IssueDao

}