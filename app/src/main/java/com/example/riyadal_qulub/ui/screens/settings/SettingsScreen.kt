package com.example.riyadal_qulub.ui.screens.settings

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.riyadal_qulub.R
import com.example.riyadal_qulub.ui.components.dialogs.AlertDialogExample
import com.example.riyadal_qulub.ui.theme.Primary
import com.example.riyadal_qulub.ui.theme.rubikSansFamily

@Composable
fun SettingsScreen(
    viewModel: SettingViewModel = hiltViewModel(),
    context: Context
) {

    val sharedPreferences = context.getSharedPreferences("MyApp", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()


    val openAlertDialog = remember { mutableStateOf(false) }

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

        SettingsItem("تسجيل الخروج",
            onClick = {
                viewModel.logout()
                changeTheSharedPrefrences(editor)
            }
        )
        SettingsItem(
            "مسح جميع الأوراد",
            //todo: add dialog to confirm
            onClick = {
                openAlertDialog.value = true
            },
            color = Color.Red
        )
        when {
            openAlertDialog.value -> {
                AlertDialogExample(
                    onDismissRequest = { openAlertDialog.value = false },
                    onConfirmation = {
                        openAlertDialog.value = false
                        viewModel.deleteAllWirds()
                    },
                    dialogTitle = "حذف جميع الأوراد",
                    dialogText = "هل انت متأكد من حذف جميع الأوراد ؟"
                )
            }
        }


        SettingsItem("التنبيهات")
        SettingsItem("تواصل معنا")
        SettingsItem("سياسة الخصوصية")
     //   SettingsItem("تغيير اللغة")


    }

}


private fun changeTheSharedPrefrences(editor: SharedPreferences.Editor) {
    editor.putBoolean(
        "hasSignedIn",
        false
    )
    editor.apply()
}


@Composable
fun SettingsItem(name: String, onClick: () -> Unit = {}, color: Color = Color.Black) {
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
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow),
            contentDescription = "arrow",
            tint = color
        )
        Text(
            text = name,
            textAlign = TextAlign.Right,
            fontSize = 20.sp,
            fontFamily = rubikSansFamily,
            modifier = Modifier.fillMaxWidth(),
            color = color
        )
    }
    Spacer(modifier = Modifier.padding(8.dp))
    Divider(modifier = Modifier.padding(1.dp), color = Color.LightGray)
}