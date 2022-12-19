package en.veille.day1

object Day12 {
    fun countReachable(text: String): Int {
        val map = text.lines().mapIndexed { i, line ->
            i to line.split(" <-> ")[1].split(", ").map(String::toInt)
        }.toMap()

        val seen = mutableSetOf<Int>()
        val remaining = mutableListOf(0)
        while (remaining.isNotEmpty()) {
            val top = remaining.removeFirst()
            if (!seen.contains(top)) {
                seen.add(top)
                remaining.addAll(map[top]!!)
            }
        }
        return seen.size
    }

    fun countGroups(text: String): Int {
        val map = text.lines().mapIndexed { i, line ->
            i to line.split(" <-> ")[1].split(", ").map(String::toInt)
        }.toMap()
        val seen = mutableSetOf<Int>()
        var groups = 0

        for (i in 0 until text.lines().size) {
            if (!seen.contains(i)) {
                groups++
            }
            val remaining = mutableListOf(i)
            while (remaining.isNotEmpty()) {
                val top = remaining.removeFirst()
                if (!seen.contains(top)) {
                    seen.add(top)
                    remaining.addAll(map[top]!!)
                }
            }
        }
        return groups
    }
}