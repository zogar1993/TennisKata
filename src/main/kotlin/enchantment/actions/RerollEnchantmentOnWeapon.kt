package enchantment.actions

import enchantment.domain.Enchantments
import enchantment.domain.ShouldItDisenchant
import enchantment.domain.Weapons
import enchantment.domain.errors.NotEnchantedError

class RerollEnchantmentOnWeapon(private val weapons: Weapons,
                                private val enchantments: Enchantments,
                                private val shouldItDisenchant: ShouldItDisenchant) {
    operator fun invoke(id: Long) {
        val weapon = weapons.findOne(id)

        if (!weapon.isEnchanted()) throw NotEnchantedError()

        if (shouldItDisenchant()) {
            weapon.removeEnchantment()
        } else {
            val enchantment = enchantments.getOneAtRandomExceptFor(weapon.enchantments)
            weapon.removeEnchantment()
            weapon.add(enchantment)
        }

        weapons.put(id, weapon)
    }
}