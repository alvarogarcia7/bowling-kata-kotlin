package com.example.kata.bowling

class Game(private val gameRepresentation: String) {
    fun score(): Int {

        return parseFrame(gameRepresentation)
    }

    private fun parseFrame(representation: String): Int {
        if (isStrike(representation)) {
            return 10
        }
        return scoreOfASingleThrow(representation[0]) +
                scoreOfASingleThrow(representation[1])
    }

    private fun isStrike(representation: String): Boolean {
        return representation.startsWith("X")
    }

    private fun scoreOfASingleThrow(throwRepresentation: Char): Int {
        return try {
            Integer.parseInt(throwRepresentation.toString())
        } catch (e: Exception) {
            0
        }

    }
}
