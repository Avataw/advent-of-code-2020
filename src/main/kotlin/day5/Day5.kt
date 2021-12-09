package day5

fun solveA(input: List<String>): Int {

    return findAllSeatIDs(input).maxOrNull() ?: 0
}

fun findAllSeatIDs(boardingPasses: List<String>): List<Int> {
    return boardingPasses.map {
        var possibleRows = (0..128).toList()
        var possibleColumns = (0..7).toList()

        it.forEach { c ->
            when (c) {
                'F' -> possibleRows = possibleRows.take(possibleRows.size / 2)
                'B' -> possibleRows = possibleRows.drop(possibleRows.size / 2)
                'L' -> possibleColumns = possibleColumns.take(possibleColumns.size / 2)
                'R' -> possibleColumns = possibleColumns.drop(possibleColumns.size / 2)
            }
        }

        possibleRows.first() * 8 + possibleColumns.first()
    }
}

fun solveB(input: List<String>): Int {

    val seats = 8..976

    val seatsFromBoardingPasses = findAllSeatIDs(input)

    return seats.subtract(seatsFromBoardingPasses.toSet()).first()
}
