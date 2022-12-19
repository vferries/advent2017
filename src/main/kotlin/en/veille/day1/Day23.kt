package en.veille.day1

import java.math.BigInteger
import kotlin.math.sqrt

object Day23 {
    fun countMul(text: String): Int {
        val instructions = parseInstructions(text)
        var state = ProgramState()
        var mul = 0
        while (state.index >= 0 && state.index < instructions.size) {
            if (instructions[state.index] is Mul) {
                mul++
            }
            state = instructions[state.index].execute(state)
        }
        return mul
    }

    private fun parseInstructions(text: String): List<Instruction> {
        return text.lines().map { line ->
            val parts = line.split(' ')
            when {
                "set" == parts[0] -> Set(parts[1], Value(parts[2]))
                "sub" == parts[0] -> Sub(parts[1], Value(parts[2]))
                "mul" == parts[0] -> Mul(parts[1], Value(parts[2]))
                "jnz" == parts[0] -> Jnz(Value(parts[1]), Value(parts[2]))
                else -> throw IllegalArgumentException("Unknown instruction $line")
            }
        }
    }

    fun part2(): Int {
        var h = 0
        val b = 108_400
        val c = 125_400
        for (p in b..c step 17) {
            if (!isPrime(p)) {
                h++
            }
        }
        return h
    }

    private fun isPrime(num: Int): Boolean {
        val end = sqrt(num.toDouble()).toInt()
        var i = 2
        while (i < end) {
            if (num % i == 0) {
                return false
            }
            i += 1
        }
        return true
    }


    data class ProgramState(
        val index: Int = 0,
        val registers: Map<String, BigInteger> = ('a'..'h').associate { it.toString() to BigInteger.ZERO }
    )

    sealed interface Instruction {
        fun execute(state: ProgramState): ProgramState
    }

    data class Set(val register: String, val value: Value) : Instruction {
        override fun execute(state: ProgramState): ProgramState {
            return state.copy(
                index = state.index + 1,
                registers = state.registers + (register to value.bigIntValue(state.registers))
            )
        }
    }

    data class Sub(val register: String, val value: Value) : Instruction {
        override fun execute(state: ProgramState): ProgramState {
            val pair =
                register to (state.registers.getOrElse(register) { BigInteger.ZERO } - value.bigIntValue(state.registers))
            return state.copy(index = state.index + 1, registers = state.registers + pair)
        }
    }

    data class Mul(val register: String, val value: Value) : Instruction {
        override fun execute(state: ProgramState): ProgramState {
            val pair =
                register to (state.registers.getOrElse(register) { BigInteger.ZERO } * value.bigIntValue(state.registers))
            return state.copy(index = state.index + 1, registers = state.registers + pair)
        }
    }

    data class Jnz(val condition: Value, val value: Value) : Instruction {
        override fun execute(state: ProgramState): ProgramState {
            val offset =
                if (condition.bigIntValue(state.registers) != BigInteger.ZERO) value.bigIntValue(state.registers)
                    .toInt() else 1
            return state.copy(index = state.index + offset)
        }
    }

    class Value(private val y: String) {
        fun bigIntValue(registers: Map<String, BigInteger>): BigInteger {
            return y.toIntOrNull()?.toBigInteger() ?: registers.getValue(y)
        }

        override fun toString(): String {
            return "Value($y)"
        }
    }
}