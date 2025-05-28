package com.example.mysecondproject


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.provider.FontsContractCompat.Columns

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

    // this is for horizontaln scroll bar like insta stories
    val images = listOf(R.drawable.img1,
        R.drawable.img2,R.drawable.img3, R.drawable.img4 , R.drawable.img5,
        R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9 )

    val name = listOf(
        // jun order ma image xa tei order ma name rakhne
        "Thor1",
        "Thor2",
        "Thor3",
        "Thor4",
        "Thor5",
        "Thor6",
        "Thor7",
        "Thor8",
        "Thor("
    )

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


    //lazy coloum just vertical ko laagi matra hunxa
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(0.dp)
    ) {

        item {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2) ,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement =  Arrangement.spacedBy(10.dp),
                modifier = Modifier.height(500.dp).fillMaxWidth()
            ) {

                items(images.size) { index ->
                    Image(
                        painter = painterResource(images[index]),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
        }
        item {

            LazyRow(modifier = Modifier.fillMaxWidth())
            {
                items(images.size){ index ->
                    Image(
                        painter = painterResource(images[index]),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(100.dp)
                            .border(
                                width = 2.dp, color = Color.Blue,
                                shape = CircleShape
                            )
                            .clip(shape = CircleShape)
                    )

                }
            }

            Box(
                modifier = Modifier
                    .height(200.dp)
                    .padding(5.dp)
                    .width(400.dp)
                    .background(color = Color.Red)
            )
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .padding(5.dp)
                    .width(400.dp)
                    .background(color = Color.Green)
            )
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .padding(5.dp)
                    .width(400.dp)
                    .background(color = Color.Gray)
            )
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .padding(5.dp)
                    .width(400.dp)
                    .background(color = Color.Magenta)
            )

            Box(
                modifier = Modifier
                    .height(200.dp)
                    .padding(5.dp)
                    .width(400.dp)
                    .background(color = Color.Red)
            )
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .padding(5.dp)
                    .width(400.dp)
                    .background(color = Color.Green)
            )
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .padding(5.dp)
                    .width(400.dp)
                    .background(color = Color.Gray)
            )
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .padding(5.dp)
                    .width(400.dp)
                    .background(color = Color.Magenta)
            )

            Box(
                modifier = Modifier
                    .height(200.dp)
                    .padding(5.dp)
                    .width(400.dp)
                    .background(color = Color.Red)
            )
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .padding(5.dp)
                    .width(400.dp)
                    .background(color = Color.Green)
            )
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .padding(5.dp)
                    .width(400.dp)
                    .background(color = Color.Gray)
            )
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .padding(5.dp)
                    .width(400.dp)
                    .background(color = Color.Magenta)
            )
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .padding(5.dp)
                    .width(400.dp)
                    .background(color = Color.Red)
            )
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .padding(5.dp)
                    .width(400.dp)
                    .background(color = Color.Green)
            )
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .padding(5.dp)
                    .width(400.dp)
                    .background(color = Color.Gray)
            )
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .padding(5.dp)
                    .width(400.dp)
                    .background(color = Color.Magenta)
            )

        }
    }

}


@Preview
@Composable
fun ListViewpreBody() {
    ListViewBody(innerPadding = PaddingValues(0.dp))
}
