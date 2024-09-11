package com.github.juanncode.pokedex_challenge.screens.home

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.github.juanncode.domain.Pokemon
import com.github.juanncode.pokedex_challenge.config.AppRouter
import com.github.juanncode.pokedex_challenge.screens.home.components.HeaderHomeWidget
import com.github.juanncode.pokedex_challenge.screens.home.components.ItemPokemon
import com.github.juanncode.pokedex_challenge.ui.theme.PokedexchallengeTheme

@Composable
fun HomeScreen(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
    navController: NavController

) {
    val context = LocalContext.current

    LaunchedEffect(key1 = state.error) {
        if (state.error != null) {
            Toast.makeText(
                context,
                state.error.message,
                Toast.LENGTH_LONG
            ).show()
            onEvent(HomeEvent.CleanError)

        }
    }
    Scaffold {
        Box(modifier = Modifier.padding(it)) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(count = 2)
            ) {
                item(span = { GridItemSpan(2) }) {
                    HeaderHomeWidget(modifier = Modifier.fillMaxWidth())
                }
                items(state.pokemons) {
                    ItemPokemon(pokemon = it,
                        onItemClick = {
                            navController.navigate(AppRouter.DetailRoute(it))
                        }
                    )
                }
            }

            if (state.loading) {
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
private fun PreviewHomeScreen() {
    PokedexchallengeTheme {
        HomeScreen(
            state = HomeState(
                pokemons = listOf(
                    Pokemon(
                        id = 1,
                        name = "Pikachu",
                        url = ""
                    ),
                    Pokemon(
                        id = 1,
                        name = "Pikachu",
                        url = ""
                    )
                )
            ),
            onEvent = {
                HomeEvent.Refresh
            },
            navController = rememberNavController()
        )
    }
}