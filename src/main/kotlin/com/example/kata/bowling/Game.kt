package com.example.kata.bowling

class Game(private val gameRepresentation: String) {
    fun score(): Int {
        return try {
            Integer.parseInt(gameRepresentation[0].toString())
        } catch (e: Exception) {
            0
        }
    }
}
