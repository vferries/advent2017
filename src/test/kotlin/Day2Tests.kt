import en.veille.day1.Day2
import en.veille.day1.Utils
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day2Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should correctly compute first row checksum`() {
            assertEquals(8, Day2.rowChecksum("5 1 9 5"))
        }

        @Test
        fun `Should correctly compute second row checksum`() {
            assertEquals(4, Day2.rowChecksum("7 5 3"))
        }

        @Test
        fun `Should correctly compute third row checksum`() {
            assertEquals(6, Day2.rowChecksum("2 4 6 8"))
        }

        @Test
        fun `Should correctly compute sample spreadsheet checksum`() {
            val sample = """5 1 9 5
7 5 3
2 4 6 8"""
            assertEquals(18, Day2.part1(sample))
        }

        @Test
        fun `Should correctly compute full spreadsheet checksum`() {
            assertEquals(21845, Day2.part1(Utils.loadText("day2.txt")))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should correctly compute first row evenly division`() {
            assertEquals(4, Day2.evenlyDivide("5 9 2 8"))
        }

        @Test
        fun `Should correctly compute second row evenly division`() {
            assertEquals(3, Day2.evenlyDivide("9 4 7 3"))
        }

        @Test
        fun `Should correctly compute third row evenly division`() {
            assertEquals(2, Day2.evenlyDivide("3 8 6 5"))
        }

        @Test
        fun `Should correctly compute sample spreadsheet checksum`() {
            val sample = """5 9 2 8
9 4 7 3
3 8 6 5"""
            assertEquals(9, Day2.part2(sample))
        }

        @Test
        fun `Should correctly compute full spreadsheet checksum`() {
            assertEquals(191, Day2.part2(Utils.loadText("day2.txt")))
        }
    }
}