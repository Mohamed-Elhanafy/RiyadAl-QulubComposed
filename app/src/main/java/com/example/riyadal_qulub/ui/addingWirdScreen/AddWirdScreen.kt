package com.example.riyadal_qulub.ui.addingWirdScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.riyadal_qulub.ui.theme.Primary

@Composable
fun AddWirdScreen(
    viewModel: AddViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = state.wirdName,
            onValueChange = { viewModel.updateWirdName(it) },
            modifier = Modifier.fillMaxWidth()
            //todo add colors
        )

    }
}

/*
@Composable
@Preview(showSystemUi = true)
fun AddWirdScreenPreview() {
    AddWirdScreen()
}*/
