import java.io.File

fun readFileAsLinesUsingUseLines(day: Int): List<String>
        = File("src/test/resources/Day${day}/input.txt").useLines { it.toList() }