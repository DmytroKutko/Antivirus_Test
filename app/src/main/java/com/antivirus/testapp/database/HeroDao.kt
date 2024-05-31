package com.antivirus.testapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.antivirus.testapp.database.model.ComponentStatus
import kotlinx.coroutines.flow.Flow

@Dao
interface IssueDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIssue(issues: ComponentStatus)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateIssue(issue: ComponentStatus)

    @Query("SELECT * FROM ComponentStatus WHERE id = :id")
    fun getIssueById(id: Int): Flow<ComponentStatus>

    @Query("SELECT * FROM ComponentStatus ORDER BY id ASC")
    fun getAllIssues(): Flow<List<ComponentStatus>>
}