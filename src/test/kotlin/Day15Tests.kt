import en.veille.day1.Day15
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day15Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should generate correct numbers for generator A`() {
            val generatorA = Day15.generatorA(65.toBigInteger())
            assertEquals(1092455.toBigInteger(), generatorA.next())
            assertEquals(1181022009.toBigInteger(), generatorA.next())
            assertEquals(245556042.toBigInteger(), generatorA.next())
            assertEquals(1744312007.toBigInteger(), generatorA.next())
            assertEquals(1352636452.toBigInteger(), generatorA.next())
        }
        @Test
        fun `Should generate correct numbers for generator B`() {
            val generatorB = Day15.generatorB(8921.toBigInteger())
            assertEquals(430625591.toBigInteger(), generatorB.next())
            assertEquals(1233683848.toBigInteger(), generatorB.next())
            assertEquals(1431495498.toBigInteger(), generatorB.next())
            assertEquals(137874439.toBigInteger(), generatorB.next())
            assertEquals(285222916.toBigInteger(), generatorB.next())
        }
        @Test
        fun `Should find matching pairs in 40M sample`() {
            assertEquals(588, Day15.part1(65.toBigInteger(), 8921.toBigInteger()))
        }
        @Test
        fun `Should find matching pairs in 40M real`() {
            assertEquals(573, Day15.part1(634.toBigInteger(), 301.toBigInteger()))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should generate correct numbers for generator A`() {
            val generatorA = Day15.generatorA2(65.toBigInteger())
            assertEquals(1352636452.toBigInteger(), generatorA.next())
            assertEquals(1992081072.toBigInteger(), generatorA.next())
            assertEquals(530830436.toBigInteger(), generatorA.next())
            assertEquals(1980017072.toBigInteger(), generatorA.next())
            assertEquals(740335192.toBigInteger(), generatorA.next())
        }
        @Test
        fun `Should generate correct numbers for generator B`() {
            val generatorB = Day15.generatorB2(8921.toBigInteger())
            assertEquals(1233683848.toBigInteger(), generatorB.next())
            assertEquals(862516352.toBigInteger(), generatorB.next())
            assertEquals(1159784568.toBigInteger(), generatorB.next())
            assertEquals(1616057672.toBigInteger(), generatorB.next())
            assertEquals(412269392.toBigInteger(), generatorB.next())
        }
        @Test
        fun `Should find matching pairs in 5M sample`() {
            assertEquals(309, Day15.part2(65.toBigInteger(), 8921.toBigInteger()))
        }
        @Test
        fun `Should find matching pairs in 5M real`() {
            assertEquals(294, Day15.part2(634.toBigInteger(), 301.toBigInteger()))
        }
    }
}
