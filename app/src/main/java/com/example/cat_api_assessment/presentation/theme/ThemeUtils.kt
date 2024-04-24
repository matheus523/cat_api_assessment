package com.example.cat_api_assessment.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import com.example.cat_api_assessment.utils.Orientation
import com.example.cat_api_assessment.utils.WindowType

@Composable
fun ProvideThemeUtils(
    dimensions: Dimensions,
    orientation: Orientation,
    windowTpe: WindowType,
    content: @Composable () -> Unit
) {
    val dimSet = remember { dimensions }
    val orientationSet = remember { orientation }
    CompositionLocalProvider(
        LocalAppDimens provides dimSet,
        LocalOrientationMode provides orientationSet,
        LocalWindowTye provides windowTpe,
        content = content
    )
}

val LocalAppDimens = compositionLocalOf { smallDimensions }

val LocalOrientationMode = compositionLocalOf { Orientation.Portrait }

val LocalWindowTye = compositionLocalOf { WindowType.SMALL }