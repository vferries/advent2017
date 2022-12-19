package en.veille.day1

import java.lang.IllegalArgumentException

object Day22 {
    fun bursts(text: String, iterations: Int): Int {
        var infections = 0
        val map = text.lines().flatMapIndexed { row, line -> line.mapIndexed { col, c -> Pos(row, col) to c } }.toMap()
            .toMutableMap()
        var pos = Pos(text.lines().size / 2, text.lines()[0].length / 2)
        var direction = Direction.NORTH
        for (i in 0 until iterations) {
            val current = map.getOrElse(pos) { '.' }
            val infected = current == '#'
            direction = if (infected) {
                direction.turnRight()
            } else {
                direction.turnLeft()
            }
            map[pos] = if (infected) {
                '.'
            } else {
                '#'
            }
            infections += if (infected) {
                0
            } else {
                1
            }
            pos += direction.delta
        }
        return infections
    }

    fun bursts2(text: String, iterations: Int): Int {
        var infections = 0
        val map = text.lines().flatMapIndexed { row, line -> line.mapIndexed { col, c -> Pos(row, col) to c } }.toMap()
            .toMutableMap()
        var pos = Pos(text.lines().size / 2, text.lines()[0].length / 2)
        var direction = Direction.NORTH
        for (i in 0 until iterations) {
            val current = map.getOrElse(pos) { '.' }
            direction = when (current) {
                '.' -> direction.turnLeft()
                'W' -> direction
                '#' -> direction.turnRight()
                'F' -> direction.reverse()
                else -> throw IllegalArgumentException("Unknown state $current")
            }
            map[pos] = when (current) {
                '.' -> 'W'
                'W' -> '#'
                '#' -> 'F'
                'F' -> '.'
                else -> throw IllegalArgumentException("Unknown state $current")
            }
            if (current == 'W') {
                infections++
            }
            pos += direction.delta
        }
        return infections
    }

    data class Pos(val row: Int, val col: Int) {
        operator fun plus(delta: Pos): Pos {
            return Pos(row + delta.row, col + delta.col)
        }
    }

    enum class Direction(val delta: Pos) {
        NORTH(Pos(-1, 0)), EAST(Pos(0, 1)), SOUTH(Pos(1, 0)), WEST(Pos(0, -1));

        fun turnLeft(): Direction {
            return when (this) {
                NORTH -> WEST
                EAST -> NORTH
                SOUTH -> EAST
                WEST -> SOUTH
            }
        }

        fun turnRight(): Direction {
            return when (this) {
                NORTH -> EAST
                EAST -> SOUTH
                SOUTH -> WEST
                WEST -> NORTH
            }
        }

        fun reverse(): Direction {
            return when (this) {
                NORTH -> SOUTH
                EAST -> WEST
                SOUTH -> NORTH
                WEST -> EAST
            }
        }
    }
}