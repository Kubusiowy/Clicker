package com.example.clickergame.ButtonUpgrade

import android.text.Layout
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun UpgradeButton(onUpgrade: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)

    ) {
        Button(
            onClick = { onUpgrade() },
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(60.dp)
        ) {
            Text(text = "ULEPSZ! 🔥 (💰)", fontSize = 20.sp)
        }
    }
}