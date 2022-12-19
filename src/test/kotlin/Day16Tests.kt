import en.veille.day1.Day16
import en.veille.day1.Utils
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class Day16Tests {
    private val AP = ('a'..'p').joinToString("")
    @Nested
    inner class Part1 {
        @Test
        fun `Should dance on sample`() {
            assertEquals("baedc", Day16.dance(('a'..'e').joinToString(""), "s1,x3/4,pe/b"))
        }
        @Test
        fun `Should dance on input`() {
            assertEquals("lgpkniodmjacfbeh", Day16.dance(AP, Utils.loadText("day16.txt")))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `Should dance bazillion times`() {
            assertEquals("hklecbpnjigoafmd", Day16.danceToDeath(AP, Utils.loadText("day16.txt")))
        }
    }
}
