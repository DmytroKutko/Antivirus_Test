package com.antivirus.testapp.feature.home.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.antivirus.testapp.R
import com.antivirus.testapp.feature.core.presentation.ErrorScreen
import com.antivirus.testapp.feature.core.presentation.LoadingScreen
import com.antivirus.testapp.feature.home.data.UiData
import com.antivirus.testapp.feature.home.presentation.components.HomeInfoComponent
import com.antivirus.testapp.util.UiState

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    val context = LocalContext.current

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding()),
        ) {
            when (state) {
                is UiState.Error -> {
                    (state as UiState.Error).error.localizedMessage?.let {
                        ErrorScreen(it)
                    }
                }

                UiState.Idle -> {}
                UiState.Loading -> {
                    LoadingScreen()
                }

                is UiState.Success -> {
                    HomeInfoComponent(
                        data = (state as UiState.Success<UiData>).data,
                        scanClicked = {
                            Toast.makeText(
                                context.applicationContext,
                                context.getString(R.string.scan_clicked),
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        deviceScanClicked = {
                            Toast.makeText(
                                context.applicationContext,
                                context.getString(R.string.scan_device_clicked),
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        checkForVirusesClicked = {
                            Toast.makeText(
                                context.applicationContext,
                                context.getString(R.string.check_for_viruses_clicked),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}