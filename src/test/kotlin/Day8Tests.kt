import en.veille.day1.Day8
import en.veille.day1.Utils
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day8Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should compute largest value in registers from sample`() {
            assertEquals(1, Day8.applyInstructions(Utils.loadText("day8_sample.txt")).max())
        }

        @Test
        fun `Should compute largest value in registers from file`() {
            assertEquals(6828, Day8.part1())
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should compute highest value during execution from sample`() {
            assertEquals(10, Day8.highestValue(Utils.loadText("day8_sample.txt")))
        }

        @Test
        fun `Should compute highest value during execution from file`() {
            assertEquals(7234, Day8.part2())
        }
    }
}