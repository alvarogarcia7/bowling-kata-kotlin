package com.example.kata.bowling

import junit.framework.Assert.assertEquals
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class BowlingTest{

    @Test
    fun total_score_when_no_pins_knocked_down(){
        assertEquals(0, calculateScore("--|--|--|--|--|--|--|--|--|--||"))
    }

    private fun calculateScore(gameRepresentation: String): Int {
        return Game(gameRepresentation).score()
    }
}
