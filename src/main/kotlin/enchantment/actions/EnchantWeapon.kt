package enchantment.actions

import enchantment.domain.Enchantments
import enchantment.domain.Weapons
import enchantment.domain.errors.AlreadyEnchantedError

class EnchantWeapon(private val weapons: Weapons,
                    private val enchantments: Enchantments) {
    operator fun invoke(id: Long) {
        val weapon = weapons.findOne(id)

        if (weapon.hasEnchantment()) throw AlreadyEnchantedError()

        val enchantment = enchantments.getOneAtRandom()
        weapon.add(enchantment)

        weapons.put(id, weapon)
    }
}