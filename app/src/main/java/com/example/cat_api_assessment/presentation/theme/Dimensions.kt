package com.example.cat_api_assessment.presentation.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(

    /* Image */
    val introImageHeight: Dp,
    val introImageHeightLandsCape: Dp,

    /* Spacing */
    val smallSpacing: Dp,
    val smallMediumSpacing: Dp,
    val mediumSpacing: Dp,

    /* Padding */
    val dialogPadding: Dp,
    val smallMediumPadding: Dp,
    val mediumLargePadding: Dp,
    val largePadding: Dp,
)

val smallDimensions = Dimensions(

    /* Image */
    introImageHeight = 200.dp,
    introImageHeightLandsCape = 150.dp,

    /* Spacing */
    smallSpacing = 3.dp,
    smallMediumSpacing = 10.dp,
    mediumSpacing = 16.dp,

    /* Padding */
    dialogPadding = 30.dp,
    smallMediumPadding = 5.dp,
    mediumLargePadding = 16.dp,
    largePadding = 30.dp,
)

val compactDimensions = Dimensions(

    /* Image */
    introImageHeight = 300.dp,
    introImageHeightLandsCape = 200.dp,

    /* Spacing */
    smallSpacing = 4.dp,
    smallMediumSpacing = 12.dp,
    mediumSpacing = 20.dp,

    /* Padding */
    dialogPadding = 30.dp,
    smallMediumPadding = 5.dp,
    mediumLargePadding = 20.dp,
    largePadding = 30.dp,
)

val mediumDimensions = Dimensions(

    /* Image */
    introImageHeight = 320.dp,
    introImageHeightLandsCape = 220.dp,

    /* Spacing */
    smallSpacing = 5.dp,
    smallMediumSpacing = 16.dp,
    mediumSpacing = 24.dp,

    /* Padding */
    dialogPadding = 30.dp,
    smallMediumPadding = 8.dp,
    mediumLargePadding = 25.dp,
    largePadding = 30.dp,
)

val largeDimensions = Dimensions(

    /* Image */
    introImageHeight = 400.dp,
    introImageHeightLandsCape = 300.dp,

    /* Spacing */
    smallSpacing = 5.dp,
    smallMediumSpacing = 25.dp,
    mediumSpacing = 32.dp,

    /* Padding */
    dialogPadding = 10.dp,
    smallMediumPadding = 10.dp,
    mediumLargePadding = 30.dp,
    largePadding = 50.dp,
)