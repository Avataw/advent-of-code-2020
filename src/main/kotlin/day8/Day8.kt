package day8

import java.lang.Integer.parseInt

class Instruction(input: String) {
    var type: String
    val amount: Int
    var visited: Boolean = false

    init {
        val typeAndAmount = input.split(" ")
        type = typeAndAmount[0]
        amount = parseInt(typeAndAmount[1])
    }

    override fun toString(): String = "Type: $type - Amount: $amount - Visited: $visited"
}

fun solveA(input: List<String>): Int {
    val instructions: Map<Int, Instruction> = input.mapIndexed { index, s -> index to Instruction(s) }.toMap()

    return solve(instructions)
}

fun solve(instructions: Map<Int, Instruction>): Int {
    var accumulator = 0
    var nextInstruction = 0

    while (true) {
        val instruction = instructions[nextInstruction] ?: return -1

        if (instruction.visited) return accumulator

        when (instruction.type) {
            "nop" -> nextInstruction++
            "acc" -> {
                accumulator += instruction.amount
                nextInstruction++
            }
            "jmp" -> nextInstruction += instruction.amount
        }

        instruction.visited = true
    }
}

fun trySolve(instructions: Map<Int, Instruction>): Int {
    var accumulator = 0
    var nextInstruction = 0

    while (true) {
        val instruction = instructions[nextInstruction] ?: return -1

        if (instruction.visited) return -1

        when (instruction.type) {
            "nop" -> nextInstruction++
            "acc" -> {
                accumulator += instruction.amount
                nextInstruction++
            }
            "jmp" -> nextInstruction += instruction.amount
        }

        instruction.visited = true

        if (nextInstruction >= instructions.size) return accumulator
    }
}

fun solveB(input: List<String>): Int {
    val instructions: Map<Int, Instruction> = input.mapIndexed { index, s -> index to Instruction(s) }.toMap()

    instructions.forEach { it ->
        if (it.value.type != "acc") {
            val instruction = input.mapIndexed { index, s -> index to Instruction(s) }.toMap().toMutableMap()
            val change = instruction[it.key] ?: return -1
            if (change.type == "nop") {
                change.type = "jmp"
            } else {
                change.type = "nop"
            }
            instruction[it.key] = change

            val result = trySolve(instruction)
            if(result != -1 ) return result
        }
    }

    return -1
}
