import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestDay1 {

    @Test
    fun `should work for the given test input`() {
        val input = listOf("1721", "979", "366", "299", "675", "1456")

        val solution = solveA(input)
        assertEquals(514579, solution)
    }

    @Test
    fun `should work for the actual input`() {
        val input = readFileAsLinesUsingUseLines(1)

        val solution = solveA(input)
        assertEquals(1014624, solution)
    }

    @Test
    fun `should work with b for the given test input`() {
        val input = listOf("1721", "979", "366", "299", "675", "1456")

        val solution = solveB(input)
        assertEquals(241861950, solution)
    }

    @Test
    fun `should work with b for the actual input`() {
        val input = readFileAsLinesUsingUseLines(1)

        val solution = solveB(input)
        assertEquals(80072256, solution)
    }
}


