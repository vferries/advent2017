import en.veille.day1.Day10
import en.veille.day1.Day14
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day14Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should correctly calculate knot hash for example`() {
            assertEquals("11010100", Day10.realKnotHash("flqrgnkx-0").map { it.toString(2) }.first())
        }

        @Test
        fun `Should correctly calculate bits that are on for example`() {
            assertEquals(8108, Day14.part1("flqrgnkx"))
        }

        @Test
        fun `Should correctly calculate bits that are on for input`() {
            assertEquals(8074, Day14.part1("jzgqcdpd"))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should count regions for sample`() {
            assertEquals(1242, Day14.countGroups("flqrgnkx"))
        }

        @Test
        fun `Should count regions for input`() {
            assertEquals(1212, Day14.countGroups("jzgqcdpd"))
        }
    }
}
