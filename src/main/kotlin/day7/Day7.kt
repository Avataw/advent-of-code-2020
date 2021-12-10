package day7

class Bag(input: String) {
    val name: String
    var bagContent: List<String>

    init {
        val inputWithoutBags = input
            .replace(" bags", "")
            .replace(" bag", "")
            .replace(".", "")
        val nameAndContent = inputWithoutBags.split(" contain ")
        name = nameAndContent[0]
        val content = nameAndContent[1].split(", ")

        bagContent = when (content.first()) {
            "no other" -> listOf()
            else -> content
        }
    }

    override fun toString(): String {
        return "Name: $name. InitialContent: $bagContent"
    }
}

var bags: List<Bag> = listOf()

fun solveA(input: List<String>): Int {
    bags = input.map { Bag(it) }

    return bags.map { canContainBagRecursively(it.name) }.filter { it }.size
}

fun canContainBagRecursively(name: String): Boolean {
    val foundBag = bags.find { bag -> bag.name == name }

    if (foundBag == null || foundBag.bagContent.isEmpty()) return false
    if (foundBag.bagContent.any { it.contains("shiny gold") }) return true

    return foundBag.bagContent.map { canContainBagRecursively(it.drop(2)) }.any { it }
}

fun countBagCountRecursively(name: String): Int {
    val foundBag = bags.find { bag -> bag.name == name } ?: return 0

    if (foundBag.bagContent.isEmpty()) return 1

    return foundBag.bagContent.sumOf {
        val count = it[0]
        Character.getNumericValue(count) * countBagCountRecursively(it.drop(2))
    } + 1
}

fun solveB(input: List<String>): Int {
    bags = input.map { Bag(it) }

    return countBagCountRecursively("shiny gold") - 1
}
