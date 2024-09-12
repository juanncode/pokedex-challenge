@file:OptIn(ExperimentalMaterial3Api::class)

package com.github.juanncode.pokedex_challenge.screens.detail

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.SubcomposeAsyncImage
import com.github.juanncode.pokedex_challenge.screens.components.PokedexToolbar
import com.github.juanncode.pokedex_challenge.screens.detail.components.ItemDetail
import com.github.juanncode.pokedex_challenge.ui.theme.PokedexchallengeTheme

@Composable
fun DetailScreen(
    state: DetailState,
    onEvent: (DetailEvent) -> Unit,
    navController: NavController,
    value: Int
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = value) {
        onEvent(DetailEvent.GetPokemon(value))
    }

    LaunchedEffect(key1 = state.error) {
        if (state.error != null) {
            Toast.makeText(
                context,
                state.error.message,
                Toast.LENGTH_LONG
            ).show()
            onEvent(DetailEvent.CleanError)

        }
    }

    Scaffold(
        topBar = {
            PokedexToolbar(
                title = "Pikachu",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent),
                startContent = {
                    Icon(imageVector = Icons.Default.Face, contentDescription = null)
                },
                showBackButton = true,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(it)

        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    SubcomposeAsyncImage(
                        model = state.pokemon?.url,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(220.dp),
                        contentDescription = "pokemon",
                        loading = { CircularProgressIndicator(modifier = Modifier.size(25.dp)) }
                    )
                }
                item {
                    state.pokemon?.types?.map {
                        ItemDetail(title = "Tipo", value = it)
                    }
                }
                item {
                    state.pokemon?.abilities?.map {
                        ItemDetail(title = "Habilidades", value = it)
                    }
                }

            }
            if (state.isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Gray.copy(alpha = 0.5f)),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewDetailScreen() {
    PokedexchallengeTheme {
        DetailScreen(
            onEvent = {

            },
            state = DetailState(),
            navController = rememberNavController(),
            value = 3
        )
    }
}