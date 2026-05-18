package com.deinname.unoapp.game

import com.deinname.unoapp.model.Card

class Player(
    val name: String
) {

    val hand = mutableListOf<Card>()

    fun drawCard(card: Card) {
        hand.add(card)
    }

    fun playCard(card: Card) {
        hand.remove(card)
    }
}