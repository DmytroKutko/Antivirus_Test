package com.antivirus.testapp.feature.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antivirus.testapp.R
import com.antivirus.testapp.feature.core.ui.theme.LatoBold
import com.antivirus.testapp.feature.core.ui.theme.LatoRegular
import com.antivirus.testapp.feature.core.ui.theme.Red
import com.antivirus.testapp.feature.core.ui.theme.TextPrimary
import com.antivirus.testapp.feature.core.ui.theme.TextSecondary
import com.antivirus.testapp.feature.home.data.DashboardItemData

@Composable
fun DashboardCard(
    dashboardItem: DashboardItemData,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(vertical = 8.dp, horizontal = 12.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors().copy(
            containerColor = Red
        ),
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .then(
                    if (dashboardItem.problemsCount > 0) {
                        Modifier.padding(start = 5.dp)
                    } else {
                        Modifier
                    }
                ),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors().copy(
                containerColor = Color.White
            ),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = dashboardItem.icon),
                    contentDescription = dashboardItem.type
                )

                Column(
                    modifier = Modifier
                        .weight(1F)
                        .padding(horizontal = 8.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = dashboardItem.title,
                        color = TextPrimary,
                        fontFamily = LatoBold,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = dashboardItem.description,
                        color = TextSecondary,
                        fontFamily = LatoRegular
                    )

                }

                if (dashboardItem.problemsCount > 0) {
                    Card(
                        modifier = Modifier
                            .size(24.dp),
                        shape = RoundedCornerShape(13.dp),
                        colors = CardDefaults.cardColors().copy(
                            containerColor = Red
                        ),
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxSize(),
                            text = "${dashboardItem.problemsCount}",
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Spacer(modifier = Modifier.size(4.dp))

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
private fun DashboardCardPreview() {
    Box(modifier = Modifier.background(Color.DarkGray)) {
        DashboardCard(
            dashboardItem = DashboardItemData(
                icon = R.drawable.device_info,
                title = "Device info",
                description = "Show you all info about phone",
                problemsCount = 0,
                type = "device_info"
            )
        )
    }
}