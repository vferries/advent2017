package en.veille.day1

import java.util.regex.Pattern

object Day6 {
    fun redistributionCycles(init: List<Int>): Pair<Int, Int> {
        val banks = mutableListOf<Int>()
        banks.addAll(init)
        val seen = mutableMapOf(init.toString() to 0)
        var step = 1
        while (true) {
            banks.redistribute()
            val str = banks.toString()
            if (seen.contains(str)) {
                return step to step - seen.getOrDefault(str, 0)
            } else {
                seen[str] = step
            }
            step++
        }
    }

    fun part1(): Int {
        return redistributionCycles(Utils.loadText("day6.txt").split(Pattern.compile("\\s")).map(String::toInt)).first
    }

    fun part2(): Int {
        return redistributionCycles(Utils.loadText("day6.txt").split(Pattern.compile("\\s")).map(String::toInt)).second
    }
}

private fun MutableList<Int>.redistribute() {
    val index = this.indexOf(this.max())
    val value = this[index]
    this[index] = 0
    for (i in 1..value) {
        this[(index + i) % this.size] += 1
    }
}
