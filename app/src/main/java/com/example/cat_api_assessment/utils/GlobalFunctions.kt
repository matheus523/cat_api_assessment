package com.example.cat_api_assessment.utils

import android.app.Activity
import android.view.View
import android.view.Window
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

object GlobalFunctions {
    @Composable
    fun ChangeStatusAndNavigationBarColor(
        darkTheme: Boolean = isSystemInDarkTheme(),
        statusBarColor: Color? = null,
        navigationBarColor: Color? = null
    ) {
        val view: View = LocalView.current
        if (!view.isInEditMode) {
            val currentWindow: Window = (view.context as? Activity)?.window
                ?: throw Exception("Not in an activity - unable to get Window reference")

            SideEffect {
                statusBarColor?.let { color: Color ->
                    (view.context as Activity).window.statusBarColor = color.toArgb()
                }
                navigationBarColor?.let { color: Color ->
                    (view.context as Activity).window.navigationBarColor = color.toArgb()
                }
                WindowCompat.getInsetsController(
                    currentWindow,
                    view
                ).isAppearanceLightStatusBars = !darkTheme
            }
        }
    }
}