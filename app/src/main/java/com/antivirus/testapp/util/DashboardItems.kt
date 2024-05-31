package com.antivirus.testapp.util

import com.antivirus.testapp.R
import com.antivirus.testapp.feature.home.data.DashboardItemData

object DashboardItems {
    val dashboardItemsList = listOf(
        DashboardItemData(
            icon = R.drawable.device_info,
            title = "Device info",
            description = "Show you all info about phone",
            problemsCount = 0,
            type = "device_info"
        ),

        DashboardItemData(
            icon = R.drawable.calibration_of_sensors,
            title = "Calibration of sensors",
            description = "Show you all info about phone",
            problemsCount = 0,
            type = "calibration_of_sensors"
        ),

        DashboardItemData(
            icon = R.drawable.app_monitoring,
            title = "App monitoring",
            description = "Show you all info about phone",
            problemsCount = 0,
            type = "app_monitoring"
        ),

        DashboardItemData(
            icon = R.drawable.antivirus,
            title = "AntiVirus",
            description = "Show you all info about phone",
            problemsCount = 0,
            type = "antivirus"
        ),

        DashboardItemData(
            icon = R.drawable.device_memory_information,
            title = "Device Memory Information",
            description = "Show you all info about phone",
            problemsCount = 0,
            type = "device_memory_information"
        ),

        DashboardItemData(
            icon = R.drawable.file_manager,
            title = "File manager",
            description = "Show you all info about phone",
            problemsCount = 0,
            type = "file_manager"
        ),

        DashboardItemData(
            icon = R.drawable.battery_info,
            title = "Battery info",
            description = "Show you all info about phone",
            problemsCount = 0,
            type = "battery_info"
        ),

    )
}