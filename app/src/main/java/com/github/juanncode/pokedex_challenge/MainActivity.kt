package com.github.juanncode.pokedex_challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.github.juanncode.pokedex_challenge.config.AppRouter
import com.github.juanncode.pokedex_challenge.screens.detail.DetailScreen
import com.github.juanncode.pokedex_challenge.screens.home.HomeScreen
import com.github.juanncode.pokedex_challenge.screens.home.HomeViewModel
import com.github.juanncode.pokedex_challenge.ui.theme.PokedexchallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexchallengeTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = AppRouter.HomeRoute,

                    ) {
                        composable<AppRouter.HomeRoute> {
                            val viewModel = hiltViewModel<HomeViewModel>()
                            val state = viewModel.state
                            HomeScreen(
                                state = state,
                                onEvent = {
                                    viewModel.onEvent(it)
                                },
                                navController = navController
                            )
                        }
                        composable<AppRouter.DetailRoute> {
                            val args = it.toRoute<AppRouter.DetailRoute>()
                            DetailScreen(value = args.id)
                        }
                    }
                }

            }
        }
    }
}
