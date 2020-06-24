package enchantment.features

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import io.mockk.every
import org.amshove.kluent.shouldBeEqualTo

class AncestrySteps {
    val weapons = WeaponsInMemory()

    interface Weapons {
        fun put(weapon: Weapon)
        fun findOne(id: Long): Weapon
    }

    class WeaponsInMemory : Weapons {
        override fun put(weapon: Weapon) {
            TODO("Not yet implemented")
        }

        override fun findOne(id: Long): Weapon {
            TODO("Not yet implemented")
        }
    }

    class Weapon(val name: String, val damageMin: Int, val damageMax: Int, val attackSpeed: Double) {
        val attribute = null
    }

    val enchantments = EnchantmentsInMemory()

    interface Enchantments {
        fun getOneAtRandom(): Any
    }

    enum class Enchantment {
        Ice,
        Fire,
        Lifesteal,
        Agility,
        Strength;

        companion object {
            fun from(name: String): Enchantment {
                return values().find { it.name == name } ?: throw Exception()
            }
        }
    }

    class EnchantmentsInMemory : Enchantments {
        override fun getOneAtRandom(): Any {
            TODO("Not yet implemented")
        }
    }

    val enchantWeapon = EnchantWeapon()

    class EnchantWeapon() {
        operator fun invoke(id: Long) {

        }
    }

    @Given("a weapon")
    fun `a weapon`(character: String, ancestry: String) {
        weapons.put(
            Weapon(
                name = WEAPON_NAME,
                damageMin = MIN_DAMAGE,
                damageMax = MAX_DAMAGE,
                attackSpeed = ATTACK_SPEED
            )
        )
    }

    @Given("enchanting a weapon will use the {string} enchantment")
    fun `enchanting a weapon will use the {enchantment} enchantment`(enchantment: String) {
        every { enchantments.getOneAtRandom() } returns Enchantment.from(enchantment)
    }

    @When("the weapon is enchanted")
    fun `the weapon is enchanted`() {
        enchantWeapon(ID)
    }

    @Then("the weapons name should be prefixed with {string}")
    fun `the weapons name should be prefixed with {prefix}`(prefix: String) {
        val weapon = weapons.findOne(ID)

        weapon.name.shouldBeEqualTo("$prefix $WEAPON_NAME")
    }

    @Then("the weapon should have the attribute {string}")
    fun `the weapon should have the attribute {attribute}`(attribute: String) {
        val weapon = weapons.findOne(ID)

        weapon.attribute.shouldBeEqualTo(attribute)
    }

    companion object {
        private const val ID: Long = 1
        private const val WEAPON_NAME = "Dagger of the Nooblet"
        private const val MIN_DAMAGE = 5
        private const val MAX_DAMAGE = 10
        private const val ATTACK_SPEED = 1.2
        private const val FIRE = "Fire"
        private const val INFERNO = "Inferno"
    }
}