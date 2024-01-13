package com.example.riyadal_qulub.ui.components.charts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.riyadal_qulub.ui.theme.Primary
import com.example.riyadal_qulub.util.MyYAxisDrawer
import com.example.riyadal_qulub.util.NoOpXAxisDrawer
import com.example.riyadal_qulub.util.simplifyNumber
import com.github.tehras.charts.bar.BarChart
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.renderer.label.LabelDrawer
import com.github.tehras.charts.bar.renderer.xaxis.XAxisDrawer
import com.github.tehras.charts.bar.renderer.yaxis.SimpleYAxisDrawer
import com.github.tehras.charts.bar.renderer.yaxis.YAxisDrawer
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
    Column(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth()
            .height(300.dp)
            ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
                    label = "الاحد",
                    value = sunday
                        ?: 0f,
                    color = Primary
                ),
                BarChartData.Bar(
                    label = "الاثنين",
                    value = monday
                        ?: 0f,
                    color = Primary
                ),
                BarChartData.Bar(
                    label = "الثلاثاء",
                    value = tuesday
                        ?: 0f,
                    color = Primary
                ),
                BarChartData.Bar(
                    label = "الأربعاء",
                    value = wednesday
                        ?: 0f,
                    color = Primary
                ),
                BarChartData.Bar(
                    label = "الخميس",
                    value = thursday
                        ?: 0f,
                    color = Primary
                ),
                BarChartData.Bar(
                    label = "الجمعة",
                    value = friday
                        ?: 0f,
                    color = Primary
                ),
            )
        ),
        labelDrawer = MyLabelDrawer(),
        /* yAxisDrawer = SimpleYAxisDrawer(
             labelValueFormatter = ::simplifyNumber,
             labelRatio = 7,
             labelTextSize = 14.sp,
             labelTextColor = Primary,
         )*/
        yAxisDrawer = MyYAxisDrawer(),
        xAxisDrawer = NoOpXAxisDrawer(),
        barDrawer = MyBarDrawer(),
        modifier = Modifier
            .padding(bottom = 20.dp, end = 28.dp)
            .fillMaxWidth()
            .height(300.dp)

    )
    }
}


