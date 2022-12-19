import en.veille.day1.Day6
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day6Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should count steps from sample`() {
            assertEquals(5, Day6.redistributionCycles(listOf(0, 2, 7, 0)).first)
        }
        @Test
        fun `Should count steps from file`() {
            assertEquals(11137, Day6.part1())
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should count steps from sample`() {
            assertEquals(4, Day6.redistributionCycles(listOf(0, 2, 7, 0)).second)
        }
        @Test
        fun `Should count steps from file`() {
            assertEquals(1037, Day6.part2())
        }
    }
}