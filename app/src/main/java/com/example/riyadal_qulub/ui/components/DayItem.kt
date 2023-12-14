package com.example.riyadal_qulub.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.VectorProperty
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.riyadal_qulub.ui.theme.Primary
import com.example.riyadal_qulub.ui.theme.rubikSansFamily

@Composable
fun DayItem(day: String = "الأحد", clicked: Boolean = false) {
    val clickedState = remember {
        mutableStateOf(clicked)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.clickable {
            clickedState.value = !clickedState.value
        }
    ) {
        Canvas(modifier = Modifier.size(64.dp), onDraw = {
            val radius = size.minDimension / 2 - 1.dp.toPx()  //-1 to make the circle fit inside the box
            drawCircle(
                color = Primary,
                center = center,
                radius = radius,
                style = if (clickedState.value) Fill else Stroke(width = 1.dp.toPx())
            )
        })
        Text(
            text = day,
            color = if (clickedState.value) Color.White else Color.Black,
            fontFamily = rubikSansFamily
        )
    }
}


@Preview
@Composable
fun DayItemPreview() {
    DayItem()
}