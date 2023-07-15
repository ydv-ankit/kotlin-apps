package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var imageNumber by remember {
        mutableStateOf(1)
    }
    var picNumber = when(imageNumber) {
        1 -> R.drawable.pic_1
        2 -> R.drawable.pic_2
        3 -> R.drawable.pic_3
        4 -> R.drawable.pic_4
        5 -> R.drawable.pic_5
        6 -> R.drawable.pic_6
        7 -> R.drawable.pic_7
        else -> R.drawable.pic_8
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
    ) {
        Image(
            painter = painterResource(id = picNumber),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(0.7F)
                .padding(5.dp)
        )
        Row {
            Button(onClick = {
                if(imageNumber != 1) imageNumber -= 1
                else imageNumber = 8
                             }, modifier = Modifier
                .padding(20.dp)
                .width(150.dp)) {
                Text(text = "Previous")
            }
            Button(onClick = {
                             if(imageNumber >= 8) imageNumber = 1
                else imageNumber += 1
            }, modifier = Modifier
                .padding(20.dp)
                .width(150.dp)) {
                Text(text = "Next")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}