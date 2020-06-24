package circular_primes

fun isCircularPrime(value: Int): Boolean {
    if (value == 1) return false
    if (value == 2) return true
    if (value.isEven()) return false
    val values = valueMutations(value)
    for (i in 3 until value step 2)
        if (values.any { it.isDivisibleBy(i) })
            return false
    return true
}

private fun Int.isDivisibleBy(i: Int) = this % i == 0

private fun valueMutations(value: Int): List<Int> {
    val string = value.toString()
    return (0 until string.length).map {
        val firstPart = string.substring(0, it)
        val secondPart = string.substring(it, string.length)
        "$secondPart$firstPart".toInt()
    }
}

private fun Int.isEven() = this % 2 == 0