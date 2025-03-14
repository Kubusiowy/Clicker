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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clickergame.R
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.ui.draw.shadow
import com.example.clickergame.ButtonUpgrade.UpgradeButton
import java.math.BigDecimal
import java.math.RoundingMode


val colors = listOf(Color.Cyan, Color.Blue)

@Composable
fun TopBar(money:Double, level:Int, jednoKlikniecie:Double)
{
    val maxMoney = 1000*level

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
           CardFirst(money)

           Spacer(Modifier.height(10.dp))

           CardSecond(money, level, jednoKlikniecie, maxMoney)
       }

   }

}

@Composable
fun CardFirst(money:Double)
{
    Card(modifier = Modifier
        .fillMaxWidth()
        ,colors = CardDefaults.cardColors(containerColor = Color.LightGray)
        ,elevation = CardDefaults.cardElevation(8.dp)
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
            Spacer(Modifier.height(5.dp))

            Text(text = "${String.format("%.2f", money).replace(',', '.').toDouble()}", fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(10.dp))
        }

    }
}

@Composable
fun CardSecond(money:Double, level: Int, jednoKlikniecie: Double, maxMoney:Int)
{

    val progress = (money / maxMoney).coerceIn(0.0, 1.0).toFloat()
    val rounded = BigDecimal(jednoKlikniecie).setScale(2, RoundingMode.HALF_UP).toDouble()
    Card(modifier = Modifier
        .fillMaxWidth()
        ,colors = CardDefaults.cardColors(containerColor = Color.White)
        ,elevation = CardDefaults.cardElevation(8.dp),

    )
    {
        Column(Modifier.padding(start = 20.dp, end = 20.dp, top = 15.dp))
        {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
                , verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(text = "$ ${String.format("%.2f", jednoKlikniecie).replace(',', '.').toDouble()}",fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.width(5.dp))
                Text(text = "za kliknięcie")
            }
            Spacer(Modifier.height(5.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                ,verticalAlignment = Alignment.CenterVertically
                ,horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Text(text = "${level} poziom")
                Row(verticalAlignment = Alignment.CenterVertically)
                {

                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "increse")
                    Text(text = "${rounded*(level+1)} za klikniecie")
                }


            }
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
                    , color = Color.Green,
                trackColor = Color.DarkGray
            )
            Spacer(Modifier.height(5.dp))

            Row(Modifier
                .fillMaxWidth()
                ,verticalAlignment = Alignment.CenterVertically)
            {
                Spacer(modifier = Modifier.weight(1f))
                Text("$ ${String.format("%.2f", money).replace(',', '.').toDouble()} / $ ${maxMoney.toInt()}")
            }
            Spacer(Modifier.height(10.dp))


        }

    }
}

