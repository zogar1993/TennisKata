package enchantment.domain

class ShouldItDisenchant(private val getRandomNumber: () -> Int = { Math.random().toInt() }) {
    operator fun invoke() = getRandomNumber() % 10 == 0
}