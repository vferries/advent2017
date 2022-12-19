package en.veille.day1

object Day13 {
    fun tripSeverity(text: String): Int {
        val depthMap = parse(text)
        return tripSeverity(depthMap)
    }

    private fun tripSeverity(depthMap: Map<Int, Int>, delay: Int = 0): Int {
        var severity = 0
        for (pos in 0..depthMap.keys.max()) {
            if (depthMap.containsKey(pos) && (pos + delay) % (2 * depthMap.getValue(pos) - 2) == 0) {
//                println("Collision at pos $pos with depth ${depthMap.getValue(pos)}")
                severity += pos * depthMap.getValue(pos)
            }
        }
        return severity
    }

    private fun caught(depthMap: Map<Int, Int>, delay: Int = 0): Boolean {
        for (pos in 0..depthMap.keys.max()) {
            if (depthMap.containsKey(pos) && (pos + delay) % (2 * depthMap.getValue(pos) - 2) == 0) {
                return true
            }
        }
        return false
    }

    fun tripDelay(text: String): Int {
        val depthMap = parse(text)
        var delay = 0
        while (caught(depthMap, delay)) {
            delay++
        }
        return delay
    }

    private fun parse(text: String): Map<Int, Int> {
        val depthMap = text.lines().associate {
            val (depth, range) = it.split(": ").map(String::toInt)
            depth to range
        }
        return depthMap
    }
}

