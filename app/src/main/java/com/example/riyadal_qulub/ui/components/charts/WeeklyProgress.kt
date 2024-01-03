package com.example.riyadal_qulub.ui.components.charts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.riyadal_qulub.ui.theme.Primary
import com.example.riyadal_qulub.ui.theme.Purple80
import com.example.riyadal_qulub.ui.theme.rubikSansFamily


@Composable
fun WeeklyProgress(weekPrev: List<Float>) {
    Box {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
 //               .shadow(2.dp),
            elevation = CardDefaults.elevatedCardElevation(2.dp),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "نظرة عامة علي إنتاجية الأسبوع",
                    textAlign = TextAlign.Right,
                    fontFamily = rubikSansFamily,
                    fontSize = 16.sp,
                    color = Color.Black
                )

                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AnimatedCircularProgressIndicator(
                        targetValue = weekPrev[0] / 100,
                        progressBackgroundColor = Purple80,
                        progressIndicatorColor = Primary,
                        day = "السبت",
                        completedColor = Primary
                    )


                    AnimatedCircularProgressIndicator(
                       targetValue = weekPrev[1]/100,
                        progressBackgroundColor = Purple80,
                        progressIndicatorColor = Primary,
                        day = "الأحد",
                        completedColor = Primary
                    )

                    AnimatedCircularProgressIndicator(
                        targetValue = weekPrev[2]/100,
                        progressBackgroundColor = Purple80,
                        progressIndicatorColor = Primary,
                        day = "الأثنين",
                        completedColor = Primary
                    )

                    AnimatedCircularProgressIndicator(
                        targetValue = weekPrev[3]/100,
                        progressBackgroundColor = Purple80,
                        progressIndicatorColor = Primary,
                        day = "الثلاثاء",
                        completedColor = Primary
                    )


                    AnimatedCircularProgressIndicator(
                        targetValue = weekPrev[4]/100,
                        progressBackgroundColor = Purple80,
                        progressIndicatorColor = Primary,
                        day = "الأربعاء",
                        completedColor = Primary
                    )


                    AnimatedCircularProgressIndicator(
                        targetValue = weekPrev[5]/100,
                        progressBackgroundColor = Purple80,
                        progressIndicatorColor = Primary,
                        day = "الخميس",
                        completedColor = Primary
                    )


                    AnimatedCircularProgressIndicator(
                        targetValue = weekPrev[6]/100,
                        progressBackgroundColor = Purple80,
                        progressIndicatorColor = Primary,
                        day = "الجمعة",
                        completedColor = Primary
                    )


                }
            }
        }
    }
}


@Preview
@Composable
fun show() {
    WeeklyProgress(weekPrev = listOf(0.0f, 33.0f, 0.0f, 100.0f, 20.0f, 0.0f, 0.0f))

}