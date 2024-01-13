package com.example.riyadal_qulub.ui.screens.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.riyadal_qulub.R
import com.example.riyadal_qulub.ui.theme.Primary
import com.example.riyadal_qulub.ui.theme.rubikSansFamily

@Composable
fun SettingsScreen(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(
            text = "الإعدادات",
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            fontFamily = rubikSansFamily,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            color = Primary
        )

        SettingsItem("تسجيل الخروج")
        SettingsItem("مسح كل الأوراد")
        SettingsItem("التنبيهات")
        SettingsItem("تواصل معنا")
        SettingsItem("سياسة الخصوصية")
        SettingsItem("تغيير اللغة")


    }

}


@Composable
fun SettingsItem(name: String, onClick: () -> Unit ={}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clickable {
                       onClick()
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_arrow), contentDescription = "arrow")
        Text(
            text = name,
            textAlign = TextAlign.Right,
            fontSize = 20.sp,
            fontFamily = rubikSansFamily,
            modifier = Modifier.fillMaxWidth(),
            color = Color.Black
        )
    }
    Spacer(modifier = Modifier.padding(8.dp))
    Divider(modifier = Modifier.padding(1.dp), color = Color.LightGray)
}