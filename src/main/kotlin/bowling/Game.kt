package org.example.bowling

class Game {
    var score = 0

    fun roll(pins: Int) {
        score += pins
    }

    fun score(): Int = score
}
