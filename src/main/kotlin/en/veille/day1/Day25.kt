package en.veille.day1

object Day25 {
    fun sample(): Int {
        val states = mapOf(
            'A' to State(Action(Write.ONE, Move.RIGHT, 'B'), Action(Write.ZERO, Move.LEFT, 'B')),
            'B' to State(Action(Write.ONE, Move.LEFT, 'A'), Action(Write.ONE, Move.RIGHT, 'A'))
        )
        return applySteps(6, states, 'A')
    }

    private fun applySteps(
        steps: Int,
        states: Map<Char, State>,
        currentState: Char
    ): Int {
        var currentState1 = currentState
        var pos = 0
        val lit = mutableSetOf<Int>()
        for (i in 0 until steps) {
            val state = states.getValue(currentState1)
            val action = if (lit.contains(pos)) {
                state.when1
            } else {
                state.when0
            }
            when (action.write) {
                Write.ZERO -> lit.remove(pos)
                Write.ONE -> lit.add(pos)
            }
            when (action.move) {
                Move.LEFT -> pos--
                Move.RIGHT -> pos++
            }
            currentState1 = action.nextState
        }
        return lit.size
    }

    fun part1(): Int {
        val states = mapOf(
            'A' to State(Action(Write.ONE, Move.RIGHT, 'B'), Action(Write.ZERO, Move.RIGHT, 'C')),
            'B' to State(Action(Write.ZERO, Move.LEFT, 'A'), Action(Write.ZERO, Move.RIGHT, 'D')),
            'C' to State(Action(Write.ONE, Move.RIGHT, 'D'), Action(Write.ONE, Move.RIGHT, 'A')),
            'D' to State(Action(Write.ONE, Move.LEFT, 'E'), Action(Write.ZERO, Move.LEFT, 'D')),
            'E' to State(Action(Write.ONE, Move.RIGHT, 'F'), Action(Write.ONE, Move.LEFT, 'B')),
            'F' to State(Action(Write.ONE, Move.RIGHT, 'A'), Action(Write.ONE, Move.RIGHT, 'E'))
        )
        return applySteps(12_399_302, states, 'A')
    }

    data class State(val when0: Action, val when1: Action)
    data class Action(val write: Write, val move: Move, val nextState: Char)
    enum class Write { ZERO, ONE }
    enum class Move { LEFT, RIGHT }
}