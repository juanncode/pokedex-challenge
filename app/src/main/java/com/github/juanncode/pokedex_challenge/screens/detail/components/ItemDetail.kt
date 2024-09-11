package com.github.juanncode.pokedex_challenge.screens.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.juanncode.pokedex_challenge.ui.theme.PokedexchallengeTheme


@Composable
fun ItemDetail(
    title: String,
    value: String,
    modifier: Modifier = Modifier,
    valueFontSize: TextUnit = 16.sp
) {
    Row(
        modifier = modifier
            .padding(vertical = 10.dp, horizontal = 16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(10.dp)

        ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 12.sp,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = value,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = valueFontSize,
            modifier = Modifier.weight(1f)

        )
    }
}

@Preview
@Composable
private fun PreviewItemDetail() {
    PokedexchallengeTheme {
        ItemDetail(title = "Tipo", value = "Agua")
    }

}