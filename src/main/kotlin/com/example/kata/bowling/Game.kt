package com.example.kata.bowling

class Game(private val gameRepresentation: String) {
    fun score(): Int {
        var result = 0
        result += scoreOfASingleThrow(gameRepresentation[0])
        result += scoreOfASingleThrow(gameRepresentation[1])
        return result
    }

    private fun scoreOfASingleThrow(throwRepresentation: Char): Int {
        var result = 0
        try {
            result = Integer.parseInt(throwRepresentation.toString())
        } catch (e: Exception) {
            //no op
        }
        return result
    }
}
