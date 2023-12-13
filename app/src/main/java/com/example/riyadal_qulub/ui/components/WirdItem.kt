package com.example.riyadal_qulub.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.riyadal_qulub.domain.model.Wird
import com.example.riyadal_qulub.ui.theme.LabelGrey
import com.example.riyadal_qulub.ui.theme.Secondary
import com.example.riyadal_qulub.ui.theme.rubikSansFamily
import com.example.riyadal_qulub.util.WirdStatus
import kotlinx.coroutines.flow.MutableStateFlow
import java.time.LocalDate


@Composable
fun WirdItem(wird: MutableState<Wird>, onClick: (Wird) -> Unit) {
    Box(
        modifier = Modifier

            .clip(RoundedCornerShape(4.dp))
            .border(2.dp, color = Secondary)
            .fillMaxWidth()
            .height(82.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = CenterVertically
        ) {
            Button(
                onClick = {
                    val newWird = wird.value.copy(isDone = !wird.value.isDone)
                    onClick(newWird)
                    wird.value = newWird
                },
                modifier = Modifier
                    //                  .width(150.dp)
                    .padding(16.dp)
            ) {
                Row(verticalAlignment = CenterVertically) {
                    Icon(
                        imageVector = if (!wird.value.isDone) Icons.Default.Check else Icons.Default.Refresh,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(
                        text = "انهيت الورد",
                        fontFamily = rubikSansFamily,
                        color = Color.White,
                        fontSize = 8.sp,
                    )

                }


            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.End,
            ) {
                Text(
                    text = wird.value.name,
                    fontFamily = rubikSansFamily,
                    color = Color.Black,
                    fontSize = 16.sp,

                    textAlign = TextAlign.Right

                )
                Text(
                    text = wird.value.quantity.toString() + " " + wird.value.unit,
                    fontFamily = rubikSansFamily,
                    color = LabelGrey,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Right
                )
            }
        }


    }
}


@Composable
@Preview
fun WirdItemPreview() {

    val wirdState = remember { mutableStateOf(Wird(name = "قرائة قران")) }

    WirdItem(wirdState, onClick = {

    })

}