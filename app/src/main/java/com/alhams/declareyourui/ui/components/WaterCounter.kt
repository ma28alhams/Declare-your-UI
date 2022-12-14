package com.alhams.declareyourui.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatefulCounter(
    modifier: Modifier = Modifier
) {

    var count by rememberSaveable { mutableStateOf(0) }

    StatelessCounter(
        count = count,
        onCountIncrement = { count++ },
        modifier = modifier
    )
}

@Composable
private fun StatelessCounter(
    count: Int,
    onCountIncrement: () -> Unit,
    modifier: Modifier,
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Text(text = "You've had $count glasses.")
        Button(
            onClick = onCountIncrement,
            modifier = Modifier
                .padding(top = 8.dp),
        ) {
            Text(text = "Add one")
        }
    }
}

@Composable
@Preview
fun WaterCounterPreview() {
    StatefulCounter()
}