package en.veille.day1

import kotlin.math.abs

object Day3 {
    data class Position(val x: Int, val y: Int) {
        operator fun plus(other: Position): Position {
            return Position(this.x + other.x, this.y + other.y)
        }

        fun sumNeighbors(map: MutableMap<Position, Int>): Int {
            return listOf(
                Position(-1, -1),
                Position(-1, 0),
                Position(-1, 1),
                Position(0, -1),
                Position(0, 1),
                Position(1, -1),
                Position(1, 0),
                Position(1, 1)
            ).map { this + it }.sumOf { map.getOrDefault(it, 0) }
        }
    }

    enum class Direction(val forward: Position) {
        UP(Position(0, -1)), LEFT(Position(-1, 0)), DOWN(Position(0, 1)), RIGHT(Position(1, 0));

        fun next(): Direction {
            val index = Direction.values().indexOf(this)
            return Direction.values()[(index + 1) % Direction.values().size]
        }
    }

    fun stepsTo(n: Int): Int {
        var pos = Position(0, 0)
        var dir = Direction.RIGHT
        val map = mutableMapOf(pos to 1)
        for (i in 2..n) {
            pos += dir.forward
            map[pos] = i
            if (!map.containsKey(pos + dir.next().forward)) {
                dir = dir.next()
            }
        }
        return abs(pos.x) + abs(pos.y)
    }

    fun firstLargerThan(n: Int): Int {
        var pos = Position(0, 0)
        var dir = Direction.RIGHT
        val map = mutableMapOf(pos to 1)
        while (true) {
            pos += dir.forward
            val sum = pos.sumNeighbors(map)
            if (sum > n) return sum
            map[pos] = sum
            if (!map.containsKey(pos + dir.next().forward)) {
                dir = dir.next()
            }
        }
    }
}