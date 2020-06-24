package enchantment

import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class EnchantmentTest {
    @Test
    fun cosa() {
        val weapon = a_weapon_with(
                name = WEAPON_NAME,
                damageMin = MIN_DAMAGE,
                damageMax = MAX_DAMAGE,
                attackSpeed = ATTACK_SPEED)

        weapon.name.shouldBeEqualTo(WEAPON_NAME)
        weapon.damageMin.shouldBeEqualTo(MIN_DAMAGE)
        weapon.damageMax.shouldBeEqualTo(MAX_DAMAGE)
        weapon.attackSpeed.shouldBeEqualTo(ATTACK_SPEED)
    }

    private fun a_weapon_with(name: String, damageMin: Int, damageMax: Int, attackSpeed: Double): Weapon {
        return Weapon(
                name = name,
                damageMin = damageMin,
                damageMax = damageMax,
                attackSpeed = attackSpeed)
    }

    class Weapon(val name: String, val damageMin: Int, val damageMax: Int, val attackSpeed: Double) {

    }

    companion object {
        private const val WEAPON_NAME = "Dagger of the Nooblet"
        private const val MIN_DAMAGE = 5
        private const val MAX_DAMAGE = 10
        private const val ATTACK_SPEED = 1.2
    }
}