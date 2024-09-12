package com.github.juanncode.pokedex_challenge.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.juanncode.pokedex_challenge.screens.components.PokedexTextField

@Composable
fun HeaderHomeWidget(
    modifier: Modifier = Modifier,
    textFieldState: TextFieldState,
    onClickCancel: () -> Unit,
) {
    Column(
        modifier = modifier.padding(horizontal = 15.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(15.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.Face, contentDescription = "Face")
            Spacer(Modifier.width(5.dp))
            Text(
                text = "Pokedex",
                style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.W700)
            )
        }
        Spacer(Modifier.height(15.dp))
        PokedexTextField(
            state = textFieldState,
            endIcon = Icons.Default.Close,
            startIcon = Icons.Default.Search,
            hint = "Busca tu pokemon",
            onClickEndIcon = onClickCancel
        )
    }

}

@Preview
@Composable
private fun TestHeaderMovieWidget() {
    HeaderHomeWidget(
        textFieldState = TextFieldState(),
        onClickCancel = {}
    )
}