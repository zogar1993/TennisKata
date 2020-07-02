package enchantment.actions

import enchantment.domain.Enchantments
import enchantment.domain.Weapons
import enchantment.domain.errors.AlreadyAtMaximumEnchantments

class EnchantWeapon(private val weapons: Weapons,
                    private val enchantments: Enchantments) {
    operator fun invoke(id: Long) {
        val weapon = weapons.findOne(id)

        if (!weapon.mayBeEnchanted()) throw AlreadyAtMaximumEnchantments()

        val enchantment = enchantments.getOneAtRandom()
        weapon.add(enchantment)

        weapons.put(id, weapon)
    }
}