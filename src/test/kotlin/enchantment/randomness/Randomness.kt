package enchantment.randomness

import enchantment.domain.Enchantment
import enchantment.domain.Enchantments
import enchantment.domain.ShouldItDisenchant
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldContainAll
import org.junit.Test

class Randomness {
    @Test
    fun `get one at random should return any enchantment`() {
        val enchantments = (1..100).map { Enchantments { it }.getOneAtRandom() }
        enchantments.shouldContainAll(Enchantment.values())
    }

    @Test
    fun `disenchant chance should be 10%`() {
        val results = (1..100).map { ShouldItDisenchant { it }() }.count { it }
        results.shouldBeEqualTo(10)
    }
}