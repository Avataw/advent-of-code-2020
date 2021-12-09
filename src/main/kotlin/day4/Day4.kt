package day4

import java.lang.Integer.parseInt

class Passport(input: List<String>, onlyCheckFieldExistence: Boolean = false) {
    val isValid: Boolean
    val hasValidFields: Boolean

    init {
        val passportFields = input.joinToString(" ")

        isValid = passportFields.contains("byr")
                && passportFields.contains("iyr")
                && passportFields.contains("eyr")
                && passportFields.contains("hgt")
                && passportFields.contains("hcl")
                && passportFields.contains("ecl")
                && passportFields.contains("pid")

        hasValidFields = if (onlyCheckFieldExistence) {
            false
        } else {
            passportFields
                .split(" ")
                .filter { it.isNotEmpty() }
                .map {
                    val field = it.split(":")
                    println("label: ${field[0]} value: ${field[1]} && ${validateField(field[0], field[1])}")
                    validateField(field[0], field[1])
                }.all { it }
        }

    }


    fun validateField(label: String, value: String): Boolean {

        return when (label) {
            "byr" -> parseInt(value) in 1920..2002
            "iyr" -> parseInt(value) in 2010..2020
            "eyr" -> parseInt(value) in 2020..2030
            "hgt" -> checkHeight(value)
            "hcl" -> value.length == 7 && (value.matches(Regex("#[0-9a-z]+")))
            "ecl" -> value in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
            "pid" -> value.length == 9 && value.toIntOrNull() != null
            "cid" -> true
            else -> false
        }
    }

    fun checkHeight(heightCMorIN: String): Boolean {
        if (heightCMorIN.length > 2) {

            val isCm = heightCMorIN[heightCMorIN.length - 2] == 'c' && heightCMorIN[heightCMorIN.length - 1] == 'm'
            val isIn = heightCMorIN[heightCMorIN.length - 2] == 'i' && heightCMorIN[heightCMorIN.length - 1] == 'n'

            val height = heightCMorIN.removeRange(heightCMorIN.length - 2, heightCMorIN.length).toIntOrNull() ?: return false

            if(isCm) {
                return height in 150 .. 193
            } else if(isIn) {
                return height in 59 .. 76
            }
        }
        return false
    }
}

fun solveA(input: List<String>): Int {

    val currentPassportInput = mutableListOf<String>()
    val passports = mutableListOf<Passport>()

    input.forEach {
        if (it.isBlank()) {
            passports.add(Passport(currentPassportInput))
            currentPassportInput.clear()
        } else {
            currentPassportInput.add(it)
        }
    }
    passports.add(Passport(currentPassportInput, true))

    return passports.filter { it.isValid }.size
}

fun solveB(input: List<String>): Int {

    val currentPassportInput = mutableListOf<String>()
    val passports = mutableListOf<Passport>()

    input.forEach {
        if (it.isBlank()) {
            passports.add(Passport(currentPassportInput))
            currentPassportInput.clear()
        } else {
            currentPassportInput.add(it)
        }
    }
    passports.add(Passport(currentPassportInput))

    return passports.filter { it.isValid && it.hasValidFields }.size
}
