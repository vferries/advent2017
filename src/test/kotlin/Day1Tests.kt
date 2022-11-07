import en.veille.day1.Day1
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should correctly sum the consecutive numbers`() {
            assertEquals(3, Day1.sumConsecutive("1122"))
        }

        @Test
        fun `Should correctly rotate at the end of input`() {
            assertEquals(4, Day1.sumConsecutive("1111"))
        }

        @Test
        fun `Should correctly compute empty result`() {
            assertEquals(0, Day1.sumConsecutive("1234"))
        }

        @Test
        fun `Should correctly compute the most complex example`() {
            assertEquals(9, Day1.sumConsecutive("91212129"))
        }

        @Test
        fun `Part 1 with my sample input`() {
            assertEquals(1069, Day1.part1())
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should correctly sum first example`() {
            assertEquals(6, Day1.sumHalfway("1212"))
        }

        @Test
        fun `Should correctly sum second example`() {
            assertEquals(0, Day1.sumHalfway("1221"))
        }

        @Test
        fun `Should correctly sum third example`() {
            assertEquals(4, Day1.sumHalfway("123425"))
        }

        @Test
        fun `Should correctly sum forth example`() {
            assertEquals(12, Day1.sumHalfway("123123"))
        }

        @Test
        fun `Should correctly sum fifth example`() {
            assertEquals(4, Day1.sumHalfway("12131415"))
        }

        @Test
        fun `Part 2 with my sample input`() {
            assertEquals(1268, Day1.part2())
        }
    }
}