package org.example.bowling

class Game {
    private val rolls = Array<Int>(21) { 0 }
    private var currentRoll = 0

    fun roll(pins: Int) {
        rolls[currentRoll++] = pins
    }

    fun score(): Int {
        var score = 0
        var i = 0

        for (frame in 0 until 10) {
            score += rolls[i] + rolls[i + 1]
            i += 2
        }

        return score
    }
}
