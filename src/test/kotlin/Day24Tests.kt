import en.veille.day1.Day24
import en.veille.day1.Utils
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day24Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should find strongest bridge on sample`() {
            assertEquals(31, Day24.strongestBridge(Utils.loadText("day24_sample.txt")))
        }
        @Test
        fun `Should find strongest bridge on input`() {
            assertEquals(1859, Day24.strongestBridge(Utils.loadText("day24.txt")))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should find longest bridge on sample`() {
            assertEquals(19, Day24.longestBridge(Utils.loadText("day24_sample.txt")))
        }
        @Test
        fun `Should find longest bridge on input`() {
            assertEquals(1799, Day24.longestBridge(Utils.loadText("day24.txt")))
        }
    }
}
