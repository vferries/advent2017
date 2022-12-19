import en.veille.day1.Day20
import en.veille.day1.Utils
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day20Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should follow correct path on sample`() {
            assertEquals(91, Day20.findClosestToOrigin(Utils.loadText("day20.txt")))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should resolve collisions`() {
            assertEquals(567, Day20.remainingParticlesAfter(Utils.loadText("day20.txt"), 10_000))
        }
    }
}
