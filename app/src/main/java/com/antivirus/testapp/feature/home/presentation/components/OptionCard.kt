package com.antivirus.testapp.feature.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antivirus.testapp.R
import com.antivirus.testapp.feature.core.ui.theme.TextPrimary
import com.antivirus.testapp.feature.core.ui.theme.Cyan
import com.antivirus.testapp.feature.core.ui.theme.LatoBold
import com.antivirus.testapp.feature.core.ui.theme.LatoRegular
import com.antivirus.testapp.feature.core.ui.theme.TextSecondary

@Composable
fun OptionCard(
    icon: Int,
    title: String,
    description: String,
    buttonText: String,
    buttonClicked: () -> Unit,
) {

    Card(
        modifier = Modifier
            .height(213.dp)
            .width(167.dp),
        shape = RoundedCornerShape(19.dp),
        colors = CardDefaults.cardColors().copy(
            containerColor = Color.White
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Card(
                modifier = Modifier
                    .size(48.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors().copy(
                    containerColor = Cyan
                ),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = title,
                fontFamily = LatoBold,
                color = TextPrimary
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = description,
                fontFamily = LatoRegular,
                color = TextSecondary
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = { buttonClicked() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Cyan,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp),
            ) {
                Text(
                    text = buttonText,
                    fontFamily = LatoRegular,
                )
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }

}

@Preview
@Composable
private fun OptionCardPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        OptionCard(
            icon = R.drawable.ic_device,
            title = "Device Scan",
            description = "Show you all info about phone",
            buttonText = "Scan",
            buttonClicked = {}
        )
    }
}