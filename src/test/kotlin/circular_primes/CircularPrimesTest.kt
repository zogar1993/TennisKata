package circular_primes

import org.junit.Test

class CircularPrimesTest {
    @Test
    fun `prime numbers`(){
        val circularPrimes = arrayOf(2, 3, 5, 7, 11, 13, 17, 37, 79, 113, 197, 199, 337, 1193, 3779, 11939)
        val notCircularPrimes = arrayOf(1, 4, 6, 8, 9, 10, 12, 15, 21, 27, 51, 89)
        circularPrimes.forEach { assert(isCircularPrime(it)) { "$it should be a circular prime" } }
        notCircularPrimes.forEach { assert(!isCircularPrime(it)) { "$it should not be a circular prime" } }
    }

    fun isCircularPrime(value: Int): Boolean {
        if (value == 1) return false
        if (value == 2) return true
        if (value.isEven()) return false
        val values = valueMutations(value)
        for (i in 3 until value step 2)
            if (values.any { it % i == 0 })
                return false
        return true
    }

    private fun valueMutations(value: Int): List<Int> {
        val string = value.toString()
        return (0 until string.length).map {
            val firstPart = string.substring(0, it)
            val secondPart = string.substring(it, string.length)
            "$secondPart$firstPart".toInt()
        }
    }

    private fun Int.isEven() = this % 2 == 0
}