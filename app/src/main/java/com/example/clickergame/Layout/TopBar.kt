package com.example.clickergame.Layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clickergame.R

import com.example.clickergame.data.Dane
val colors = listOf(Color.Cyan, Color.Blue)

val dane = Dane(money = 0.00, lvl = 1, jednoKlikniecie = 2.50)


@Composable
fun TopBar()
{
   Box(modifier = Modifier
       .fillMaxWidth()
       .background(brush = Brush.linearGradient(
           colors = colors
       ))
       .padding(WindowInsets.statusBars.asPaddingValues())
       .padding(8.dp)

   )
   {
       Column()
       {
           CardFirst()

           Spacer(Modifier.height(5.dp))

           CardSecond()
       }

   }

}

@Composable
fun CardFirst()
{
    Card(modifier = Modifier
        .fillMaxWidth()
        ,colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    )
    {
        Column(Modifier.padding(start = 20.dp, end = 20.dp))
        {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
                ,horizontalArrangement = Arrangement.SpaceBetween)
            {
                Text(text = "**** 7439")
                Text(text = "05/26")
            }
            Spacer(Modifier.height(10.dp))
            Text(text = "Saldo: ")
            Spacer(Modifier.height(10.dp))

            Text(text = "${dane.money}", fontSize = 26.sp)
            Spacer(Modifier.height(10.dp))
        }

    }
}

@Composable
fun CardSecond()
{
    Card(modifier = Modifier
        .fillMaxWidth()
        ,colors = CardDefaults.cardColors(containerColor = Color.White)

    )
    {
        Column(Modifier.padding(start = 20.dp, end = 20.dp))
        {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp))
            {
                Text(text = "${dane.jednoKlikniecie}")
            }



        }

    }
}

