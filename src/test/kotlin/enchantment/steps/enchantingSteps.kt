package enchantment.steps

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import enchantment.domain.Enchantment
import enchantment.domain.Weapon
import enchantment.enchantWeapon
import enchantment.enchantments
import enchantment.weapons
import io.mockk.every
import org.amshove.kluent.shouldBeEqualTo

class EnchantingSteps {

    @Given("a weapon")
    fun `a weapon`() {
        weapons.put(
                ID,
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
    }
}