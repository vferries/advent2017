import en.veille.day1.Day25
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day25Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should find sample diagnostic checksum`() {
            assertEquals(3, Day25.sample())
        }
        @Test
        fun `Should find diagnostic checksum`() {
            assertEquals(2794, Day25.part1())
        }
    }
}
