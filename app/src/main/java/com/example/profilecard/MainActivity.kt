package com.example.profilecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
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
                        username = stringResource(R.string.username),
                        bio = stringResource(R.string.bio),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileCard(username: String, bio: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.profilepic)
    Surface(
        //set background color
        color = colorResource(R.color.backgroundColor),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(start = 16.dp, bottom = 16.dp, end = 16.dp, top = 32.dp)
        ) {
            //profile picture
            Row(
                Modifier.padding(8.dp)
            ) {
                Image(
                    painter = image,
                    contentDescription = "The users profile picture",
                    Modifier
                        .size(250.dp)
                        .clip(CircleShape)
                        .border(5.dp, colorResource(R.color.mainColor), CircleShape)

                )
            }

            //username
            Row(
                Modifier.padding(6.dp)
            ) {
                Text(
                    text = username,
                    textAlign = TextAlign.Center,
                    color = colorResource(R.color.mainColor),
                    fontSize = 44.sp, //wonky in my preview but fine in app
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    modifier = modifier
                )
            }

            //about me
            Row(
                Modifier.padding(top = 2.dp)
            ) {
                Text(
                    text = "About Me",
                    textAlign = TextAlign.Center,
                    color = colorResource(R.color.mainColor),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    modifier = modifier
                )
            }
            //biography
            Row(
                Modifier.padding(8.dp).fillMaxWidth()
            ) {
                Text(
                    text = bio,
                    color = colorResource(R.color.mainColor),
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    lineHeight = 30.sp,
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    ProfileCardTheme {
        ProfileCard(stringResource(R.string.username),stringResource(R.string.bio))
    }
}