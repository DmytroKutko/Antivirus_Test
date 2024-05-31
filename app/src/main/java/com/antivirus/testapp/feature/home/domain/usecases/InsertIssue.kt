package com.antivirus.testapp.feature.home.domain.usecases

import com.antivirus.testapp.database.model.ComponentStatus
import com.antivirus.testapp.feature.home.domain.IssuesRepository
import javax.inject.Inject

class InsertIssue @Inject constructor(
    private val repository: IssuesRepository
) {

    suspend operator fun invoke(issue: ComponentStatus) {
        repository.insertIssue(issue)
    }
}