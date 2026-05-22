package com.deinname.unoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deinname.unoapp.game.GameManager

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val gameManager = GameManager()

        setContent {
            var showGame by remember { mutableStateOf(false) }

            if (showGame) {
                UnoScreen(gameManager)
            } else {
                MainMenu(onStartGame = {
                    gameManager.startGame()
                    showGame = true
                })
            }
        }
    }
}

@Composable
fun MainMenu(onStartGame: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Hintergrundbild
        Image(
            painter = painterResource(id = R.drawable.main_menu_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "UNO",
                fontSize = 80.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(64.dp))

            Button(
                onClick = onStartGame,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107)) // Gold/Gelb
            ) {
                Text(text = "Spiel Starten", color = Color.Black, fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Einstellungen */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(text = "Einstellungen", color = Color.Black, fontSize = 20.sp)
            }
        }
    }
}

@Composable
fun UnoScreen(gameManager: GameManager) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Spieler hat ${gameManager.player1.hand.size} Karten"
        )
    }
}
