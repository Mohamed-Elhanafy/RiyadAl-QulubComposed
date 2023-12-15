package com.example.riyadal_qulub.ui.addingWirdScreen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.riyadal_qulub.R
import com.example.riyadal_qulub.ui.components.ClickableWeekDays
import com.example.riyadal_qulub.ui.theme.Primary
import com.example.riyadal_qulub.ui.theme.rubikSansFamily

@Composable
fun AddWirdScreen(
    viewModel: AddViewModel = hiltViewModel(),
    navController: NavController
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
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(
                    text = "اسم الورد",
                    fontFamily = rubikSansFamily,
                    textAlign = TextAlign.Right,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            //todo add colors
        )

        Divider(modifier = Modifier.padding(vertical = 16.dp))

        Text(
            text = "تكرار الورد",
            fontFamily = rubikSansFamily,
            fontSize = 24.sp,
            color = Color.Black, textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(8.dp))
        ClickableWeekDays(
            daysChecked = state.daysCheckedState
        )
        Divider(modifier = Modifier.padding(vertical = 16.dp))
        Text(
            text = "تنبيهات الورد",
            fontFamily = rubikSansFamily,
            fontSize = 24.sp,
            color = Color.Black, textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth()
        )
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                tint = Primary,
                modifier = Modifier.size(12.dp) // Adjust the size as needed
            )
            Text(
                text = "إضافة تنبيه",
                fontFamily = rubikSansFamily,
                fontSize = 12.sp,
                color = Primary,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .clickable {

                    }
            )

        }
        Divider(modifier = Modifier.padding(vertical = 16.dp))

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_calender),
                contentDescription = "Add",

                modifier = Modifier
                    .size(24.dp)
                    .clickable {

                    }
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "بداية الورد من اليوم ",
                fontFamily = rubikSansFamily,
                fontSize = 24.sp,
                color = Primary,
                textAlign = TextAlign.End

            )
        }
        Divider(modifier = Modifier.padding(vertical = 16.dp))
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_sun),
                contentDescription = "Add",

                modifier = Modifier
                    .size(24.dp)
                    .clickable {

                    }
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "معاد الورد",
                fontFamily = rubikSansFamily,
                fontSize = 24.sp,
                color = Primary,
                textAlign = TextAlign.End

            )
        }
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = state.isMorningWird,
                onCheckedChange = { viewModel.updateIsMorningWird(it) })
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "صباحاً",
                fontFamily = rubikSansFamily,
                fontSize = 12.sp,
                color = Color.Black,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .clickable {

                    }
            )
        }
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = state.isEveningWird,
                onCheckedChange = { viewModel.updateIsEveningWird(it) })
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "مساءً",
                fontFamily = rubikSansFamily,
                fontSize = 12.sp,
                color = Color.Black,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .clickable {

                    }
            )
        }
        Button(
            onClick = {
                viewModel.addWird()
                navController.navigateUp()
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 62.dp, horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Primary,
            )
        ) {
            Text(text = "إضافة الورد")
        }


    }
}


