package en.veille.day1

import java.math.BigInteger

object Day18 {
    fun playProgram(test: String): BigInteger {
        val instructions = parseInstructions(test)
        var state = ProgramState()
        while (state.index >= 0 && state.index < instructions.size && state.received.isEmpty()) {
            println(state)
            state = instructions[state.index].execute(state)
        }
        return state.received.first().frequency
    }

    private fun parseInstructions(text: String): List<Instruction> {
        return text.lines().map { line ->
            val parts = line.split(' ')
            when {
                "snd" == parts[0] -> PlaySound(Value(parts[1]))
                "set" == parts[0] -> Set(parts[1], Value(parts[2]))
                "add" == parts[0] -> Add(parts[1], Value(parts[2]))
                "mul" == parts[0] -> Mul(parts[1], Value(parts[2]))
                "mod" == parts[0] -> Mod(parts[1], Value(parts[2]))
                "rcv" == parts[0] -> Rcv(Value(parts[1]))
                "jgz" == parts[0] -> Jgz(Value(parts[1]), Value(parts[2]))
                else -> throw IllegalArgumentException("Unknown instruction $line")
            }
        }
    }

    private fun parseInstructionsV2(text: String): List<Instruction> {
        return text.lines().map { line ->
            val parts = line.split(' ')
            when {
                "snd" == parts[0] -> Send(Value(parts[1]))
                "set" == parts[0] -> Set(parts[1], Value(parts[2]))
                "add" == parts[0] -> Add(parts[1], Value(parts[2]))
                "mul" == parts[0] -> Mul(parts[1], Value(parts[2]))
                "mod" == parts[0] -> Mod(parts[1], Value(parts[2]))
                "rcv" == parts[0] -> Receive(parts[1])
                "jgz" == parts[0] -> Jgz(Value(parts[1]), Value(parts[2]))
                else -> throw IllegalArgumentException("Unknown instruction $line")
            }
        }
    }

    fun playProgramV2(text: String): Int {
        val instructions = parseInstructionsV2(text)
        var state0 = ProgramState(registers = mapOf("p" to BigInteger.ZERO))
        var state1 = ProgramState(registers = mapOf("p" to BigInteger.ONE), other = state0)
        state0.other = state1
        var program0Waiting = false
        var program1Waiting = false
        while (!program0Waiting || !program1Waiting) {
            val nextInstruction0 = instructions[state0.index]
            if (nextInstruction0 is Receive && state0.received.size == 0) {
                program0Waiting = true
            } else {
                program0Waiting = false
                state0 = nextInstruction0.execute(state0)
            }
            val nextInstruction1 = instructions[state1.index]
            if (nextInstruction1 is Receive && state1.received.size == 0) {
                program1Waiting = true
            } else {
                program1Waiting = false
                state1 = nextInstruction1.execute(state1)
            }
        }
        return state1.sent.size
    }

    data class ProgramState(
        val index: Int = 0,
        val registers: Map<String, BigInteger> = mapOf(),
        val sent: List<Sound> = listOf(),
        val received: MutableList<Sound> = mutableListOf(),
        var other: ProgramState? = null
    )

    sealed interface Instruction {
        fun execute(state: ProgramState): ProgramState
    }

    data class PlaySound(val frequency: Value) : Instruction {
        override fun execute(state: ProgramState): ProgramState {
            return state.copy(
                index = state.index + 1,
                sent = state.sent + Sound(frequency.bigIntValue(state.registers))
            )
        }
    }

    data class Rcv(val condition: Value) : Instruction {
        override fun execute(state: ProgramState): ProgramState {
            val nextReceived =
                if (condition.bigIntValue(state.registers) != BigInteger.ZERO) state.received + state.sent.last() else state.received
            println(nextReceived)
            return state.copy(index = state.index + 1, received = nextReceived.toMutableList())
        }
    }

    data class Send(val value: Value) : Instruction {
        override fun execute(state: ProgramState): ProgramState {
            state.other?.received?.add(Sound(value.bigIntValue(state.registers)))
            return state.copy(
                index = state.index + 1,
                sent = state.sent + Sound(value.bigIntValue(state.registers))
            )
        }
    }

    data class Receive(val register: String) : Instruction {
        override fun execute(state: ProgramState): ProgramState {
            val pair = register to state.received.removeFirst().frequency
            return state.copy(index = state.index + 1, registers = state.registers + pair)
        }
    }

    data class Set(val register: String, val value: Value) : Instruction {
        override fun execute(state: ProgramState): ProgramState {
            return state.copy(
                index = state.index + 1,
                registers = state.registers + (register to value.bigIntValue(state.registers))
            )
        }
    }

    data class Add(val register: String, val value: Value) : Instruction {
        override fun execute(state: ProgramState): ProgramState {
            val pair =
                register to (state.registers.getOrElse(register) { BigInteger.ZERO } + value.bigIntValue(state.registers))
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

    data class Mod(val register: String, val value: Value) : Instruction {
        override fun execute(state: ProgramState): ProgramState {
            val pair =
                register to (state.registers.getOrElse(register) { BigInteger.ZERO } % value.bigIntValue(state.registers))
            return state.copy(index = state.index + 1, registers = state.registers + pair)
        }
    }

    data class Jgz(val condition: Value, val value: Value) : Instruction {
        override fun execute(state: ProgramState): ProgramState {
            val offset =
                if (condition.bigIntValue(state.registers) > BigInteger.ZERO) value.bigIntValue(state.registers)
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

    data class Sound(val frequency: BigInteger)
}