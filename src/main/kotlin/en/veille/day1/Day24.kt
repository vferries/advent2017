package en.veille.day1

object Day24 {
    fun strongestBridge(text: String): Int {
        val pairs = text.lines().map { line ->
            val (a, b) = line.split("/").map(String::toInt)
            a to b
        }
        return best(0, pairs)
    }

    private fun best(currentConnector: Int, remainingPairs: List<Pair<Int, Int>>): Int {
        val matchingConnectors = remainingPairs.filter { it.first == currentConnector || it.second == currentConnector }
        return if (matchingConnectors.isEmpty()) {
            0
        } else {
            matchingConnectors.maxOf { (a, b) ->
                val nextConnector = if (a == currentConnector) {
                    b
                } else {
                    a
                }
                a + b + best(nextConnector, remainingPairs.filter { it != a to b })
            }
        }
    }

    fun longestBridge(text: String): Int {
        val pairs = text.lines().map { line ->
            val (a, b) = line.split("/").map(String::toInt)
            a to b
        }
        return longest(0, pairs).second
    }

    private fun longest(currentConnector: Int, remainingPairs: List<Pair<Int, Int>>): Pair<Int, Int> {
        val matchingConnectors = remainingPairs.filter { it.first == currentConnector || it.second == currentConnector }
        return if (matchingConnectors.isEmpty()) {
            0 to 0
        } else {
            val results = matchingConnectors.map { (a, b) ->
                val nextConnector = if (a == currentConnector) {
                    b
                } else {
                    a
                }
                val (l, s) = longest(nextConnector, remainingPairs.filter { it != a to b })
                l + 1 to s + a + b
            }
            return results.sortedWith(compareBy({ it.first }, { it.second })).last()
        }
    }
}