import en.veille.day1.Day22
import en.veille.day1.Utils
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day22Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should count infections on sample`() {
            assertEquals(5587, Day22.bursts(Utils.loadText("day22_sample.txt"), 10_000))
        }

        @Test
        fun `Should count infections on input`() {
            assertEquals(5196, Day22.bursts(Utils.loadText("day22.txt"), 10_000))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should count infections on sample 1`() {
            assertEquals(26, Day22.bursts2(Utils.loadText("day22_sample.txt"), 100))
        }
        @Test
        fun `Should count infections on sample 2`() {
            assertEquals(2511944, Day22.bursts2(Utils.loadText("day22_sample.txt"), 10_000_000))
        }
        @Test
        fun `Should count infections on input`() {
            assertEquals(2511633, Day22.bursts2(Utils.loadText("day22.txt"), 10_000_000))
        }
    }
}
