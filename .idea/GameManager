package com.deinname.unoapp.game

class GameManager {

    private val deck = Deck()

    val player1 = Player("Spieler")
    val player2 = Player("Bot")

    fun startGame() {

        repeat(7) {

            player1.drawCard(deck.drawCard())
            player2.drawCard(deck.drawCard())
        }
    }
}