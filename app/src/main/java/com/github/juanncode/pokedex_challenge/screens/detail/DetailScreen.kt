@file:OptIn(ExperimentalMaterial3Api::class)

package com.github.juanncode.pokedex_challenge.screens.detail

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.github.juanncode.pokedex_challenge.screens.components.PokedexToolbar
import com.github.juanncode.pokedex_challenge.screens.detail.components.ItemDetail
import com.github.juanncode.pokedex_challenge.ui.theme.PokedexBlue
import com.github.juanncode.pokedex_challenge.ui.theme.PokedexBlue30
import com.github.juanncode.pokedex_challenge.ui.theme.PokedexchallengeTheme

@Composable
fun DetailScreen(modifier: Modifier = Modifier, value: Int) {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current

    val screenWidthPx = with(density) {
        configuration.screenWidthDp.dp.roundToPx()
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
                showBackButton = true
            )
        }
    ) {

        Box(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(it)

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubcomposeAsyncImage(
                    model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(220.dp),
                    contentDescription = "pokemon",
                    loading = { CircularProgressIndicator(modifier = Modifier.size(25.dp)) }
                )
                ItemDetail(title = "Tipo", value = "Fuego")
                ItemDetail(title = "Tipo", value = "Fuego")
                ItemDetail(title = "Tipo", value = "Fuego")
            }

        }
    }
}

@Preview
@Composable
private fun PreviewDetailScreen() {
    PokedexchallengeTheme {
        DetailScreen(value = 3)
    }
}