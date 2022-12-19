import en.veille.day1.Day9
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day9Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should correctly remove garbage 1`() {
            assertEquals("", Day9.removeGarbage("<>"))
        }

        @Test
        fun `Should correctly remove garbage 2`() {
            assertEquals("", Day9.removeGarbage("<random characters>"))
        }

        @Test
        fun `Should correctly remove garbage 3`() {
            assertEquals("", Day9.removeGarbage("<<<<>"))
        }

        @Test
        fun `Should correctly remove garbage 4`() {
            assertEquals("", Day9.removeGarbage("<{!>}>"))
        }

        @Test
        fun `Should correctly remove garbage 5`() {
            assertEquals("", Day9.removeGarbage("<!!>"))
        }

        @Test
        fun `Should correctly remove garbage 6`() {
            assertEquals("", Day9.removeGarbage("<!!!>>"))
        }

        @Test
        fun `Should correctly remove garbage 7`() {
            assertEquals("", Day9.removeGarbage("<{o\"i!a,<{i<a>"))
        }

        @Test
        fun `Should correctly remove garbage 8`() {
            assertEquals("{}", Day9.removeGarbage("{<{},{},{{}}>}"))
        }

        @Test
        fun `Should correctly remove garbage 9`() {
            assertEquals("{{},{},{},{}}", Day9.removeGarbage("{{<a>},{<a>},{<a>},{<a>}}"))
        }

        @Test
        fun `Should correctly remove garbage 10`() {
            assertEquals("{{}}", Day9.removeGarbage("{{<!>},{<!>},{<!>},{<a>}}"))
        }

        @Test
        fun `Should correctly calculate score 1`() {
            assertEquals(1, Day9.score("{}"))
        }

        @Test
        fun `Should correctly calculate score 2`() {
            assertEquals(6, Day9.score("{{{}}}"))
        }

        @Test
        fun `Should correctly calculate score 3`() {
            assertEquals(5, Day9.score("{{},{}}"))
        }

        @Test
        fun `Should correctly calculate score 4`() {
            assertEquals(16, Day9.score("{{{},{},{{}}}}"))
        }

        @Test
        fun `Should correctly calculate score 5`() {
            assertEquals(1, Day9.score("{<a>,<a>,<a>,<a>}"))
        }

        @Test
        fun `Should correctly calculate score 6`() {
            assertEquals(9, Day9.score("{{<ab>},{<ab>},{<ab>},{<ab>}}"))
        }

        @Test
        fun `Should correctly calculate score 7`() {
            assertEquals(9, Day9.score("{{<!!>},{<!!>},{<!!>},{<!!>}}"))
        }

        @Test
        fun `Should correctly calculate score 8`() {
            assertEquals(3, Day9.score("{{<a!>},{<a!>},{<a!>},{<ab>}}"))
        }

        @Test
        fun `Should correctly calculate score from file`() {
            assertEquals(17537, Day9.part1())
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should count removed garbage 1`() {
            assertEquals(0, Day9.countRemoved("<>"))
        }

        @Test
        fun `Should count removed garbage 2`() {
            assertEquals(17, Day9.countRemoved("<random characters>"))
        }

        @Test
        fun `Should count removed garbage 3`() {
            assertEquals(3, Day9.countRemoved("<<<<>"))
        }

        @Test
        fun `Should count removed garbage 4`() {
            assertEquals(2, Day9.countRemoved("<{!>}>"))
        }

        @Test
        fun `Should count removed garbage 5`() {
            assertEquals(0, Day9.countRemoved("<!!>"))
        }

        @Test
        fun `Should count removed garbage 6`() {
            assertEquals(0, Day9.countRemoved("<!!!>>"))
        }

        @Test
        fun `Should count removed garbage 7`() {
            assertEquals(10, Day9.countRemoved("<{o\"i!a,<{i<a>"))
        }

        @Test
        fun `Should count removed garbage from file`() {
            assertEquals(7539, Day9.part2())
        }
    }
}