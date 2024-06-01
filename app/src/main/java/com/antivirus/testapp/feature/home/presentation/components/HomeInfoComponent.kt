package com.antivirus.testapp.feature.home.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antivirus.testapp.R
import com.antivirus.testapp.feature.core.ui.theme.BottomSheetBackground
import com.antivirus.testapp.feature.core.ui.theme.CardSecondary
import com.antivirus.testapp.feature.core.ui.theme.ContainerSecondary
import com.antivirus.testapp.feature.core.ui.theme.Cyan
import com.antivirus.testapp.feature.core.ui.theme.LatoBold
import com.antivirus.testapp.feature.core.ui.theme.LatoRegular
import com.antivirus.testapp.feature.core.ui.theme.Red
import com.antivirus.testapp.feature.home.data.UiData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeInfoComponent(
    data: UiData,
    scanClicked: () -> Unit,
    deviceScanClicked: () -> Unit,
    checkForVirusesClicked: () -> Unit,
) {
    BottomSheetScaffold(
        sheetPeekHeight = 240.dp,
        sheetContent = {
            Box(
                modifier = Modifier
                    .heightIn(max = 640.dp)
            ) {
                BottomSheetContent(data.status)
            }
        },
        sheetContainerColor = BottomSheetBackground,
        sheetShadowElevation = 8.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = ContainerSecondary),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-262).dp),
                contentAlignment = Alignment.Center
            ) {

                LottieLoader(modifier = Modifier)

                Card(
                    modifier = Modifier,
                    border = BorderStroke(
                        width = 7.dp,
                        color = CardSecondary
                    ),
                    shape = RoundedCornerShape(150.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .size(224.dp)
                            .background(Color.White)
                            .clickable {
                                scanClicked()
                            },
                        contentAlignment = Alignment.Center
                    ) {

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(width = 90.dp, height = 88.dp),
                                painter = painterResource(id = R.drawable.ic_main),
                                contentDescription = null
                            )

                            Text(
                                text = stringResource(R.string.scan),
                                color = Cyan,
                                fontFamily = LatoBold,
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Spacer(modifier = Modifier.size(8.dp))

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {

                                if (data.totalProblemsCount > 0) {
                                    Card(
                                        modifier = Modifier
                                            .size(19.dp),
                                        shape = RoundedCornerShape(13.dp),
                                        colors = CardDefaults.cardColors().copy(
                                            containerColor = Red
                                        ),
                                    ) {
                                        Text(
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            text = stringResource(R.string.sign),
                                            color = Color.White,
                                            textAlign = TextAlign.Center
                                        )
                                    }

                                    Spacer(modifier = Modifier.size(4.dp))

                                    Text(
                                        text = stringResource(
                                            R.string.problems,
                                            data.totalProblemsCount
                                        ),
                                        color = Red,
                                        fontFamily = LatoRegular
                                    )
                                } else {
                                    Text(
                                        text = stringResource(
                                            R.string.problems,
                                            data.totalProblemsCount
                                        ),
                                        fontFamily = LatoRegular
                                    )
                                }
                            }
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .padding(top = 372.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Spacer(modifier = Modifier.weight(1F))

                    OptionCard(
                        icon = R.drawable.ic_device,
                        title = stringResource(R.string.device_scan),
                        description = stringResource(R.string.show_you_all_info_about_phone),
                        buttonText = stringResource(R.string.scan),
                        buttonClicked = {
                            deviceScanClicked()
                        }
                    )

                    Spacer(modifier = Modifier.weight(0.5F))

                    OptionCard(
                        icon = R.drawable.ic_virus,
                        title = stringResource(R.string.check_for_viruses),
                        description = stringResource(R.string.show_you_all_info_about_phone),
                        buttonText = stringResource(R.string.check),
                        buttonClicked = {
                            checkForVirusesClicked()
                        }
                    )

                    Spacer(modifier = Modifier.weight(1F))
                }
            }
        }
    }
}


@Preview
@Composable
private fun HomeInfoComponent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        HomeInfoComponent(
            data = UiData(emptyList(), 12),
            scanClicked = {},
            deviceScanClicked = {},
            checkForVirusesClicked = {}
        )
    }
}