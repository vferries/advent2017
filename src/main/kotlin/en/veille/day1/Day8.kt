package en.veille.day1

import java.lang.Integer.max

typealias Register = Int

object Day8 {
    val operators = mapOf<String, (Int, Int) -> Boolean>(
        "==" to { a, b -> a == b },
        "!=" to { a, b -> a != b },
        "<" to { a, b -> a < b },
        "<=" to { a, b -> a <= b },
        ">" to { a, b -> a > b },
        ">=" to { a, b -> a >= b }
    )

    fun applyInstructions(text: String): List<Register> {
        val registers = mutableMapOf<String, Int>()
        text.lines().forEach {
            val parts = it.split(" ")
            val register = parts[0]
            val sign = if (parts[1] == "inc") 1 else -1
            val increment = parts[2].toInt()
            val register2 = parts[4]
            val comp = parts[5]
            val value = parts[6].toInt()
            if (operators[comp]!!.invoke(registers.getOrDefault(register2, 0), value)) {
                registers[register] = registers.getOrDefault(register, 0) + sign * increment
            }
        }
        return registers.values.toList()
    }

    fun part1(): Int {
        return applyInstructions(Utils.loadText("day8.txt")).max()
    }

    fun highestValue(text: String): Int {
        var max = 0
        val registers = mutableMapOf<String, Int>()
        text.lines().forEach {
            val parts = it.split(" ")
            val register = parts[0]
            val sign = if (parts[1] == "inc") 1 else -1
            val increment = parts[2].toInt()
            val register2 = parts[4]
            val comp = parts[5]
            val value = parts[6].toInt()
            if (operators[comp]!!.invoke(registers.getOrDefault(register2, 0), value)) {
                registers[register] = registers.getOrDefault(register, 0) + sign * increment
                max = max(max, registers[register]!!)
            }
        }
        return max
    }

    fun part2(): Int {
        return highestValue(Utils.loadText("day8.txt"))
    }
}