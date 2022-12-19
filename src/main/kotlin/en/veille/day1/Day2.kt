package en.veille.day1

import java.util.regex.Pattern

object Day2 {
    fun part1(spreadsheet: String): Int {
        return spreadsheet.lines().sumOf(::rowChecksum)
    }

    fun rowChecksum(row: String): Int {
        val nums = row.split(Pattern.compile("\\s")).map(String::toInt)
        return nums.max() - nums.min()
    }

    fun part2(spreadsheet: String): Int {
        return spreadsheet.lines().sumOf(::evenlyDivide)
    }

    fun evenlyDivide(row: String): Int {
        val nums = row.split(Pattern.compile("\\s")).map(String::toInt)
        for (i in 0..nums.lastIndex) {
            for (j in i+1..nums.lastIndex) {
                val a = nums[i]
                val b = nums[j]
                if (a % b == 0) {
                    return a / b
                }
                if (b % a == 0) {
                    return b / a
                }
            }
        }
        return -1
    }
}