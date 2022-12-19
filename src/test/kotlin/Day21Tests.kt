import en.veille.day1.Day21
import en.veille.day1.Utils
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day21Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should follow correct path on sample`() {
            assertEquals(12, Day21.iterate(Utils.loadText("day21_sample.txt"), 2))
        }
        @Test
        fun `Should follow correct path on input`() {
            assertEquals(110, Day21.iterate(Utils.loadText("day21.txt"), 5))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should follow correct path on input`() {
            assertEquals(1277716, Day21.iterate(Utils.loadText("day21.txt"), 18))
        }
    }
}
