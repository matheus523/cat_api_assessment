package com.example.cat_api_assessment.presentation.ui.components.dialog

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog
import com.example.cat_api_assessment.presentation.theme.LightBackground

@Composable
fun LoadingDialog() {
    Dialog(onDismissRequest = { }) {
        CircularProgressIndicator(color = LightBackground)
    }
}