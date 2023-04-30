package com.example.buisnesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buisnesscard.ui.theme.BuisnessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuisnessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}


@Composable
fun buisnessCard() {

    var contact= painterResource(id = R.drawable.ic_baseline_phone_24)
    var share= painterResource(id = R.drawable.ic_baseline_share_24)
    var mail= painterResource(id = R.drawable.ic_baseline_email_24)

    var img = painterResource(R.drawable.android_logo)

    // Use a LazyColumn instead of Column, and specify its height
    //it is used to sho a list of large data items
    // it works only for those lists items which are currently showing up
    // and recycle those  which got scrolled up
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        item {
            Image(painter = img,
                contentDescription = null,
                modifier = Modifier.padding(bottom = 8.dp,top = 12.dp)
                    .background(Color.White)
                    .fillMaxWidth()
                    .size(200.dp)

            )
            Text(
                text= stringResource(id = R.string.name),
                fontSize = 34.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text= stringResource(id = R.string.Domain),
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top=16.dp,bottom=108.dp)
            )
            // Use a Column instead of a Row for the contact, share, and mail cards
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
                    .background(Color.White)
            ) {
                Card(contact, stringResource(id = R.string.contct),)
                Card(share, stringResource(id = R.string.shareing))
                Card(mail, stringResource(id = R.string.mail))
            }
        }
    }
}



@Composable
fun Card(icon : Painter , detail:String){

    // just for the second card to present contact details and all
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    )
    {
            Icon(painter =icon ,
                contentDescription =null,
                modifier = Modifier.scale(1f).background(Color.White).padding(start=12.dp)
            )
            Text(
                text = detail,
                fontSize = 20.sp,
                modifier = Modifier.scale(1f).background(Color.White)
            )


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BuisnessCardTheme {
        buisnessCard()
    }
}