package com.example.mysecondproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class LoginActivity: ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // This is the base (Scaffold)
            Scaffold { innerPadding->
                LoginBody(innerPadding)
            }
        }
    }

}


@Composable
fun LoginBody(innerPadding: PaddingValues){

    // State variable
    // import garda suru ma get ra ani set garne

    var  username by remember { mutableStateOf("") }
    var  password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(color = Color.White)
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.loginimage),
            contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .width(250.dp)
        )

        OutlinedTextField(
            // Call back funtion ho yo
            // kunai pani call back le return garyeko
            // function variable ma hunxa ra tyo variable ko namm 'it' ho
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .padding(top = 50.dp),
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            label = { Text("Email") },
            placeholder = {
                Text(
                    text = "Saroj@gmail.com",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            },
            value = username,
            onValueChange = { input -> username = input }
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            shape = RoundedCornerShape(12.dp),
            // Lukaune kaam garxa
            visualTransformation =
                if (passwordVisibility) PasswordVisualTransformation()
                else VisualTransformation.None,

            // Keyboard Option EMail, Text, Password
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            prefix = {
                Icon(
                    painter = painterResource(R.drawable.baseline_lock_outline_24),
                    contentDescription = null
                )
            },
            suffix = {
                val visibilityIcon = if (passwordVisibility) {
                    R.drawable.baseline_visibility_24
                } else {
                    R.drawable.baseline_visibility_off_24
                }

                Icon(
                    painter = painterResource(id = visibilityIcon),
                    contentDescription = if (passwordVisibility) "Hide password" else "Show password",
                    modifier = Modifier.clickable {
                        passwordVisibility = !passwordVisibility
                    }
                )
            },
            placeholder = {
                Text(
                    text = "******",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            },
            value = password,
            onValueChange = { input -> password = input }
        )

        Spacer(modifier = Modifier.height(10.dp))

        // 🔗 Forgot Password Text
        Text(
            text = "Forgot Password?",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .clickable {
                    // TODO: Handle forgot password
                },
            color = Color.Blue,
            textAlign = androidx.compose.ui.text.style.TextAlign.End
        )

        Spacer(modifier = Modifier.height(30.dp))

        // 🔘 Login Button
        Button(
            onClick = {
                // TODO: Handle login click
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0A84FF)) // Blue
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // 🆕 Sign Up Prompt
        Text(
            text = "Don't have an account? Sign Up",
            modifier = Modifier.clickable {
                // TODO: Handle sign-up navigation
            },
            color = Color.Blue
        )
    }
}


@Preview
@Composable
fun LoginPreBody(){
    LoginBody(innerPadding = PaddingValues(0.dp))
}