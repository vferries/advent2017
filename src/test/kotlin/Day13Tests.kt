import en.veille.day1.Day13
import en.veille.day1.Utils
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day13Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should correctly compute trip severity from sample`() {
            assertEquals(24, Day13.tripSeverity(Utils.loadText("day13_sample.txt")))
        }

        @Test
        fun `Should correctly compute trip severity from file`() {
            assertEquals(632, Day13.tripSeverity(Utils.loadText("day13.txt")))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should correctly compute delay from sample`() {
            assertEquals(10, Day13.tripDelay(Utils.loadText("day13_sample.txt")))
        }

        @Test
        fun `Should correctly compute delay from file`() {
            assertEquals(3849742, Day13.tripDelay(Utils.loadText("day13.txt")))
        }
    }
}
