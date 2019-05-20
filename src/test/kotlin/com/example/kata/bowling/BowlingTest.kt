package com.example.kata.bowling

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class BowlingTest{

    @Test
    fun total_score_when_no_pins_are_knocked_down(){
        assertThat(0, `is`(calculateScore("--|--|--|--|--|--|--|--|--|--||")))
    }

    @Test
    fun total_score_for_one_frame_when_no_pins_are_knocked_down(){
        assertThat(0, `is`(calculateScore("--")))
    }

    @Test
    fun `total score for one frame when one pin is knocked down`(){
        assertThat(1, `is`(calculateScore("1-")))
    }

    @Test
    fun `total score for one frame when one pin is knocked down after a miss`(){
        assertThat(1, `is`(calculateScore("-1")))
    }

    @Test
    fun `total score for one frame when eight pins are knocked down`(){
        assertThat(8, `is`(calculateScore("71")))
    }


    private fun calculateScore(gameRepresentation: String) = Game(gameRepresentation).score()
}
