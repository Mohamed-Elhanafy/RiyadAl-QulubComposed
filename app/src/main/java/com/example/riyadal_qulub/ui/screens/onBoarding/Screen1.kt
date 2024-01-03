package com.example.riyadal_qulub.ui.screens.onBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.riyadal_qulub.R
import com.example.riyadal_qulub.ui.theme.PrimaryVariant
import com.example.riyadal_qulub.ui.theme.rubikSansFamily

@Composable
fun Screen1(image:Int , text:String, onclick:()-> Unit) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = image),
            contentDescription = "image1",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = text,
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            fontFamily = rubikSansFamily,
            color = Color.Black,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            lineHeight = 30.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { onclick() }, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            ,
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryVariant)

        ) {
            Text(text = "التالي", fontFamily = rubikSansFamily)

        }
        Spacer(modifier = Modifier.weight(1f))

    }
}
