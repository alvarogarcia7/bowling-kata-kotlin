package com.example.kata.bowling

class Game(private val gameRepresentation: String) {
    fun score(): Int {

        return scoreOfASingleThrow(gameRepresentation[0]) +
                scoreOfASingleThrow(gameRepresentation[1])
    }

    private fun scoreOfASingleThrow(throwRepresentation: Char): Int {
        return try {
            Integer.parseInt(throwRepresentation.toString())
        } catch (e: Exception) {
            0
        }

    }
}
