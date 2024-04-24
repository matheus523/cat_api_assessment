package com.example.cat_api_assessment.presentation.ui.animalList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.cat_api_assessment.R
import com.example.cat_api_assessment.data.model.AnimalBreed
import com.example.cat_api_assessment.presentation.theme.AppTheme
import com.example.cat_api_assessment.presentation.theme.Dimensions
import com.example.cat_api_assessment.presentation.ui.components.ImageBoxView

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AnimalListElement(
    animalBreed: AnimalBreed,
    modifier: Modifier = Modifier,
) {
    val dimensions: Dimensions = AppTheme.dimensions

    ElevatedCard(modifier = modifier.fillMaxWidth()) {
        Row {
            ImageBoxView(
                image = animalBreed.animalImage,
                animalName = animalBreed.animalName,
                placeHolderResourceId = R.drawable.cat_place_holder
            )
            Column(
                modifier = modifier.padding(dimensions.smallMediumPadding),
                verticalArrangement = Arrangement.spacedBy(dimensions.smallSpacing)
            ) {
                Text(text = animalBreed.animalName, style = MaterialTheme.typography.labelLarge)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(dimensions.smallMediumSpacing)
                ) {
                    Text(
                        text = stringResource(id = R.string.country_code),
                        style = MaterialTheme.typography.labelMedium
                    )
                    Text(
                        text = animalBreed.animalCountryCode,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                FlowRow(
                    verticalArrangement = Arrangement.spacedBy(dimensions.smallSpacing),
                    horizontalArrangement = Arrangement.spacedBy(dimensions.smallMediumSpacing)
                ) {
                    Text(
                        text = stringResource(id = R.string.temperament),
                        style = MaterialTheme.typography.labelMedium
                    )
                    animalBreed.animalTemperament.forEach { temperament: String ->
                        Text(text = temperament, style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}