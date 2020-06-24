package circular_primes

import org.junit.Test

class CircularPrimesTest {
    @Test
    fun `circular prime numbers`(){
        val circularPrimes = arrayOf(2, 3, 5, 7, 11, 13, 17, 37, 79, 113, 197, 199, 337, 1193, 3779, 11939)

        circularPrimes.forEach { assert(isCircularPrime(it)) { "$it should be a circular prime" } }
    }

    @Test
    fun `non prime numbers`(){
        val nonPrimes = arrayOf(1, 4, 6, 8, 9, 10, 12, 15, 21, 27, 51)

        nonPrimes.forEach { assert(!isCircularPrime(it)) { "$it should not be a circular prime" } }
    }

    @Test
    fun `non circular primes`(){
        val nonCircularPrimes = arrayOf(61, 67, 83, 89)

        nonCircularPrimes.forEach { assert(!isCircularPrime(it)) { "$it should not be a circular prime" } }
    }
}