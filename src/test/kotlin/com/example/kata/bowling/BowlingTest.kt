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


    @ParameterizedTest(name = "Scoring multiple frames (without interaction): \"{0}\" is scored at {1}")
    @CsvSource(
        "'-1|-1', 2",
        "'-1|-1|-1', 3"
    )
    fun `scoring multiple frames`(gameRepresentation: String, expected: Int) {
        assertThat(calculateScore(gameRepresentation), Is.`is`(expected))
    }

    @ParameterizedTest(name = "Scoring multiple frames (with interaction): case {2} - \"{0}\" is scored at {1}")
    @CsvSource(
        "'-/|-1', 11, 'There is no bonus to add, from the spare'",
        "'-/|15', 17, 'from the spare, add the first throw. The second throw does not matter'",
        "'X|15', 22, 'from the strike, add two throws'",
        "'X|X', 30, 'bonus from the strike'"
    )
    fun `scoring multiple frames with interaction`(gameRepresentation: String, expected: Int) {
        assertThat(calculateScore(gameRepresentation), Is.`is`(expected))
    }

    private fun calculateScore(gameRepresentation: String) = Game(gameRepresentation).score()
}
