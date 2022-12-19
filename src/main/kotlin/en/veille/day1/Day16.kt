package en.veille.day1

object Day16 {
    fun dance(input: String, instructions: String): String {
        var letters = input.toMutableList()
        for (instruction in instructions.split(",")) {
            val content = instruction.drop(1)
            when {
                instruction.startsWith("s") -> {
                    val count = content.toInt()
                    letters =
                        (letters.subList(letters.size - count, letters.size) + letters.dropLast(count)).toMutableList()
                }

                instruction.startsWith("x") -> {
                    val (a, b) = content.split("/").map(String::toInt)
                    val tmp = letters[a]
                    letters[a] = letters[b]
                    letters[b] = tmp
                }

                instruction.startsWith("p") -> {
                    val (a, b) = content.split("/")
                    val ia = letters.indexOf(a.toCharArray()[0])
                    val ib = letters.indexOf(b.toCharArray()[0])
                    val tmp = letters[ia]
                    letters[ia] = letters[ib]
                    letters[ib] = tmp
                }

                else -> throw IllegalArgumentException("Unknown instruction $instruction")
            }
        }
        return letters.joinToString("")
    }

    fun danceToDeath(alphabet: String, text: String): String {
        var loop = 1
        val seen = mutableSetOf(alphabet)
        var next = dance(alphabet, text)
        while (!seen.contains(next)) {
            seen.add(next)
            next = dance(next, text)
            loop++
        }
        println("Loop $loop on word $next")
        next = alphabet
        for (i in 0 until (1_000_000_000 % loop)) {
            next = dance(next, text)
        }
        return next
    }
}