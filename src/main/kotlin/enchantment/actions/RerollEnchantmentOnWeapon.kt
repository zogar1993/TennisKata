package enchantment.actions

import enchantment.domain.Enchantments
import enchantment.domain.Weapons
import enchantment.domain.errors.NotEnchantedError

class RerollEnchantmentOnWeapon(private val weapons: Weapons,
                                private val enchantments: Enchantments) {
    operator fun invoke(id: Long) {
        val weapon = weapons.findOne(id)

        if (!weapon.hasEnchantment()) throw NotEnchantedError()

        val enchantment = enchantments.getOneAtRandomExceptFor(weapon.enchantment!!)
        weapon.add(enchantment)

        weapons.put(id, weapon)
    }
}