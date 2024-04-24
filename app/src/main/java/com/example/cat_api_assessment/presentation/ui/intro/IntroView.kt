package com.example.cat_api_assessment.presentation.ui.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.Dp
import com.example.cat_api_assessment.R
import com.example.cat_api_assessment.presentation.theme.AppTheme
import com.example.cat_api_assessment.presentation.theme.CatAppTheme
import com.example.cat_api_assessment.presentation.theme.Dimensions
import com.example.cat_api_assessment.presentation.theme.rememberWindowSizeClass
import com.example.cat_api_assessment.utils.Orientation

@Composable
fun IntroView(
    imageResourceId: Int,
    introTextId: Int,
    introButtonTextId: Int,
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit,
) {
    val dimensions: Dimensions = AppTheme.dimensions
    val orientation: Orientation = AppTheme.orientation
    val imageHeight: Dp =
        if (orientation != Orientation.Landscape) dimensions.introImageHeight else dimensions.introImageHeightLandsCape

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensions.largePadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = modifier
                .fillMaxWidth()
                .height(imageHeight),
            painter = painterResource(id = imageResourceId),
            contentDescription = "introImage"
        )
        Spacer(modifier = modifier.height(dimensions.smallMediumSpacing))
        Text(
            text = stringResource(id = introTextId),
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = modifier.height(dimensions.smallMediumSpacing))
        Button(onClick = onButtonClick) {
            Text(
                text = stringResource(id = introButtonTextId),
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@PreviewScreenSizes
@PreviewLightDark
@Preview(showBackground = true)
@Composable
fun IntroViewPreview() {
    CatAppTheme(rememberWindowSizeClass()) {
        IntroView(
            imageResourceId = R.drawable.the_cat_api_image,
            introButtonTextId = R.string.cat_intro_button_text,
            introTextId = R.string.cat_intro_text,
            onButtonClick = {}
        )
    }
}