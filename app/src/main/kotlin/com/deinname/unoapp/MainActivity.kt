package com.deinname.unoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.deinname.unoapp.game.GameManager

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val gameManager = GameManager()
        gameManager.startGame()

        setContent {
            UnoScreen(gameManager)
        }
    }
}

@Composable
fun UnoScreen(gameManager: GameManager) {

    Text(
        text = "Spieler hat ${gameManager.player1.hand.size} Karten"
    )

    Button(onClick = { /* x */ },
        modifier = Modifier
            .width(5.dp)
            .height(5.dp),
        colors = ButtonDefaults.buttonColors(containerColor=Color.White)
    ) { }
}