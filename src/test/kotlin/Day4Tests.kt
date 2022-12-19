import en.veille.day1.Day4
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class Day4Tests {
    @Nested
    inner class Part1 {
        @DisplayName("Should verify valid passphrases")
        @ParameterizedTest(name = "{index} => expected {0} for passphrase {1}")
        @CsvSource(
            "true,aa bb cc dd ee is",
            "false,aa bb cc dd aa",
            "true,aa bb cc dd aaa"
        )
        fun `Should verify valid passphrases`(expected: Boolean, passphrase: String) {
            assertEquals(expected, Day4.isValid(passphrase))
        }

        @Test
        fun `Should count valid phrases from file`() {
            assertEquals(386, Day4.part1())
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should count valid phrases from file`() {
            assertEquals(208, Day4.part2())
        }
    }
}