package com.example.riyadal_qulub.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.riyadal_qulub.ui.theme.Primary
import com.example.riyadal_qulub.util.simplifyNumber
import com.github.tehras.charts.bar.BarChart
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.renderer.label.LabelDrawer
import com.github.tehras.charts.bar.renderer.yaxis.SimpleYAxisDrawer
import java.time.DayOfWeek


@Composable
fun WeeklyChart(
    saturday: Float?,
    sunday: Float?,
    monday: Float?,
    tuesday: Float?,
    wednesday: Float?,
    thursday: Float?,
    friday: Float?
) {
    //  val groupedExpenses = expenses.groupedByDayOfWeek()

    BarChart(
        barChartData = BarChartData(
            bars = listOf(
                BarChartData.Bar(
                    label = "سبت",
                    value = saturday
                        ?: 0f,
                    color = Primary,
                ),
                BarChartData.Bar(
                    label = DayOfWeek.TUESDAY.name.substring(0, 1),
                    value = sunday
                        ?: 0f,
                    color = Primary
                ),
                BarChartData.Bar(
                    label = DayOfWeek.WEDNESDAY.name.substring(0, 1),
                    value = monday
                        ?: 0f,
                    color = Primary
                ),
                BarChartData.Bar(
                    label = DayOfWeek.THURSDAY.name.substring(0, 1),
                    value = tuesday
                        ?: 0f,
                    color = Primary
                ),
                BarChartData.Bar(
                    label = DayOfWeek.FRIDAY.name.substring(0, 1),
                    value = wednesday
                        ?: 0f,
                    color = Primary
                ),
                BarChartData.Bar(
                    label = DayOfWeek.SATURDAY.name.substring(0, 1),
                    value = thursday
                        ?: 0f,
                    color = Primary
                ),
                BarChartData.Bar(
                    label = DayOfWeek.SUNDAY.name.substring(0, 1),
                    value = friday
                        ?: 0f,
                    color = Primary
                ),
            )
        ),
        //   labelDrawer = LabelDrawer(),
        yAxisDrawer = SimpleYAxisDrawer(
            labelValueFormatter = ::simplifyNumber,
            labelRatio = 7,
            labelTextSize = 14.sp,
            labelTextColor = Primary,
        ),
        barDrawer = MyBarDrawer(),
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth()
            .height(300.dp)
    )
}