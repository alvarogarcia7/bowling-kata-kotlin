package com.example.kata.bowling

class Game(private val gameRepresentation: String) {
    fun score(): Int {
        return (try {
            Integer.parseInt(gameRepresentation[0].toString()) +
                    Integer.parseInt(gameRepresentation[1].toString())

        } catch (e: Exception) {
            return (try {
                Integer.parseInt(gameRepresentation[0].toString())
            } catch (e: Exception) {
                return (try {
                    Integer.parseInt(gameRepresentation[1].toString())
                } catch (e: Exception) {
                    0
                })
            })
        })
    }
}
