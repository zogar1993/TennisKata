package enchantment.steps

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import enchantment.*
import enchantment.actions.EnchantWeapon
import enchantment.actions.RerollEnchantmentOnWeapon
import enchantment.domain.Enchantment
import enchantment.domain.Enchantments
import enchantment.domain.ShouldItDisenchant
import enchantment.domain.Weapon
import enchantment.domain.errors.AlreadyEnchantedError
import enchantment.domain.errors.NotEnchantedError
import enchantment.infrastructure.WeaponsInMemory
import io.mockk.every
import io.mockk.spyk
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeFalse
import org.amshove.kluent.shouldBeInstanceOf
import kotlin.test.fail

class EnchantingSteps {
    @Given("all state is cleaned")
    fun `all state is cleaned`() {
        weapons = WeaponsInMemory()
        enchantments = spyk(Enchantments())
        enchantWeapon = EnchantWeapon(weapons, enchantments)
        shouldItDisenchant = spyk(ShouldItDisenchant())
        every { shouldItDisenchant() } returns false
        rerollEnchantmentOnWeapon = RerollEnchantmentOnWeapon(weapons, enchantments, shouldItDisenchant)
    }

    @Given("a weapon")
    fun `a weapon`() {
        val weapon = Weapon(WEAPON_NAME, MIN_DAMAGE, MAX_DAMAGE, ATTACK_SPEED)
        weapons.put(ID, weapon)
    }

    @Given("enchanting a weapon will use the {string} enchantment")
    fun `enchanting a weapon will use the {enchantment} enchantment`(enchantment: String) {
        every { enchantments.getOneAtRandom() } returns Enchantment.from(enchantment)
    }

    @Given("an enchanted weapon")
    fun `an enchanted weapon`() {
        val weapon = Weapon(WEAPON_NAME, MIN_DAMAGE, MAX_DAMAGE, ATTACK_SPEED)
        weapon.add(Enchantment.Agility)
        weapons.put(ID, weapon)
    }

    @Given("a weapon enchanted with {string}")
    fun `a weapon enchanted with {enchantment}`(enchantment: String) {
        val weapon = Weapon(WEAPON_NAME, MIN_DAMAGE, MAX_DAMAGE, ATTACK_SPEED)
        weapon.add(Enchantment.from(enchantment))
        weapons.put(ID, weapon)
    }

    @Given("rerolling an enchantment will use the {string} enchantment")
    fun `rerolling an enchantment will use the {enchantment} enchantment`(enchantment: String) {
        every { enchantments.getOneAtRandomExceptFor(any()) } returns Enchantment.from(enchantment)
    }

    @Given("rerolling an enchantment will cause a disenchantment")
    fun `rerolling an enchantment will cause a disenchantment`() {
        every { shouldItDisenchant() } returns true
    }

    @When("the weapon is enchanted")
    fun `the weapon is enchanted`() {
        enchantWeapon(ID)
    }

    @When("the weapons enchantment is rerolled")
    fun `he weapons enchantment is rerolled`() {
        rerollEnchantmentOnWeapon(ID)
    }

    @When("the weapon is enchanted, it should fail because it was already enchanted")
    fun `the weapon is enchanted, it should fail because it was already enchanted`() {
        runCatching { enchantWeapon(ID) }.onSuccess { fail("Expected an exception") }.onFailure { it.shouldBeInstanceOf<AlreadyEnchantedError>() }
    }


    @When("the weapons enchantment is rerolled, it should fail because it was not enchanted")
    fun `the weapons enchantment is rerolled, it should fail because it was not enchanted`() {
        runCatching { rerollEnchantmentOnWeapon(ID) }.onSuccess { fail("Expected an exception") }.onFailure { it.shouldBeInstanceOf<NotEnchantedError>() }
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

    @Then("the weapon should be disenchanted")
    fun `the weapon should be disenchanted`() {
        val weapon = weapons.findOne(ID)

        weapon.hasEnchantment().shouldBeFalse()
    }

    companion object {
        private const val ID: Long = 1
        private const val WEAPON_NAME = "Dagger of the Nooblet"
        private const val MIN_DAMAGE = 5
        private const val MAX_DAMAGE = 10
        private const val ATTACK_SPEED = 1.2
    }
}