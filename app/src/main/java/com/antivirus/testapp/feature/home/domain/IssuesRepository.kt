package com.antivirus.testapp.feature.home.domain

import com.antivirus.testapp.database.model.ComponentStatus
import kotlinx.coroutines.flow.Flow

interface IssuesRepository {

    suspend fun insertIssue(issue: ComponentStatus)

    suspend fun updateIssue(issue: ComponentStatus)

    fun getIssueById(id: Int): Flow<ComponentStatus>

    fun getAllIssues(): Flow<List<ComponentStatus>>
}