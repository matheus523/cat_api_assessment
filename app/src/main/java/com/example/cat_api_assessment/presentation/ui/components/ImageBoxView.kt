package com.example.cat_api_assessment.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cat_api_assessment.data.model.Image

@Composable
fun ImageBoxView(
    image: Image?,
    animalName: String,
    placeHolderResourceId: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(150.dp)
            .clip(shape = CardDefaults.elevatedShape)
    ) {
        if (image == null) {
            Image(
                modifier = modifier.size(150.dp),
                painter = painterResource(id = placeHolderResourceId),
                contentDescription = "place holder",
                contentScale = ContentScale.FillBounds
            )
        } else {
            AsyncImage(
                model = image.url,
                contentDescription = animalName,
                contentScale = ContentScale.FillBounds
            )
        }
    }
}