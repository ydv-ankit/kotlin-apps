package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp(modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    val imgSize = 200.dp
    var step by remember {
        mutableStateOf(1)
    }
    println(step)
    val imageResource = when(step) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val descText = when(step) {
        1 -> R.string.img_1
        2 -> R.string.img_2
        3 -> R.string.img_3
        else -> R.string.img_4
    }
    val textValue = when(step) {
        1 -> R.string.step_1
        2 -> R.string.step_2
        3 -> R.string.step_3
        else -> R.string.step_4
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { if (step >= 4) step = 1 else step += 1 },
            shape = RoundedCornerShape(40.dp),
            colors = ButtonDefaults.buttonColors(Color.Green),
            modifier = Modifier.padding(20.dp)
            ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = stringResource(id = descText),
                modifier = Modifier
                    .width(imgSize)
                    .height(imgSize)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = stringResource(id = textValue), fontSize = 18.sp)
    }
}























