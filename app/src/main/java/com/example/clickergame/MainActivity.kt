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
    val context = LocalContext.current
    var selectedScreen by remember { mutableStateOf("home") }
    var gameData by remember { mutableStateOf(StorageOperations.loadGameData(context)?: GameData(0.0, 1, 1.0)) }
    when (selectedScreen) {
        "home" -> MainScreen(gameData, { newGameData -> gameData = newGameData }, { selectedScreen = it })
        "shop" -> shopScreen { selectedScreen = it }
        "profile" -> profileScreen (gameData, { selectedScreen = it })
    }
}


@Composable
fun MainScreen(gameData: GameData, onGameDataChange: (GameData) -> Unit, onNavigate: (String) -> Unit)
{
   val context = LocalContext.current

   Column(modifier = Modifier.fillMaxSize())
   {
       TopBar(gameData.money, gameData.level, gameData.jednoKlikniecie)

       Column(modifier = Modifier.weight(1f))
       {


           Body {
               var newgameData = gameData.copy(money = gameData.money + gameData.jednoKlikniecie)
               onGameDataChange(newgameData)
               StorageOperations.saveGameData(context, newgameData)

           }

           if (gameData.money >= 1000 * gameData.level) {
               UpgradeButton(
                   onUpgrade = {
                    var newgameData = gameData.copy(
                           money = gameData.money - (1000 * gameData.level),
                           level = gameData.level + 1,
                           jednoKlikniecie = gameData.jednoKlikniecie * ((gameData.level +1))

                       )
                       onGameDataChange(newgameData)
                       StorageOperations.saveGameData(context, newgameData)
                   })


           }


       }

       BottomNavBar(onNavigate = onNavigate)


   }
}




