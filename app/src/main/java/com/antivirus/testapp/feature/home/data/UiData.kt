package com.antivirus.testapp.feature.home.data

import com.antivirus.testapp.database.model.ComponentStatus

data class UiData(
    val status: List<ComponentStatus>,
    val totalProblemsCount: Int
)
