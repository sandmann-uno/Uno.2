package com.deinname.unoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
}