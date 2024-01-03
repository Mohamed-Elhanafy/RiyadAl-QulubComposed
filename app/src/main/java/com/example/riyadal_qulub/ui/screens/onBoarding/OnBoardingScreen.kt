package com.example.riyadal_qulub.ui.screens.onBoarding

import android.content.Context
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.riyadal_qulub.R
import com.example.riyadal_qulub.ui.navigation.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavController,
    context: Context

) {
    val pagerState = rememberPagerState(pageCount = {
        3
    })
    val scope = rememberCoroutineScope()


    val sharedPreferences = context.getSharedPreferences("MyApp", Context.MODE_PRIVATE)

    val editor = sharedPreferences.edit()

    HorizontalPager(state = pagerState) { page ->

        when (page) {
            0 -> {
                Column(modifier = Modifier.fillMaxSize()) {
                    Screen1(
                        R.drawable.on_boarding_image1,
                        "هل انت جاهز لمتابعة اورادك اليومية ؟",
                        onclick = {
                            scope.launch {
                                pagerState.scrollToPage(1)
                            }
                        })
                }


            }

            1 -> {
                Column(modifier = Modifier.fillMaxSize()) {
                    Screen1(
                        R.drawable.on_boarding_image2,
                        "واعلم أنه لا يستقيم مع الإهمال حال، ولا يصلح مع الإغفال بال",
                        onclick = {
                            scope.launch {
                                pagerState.scrollToPage(2)
                            }
                        })
                }
            }

            2 -> {
                Column(modifier = Modifier.fillMaxSize()) {
                    Screen1(
                        R.drawable.on_boarding_image3,
                        "ينبغي أن توزع أوقاتك وترتب أورادك وتعين لكل وقت شغلًا لا تتعداه ولا تؤثر فيه سواه، وأما من ترك نفسه مهملًا سدى إهمال البهائم يشتغل في كل وقت بما اتفق كيف اتفق فتمضي أكثر أوقاته ضائعة",
                        onclick = {
                            editor.putBoolean(
                                "hasSeenOnboarding",
                                true
                            )
                            editor.apply()
                            navController.navigate(Screen.HomeScreen.route) {
                                popUpTo("onBoardingScreen") { inclusive = true;saveState = false }
                                //todo fix the backstack
                            }
                        })
                }
            }
        }
    }

}