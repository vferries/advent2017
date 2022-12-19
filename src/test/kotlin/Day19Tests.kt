import en.veille.day1.Day19
import en.veille.day1.Utils
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day19Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should follow correct path on sample`() {
            assertEquals("ABCDEF", Day19.followPath(Utils.loadText("day19_sample.txt")))
        }

        @Test
        fun `Should follow correct path on input`() {
            assertEquals("MKXOIHZNBL", Day19.followPath(Utils.loadText("day19.txt")))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should count steps on sample`() {
            assertEquals(38, Day19.countSteps(Utils.loadText("day19_sample.txt")))
        }

        @Test
        fun `Should count steps on input`() {
            assertEquals(17872, Day19.countSteps(Utils.loadText("day19.txt")))
        }
    }
}
