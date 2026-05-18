package com.deinname.unoapp.game

import com.deinname.unoapp.model.Card
import com.deinname.unoapp.model.CardColor
import com.deinname.unoapp.model.CardValue

class Deck {

    private val cards = mutableListOf<Card>()

    init {
        createDeck()
        shuffle()
    }

    private fun createDeck() {

        val colors = listOf(
            CardColor.RED,
            CardColor.BLUE,
            CardColor.GREEN,
            CardColor.YELLOW
        )

        val values = listOf(
            CardValue.ZERO,
            CardValue.ONE,
            CardValue.TWO,
            CardValue.THREE,
            CardValue.FOUR,
            CardValue.FIVE,
            CardValue.SIX,
            CardValue.SEVEN,
            CardValue.EIGHT,
            CardValue.NINE
        )

        for (color in colors) {
            for (value in values) {
                cards.add(Card(color, value))
            }
        }
    }

    fun shuffle() {
        cards.shuffle()
    }

    fun drawCard(): Card {
        return cards.removeAt(0)
    }
}