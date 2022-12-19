package en.veille.day1

object Day9 {
    fun removeGarbage(stream: String): String {
        var result = ""
        var i = 0
        var insideGarbage = false
        while (i < stream.length) {
            val current = stream[i]
            if (insideGarbage) {
                if (current == '>') {
                    insideGarbage = false
                } else if (current == '!') {
                    i++
                }
            } else {
                if (current == '<') {
                    insideGarbage = true
                } else {
                    result += current
                }
            }
            i++
        }
        return result
    }

    fun countRemoved(stream: String): Int {
        var removed = 0
        var i = 0
        var insideGarbage = false
        while (i < stream.length) {
            val current = stream[i]
            if (insideGarbage) {
                if (current == '>') {
                    insideGarbage = false
                } else if (current == '!') {
                    i++
                } else {
                    removed++
                }
            } else {
                if (current == '<') {
                    insideGarbage = true
                }
            }
            i++
        }
        return removed
    }

    fun score(input: String): Int {
        val stream = removeGarbage(input)
        var score = 0
        var currentDepth = 1
        for (i in 0..stream.lastIndex) {
            val current = stream[i]
            if (current == '{') {
                score += currentDepth
                currentDepth++
            } else if (current == '}') {
                currentDepth--
            }
        }
        return score
    }

    fun part1(): Int {
        return score(Utils.loadText("day9.txt"))
    }

    fun part2(): Int {
        return countRemoved(Utils.loadText("day9.txt"))
    }
}