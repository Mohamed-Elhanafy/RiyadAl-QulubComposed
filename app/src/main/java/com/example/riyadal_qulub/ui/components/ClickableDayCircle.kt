package com.example.riyadal_qulub.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.riyadal_qulub.ui.theme.Primary
import com.example.riyadal_qulub.ui.theme.rubikSansFamily

private const val BOX_SIZE = 46

@Composable
fun DayCircle(
    clickedState: MutableState<Boolean>, onCheckedChange: (Boolean) -> Unit = {} // Add this line
) {
    Canvas(modifier = Modifier
        .size(BOX_SIZE.dp)
        .clickable {
            clickedState.value = !clickedState.value
            onCheckedChange(clickedState.value) // Add this line
        }) {
        val radius = size.minDimension / 2 - 1.dp.toPx()
        drawCircle(
            color = Primary,
            center = center,
            radius = radius,
            style = if (clickedState.value) Fill else Stroke(width = 1.dp.toPx())
        )
    }
}

@Composable
fun ClickableDayCircle(
    day: String = "الأحد",
    clicked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {} // Add this line
) {
    val clickedState = remember { mutableStateOf(clicked) }
    Box(contentAlignment = Alignment.Center) {
        DayCircle(clickedState = clickedState, onCheckedChange = onCheckedChange)
        DayText(day = day, clickedState = clickedState.value)
    }
}

@Composable
fun DayText(day: String, clickedState: Boolean) {
    Text(
        text = day,
        color = if (clickedState) Color.White else Color.Black,
        fontFamily = rubikSansFamily,
        fontSize = 12.sp,
    )
}


@Preview
@Composable
fun ClickableDayCirclePreview() {
    ClickableDayCircle()
}