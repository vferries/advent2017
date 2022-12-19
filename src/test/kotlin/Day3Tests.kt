import en.veille.day1.Day3
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class Day3Tests {
    @Nested
    inner class Part1 {
        @DisplayName("Should compute steps to tile")
        @ParameterizedTest(name = "{index} => expected {0} for tile {1}")
        @CsvSource(
            "0, 1",
            "3, 12",
            "2, 23",
            "31, 1024",
            "552, 325489"
        )
        fun `Should correctly compute steps to initial state`(expected: Int, tile: Int) {
            assertEquals(expected, Day3.stepsTo(tile))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should return the first larger than`() {
            assertEquals(330785, Day3.firstLargerThan(325489))
        }
    }
}