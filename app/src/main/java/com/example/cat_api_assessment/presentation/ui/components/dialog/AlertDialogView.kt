package com.example.cat_api_assessment.presentation.ui.components.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.DialogProperties
import com.example.cat_api_assessment.presentation.theme.AppTheme
import com.example.cat_api_assessment.presentation.theme.Dimensions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogView(
    title: String,
    body: String,
    buttonText: String,
    modifier: Modifier = Modifier,
    properties: DialogProperties = DialogProperties(usePlatformDefaultWidth = false),
    actionCallBack: (() -> Unit),
) {
    val dimensions: Dimensions = AppTheme.dimensions

    BasicAlertDialog(
        onDismissRequest = { /* Do nothing */ },
        properties = properties
    ) {
        Surface(
            modifier = modifier.padding(horizontal = dimensions.dialogPadding),
            shape = MaterialTheme.shapes.large,
            tonalElevation = AlertDialogDefaults.TonalElevation
        ) {
            Column(modifier = modifier.padding(dimensions.mediumLargePadding)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.displaySmall,
                )
                Spacer(modifier = modifier.height(dimensions.smallMediumSpacing))
                Text(
                    text = body,
                    style = MaterialTheme.typography.labelMedium,
                )
                Spacer(modifier = Modifier.height(dimensions.mediumSpacing))
                Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    TextButton(onClick = actionCallBack) { Text(text = buttonText) }
                }
            }
        }
    }
}