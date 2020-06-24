package enchantment.randomness

import enchantment.domain.Enchantment
import enchantment.domain.Enchantments
import org.amshove.kluent.shouldContainAll
import org.junit.Test

class Randomness {
    @Test
    fun `get one at random should return any enchantment`() {
        val enchantments = (1..100).map { Enchantments { it }.getOneAtRandom() }
        enchantments.shouldContainAll(Enchantment.values())
    }
}