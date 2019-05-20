package com.example.kata.bowling

class Game(private val gameRepresentation: String) {
    fun score(): Int {
        var frames = gameRepresentation.split("|")
        return parseFrame(frames[0]) + try {
            parseFrame(frames[1])
        } catch (e: Exception) {
            0
        }
    }

    private fun parseFrame(representation: String): Int {
        if (isStrike(representation)) {
            return 10
        }
        if (isSpare(representation)) {
            return 10
        }
        return scoreOfASingleThrow(representation[0]) +
                scoreOfASingleThrow(representation[1])
    }

    private fun isSpare(representation: String): Boolean {
        return representation.contains("/")
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
