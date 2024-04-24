package com.example.cat_api_assessment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cat_api_assessment.presentation.navGraph.RootNavigationGraph
import com.example.cat_api_assessment.presentation.route.IntroRoute
import com.example.cat_api_assessment.presentation.theme.CatAppTheme
import com.example.cat_api_assessment.presentation.theme.rememberWindowSizeClass
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CatAppTheme(windowSizeClass = rememberWindowSizeClass()) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) { GoToRootNavigationGraph() }
            }
        }
    }
}

@Composable
private fun GoToRootNavigationGraph() {
    val navController: NavHostController = rememberNavController()
    RootNavigationGraph(
        navController = navController,
        startDestination = IntroRoute.CatBreedIntroRoute
    )
}