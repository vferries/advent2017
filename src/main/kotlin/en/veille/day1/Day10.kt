package en.veille.day1

import kotlin.streams.toList

object Day10 {
    fun knotHash(nodes: Int, lengths: List<Int>, rounds: Int = 1): List<Int> {
        val hash = (0 until nodes).toMutableList()
        var skipSize = 0
        var position = 0
        for (round in (0 until rounds)) {
            for (length in lengths) {
                val backup = mutableListOf<Int>()
                for (i in 0 until length) {
                    backup.add(hash[(position + i) % hash.size])
                }
                backup.reverse()
                for (i in 0 until length) {
                    hash[(position + i) % hash.size] = backup[i]
                }
                position += length + skipSize++
                position %= hash.size
            }
        }
        return hash
    }

    fun part1(): Int {
        val lengths = Utils.loadText("day10.txt").split(",").map(String::toInt)
        return knotHash(256, lengths).take(2).reduce(Int::times)
    }


    fun String.toAscii(): List<Int> {
        return this.chars().toList()
    }

    fun part2(): String {
        val text = Utils.loadText("day10.txt")
        return realKnotHash(text).displayDenseHash()
    }

    fun realKnotHash(text: String): List<Int> {
        val lengths = parseLengths(text)
        val sparseHash = knotHash(256, lengths, 64)
        return sparseHash.chunked(16).map { it.reduce(Int::xor) }
    }

    fun List<Int>.displayDenseHash(): String {
        return this.joinToString("") { it.toString(16).padStart(2, '0') }
    }

    fun parseLengths(text: String): List<Int> {
        return text.toAscii() + listOf(17, 31, 73, 47, 23)
    }
}