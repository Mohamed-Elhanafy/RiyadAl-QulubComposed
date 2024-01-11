package com.example.riyadal_qulub.ui.screens.authenticate.signin

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.riyadal_qulub.R
import com.example.riyadal_qulub.ui.navigation.Screen
import com.example.riyadal_qulub.ui.theme.Primary
import com.example.riyadal_qulub.ui.theme.rubikSansFamily

@Composable
fun SignInScreen(
    viewModel: SignInViewModel = hiltViewModel(), navController: NavController
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    val signInResult by viewModel.signInResult.collectAsState()



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "تسجيل الدخول",
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            fontFamily = rubikSansFamily,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            color = Primary
        )

        Image(
            painter = painterResource(id = R.drawable.img_auth),
            contentDescription = "auth img",
            modifier = Modifier.padding(16.dp)
        )

        OutlinedTextField(
            value = state.email,
            onValueChange = { viewModel.updateEmail(it) },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "email",
                    fontFamily = rubikSansFamily,
                    textAlign = TextAlign.Right,
                    modifier = Modifier.fillMaxWidth()
                )
            })

        Spacer(modifier = Modifier.padding(16.dp))

        OutlinedTextField(
            value = state.password,
            onValueChange = { viewModel.updatePassword(it) },
            placeholder = { Text("Password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()

        )

        Spacer(modifier = Modifier.padding(16.dp))

        Text(
            text = "هل انت مستخدم جديد؟ سجل حساب ",
            textAlign = TextAlign.Right,
            modifier = Modifier.fillMaxWidth(),
            fontFamily = rubikSansFamily,
            fontSize = 16.sp,
            color = Primary
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Button(
            onClick = { viewModel.signIn(state.email, state.password) }, modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "تسجيل الدخول", fontFamily = rubikSansFamily, fontSize = 16.sp)
        }

        if (signInResult == "Success") {
            navController.navigate(Screen.HomeScreen.route)

        } else if (signInResult == "Failure") {
            // Handle failure
        }

    }
}


/*

@Preview
@Composable
fun SignInScreenPreview() {
    SignInScreen(
    )
}
*/



