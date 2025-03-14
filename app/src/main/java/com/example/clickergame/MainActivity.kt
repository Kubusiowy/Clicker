package com.example.clickergame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.clickergame.ButtonUpgrade.UpgradeButton
import com.example.clickergame.Layout.Body
import com.example.clickergame.Layout.BottomNavBar
import com.example.clickergame.Layout.TopBar
import com.example.clickergame.Screens.profileScreen
import com.example.clickergame.Screens.shopScreen
import com.example.clickergame.gameData.GameData
import com.example.clickergame.util.StorageOperations

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {

            AppNavigator()

        }
    }
}

@Composable
fun AppNavigator() {
    var selectedScreen by remember { mutableStateOf("home") }

    when (selectedScreen) {
        "home" -> MainScreen { selectedScreen = it }
        "shop" -> shopScreen { selectedScreen = it }
        "profile" -> profileScreen { selectedScreen = it }
    }
}


@Composable
fun MainScreen(onNavigate: (String) -> Unit)
{
   val context = LocalContext.current
    var gameData by remember { mutableStateOf(StorageOperations.loadGameData(context)?: GameData(0.0, 1, 1.0)) }




   Column(modifier = Modifier.fillMaxSize())
   {
       TopBar(gameData.money, gameData.level, gameData.jednoKlikniecie)

       Column(modifier = Modifier.weight(1f))
       {


           Body {
               gameData = gameData.copy(money = gameData.money + gameData.jednoKlikniecie)
               StorageOperations.saveGameData(context, gameData)

           }

           if (gameData.money >= 1000 * gameData.level) {
               UpgradeButton(
                   onUpgrade = {
                       gameData = gameData.copy(
                           money = gameData.money - (1000 * gameData.level),
                           level = gameData.level + 1,
                           jednoKlikniecie = gameData.jednoKlikniecie * (gameData.level * 0.8)

                       )
                   })

           }


       }

       BottomNavBar(onNavigate = onNavigate)


   }
}




