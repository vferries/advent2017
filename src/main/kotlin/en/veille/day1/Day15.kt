package en.veille.day1

import java.math.BigInteger

object Day15 {
    private val modulo = 2147483647.toBigInteger()

    fun generatorA(seed: BigInteger): Iterator<BigInteger> {
        return generator(seed, 16807.toBigInteger())
    }

    fun generatorB(seed: BigInteger): Iterator<BigInteger> {
        return generator(seed, 48271.toBigInteger())
    }

    private fun generator(seed: BigInteger, factor: BigInteger): Iterator<BigInteger> {
        var current = seed
        return iterator {
            while (true) {
                current = (current * factor).mod(modulo)
                yield(current)
            }
        }
    }

    fun part1(seedA: BigInteger, seedB: BigInteger): Int {
        var count = 0
        val generatorA = generatorA(seedA)
        val generatorB = generatorB(seedB)
        for (i in 0 until 40_000_000) {
            val a = generatorA.next()
            val b = generatorB.next()
            if (a.mod(65536.toBigInteger()).equals(b.mod(65536.toBigInteger()))) {
                count++
            }
        }
        return count
    }

    fun generatorA2(seed: BigInteger): Iterator<BigInteger> {
        return generator2(seed, 16807.toBigInteger(), 4.toBigInteger())
    }

    fun generatorB2(seed: BigInteger): Iterator<BigInteger> {
        return generator2(seed, 48271.toBigInteger(), 8.toBigInteger())
    }

    private fun generator2(seed: BigInteger, factor: BigInteger, m: BigInteger): Iterator<BigInteger> {
        var current = seed
        return iterator {
            while (true) {
                do {
                    current = (current * factor).mod(modulo)
                } while (current.mod(m) != BigInteger.ZERO)
                yield(current)
            }
        }
    }

    fun part2(seedA: BigInteger, seedB: BigInteger): Int {
        var count = 0
        val generatorA = generatorA2(seedA)
        val generatorB = generatorB2(seedB)
        for (i in 0 until 5_000_000) {
            val a = generatorA.next()
            val b = generatorB.next()
            if (a.mod(65536.toBigInteger()).equals(b.mod(65536.toBigInteger()))) {
                count++
            }
        }
        return count
    }
}