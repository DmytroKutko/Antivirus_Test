package com.antivirus.testapp.feature.home.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.antivirus.testapp.feature.core.ui.theme.LatoBold
import com.antivirus.testapp.feature.core.ui.theme.TextPrimary
import com.antivirus.testapp.database.model.ComponentStatus
import com.antivirus.testapp.util.DashboardItems.dashboardItemsList

@Composable
fun BottomSheetContent(status: List<ComponentStatus>) {
    val statusList = dashboardItemsList.map { item ->
        val matchingStatus = status.find { it.type == item.type }
        matchingStatus?.let {
            item.copy(problemsCount = it.problemsCounter)
        } ?: item
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Dashboard",
                fontSize = 24.sp,
                fontFamily = LatoBold,
                color = TextPrimary,
                textAlign = TextAlign.Center
            )
            LazyColumn {
                items(statusList) {
                    DashboardCard(it)
                }
            }
        }
    }
}

