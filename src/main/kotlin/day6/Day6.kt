package day6

fun solveA(input: List<String>): Int {
    val groups = inputToGroups(input)
    val uniqueAnswers = groups.map { group -> group.value.reduce { acc, s -> acc + s }.toSet() }

    return uniqueAnswers.sumOf { it.size }
}

fun inputToGroups(input: List<String>): Map<Int, List<String>> {
    val groups = mutableMapOf<Int, MutableList<String>>()

    var counter = 0
    input.forEach {
        if (it != "") {
            groups[counter] = groups.getOrDefault(counter, mutableListOf()).also { list -> list.add(it) }
        } else {
            counter++
        }
    }

    return groups
}


fun solveB(input: List<String>): Int {
    val groups = inputToGroups(input)

    val sharedAnswers = groups.map { group ->
        group.value.reduce { acc, list ->
            list.toList().intersect(acc.toList().toSet()).joinToString("")
        }
    }.filter { it.isNotBlank() }

    return sharedAnswers.sumOf { it.length }
}
