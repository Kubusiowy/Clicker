package com.example.clickergame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.clickergame.ButtonUpgrade.UpgradeButton
import com.example.clickergame.Layout.Body
import com.example.clickergame.Layout.Footer
import com.example.clickergame.Layout.TopBar
import com.example.clickergame.ui.theme.ClickerGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {

            MainScreen()

        }
    }
}

@Composable
fun MainScreen()
{
    var money by remember { mutableStateOf(0.0) }
    var level by remember { mutableStateOf(1) }
    var jednoKlikniecie by remember { mutableStateOf(2.5 * level) }
   Column()
   {

       Column(modifier = Modifier.fillMaxSize())
       {
           TopBar(money, level, jednoKlikniecie)

           Body { money += jednoKlikniecie }

           if (money >= 1000*level) {


           UpgradeButton(
               onUpgrade = {
                   money -= 1000*level
                   level++
                   jednoKlikniecie *= level
               })
             }

           Footer()
       }


   }
}



