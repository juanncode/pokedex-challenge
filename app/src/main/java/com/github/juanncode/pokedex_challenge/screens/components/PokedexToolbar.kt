@file:OptIn(ExperimentalMaterial3Api::class)

package com.github.juanncode.pokedex_challenge.screens.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.juanncode.pokedex_challenge.R
import com.github.juanncode.pokedex_challenge.ui.theme.PokedexchallengeTheme

@Composable
fun PokedexToolbar(
    showBackButton: Boolean,
    title: String,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
    startContent: (@Composable () -> Unit)? = null,
) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                startContent?.invoke()
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground,
                )

            }
        },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(id = R.string.go_back),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        },

    )
}

@Preview
@Composable
private fun RuniqueToolbarPreview() {
    PokedexchallengeTheme {
        PokedexToolbar(
            showBackButton = true,
            title = "Run",
            modifier = Modifier.fillMaxWidth(),
            startContent = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(35.dp),
                )
            },

        )
    }
}