package en.veille.day1

object Day5 {
    fun part1(): Int {
        return steps(Utils.loadText("day5.txt").lines().map(String::toInt))
    }

    fun part2(): Int {
        return steps2(Utils.loadText("day5.txt").lines().map(String::toInt))
    }

    fun steps(list: List<Int>): Int {
        val mutableList = mutableListOf<Int>()
        mutableList.addAll(list)
        var i = 0
        var steps = 0
        while (i >= 0 && i <= mutableList.lastIndex) {
            mutableList[i] += 1
            i += mutableList[i] - 1
            steps++
        }
        return steps
    }

    fun steps2(list: List<Int>): Int {
        val mutableList = mutableListOf<Int>()
        mutableList.addAll(list)
        var i = 0
        var steps = 0
        while (i >= 0 && i <= mutableList.lastIndex) {
            val old = mutableList[i]
            mutableList[i] += if (old < 3) 1 else -1
            i += old
            steps++
        }
        return steps
    }
}