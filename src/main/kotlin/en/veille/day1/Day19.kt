package en.veille.day1

object Day19 {
    fun followPath(text: String): String {
        var result = ""
        val map = text.lines()
        val height = map.size
        val width = map.maxOf(String::length)
        val initCol = map[0].indexOf('|')
        var (row, col) = 0 to initCol
        var (dr, dc) = 1 to 0
        while ((row + dr) in 0 until height && (col + dc) in 0 until width && map[row + dr][col + dc] != ' ') {
            row += dr
            col += dc
            val current = map[row][col]
            if (current in 'A'..'Z') {
                result += current
            } else if (current == '+') {
                val newDir = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
                    .filter { (r, c) -> (row + r) in 0 until height && (col + c) in 0 until map[row + r].length }
                    .filter { (r, c) -> r != dr && c != dc }
                    .filter { (r, c) -> map[row + r][col + c] != ' ' }
                    .first()
                dr = newDir.first
                dc = newDir.second
            }
        }
        return result
    }

    fun countSteps(text: String): Int {
        var steps = 1
        val map = text.lines()
        val height = map.size
        val width = map.maxOf(kotlin.String::length)
        val initCol = map[0].indexOf('|')
        var (row, col) = 0 to initCol
        var (dr, dc) = 1 to 0
        while ((row + dr) in 0 until height && (col + dc) in 0 until width && map[row + dr][col + dc] != ' ') {
            steps++
            row += dr
            col += dc
            val current = map[row][col]
            if (current == '+') {
                val newDir = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
                    .filter { (r, c) -> (row + r) in 0 until height && (col + c) in 0 until map[row + r].length }
                    .filter { (r, c) -> r != dr && c != dc }
                    .filter { (r, c) -> map[row + r][col + c] != ' ' }
                    .first()
                dr = newDir.first
                dc = newDir.second
            }
        }
        return steps
    }
}