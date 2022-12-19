import en.veille.day1.Day7
import en.veille.day1.Utils
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day7Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should compute root node from sample`() {
            assertEquals("tknk", Day7.rootName(Utils.loadText("day7_sample.txt")))
        }
        @Test
        fun `Should compute root node from file`() {
            assertEquals("veboyvy", Day7.part1())
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should compute erroneous weight from sample`() {
            assertEquals(60, Day7.erroneousWeight(Utils.loadText("day7_sample.txt")))
        }
        @Test
        fun `Should compute erroneous weight from file`() {
            assertEquals(749, Day7.part2())
        }
    }
}