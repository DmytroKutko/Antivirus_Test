package com.antivirus.testapp.database

import com.antivirus.testapp.database.model.ComponentStatus
import com.antivirus.testapp.feature.home.domain.IssuesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IssuesRepositoryImpl @Inject constructor(
    private val dao: IssueDao,
) : IssuesRepository {
    override suspend fun insertIssue(issue: ComponentStatus) = dao.insertIssue(issue)

    override suspend fun updateIssue(issue: ComponentStatus) = dao.updateIssue(issue)

    override fun getIssueById(id: Int): Flow<ComponentStatus> = dao.getIssueById(id)

    override fun getAllIssues(): Flow<List<ComponentStatus>> = dao.getAllIssues()

}