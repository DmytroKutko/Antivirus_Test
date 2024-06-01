package com.antivirus.testapp

import android.app.Activity
import android.graphics.Color.TRANSPARENT
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.antivirus.testapp.feature.core.ui.theme.AntivirusTestAppTheme
import com.antivirus.testapp.feature.core.ui.theme.ContainerSecondary
import com.antivirus.testapp.navigation.AppNavigation
import com.antivirus.testapp.util.Constants.backPressInterval
import com.antivirus.testapp.util.Constants.backPressedTime
import dagger.hilt.android.AndroidEntryPoint
import kotlin.system.exitProcess

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setupBackPressHandler()
        setContent {
            AntivirusTestAppTheme {
                setStatusBarColor(color = ContainerSecondary)
                AppNavigation()
            }
        }
    }

    private fun setupBackPressHandler() {
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (backPressedTime + backPressInterval > System.currentTimeMillis()) {
                    // Exit the app
                    finishAffinity()
                    exitProcess(0)
                } else {
                    Toast.makeText(applicationContext,
                        getString(R.string.press_back_again_to_exit), Toast.LENGTH_SHORT).show()
                    backPressedTime = System.currentTimeMillis()
                }
            }
        }

        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
    }
}

@Composable
private fun setStatusBarColor(color: Color){
    val view = LocalView.current

    if (!view.isInEditMode){
        LaunchedEffect(key1 = true) {
            val window = (view.context as Activity).window
            window.statusBarColor = color.toArgb()
        }
    }
}