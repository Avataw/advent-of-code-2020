package day8

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import readFileAsLinesUsingUseLines

class TestDay8 {

    @Test
    fun `should work for the given test input`() {
        val input = listOf(
            "nop +0",
            "acc +1",
            "jmp +4",
            "acc +3",
            "jmp -3",
            "acc -99",
            "acc +1",
            "jmp -4",
            "acc +6"
        )

        val solution = solveA(input)
        assertEquals(5, solution)
    }

    @Test
    fun `should work for the actual input`() {
        val input = readFileAsLinesUsingUseLines(8)

        val solution = solveA(input)
        assertEquals(2034, solution)
    }

    @Test
    fun `should work with b for the given test input`() {
        val input = listOf(
            "nop +0",
            "acc +1",
            "jmp +4",
            "acc +3",
            "jmp -3",
            "acc -99",
            "acc +1",
            "jmp -4",
            "acc +6"
        )

        val solution = solveB(input)
        assertEquals(8, solution)
    }

    @Test
    fun `should work with b for the actual input`() {
        val input = readFileAsLinesUsingUseLines(8)

        val solution = solveB(input)
        assertEquals(7872, solution)
    }
}


