import en.veille.day1.Day5
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day5Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should count steps from sample`() {
            assertEquals(5, Day5.steps(listOf(0, 3, 0, 1, -3)))
        }

        @Test
        fun `Should count steps from file`() {
            assertEquals(376976, Day5.part1())
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should count steps from sample`() {
            assertEquals(10, Day5.steps2(listOf(0, 3, 0, 1, -3)))
        }

        @Test
        fun `Should count steps from file`() {
            assertEquals(29227751, Day5.part2())
        }
    }
}