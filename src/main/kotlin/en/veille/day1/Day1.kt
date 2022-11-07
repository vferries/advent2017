package en.veille.day1

object Day1 {
    fun sumConsecutive(input: String): Int {
        val digits = input.chunked(1).map(String::toInt)
        val rotated = digits.drop(1) + digits.first()
        return digits.zip(rotated).filter { (i, j) -> i == j }.sumOf { it.first }
    }

    fun part1(): Int {
        return sumConsecutive(Utils.loadText("day1.txt"))
    }

    fun part2(): Int {
        return sumHalfway(Utils.loadText("day1.txt"))
    }

    fun sumHalfway(input: String): Int {
        val digits = input.chunked(1).map(String::toInt)
        val half = digits.size / 2
        val rotated = digits.drop(half) + digits.take(half)
        return digits.zip(rotated).filter { (i, j) -> i == j }.sumOf { it.first }
    }
}
