package day9

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import readFileAsLinesUsingUseLines
import readTestFileAsLinesUsingUseLines

class TestDay9 {

    @Test
    fun `should work for the given test input`() {
        val input = readTestFileAsLinesUsingUseLines(9)

        val solution = solveA(input,5)
        assertEquals(127, solution)
    }

    @Test
    fun `should work for the actual input`() {
        val input = readFileAsLinesUsingUseLines(9)

        val solution = solveA(input,25)
        assertEquals(375054920, solution)
    }

    @Test
    fun `should work with b for the given test input`() {
        val input = readTestFileAsLinesUsingUseLines(9)

        val solution = solveB(input, 5)
        assertEquals(62, solution)
    }

    @Test
    fun `should work with b for the actual input`() {
        val input = readFileAsLinesUsingUseLines(9)

        val solution = solveB(input, 25)
        assertEquals(54142584, solution)
    }
}


