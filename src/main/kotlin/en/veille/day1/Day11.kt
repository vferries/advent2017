package en.veille.day1

import kotlin.math.abs

object Day11 {
    fun shortestPath(path: String): Int {
        return path
            .split(',')
            .fold(Position(0, 0)) { pos, direction -> pos.move(direction) }.distanceToOrigin()
    }

    private fun maxDistance(path: String): Int {
        var pos = Position(0, 0)
        return path.split(',').maxOf { direction ->
            pos = pos.move(direction)
            pos.distanceToOrigin()
        }
    }

    fun part1(): Int {
        return shortestPath(Utils.loadText("day11.txt"))
    }

    fun part2(): Int {
        return maxDistance(Utils.loadText("day11.txt"))
    }

    data class Position(val row: Int, val col: Int) {
        fun move(direction: String): Position {
            return when (direction) {
                "n" -> Position(row - 2, col)
                "nw" -> Position(row - 1, col - 1)
                "ne" -> Position(row - 1, col + 1)
                "s" -> Position(row + 2, col)
                "sw" -> Position(row + 1, col - 1)
                "se" -> Position(row + 1, col + 1)
                else -> throw IllegalArgumentException("Unknown direction $direction")
            }
        }

        fun distanceToOrigin(): Int {
            return abs(col) + (abs(row) - abs(col) + 1) / 2
        }
    }
}