import en.veille.day1.Day23
import en.veille.day1.Utils
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.math.BigInteger
import kotlin.test.assertEquals

class Day23Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should count mul on input`() {
            assertEquals(0, Day23.countMul(Utils.loadText("day23.txt")))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should compute h on input`() {
            assertEquals(0, Day23.part2())
        }
    }
}
