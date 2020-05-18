package com.example.kata.marsrover

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class CanaryTest {

    @ParameterizedTest(name = "Canary: \"{1}\": {0}")
    @CsvSource(
        "1, 'a positive number'",
        "0, 'zero'",
        "-1, 'a negative number'",
        "2, 'an even number'",
        "3, 'an odd number'"
    )
    fun `canary test`(input: Int, description: String) {
        assertThat(input * 0, Is.`is`(0))
    }

    @Test
    fun `mockito cheat sheet`() {
        val stub = mock<Example> {
            on { getInt() } doReturn 1
        }

        stub.getInt()

        verify(stub, times(1)).getInt()
    }
}
