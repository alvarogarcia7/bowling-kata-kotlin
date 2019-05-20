package com.example.kata.bowling

class Game(private val gameRepresentation: String) {
    var remainingBonusBalls = 0
    fun score(): Int {
        return gameRepresentation.split("|").map { parseFrame(it) }.sum()
    }

    private fun parseFrame(representation: String): Int {
        if (isStrike(representation)) {
            var result = 10
            if (remainingBonusBalls > 0) {
                result += 10
                remainingBonusBalls--
            }
            remainingBonusBalls++
            remainingBonusBalls++
            return result
        }
        if (isSpare(representation)) {
            var result = 10
            if (remainingBonusBalls > 0) {
                result += 10
                remainingBonusBalls--
            }
            remainingBonusBalls++
            return result
        }
        return try {
            var result = 0

            result += scoreOfASingleThrow(representation[0])
            if (remainingBonusBalls > 0) {
                result += scoreOfASingleThrow(representation[0])
                remainingBonusBalls--
            }
            result += scoreOfASingleThrow(representation[1])
            if (remainingBonusBalls > 0) {
                result += scoreOfASingleThrow(representation[1])
                remainingBonusBalls--
            }

            result
        } catch (e: Exception) {
            0
        }
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
