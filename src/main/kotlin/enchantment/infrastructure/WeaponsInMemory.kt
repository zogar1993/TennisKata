package enchantment.infrastructure

import enchantment.domain.Weapon
import enchantment.domain.Weapons

class WeaponsInMemory : Weapons {
    val weapons = mutableMapOf<Long, Weapon>()
    override fun put(id: Long, weapon: Weapon) {
        weapons[id] = weapon
    }

    override fun findOne(id: Long): Weapon {
        return weapons.getValue(id)
    }
}