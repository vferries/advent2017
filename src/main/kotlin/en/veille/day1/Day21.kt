package en.veille.day1

object Day21 {
    fun iterate(text: String, iterations: Int): Int {
        val rules = parseRules(text)
        var pattern = listOf(".#.", "..#", "###")
        for (i in 1..iterations) {
            val nextPattern = mutableListOf<String>()
            val tileSize = if (pattern.size % 2 == 0) { 2 } else { 3 }
            for (row in 0 until pattern.size/tileSize) {
                val rows = mutableListOf<List<String>>()
                for (col in 0 until pattern.size/tileSize) {
                    var tile = ""
                    for (r in 0 until tileSize) {
                        for (c in 0 until tileSize) {
                            tile += pattern[row * tileSize + r][col * tileSize + c]
                        }
                    }
                    rows.add(rules[tile]!!)
                }
                for (j in 0 until rows[0].size) {
                    var line = ""
                    for (block in rows) {
                        line += block[j]
                    }
                    nextPattern += line
                }
            }
            pattern = nextPattern
        }
        return pattern.joinToString("").count { it == '#' }
    }

    private fun parseRules(text: String): Map<String, List<String>> {
        val rules = mutableMapOf<String, List<String>>();
        for (line in text.lines()) {
            val (rule, output) = line.split(" => ")
            val rotations = generateRotationsAndMirrors(rule.replace("/", ""))
            val replacement = output.split("/")
            for (rotation in rotations) {
                rules[rotation] = replacement
            }
        }
        return rules
    }

    private fun generateRotationsAndMirrors(pattern: String): Set<String> {
        val set = mutableSetOf(pattern)
        var current = pattern
        for (i in 0..3) {
            current = current.rotateRight()
            set.add(current)
        }
        current = pattern.mirror()
        set.add(current)
        for (i in 0..3) {
            current = current.rotateRight()
            set.add(current)
        }
        return set
    }

}

private fun String.mirror(): String {
    return if (this.length == 4) {
        "" + this[1] + this[0] + this[3] + this[2]
    } else {
        "" + this[2] + this[1] + this[0] + this[5] + this[4] + this[3] + this[8] + this[7] + this[6]
    }
}

private fun String.rotateRight(): String {
    return if (this.length == 4) {
        "" + this[2] + this[0] + this[3] + this[1]
    } else {
        "" + this[6] + this[3] + this[0] + this[7] + this[4] + this[1] + this[8] + this[5] + this[2]
    }
}
