package en.veille.day1

import java.io.File

object Utils {
    fun loadText(fileName: String): String {
        return File("src/main/resources/$fileName").readText()
    }
}