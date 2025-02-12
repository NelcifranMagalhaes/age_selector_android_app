package com.naltispace.myage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naltispace.myage.ui.theme.MyAgeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAgeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AgeComponent()
                }
            }
        }
    }
}

@Composable
fun AgeComponent() {
    val age = remember {
        mutableIntStateOf(0)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "How old are you?",
            color = Color.Red,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Text(
            text = "Press the buttons to enter your age.",
            fontSize = 12.sp,
            color = Color.Blue,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "${age.intValue}",
            fontSize = 48.sp,
            color = Color.Red,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(25.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = {
                if (age.intValue > 0){
                    age.intValue--
                }
            },
                modifier = Modifier.size(84.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA3E0BB))) {
                Text(text= "-", fontSize = 40.sp)
            }
            Spacer(modifier = Modifier.width(50.dp))
            Button(onClick = {
                age.intValue++
            },
                modifier = Modifier.size(84.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA3E0BB))) {
                Text(text= "+", fontSize = 40.sp)
            }

        }
        Spacer(modifier = Modifier.height(50.dp))
        if (age.intValue >= 18){
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_circle_up_24),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "You are of legal age.",
                color = Color.Green,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )

        } else{
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_circle_down_24),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "You are underage.",
                color = Color.Red,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )

        }


    }
}

@Preview(showBackground = true)
@Composable
fun AgeComponentPreview() {
    MyAgeTheme {
        AgeComponent()
    }
}