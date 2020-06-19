package circular_primes

import org.junit.Test

class CircularPrimesTest {
    @Test
    fun `prime numbers`(){
        val circularPrimes = arrayOf(2, 3, 5, 7, 11)
        val notCircularPrimes = arrayOf(1, 4, 6, 8, 9, 10, 12)
        circularPrimes.forEach { assert(isCircularPrime(it)) { "$it should be a circular prime" } }
        notCircularPrimes.forEach { assert(!isCircularPrime(it)) { "$it should not be a circular prime" } }
    }

    fun isCircularPrime(value: Int): Boolean {
        if (value == 1) return false
        if (value == 2) return true
        if (value % 2 == 0) return false
        for (i in 3 until value step 2)
            if (value % i == 0) return false
        return true
    }
}