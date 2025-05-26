package com.example.mysecondproject


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ListViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold { innerPadding->
                ListViewBody(innerPadding)
            }
        }
    }
}

@Composable
fun ListViewBody(innerPadding: PaddingValues){

    val scrollState1 = rememberScrollState()
    val scrollState2 = rememberScrollState()



//
//    Column (
//        modifier = Modifier.fillMaxSize().verticalScroll(scrollState1)
//
//    ) {
//        Box(
//            modifier = Modifier.height(300.dp)
//                .fillMaxWidth().padding(10.dp)
//                .background(color = Color.Magenta)
//        )
//        Box(
//            modifier = Modifier.height(300.dp)
//                .fillMaxWidth().padding(10.dp)
//                .background(color = Color.Black)
//        )
//        Box(
//            modifier = Modifier.height(300.dp)
//                .fillMaxWidth().padding(10.dp)
//                .background(color = Color.Green)
//
//        )
//
//            Row (modifier = Modifier
//                .height(300.dp)
//                .fillMaxWidth()
//                .padding(innerPadding)
//                .horizontalScroll(scrollState2)) {
//
//
//                Box(
//                    modifier = Modifier.height(300.dp)
//                        .width(100.dp).padding(10.dp)
//                        .background(color = Color.Red)
//                )
//                Box(
//                    modifier = Modifier.height(300.dp)
//                        .width(100.dp).padding(10.dp)
//                        .background(color = Color.Black)
//                )
//                Box(
//                    modifier = Modifier.height(300.dp)
//                        .width(100.dp).padding(10.dp)
//                        .background(color = Color.Green)
//                )
//
//                Box(
//                    modifier = Modifier.height(300.dp)
//                        .width(100.dp).padding(10.dp)
//                        .background(color = Color.Red)
//                )
//                Box(
//                    modifier = Modifier.height(300.dp)
//                        .width(100.dp).padding(10.dp)
//                        .background(color = Color.Black)
//                )
//                Box(
//                    modifier = Modifier.height(300.dp)
//                        .width(100.dp).padding(10.dp)
//                        .background(color = Color.Green)
//                )
//
//            }
//        Box(
//            modifier = Modifier.height(300.dp)
//                .fillMaxWidth().padding(10.dp)
//                .background(color = Color.Blue)
//        )
//        Box(
//            modifier = Modifier.height(300.dp)
//                .fillMaxWidth().padding(10.dp)
//                .background(color = Color.Yellow)
//        )
//    }

//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize()
//    ){
//        items (100){index  ->
//            Text("$index")
//        }
//    }


    //lazy coloum just horizental ko laagi matra hunxa
    LazyColumn (
        modifier = Modifier.fillMaxSize().background(color = Color.White).padding(50.dp)
    ) {
        item {

            Box(
                modifier = Modifier.height(100.dp).padding(5.dp)
                    .width(300.dp).background(color = Color.Red)
            )
            Box(
                modifier = Modifier.height(100.dp).padding(5.dp).
                width(300.dp).background(color = Color.Green)
            )
            Box(
                modifier = Modifier.height(100.dp).padding(5.dp).
                width(300.dp).background(color = Color.Gray)
            )
            Box(
                modifier = Modifier.height(100.dp).padding(5.dp).
                width(300.dp).background(color = Color.Magenta)
            )

            Box(
                modifier = Modifier.height(100.dp).padding(5.dp)
                    .width(300.dp).background(color = Color.Red)
            )
            Box(
                modifier = Modifier.height(100.dp).padding(5.dp).
                width(300.dp).background(color = Color.Green)
            )
            Box(
                modifier = Modifier.height(100.dp).padding(5.dp).
                width(300.dp).background(color = Color.Gray)
            )
            Box(
                modifier = Modifier.height(100.dp).padding(5.dp).
                width(300.dp).background(color = Color.Magenta)
            )

            Box(
                modifier = Modifier.height(100.dp).padding(5.dp)
                    .width(300.dp).background(color = Color.Red)
            )
            Box(
                modifier = Modifier.height(100.dp).padding(5.dp).
                width(300.dp).background(color = Color.Green)
            )
            Box(
                modifier = Modifier.height(100.dp).padding(5.dp).
                width(300.dp).background(color = Color.Gray)
            )
            Box(
                modifier = Modifier.height(100.dp).padding(5.dp).
                width(300.dp).background(color = Color.Magenta)
            )
            Box(
                modifier = Modifier.height(100.dp).padding(5.dp)
                    .width(300.dp).background(color = Color.Red)
            )
            Box(
                modifier = Modifier.height(100.dp).padding(5.dp).
                width(300.dp).background(color = Color.Green)
            )
            Box(
                modifier = Modifier.height(100.dp).padding(5.dp).
                width(300.dp).background(color = Color.Gray)
            )
            Box(
                modifier = Modifier.height(100.dp).padding(5.dp).
                width(300.dp).background(color = Color.Magenta)
            )

        }
    }

}


@Preview
@Composable
fun ListViewpreBody() {
    ListViewBody(innerPadding = PaddingValues(0.dp))
}
