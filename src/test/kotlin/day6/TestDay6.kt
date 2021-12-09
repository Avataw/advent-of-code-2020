package day6

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import readFileAsLinesUsingUseLines

class TestDay6 {

    @Test
    fun `should work for the given test input`() {
        val input = listOf(
            "abc",
            "",
            "a",
            "b",
            "c",
            "",
            "ab",
            "ac",
            "",
            "a",
            "a",
            "a",
            "a",
            "",
            "b"
        )

        val solution = solveA(input)
        assertEquals(11, solution)
    }

    @Test
    fun `should work for the actual input`() {
        val input = readFileAsLinesUsingUseLines(6)

        val solution = solveA(input)
        assertEquals(6947, solution)
    }

    @Test
    fun `should work with b for the given test input`() {
        val input = listOf(
            "abc",
            "",
            "a",
            "b",
            "c",
            "",
            "ab",
            "ac",
            "",
            "a",
            "a",
            "a",
            "a",
            "",
            "b"
        )

        val solution = solveB(input)
        assertEquals(6, solution)
    }

    @Test
    fun `should work with b for the actual input`() {
        val input = readFileAsLinesUsingUseLines(6)

        val solution = solveB(input)
        assertEquals(3398, solution)
    }
}


