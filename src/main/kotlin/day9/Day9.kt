package day9

fun solveA(input: List<String>, preamble: Int): Long {

    val inputNumbers = input.map { it.toLong() }

    for (i in preamble..inputNumbers.size) {
        val current = inputNumbers[i]

        val checkNumbers = (i - preamble until i).map { inputNumbers[it] }

        if (!isValid(checkNumbers, current)) {
            return current
        }
    }

    return -1
}

fun isValid(checkNumbers: List<Long>, sum: Long): Boolean {
    for (j in 0..checkNumbers.size) {
        checkNumbers.forEach { outer ->
            checkNumbers.forEach { inner ->
                if (outer + inner == sum) return true
            }
        }
    }
    return false
}

fun findContiguousSet(checkNumbers: List<Long>, target: Long): Long {
    for (j in 0..checkNumbers.size) {
        checkNumbers.drop(j).reduceIndexed { index, sum, element ->
            val nextSum = sum + element
            if(nextSum == target) {
                val result = (j .. index + j).map{checkNumbers[it]}.sorted()
                return result.first() + result.last()
            }
            nextSum
        }
    }

    return 0
}

fun solveB(input: List<String>, preamble: Int): Long {
    val inputNumbers = input.map { it.toLong() }

    val targetNumber = solveA(input, preamble)

    return findContiguousSet(inputNumbers, targetNumber)
}
