package com.example.clickergame.Screens

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowInsetsControllerCompat
import com.example.clickergame.Layout.BottomNavBar
import com.example.clickergame.Layout.CardFirst
import com.example.clickergame.Layout.CardSecond
import com.example.clickergame.Layout.colors
import com.example.clickergame.Screens.ui.theme.ClickerGameTheme
import com.example.clickergame.gameData.GameData
import java.math.RoundingMode


@Composable
fun profileScreen(gameData: GameData,onNavigate:(String)-> Unit)
{
    val perClickRounded = gameData.jednoKlikniecie.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toPlainString()
    val moneyRounded = gameData.money.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toPlainString()

    Column(Modifier.fillMaxSize()) {
        Column(Modifier.weight(1f))
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
                Column(Modifier.padding(start = 10.dp, end = 10.dp))
                {
                   Card(modifier = Modifier
                       .fillMaxWidth()

                   )
                   {
                       Row(Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically)
                       {
                           Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "icona", Modifier.size(55.dp))
                           Spacer(Modifier.width(25.dp))
                            Column(horizontalAlignment = Alignment.CenterHorizontally)
                            {
                                Text(text = "Saldo: ",fontSize = 18.sp)
                                Spacer(Modifier.height(4.dp))
                                Text(text = "${moneyRounded}", fontWeight = FontWeight.Bold)
                            }
                           Spacer(Modifier.width(25.dp))
                           Column(horizontalAlignment = Alignment.CenterHorizontally)
                           {
                               Text(text = "Per Click: ", fontSize = 18.sp)
                               Spacer(Modifier.height(4.dp))
                               Text(text = perClickRounded,fontWeight = FontWeight.Bold)
                           }

                           Spacer(Modifier.width(25.dp))
                           Column(horizontalAlignment = Alignment.CenterHorizontally)
                           {
                               Text(text = "level: ",fontSize = 18.sp)
                               Spacer(Modifier.height(4.dp))
                               Text(text = "${gameData.level}", fontWeight = FontWeight.Bold)
                           }
                       }
                   }
                }

            }
        }
        BottomNavBar(onNavigate = onNavigate)
    }


}
