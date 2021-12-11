package day10

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import readFileAsLinesUsingUseLines
import readTestFileAsLinesUsingUseLines

class TestDay10 {

    @Test
    fun `should work for the given test input`() {
        val input = readTestFileAsLinesUsingUseLines(10)

        val solution = solveA(input)
        assertEquals(220, solution)
    }

    @Test
    fun `should work for the actual input`() {
        val input = readFileAsLinesUsingUseLines(10)

        val solution = solveA(input)
        assertEquals(1917, solution)
    }

    @Test
    fun `should work with b for the given test input`() {
        val input = readTestFileAsLinesUsingUseLines(10)

        val solution = solveB(input)
        assertEquals(62, solution)
    }

    @Test
    fun `should work with b for the actual input`() {
        val input = readFileAsLinesUsingUseLines(10)

        val solution = solveB(input)
        assertEquals(54142584, solution)
    }
}


