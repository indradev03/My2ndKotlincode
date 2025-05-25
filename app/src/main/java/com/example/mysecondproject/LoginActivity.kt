package com.example.mysecondproject

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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

    // LocalContext le arko file sanga add garauxa
    val context = LocalContext.current  // Add this at the top of LoginBody()
    // State variable
    // import garda suru ma get ra ani set garne


    // email
    var  username by remember { mutableStateOf("") }
    //Password
    var  password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    //Checkbox
    var rememberMe by remember { mutableStateOf(false) }

    // for connecting registeration
    val activity = context as? Activity

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val sharedPreferences = context.getSharedPreferences("User", Context.MODE_PRIVATE)

    val localEmail : String? = sharedPreferences.getString("email","")
    val localpassword : String? = sharedPreferences.getString("password","")

    username = localEmail.toString()
    password = localpassword.toString()
    val editor = sharedPreferences.edit()


    Column (
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(color = Color.White)
            .padding(top = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //Top Image
        Image(
            painter = painterResource(R.drawable.loginimage),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 20.dp)
                .height(250.dp)
                .width(250.dp)
        )


        // For Email
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

            prefix = {
                Icon(
                    painter = painterResource(R.drawable.baseline_email_24),
                    contentDescription = null
                )
            },
            placeholder = {
                Text(
                    text = "Saroj@gmail.com",

                    )
            },
            value = username,
            onValueChange = { input -> username = input }
        )

        Spacer(modifier = Modifier.height(20.dp))


        // for Password
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            shape = RoundedCornerShape(12.dp),
            // Lukaune kaam garxa
            visualTransformation =
                if (!passwordVisibility) PasswordVisualTransformation()
                else VisualTransformation.None,

            // Keyboard Option EMail, Text, Password
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

            // For visibilty and non visibility
            suffix = {
                Icon(
                    painter = painterResource(
                        if(!passwordVisibility)
                            R.drawable.baseline_visibility_off_24 else R.drawable.baseline_visibility_24
                    ),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        passwordVisibility = !passwordVisibility
                    }
                )
            },
            placeholder = {
                Text(
                    text = "******",
                    modifier = Modifier.fillMaxWidth(),
                )
            },
            value = password,
            onValueChange = { input -> password = input }
        )

        // Check box and Forget Password Linkup
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically)
        {
            Row (
                verticalAlignment = Alignment.CenterVertically,
            ){
                Checkbox(checked = rememberMe,
                    onCheckedChange = {remember->
                        rememberMe = remember
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Green, // this is for chnage color after checked in

                        checkmarkColor = Color.White // This is for tick one
                    )
                )

                Text(
                    text = "Remember Me"
                )

            }
            // 🔗 Forgot Password Text
            Text(
                text = "Forget Password",
                modifier = Modifier.padding(end = 5.dp)
                    .clickable {  },

                color = Color.Blue,
            )
        }


        Spacer(modifier = Modifier.height(30.dp))

        // 🔘 Login Button
        Button(
            onClick = {

                if (rememberMe){
                    editor.putString("email", username)
                    editor.putString("password",password)
                    editor.apply()
                }
                val intent = Intent(context,DashboardActivity::class.java)
                intent.putExtra("email",username)
                intent.putExtra("password",password)

                context.startActivity(intent)
                activity?.finish()
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


        // If already have aacount Sign up link
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){


            Text("Don't have an account? ")
            // 🆕 Sign Up Prompt
            // Then inside the clickable Sign Up text:
            Text(
                text = "Sign Up",
                modifier = Modifier.clickable {
                    // Connected with registrationActivity
                    val intent = Intent(context, RegistrationActivity::class.java)
                    context.startActivity(intent)
                },
                // intent 2 typeko hunxa implict ra explict
                // app vitra navigate hunye lai explict vanne thau ma hunxa
                // app lai xodyera bahira navigate garirako xa vane implicit vanxa
                // eg. camera khulnu , photo upload garnu implicit ma parxa
                color = Color.Blue

                // Destory garna lai
                // activity.finish()
            )
        }


        Spacer(modifier = Modifier.height(20.dp))



        //Other method for login
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center)
             {
            Icon(painter = painterResource(R.drawable.baseline_horizontal_rule_24),
                contentDescription = null)
            Text(text = "Use Other Method to Signup"

                )
            Icon(painter = painterResource(R.drawable.baseline_horizontal_rule_24),
                contentDescription = null)
        }

            // Facebook and google buttons
        Row {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                onClick = {

            }) {
                Image(
                    painter = painterResource(R.drawable.facebook),
                    contentDescription = null,
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp))


            }


            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                onClick = {

            }) {
                Image(
                    painter = painterResource(R.drawable.google),
                    contentDescription = null,
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp))
            }

        }
    }
}

@Preview
@Composable
fun LoginPreBody(){
    LoginBody(innerPadding = PaddingValues(0.dp))
}