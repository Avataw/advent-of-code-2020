package day10

fun solveA(input: List<String>): Int {

    val jolts = input.map { it.toInt() }.toMutableList()
    val deviceJoltage = jolts.maxOrNull()?.plus(3) ?: return -1

    jolts.add(0)
    jolts.add(deviceJoltage)

    val joltDifferences = jolts
        .sorted()
        .zipWithNext()
        .map { it.second - it.first }

    return joltDifferences.filter { it == 1 }.size * joltDifferences.filter { it == 3 }.size
}

fun solveB(input: List<String>): Int {

    return TODO()
}
