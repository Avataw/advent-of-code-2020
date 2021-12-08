package day1

fun solveA(input: List<String>): Int {

    var result = 0;
    val inputNumbers = input.map { Integer.parseInt(it) }

    inputNumbers.forEach { outer ->
        inputNumbers.forEach { inner ->
            if (outer + inner == 2020) result = outer * inner
        }
    }

    return result
}

fun solveB(input: List<String>): Int {

    var result = 0;
    val inputNumbers = input.map { Integer.parseInt(it) }

    inputNumbers.forEach { first ->
        inputNumbers.forEach { second ->
            inputNumbers.forEach { third ->
                if(first + second + third == 2020) {
                    result = first * second * third
                }
            }
        }
    }

    return result
}
