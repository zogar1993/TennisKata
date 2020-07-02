package enchantment.domain

import java.lang.Math.random

open class Enchantments(private val getRandomNumber: () -> Int = { random().toInt() }) {
    private val enchantments = Enchantment.values()

    open fun getOneAtRandom() = getOneAtRandomExceptFor(listOf())

    open fun getOneAtRandomExceptFor(exceptions: List<Enchantment>): Enchantment {
        val enchantments = enchantments.filter { it !in exceptions }
        val index = getRandomNumber() % enchantments.size
        return enchantments[index]
    }
}