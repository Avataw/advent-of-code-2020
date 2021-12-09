package day3

data class Toboggan(val xSpeed: Int, val ySpeed: Int) {
    var x: Int = 0
    var y: Int = 0

    fun move() {
        x += xSpeed
        y += ySpeed
    }
}

class Geology(input: List<String>) {
    private var map: List<List<String>>

    init {
        map = input.map { it.split("").filter { s -> s.isNotEmpty() } }
    }

    private fun makeBigger() {
        map = map.map {
            listOf(it, it).flatten()
        }
    }

    fun countTreesHit(toboggan: Toboggan): Int {
        var treesHit = 0

        while (toboggan.y < map.size) {
            if (map[toboggan.y][toboggan.x] == "#") {
                treesHit++
            }
            if (map[0].size <= toboggan.x + toboggan.xSpeed) {
                makeBigger()
            }
            toboggan.move()
        }
        return treesHit
    }
}

fun solveA(input: List<String>): Int {
    val toboggan = Toboggan(3, 1)

    val geology = Geology(input)
    return geology.countTreesHit(toboggan)
}

fun solveB(input: List<String>): Long {
    val toboggans = listOf(
        Toboggan(1,1),
        Toboggan(3,1),
        Toboggan(5,1),
        Toboggan(7,1),
        Toboggan(1,2)
    )

    val geology = Geology(input)

    return toboggans.map { geology.countTreesHit(it).toLong() }.reduce { prod, element -> prod * element }
}
