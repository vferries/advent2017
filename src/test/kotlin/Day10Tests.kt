import en.veille.day1.Day10
import en.veille.day1.Day10.displayDenseHash
import en.veille.day1.Day10.toAscii
import en.veille.day1.Utils
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day10Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should correctly calculate knot hash for example`() {
            assertEquals(listOf(3, 4, 2, 1, 0), Day10.knotHash(5, listOf(3, 4, 1, 5)))
        }

        @Test
        fun `Should correctly calculate knot hash for input`() {
            assertEquals(19591, Day10.part1())
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should convert to ascii`() {
            assertEquals(listOf(49, 44, 50, 44, 51), "1,2,3".toAscii())
        }

        @Test
        fun `Should convert to ascii from input`() {
            assertEquals(listOf(49, 50, 57, 44, 49, 53, 52, 44, 52, 57, 44, 49, 57, 56, 44, 50, 48, 48, 44, 49, 51, 51, 44, 57, 55, 44, 50, 53, 52, 44, 52, 49, 44, 54, 44, 50, 44, 49, 44, 50, 53, 53, 44, 48, 44, 49, 57, 49, 44, 49, 48, 56, 17, 31, 73, 47, 23), Day10.parseLengths(
                Utils.loadText("day10.txt")
            )
            )
        }

        @Test
        fun `Should correctly xor`() {
            assertEquals(64, listOf(65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22).reduce(Int::xor))
        }

        @Test
        fun `Should correctly display dense hash`() {
            assertEquals("4007ff", listOf(64, 7, 255).displayDenseHash())
        }

        @Test
        fun `Should correctly compute part 2`() {
            assertEquals("62e2204d2ca4f4924f6e7a80f1288786", Day10.part2())
        }
    }
}
