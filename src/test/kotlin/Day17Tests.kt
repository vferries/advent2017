import en.veille.day1.Day17
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day17Tests {
    @Nested
    inner class Part1 {
        @Test
        fun `Should insert nodes on sample`() {
            assertEquals(638, Day17.after2017(3))
        }

        @Test
        fun `Should insert nodes on input`() {
            assertEquals(772, Day17.after2017(312))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should find correct node`() {
            assertEquals(42729050, Day17.afterZero(312))
        }
    }
}
