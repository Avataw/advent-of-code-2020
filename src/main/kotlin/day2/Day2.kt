package day2

import java.lang.Integer.parseInt

class PasswordValidation(input: List<String>) {
    private val minimum: Int
    private val maximum: Int
    private val letter: String
    private val password: String

    init {
        val validationRange = input[0].split("-").map { parseInt(it) }
        minimum = validationRange[0]
        maximum = validationRange[1]

        letter = input[1].split(":")[0]
        password = input[2]
    }

    fun validateA(): Boolean = password
        .split("")
        .filter { it == letter }
        .size in minimum..maximum

    fun validateB(): Boolean {
        val passwordLetters = password.split("")

        return (passwordLetters[minimum] == letter && passwordLetters[maximum] != letter) ||
                (passwordLetters[minimum] != letter && passwordLetters[maximum] == letter)
    }
}

fun solveA(input: List<String>): Int {

    val passwordValidations = input.map { PasswordValidation(it.split(" ")).validateA() }

    return passwordValidations.filter { it }.size
}

fun solveB(input: List<String>): Int {

    val passwordValidations = input.map { PasswordValidation(it.split(" ")).validateB() }

    return passwordValidations.filter { it }.size
}
