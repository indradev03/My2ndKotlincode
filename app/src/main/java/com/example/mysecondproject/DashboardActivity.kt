package com.example.mysecondproject

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysecondproject.ui.theme.MysecondProjectTheme

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold { innerPadding ->
                DashboardBody(innerPadding)
            }
        }
    }
}

@Composable
fun DashboardBody(innerPadding: PaddingValues) {

    val context = LocalContext.current
    val activity = context as Activity

    val email: String? = activity.intent.getStringExtra("email") // ? this means nullabe
    val password: String? = activity.intent.getStringExtra("password")

        Column  (modifier = Modifier.padding(innerPadding).fillMaxSize())
        {
            Text("Good Morning, $email" ) // $ ko kaam varaible dine ho
        }


    }


@Preview
@Composable
fun Dashboardprebody() {
    DashboardBody(innerPadding = PaddingValues(0.dp))
}
