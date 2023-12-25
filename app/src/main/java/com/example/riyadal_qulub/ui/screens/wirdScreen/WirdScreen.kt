package com.example.riyadal_qulub.ui.screens.wirdScreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.riyadal_qulub.ui.components.MonthCalenderItem
import com.example.riyadal_qulub.ui.theme.rubikSansFamily


private const val TAG = "WirdScreen"

@Composable
fun WirdScreen(
    wirdId: Int,
    viewModel: WirdViewModel = hiltViewModel(),
    navController: NavController
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Log.i(TAG, "WirdScreen: $wirdId")

    viewModel.getWirdById(wirdId)
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "")
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "ملخص الورد",
                    fontSize = 12.sp,
                    fontFamily = rubikSansFamily,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = "عدد أيام الإنجاز في الشهر ",
                    fontSize = 12.sp,
                    fontFamily = rubikSansFamily
                )
                Text(
                    text = "اجمالي عدد أيام الإنجاز 77 يوم",
                    fontSize = 12.sp,
                    fontFamily = rubikSansFamily
                )
                Text(
                    text = "نسبة انجاز الشهر 93%",
                    fontSize = 12.sp,
                    fontFamily = rubikSansFamily
                )
                Text(
                    text = "الإستمرارية 5 أيام",
                    fontSize = 12.sp,
                    fontFamily = rubikSansFamily
                )

            }
        }

        MonthCalenderItem(state.wird)
    }
}
