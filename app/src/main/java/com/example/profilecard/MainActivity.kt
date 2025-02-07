package com.example.profilecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilecard.ui.theme.ProfileCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileCard(
                        username = "Campbell-E-Soup",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileCard(username: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.profilepic)
    Surface(
        color = colorResource(R.color.backgroundColor),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                Modifier.padding(8.dp)
            ) {
                Image(
                    painter = image,
                    contentDescription = "The users profile picture",
                    Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .border(5.dp, colorResource(R.color.mainColor), CircleShape)

                )
            }

            Row(
                Modifier.padding(8.dp)
            ) {
                Text(
                    text = username,
                    textAlign = TextAlign.Center,
                    color = colorResource(R.color.mainColor),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    ProfileCardTheme {
        ProfileCard("Campbell-E-Soup")
    }
}