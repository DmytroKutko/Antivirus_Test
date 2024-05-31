package com.antivirus.testapp.feature.home.domain.usecases

import com.antivirus.testapp.database.model.ComponentStatus
import com.antivirus.testapp.feature.home.domain.IssuesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllIssues @Inject constructor(
    private val repository: IssuesRepository,
) {

    suspend operator fun invoke(): Flow<List<ComponentStatus>> = repository.getAllIssues()
}