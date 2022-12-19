package en.veille.day1

object Day7 {
    private fun parseAllNodes(text: String): Node {
        val nodesMap = mutableMapOf<String, Node>()
        for (line in text.lines()) {
            val parts = line.replace(",", "").split(" ")
            val name = parts[0]
            val weight = parts[1].drop(1).dropLast(1).toInt()
            if (!nodesMap.containsKey(name)) {
                nodesMap[name] = Node(name)
            }
            nodesMap[name]!!.weight = weight
            for (i in 3..parts.lastIndex) {
                val childName = parts[i]
                if (!nodesMap.containsKey(childName)) {
                    nodesMap[childName] = Node(childName)
                }
                nodesMap[childName]!!.parent = nodesMap[name]
                nodesMap[name]!!.children.add(nodesMap[childName]!!)
            }
        }
        val rootNode = nodesMap.values.find { n -> n.parent == null }!!
        return rootNode
    }

    fun rootName(text: String): String {
        val rootNode = parseAllNodes(text)
        return rootNode.name
    }

    fun part1(): String {
        return rootName(Utils.loadText("day7.txt"))
    }

    fun erroneousWeight(text: String): Int {
        var node = parseAllNodes(text)
        var delta = 0
        var childWeights = node.children.map(Node::fullWeight)
        while (childWeights.distinct().size > 1) {
            println(node)
            println(childWeights)
            val counts = childWeights.groupingBy { it }.eachCount()
            val once = counts.entries.find { it.value == 1 }!!.key
            val twice = counts.entries.find { it.value != 1 }!!.key
            delta = twice - once
            node = node.children.find { it.fullWeight() == once }!!
            childWeights = node.children.map(Node::fullWeight)
        }
        return node.weight + delta
    }

    fun part2(): Int {
        return erroneousWeight(Utils.loadText("day7.txt"))
    }

    class Node(val name: String) {
        var parent: Node? = null
        var children: MutableList<Node> = mutableListOf()
        var weight: Int = 0

        fun fullWeight(): Int {
            return weight + children.sumOf(Node::fullWeight)
        }
    }
}
