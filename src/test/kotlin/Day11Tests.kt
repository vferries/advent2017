import en.veille.day1.Day11
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class Day11Tests {
    @Nested
    inner class Part1 {
        @DisplayName("Should correctly calculate shortest path")
        @ParameterizedTest(name = "{index} => expected {0} for passphrase {1}")
        @CsvSource(
            "3;ne,ne,ne",
            "0;ne,ne,sw,sw",
            "2;ne,ne,s,s",
            "3;se,sw,se,sw,sw", delimiter = ';'
        )
        fun `Should correctly calculate shortest path`(expected: Int, path: String) {
            assertEquals(expected, Day11.shortestPath(path))
        }

        @Test
        fun `Should correctly calculate shortest path for file`() {
            assertEquals(685, Day11.part1())
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should correctly calculate max distance reached for file`() {
            assertEquals(1457, Day11.part2())
        }
    }
}
