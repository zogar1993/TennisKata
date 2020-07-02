package enchantment.randomness

import enchantment.domain.Enchantment
import enchantment.domain.Enchantments
import enchantment.domain.ShouldItDisenchant
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldContainSame
import org.junit.Test

class Randomness {
    @Test
    fun `get one at random should return any enchantment`() {
        val enchantments = (1..100).map { Enchantments { it }.getOneAtRandom() }
        enchantments.toSet().shouldContainSame(ALL_ENCHANTMENTS)
    }

    @Test
    fun `get one at random should never return excepted enchantment`() {
        val enchantments = (1..100).map { Enchantments { it }.getOneAtRandomExceptFor(listOf(AN_ENCHANTMENT)) }
        enchantments.toSet().shouldContainSame(ALL_ENCHANTMENTS - AN_ENCHANTMENT)
    }

    @Test
    fun `disenchant chance should be 10%`() {
        val results = (1..100).map { ShouldItDisenchant { it }() }.count { it }
        results.shouldBeEqualTo(10)
    }

    private companion object {
        val AN_ENCHANTMENT = Enchantment.Agility
        val ALL_ENCHANTMENTS = Enchantment.values()
        operator fun Array<Enchantment>.minus(enchantment: Enchantment): List<Enchantment> {
            return this.filter { it != enchantment }
        }
    }
}