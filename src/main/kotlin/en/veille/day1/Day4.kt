package en.veille.day1

object Day4 {
    fun isValid(passphrase: String): Boolean {
        val words = passphrase.split(" ")
        return words.size - words.distinct().size == 0
    }

    fun isValid2(passphrase: String): Boolean {
        val words = passphrase.split(" ").map { w -> w.toList().sorted() }
        return words.size - words.distinct().size == 0
    }

    fun part1(): Int {
        return Utils.loadText("day4.txt").lines().count(::isValid)
    }

    fun part2(): Int {
        return Utils.loadText("day4.txt").lines().count(::isValid2)
    }
}