package com.example.cat_api_assessment.presentation.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.cat_api_assessment.utils.GlobalFunctions.ChangeStatusAndNavigationBarColor
import com.example.cat_api_assessment.utils.Orientation
import com.example.cat_api_assessment.utils.WindowType

private val DarkColorScheme = darkColorScheme(
    primary = LightBackground,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    onPrimary = DarkBackground,
    background = DarkBackground,
    onBackground = LightBackground,
)

private val LightColorScheme = lightColorScheme(
    primary = DarkBackground,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    onPrimary = LightBackground,
    background = LightBackground,
    onBackground = DarkBackground,
)

@Composable
fun CatAppTheme(
    windowSizeClass: WindowSizeClass,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme: ColorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val orientation: Orientation = when {
        windowSizeClass.width.size > windowSizeClass.height.size -> Orientation.Landscape
        else -> Orientation.Portrait
    }

    val sizeThatMatters: WindowSize = when (orientation) {
        Orientation.Portrait -> windowSizeClass.width
        else -> windowSizeClass.height
    }

    val dimensions: Dimensions = when (sizeThatMatters) {
        is WindowSize.Small -> smallDimensions
        is WindowSize.Compact -> compactDimensions
        is WindowSize.Medium -> mediumDimensions
        else -> largeDimensions
    }

    val windowType: WindowType = when (sizeThatMatters) {
        is WindowSize.Small -> WindowType.SMALL
        is WindowSize.Compact -> WindowType.COMPACT
        is WindowSize.Medium -> WindowType.MEDIUM
        else -> WindowType.LARGE
    }

    val typography = when (sizeThatMatters) {
        is WindowSize.Small -> typographySmall

        is WindowSize.Compact -> typographyCompact

        is WindowSize.Medium -> typographyMedium

        else -> typographyBig
    }

    ChangeStatusAndNavigationBarColor(
        statusBarColor = if (darkTheme) DarkBackground else LightBackground,
        navigationBarColor = if (darkTheme) DarkBackground else LightBackground
    )

    ProvideThemeUtils(dimensions = dimensions, orientation = orientation, windowTpe = windowType) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            content = content
        )
    }
}

object AppTheme {
    val dimensions: Dimensions
        @Composable
        get() = LocalAppDimens.current

    val orientation: Orientation
        @Composable
        get() = LocalOrientationMode.current

    val windowType: WindowType
        @Composable
        get() = LocalWindowTye.current
}