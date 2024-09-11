package com.github.juanncode.pokedex_challenge.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.github.juanncode.domain.Pokemon


@Composable
fun ItemPokemon(
    modifier: Modifier = Modifier,
    pokemon: Pokemon,
    onItemClick: (Int) -> Unit,
) {
    Box(
        modifier = modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.Black.copy(alpha = 0.5f))
            .clickable {
                onItemClick(pokemon.id)
            }
            .padding(10.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Row {
                Text(text = "#${pokemon.id}", color = MaterialTheme.colorScheme.onPrimary)
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = pokemon.name,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.SemiBold
                )
            }
            SubcomposeAsyncImage(
                model = pokemon.url,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(120.dp),
                contentDescription = "pokemon ${pokemon.name}",
                loading = { CircularProgressIndicator(modifier = Modifier.size(25.dp)) }
            )
        }
    }
}
