import day5.solveA
import day5.solveB
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestDay5 {

    @Test
    fun `should work for the given test input`() {
        val input = listOf("FBFBBFFRLR")

        val solution = solveA(input)
        assertEquals(357, solution)
    }

    @Test
    fun `should work for the actual input`() {
        val input = readFileAsLinesUsingUseLines(5)

        val solution = solveA(input)
        assertEquals(976, solution)
    }

    @Test
    fun `should work with b for the actual input`() {
        val input = readFileAsLinesUsingUseLines(5)

        val solution = solveB(input)
        assertEquals(685, solution)
    }
}


