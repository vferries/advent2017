package en.veille.day1

object Day14 {
    fun part1(seed: String): Int {
        val map = generateMap(seed)
        return map.joinToString("").count { it == '1' }
    }

    private fun generateMap(seed: String): List<List<String>> {
        return (0 until 128).map { Day10.realKnotHash("$seed-$it").map { hash -> hash.toString(2).padStart(8, '0') } }
    }

    fun countGroups(seed: String): Int {
        val map = generateMap(seed).map { it.joinToString("") }
        println(map)
        val seen = mutableSetOf<Pair<Int, Int>>()
        var groups = 0
        for (row in map.indices) {
            for (col in map[0].indices) {
                if (map[row][col] == '1' && !seen.contains(row to col)) {
                    groups++
                    val toVisit = mutableListOf(row to col)
                    while (toVisit.isNotEmpty()) {
                        val pos = toVisit.removeFirst()
                        seen.add(pos)
                        toVisit.addAll(
                            pos.neighbors().filter { (row, col) -> row >= 0 && col >= 0 && col < 128 && row < 128 }
                                .filter { (row, col) -> map[row][col] == '1' }
                                .filter { !seen.contains(it) && !toVisit.contains(it) })
                    }
                }
            }
        }
        return groups
    }
}

private fun Pair<Int, Int>.neighbors(): List<Pair<Int, Int>> {
    return listOf(
        this.first - 1 to this.second,
        this.first + 1 to this.second,
        this.first to this.second - 1,
        this.first to this.second + 1
    )
}
