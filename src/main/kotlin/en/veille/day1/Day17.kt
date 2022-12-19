package en.veille.day1

object Day17 {
    fun after2017(steps: Int): Int {
        return after(steps, 2017).next.n
    }

    fun afterZero(steps: Int): Int {
        var node = after(steps, 50_000_000)
        while (node.n != 0) {
            node = node.next
        }
        return node.next.n
    }

    private fun after(steps: Int, nbNodes: Int): Node {
        var current = Node(0)
        for (i in 1 .. nbNodes) {
            if (i % 1000000 == 0) {
                println(i)
            }
            for (j in 0 until steps) {
                current = current.next
            }
            val next = current.next
            val insertedNode = Node(i)
            current.next = insertedNode
            insertedNode.next = next
            current = insertedNode
        }
        return current
    }

    class Node(val n: Int) {
        var next: Node = this
    }
}