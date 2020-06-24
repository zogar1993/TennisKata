package enchantment.actions

import enchantment.domain.Enchantments
import enchantment.domain.Weapons

class EnchantWeapon(private val weapons: Weapons,
                    private val enchantments: Enchantments) {
    operator fun invoke(id: Long) {
        val weapon = weapons.findOne(id)

        val enchantment = enchantments.getOneAtRandom()
        weapon.add(enchantment)

        weapons.put(id, weapon)
    }
}