package com.example.kata.bowling

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class BowlingTest {

    @ParameterizedTest(name = "No Pins are knocked down: {0}")
    @CsvSource(
        "--|--|--|--|--|--|--|--|--|--||",
        "--"
    )
    fun `no pins are knocked down`(gameRepresentation: String) {
        assertThat(calculateScore(gameRepresentation), Is.`is`(0))
    }

    @ParameterizedTest(name = "Scoring a single frame: \"{0}\" is scored at {1}")
    @CsvSource(
        "'-1', 1",
        "'1-', 1",
        "'71', 8",
        "'X', 10",
        "'2/', 10"
    )
    fun `scoring a single frame`(gameRepresentation: String, expected: Int) {
        assertThat(calculateScore(gameRepresentation), Is.`is`(expected))
    }


    @ParameterizedTest(name = "Scoring multiple frames: \"{0}\" is scored at {1}")
    @CsvSource(
        "'-1|-1', 2"
    )
    fun `scoring multiple frames`(gameRepresentation: String, expected: Int) {
        assertThat(calculateScore(gameRepresentation), Is.`is`(expected))
    }

    private fun calculateScore(gameRepresentation: String) = Game(gameRepresentation).score()
}
