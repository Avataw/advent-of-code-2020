package day7

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import readFileAsLinesUsingUseLines

class TestDay7 {

    @Test
    fun `should work for the given test input`() {
        val input = listOf(
            "light red bags contain 1 bright white bag, 2 muted yellow bags.",
            "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
            "bright white bags contain 1 shiny gold bag.",
            "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
            "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
            "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
            "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
            "faded blue bags contain no other bags.",
            "dotted black bags contain no other bags."
        )

        val solution = solveA(input)
        assertEquals(4, solution)
    }

    @Test
    fun `should work for the actual input`() {
        val input = readFileAsLinesUsingUseLines(7)

        val solution = solveA(input)
        assertEquals(164, solution)
    }

    @Test
    fun `should work with b for the given test input`() {
        val input = listOf(
            "shiny gold bags contain 2 dark red bags.",
            "dark red bags contain 2 dark orange bags.",
            "dark orange bags contain 2 dark yellow bags.",
            "dark yellow bags contain 2 dark green bags.",
            "dark green bags contain 2 dark blue bags.",
            "dark blue bags contain 2 dark violet bags.",
            "dark violet bags contain no other bags."
        )

        val solution = solveB(input)
        assertEquals(126, solution)
    }

    @Test
    fun `should work with b for the actual input`() {
        val input = readFileAsLinesUsingUseLines(7)

        val solution = solveB(input)
        assertEquals(7872, solution)
    }
}


