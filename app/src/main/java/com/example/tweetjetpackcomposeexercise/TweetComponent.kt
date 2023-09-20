package com.example.tweetjetpackcomposeexercise

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Tweet() {
    Column(
        modifier = Modifier
            .background(Color(0xFF161D26))
            .padding(4.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Profile()
            TweetText()
        }
        Divider(color = Color.Gray)
    }
}

@Composable
fun Profile() {
    Box(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile image",
            modifier = Modifier
                .clip(
                    shape = CircleShape
                )
                .size(75.dp)
        )
    }
}

@Composable
fun TweetText() {
    Column(modifier = Modifier.padding(8.dp)) {
        Nickname()
        MainText()
        TweetActions()
    }
}

@Composable
fun Nickname() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            ) {
                append("Aris ")
            }
            withStyle(
                style = SpanStyle(
                    color = Color.Gray,
                )
            ) {
                append("@AristiDev ")
                append("4h")
            }
        })
        Icon(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = "three dots",
            tint = Color.White
        )
    }
}

@Composable
fun MainText() {
    Column {
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam sed mollis massa, ac posuere diam. Donec efficitur lorem convallis sodales sed.",
            color = Color.White
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp)),
        )
    }
}

@Composable
fun TweetActions() {
    var stateCom by remember {
        mutableStateOf(false)
    }

    var stateRt by remember {
        mutableStateOf(false)
    }

    var stateLk by remember {
        mutableStateOf(false)
    }

    var comment by remember {
        mutableStateOf(1)
    }
    var retwitt by remember {
        mutableStateOf(1)
    }
    var like by remember {
        mutableStateOf(1)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Row {
            Icon(
                painter = if (stateCom) {
                    painterResource(id = R.drawable.ic_chat_filled)
                } else {
                    painterResource(id = R.drawable.ic_chat)
                },
                contentDescription = "Icon chat",
                tint = Color.Gray,
                modifier = Modifier.clickable {
                    stateCom = !stateCom
                    if (stateCom) comment += 1
                    else comment -= 1
                }
            )
            Text(text = comment.toString(), color = Color.Gray)
        }
        Spacer(modifier = Modifier.padding(horizontal = 32.dp))
        Row {
            Icon(
                painter = if (stateRt) {
                    painterResource(id = R.drawable.ic_rt)
                } else {
                    painterResource(id = R.drawable.ic_rt)
                },
                contentDescription = "Icon retwitt",
                tint = if (stateRt) {
                    Color.Green
                } else {
                    Color.Gray
                },
                modifier = Modifier.clickable {
                    stateRt = !stateRt
                    if (stateRt) retwitt += 1
                    else retwitt -= 1
                }
            )
            Text(text = retwitt.toString(), color = Color.Gray)
        }
        Spacer(modifier = Modifier.padding(horizontal = 32.dp))
        Row {
            Icon(
                painter = if (stateLk) {
                    painterResource(id = R.drawable.ic_like_filled)
                } else {
                    painterResource(id = R.drawable.ic_like)
                },
                contentDescription = "Icon like",
                tint = if (stateLk) {
                    Color.Red
                } else {
                    Color.Gray
                },
                modifier = Modifier.clickable {
                    stateLk = !stateLk
                    if (stateLk) like += 1
                    else like -= 1
                }
            )
            Text(text = like.toString(), color = Color.Gray)
        }
    }
}