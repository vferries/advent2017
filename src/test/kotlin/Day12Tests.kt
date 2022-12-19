import en.veille.day1.Day12
import en.veille.day1.Utils
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day12Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should correctly count reachable programs from sample`() {
            assertEquals(6, Day12.countReachable(Utils.loadText("day12_sample.txt")))
        }

        @Test
        fun `Should correctly count reachable programs from file`() {
            assertEquals(306, Day12.countReachable(Utils.loadText("day12.txt")))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should correctly count reachable programs from sample`() {
            assertEquals(2, Day12.countGroups(Utils.loadText("day12_sample.txt")))
        }

        @Test
        fun `Should correctly count reachable programs from file`() {
            assertEquals(200, Day12.countGroups(Utils.loadText("day12.txt")))
        }
    }
}
