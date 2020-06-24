package enchantment.domain

import java.lang.Math.random

open class Enchantments(private val getRandomNumber: () -> Int = { random().toInt() }) {
    private val enchantments = Enchantment.values()

    open fun getOneAtRandom(): Enchantment {
        val index = getRandomNumber() % enchantments.size
        return enchantments[index]
    }
}