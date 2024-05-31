package com.antivirus.testapp.feature.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antivirus.testapp.database.model.ComponentStatus
import com.antivirus.testapp.feature.home.data.UiData
import com.antivirus.testapp.feature.home.domain.usecases.IssuesUseCases
import com.antivirus.testapp.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: IssuesUseCases
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<UiData>> = MutableStateFlow(UiState.Idle)
    val uiState = _uiState.asStateFlow()

    init {
        initialStatus()
        getDeviceStatus()
    }

    private fun getDeviceStatus() = viewModelScope.launch {
        useCases.getAllIssues()
            .onStart {
                _uiState.emit(UiState.Loading)
            }
            .catch {
                _uiState.emit(UiState.Error(it))
            }
            .collect { componentStatusList ->
                delay(2000L) // Just in case ;D

                val totalCount = componentStatusList.sumOf {status ->
                    status.problemsCounter
                }

                _uiState.emit(
                    UiState.Success(
                        UiData(componentStatusList, totalCount)
                    )
                )
            }
    }

    private fun initialStatus() = viewModelScope.launch {
        useCases.insertIssue(
            issue = ComponentStatus(
                id = 0,
                type = "battery_info",
                problemsCounter = 1
            )
        )
        useCases.insertIssue(
            issue = ComponentStatus(
                id = 1,
                type = "calibration_of_sensors",
                problemsCounter = 1
            )
        )
    }
}