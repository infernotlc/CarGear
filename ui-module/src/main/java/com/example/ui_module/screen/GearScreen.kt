package com.example.ui_module.screen


import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ui_module.viewmodel.GearViewModel

@Composable
fun GearScreen(viewModel: GearViewModel) {
    val gearState = viewModel.gearState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Current Gear: ${gearState.value}",
            style = MaterialTheme.typography.h2
        )
    }
}
