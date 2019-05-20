package com.example.kata.bowling

import junit.framework.Assert.assertEquals
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class BowlingTest{

    @Test
    fun total_score_when_no_pins_are_knocked_down(){
        assertEquals(0, calculateScore("--|--|--|--|--|--|--|--|--|--||"))
    }

    @Test
    fun total_score_for_one_frame_when_no_pins_are_knocked_down(){
        assertEquals(0, calculateScore("--"))
    }

    @Test
    fun `total score for one frame when one pin is knocked down`(){
        assertEquals(1, calculateScore("1-"))
    }

    @Test
    fun `total score for one frame when one pin is knocked down after a miss`(){
        assertEquals(1, calculateScore("-1"))
    }

    @Test
    fun `total score for one frame when eight pins are knocked down`(){
        assertEquals(8, calculateScore("71"))
    }



    private fun calculateScore(gameRepresentation: String): Int {
        return Game(gameRepresentation).score()
    }
}
