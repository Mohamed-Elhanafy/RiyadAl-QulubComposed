package com.example.riyadal_qulub.ui.components.dialogs

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import com.example.riyadal_qulub.ui.theme.Primary
import com.example.riyadal_qulub.ui.theme.Secondary
import com.example.riyadal_qulub.ui.theme.rubikSansFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
) {
    AlertDialog(

        title = {
            Text(text = dialogTitle, fontFamily = rubikSansFamily, textAlign = TextAlign.Center)
        },
        text = {
            Text(text = dialogText, fontFamily = rubikSansFamily, textAlign = TextAlign.Right)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(
                    "حذف",
                    color = androidx.compose.ui.graphics.Color.Red,
                    fontFamily = rubikSansFamily
                )
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text(
                    "الرجوع",
                    //color = androidx.compose.ui.graphics.Color.Red,
                    fontFamily = rubikSansFamily
                )
            }
        },
        containerColor = Secondary
    )
}
