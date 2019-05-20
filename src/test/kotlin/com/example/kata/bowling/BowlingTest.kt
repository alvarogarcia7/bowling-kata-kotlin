package com.example.kata.bowling

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class BowlingTest {

    @ParameterizedTest(name = "No Pins are knocked down: {0}")
    @CsvSource(
        "--|--|--|--|--|--|--|--|--|--||"
    )
    fun `total score when no pins are knocked down`(gameRepresentation: String) {
        assertThat(calculateScore(gameRepresentation), Is.`is`(0))
    }

    @Test
    fun `total score for one frame when no pins are knocked down`() {
        assertThat(0, `is`(calculateScore("--")))
    }

    @Test
    fun `total score for one frame when one pin is knocked down`() {
        assertThat(1, `is`(calculateScore("1-")))
    }

    @Test
    fun `total score for one frame when one pin is knocked down after a miss`() {
        assertThat(1, `is`(calculateScore("-1")))
    }

    @Test
    fun `total score for one frame when eight pins are knocked down`() {
        assertThat(8, `is`(calculateScore("71")))
    }


    private fun calculateScore(gameRepresentation: String) = Game(gameRepresentation).score()
}
