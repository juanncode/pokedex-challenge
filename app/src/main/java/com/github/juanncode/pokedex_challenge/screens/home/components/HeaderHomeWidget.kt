package com.github.juanncode.pokedex_challenge.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderHomeWidget(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(horizontal = 15.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(15.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.Face, contentDescription = "Face")
            Spacer(Modifier.width(5.dp))
            Text(text = "Pokedex", style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.W700))
        }
        Spacer(Modifier.height(15.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.4f))
                .padding(horizontal = 10.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
            Spacer(Modifier.width(5.dp))

            Text(
                text = "Busca tu pokemon",
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.W600)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }
    }

}

@Preview
@Composable
private fun TestHeaderMovieWidget() {
    HeaderHomeWidget()
}