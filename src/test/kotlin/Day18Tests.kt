import en.veille.day1.Day18
import en.veille.day1.Utils
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day18Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should play program on sample`() {
            assertEquals(4.toBigInteger(), Day18.playProgram(Utils.loadText("day18_sample.txt")))
        }

        @Test
        fun `Should play program on input`() {
            assertEquals(1187.toBigInteger(), Day18.playProgram(Utils.loadText("day18.txt")))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should play program with two players on input`() {
            assertEquals(5969, Day18.playProgramV2(Utils.loadText("day18.txt")))
        }
    }
}
