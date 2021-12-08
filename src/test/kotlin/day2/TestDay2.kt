import day2.solveA
import day2.solveB
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestDay2 {

    @Test
    fun `should work for the given test input`() {
        val input = listOf(
            "1-3 a: abcde",
            "1-3 b: cdefg",
            "2-9 c: ccccccccc"
        )

        val solution = solveA(input)
        assertEquals(2, solution)
    }

    @Test
    fun `should work for the actual input`() {
        val input = readFileAsLinesUsingUseLines(2)

        val solution = solveA(input)
        assertEquals(393, solution)
    }

    @Test
    fun `should work with b for the given test input`() {
        val input = listOf(
            "1-3 a: abcde",
            "1-3 b: cdefg",
            "2-9 c: ccccccccc"
        )

        val solution = solveB(input)
        assertEquals(1, solution)
    }

    @Test
    fun `should work with b for the actual input`() {
        val input = readFileAsLinesUsingUseLines(2)

        val solution = solveB(input)
        assertEquals(690, solution)
    }
}


