package com.example.clickergame.Layout


import android.content.Intent
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.clickergame.MainActivity


@Composable
fun BottomNavBar(onNavigate:(String)-> Unit) {

    val context = LocalContext.current

    NavigationBar(
        containerColor = Color.LightGray,
        tonalElevation = 0.dp
    ) {


        NavigationBarItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Shop") },
            label = { Text("Shop") },
            selected = false,
            onClick = { onNavigate("shop") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = false,
            onClick = { onNavigate("home") }
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = false,
            onClick = { onNavigate("profile") }
        )
    }
}