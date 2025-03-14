package com.example.clickergame.Layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Body(onMoneyEarned: () -> Unit)
{

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
    ) {
        Button(
            onClick = { onMoneyEarned() },
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(100.dp)
                .align(Alignment.Center)
        ) {
            Text(text = "ZARABIAJ 💰", fontSize = 24.sp)
        }
    }
}
