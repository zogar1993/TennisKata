package enchantment.domain

interface Weapons {
    fun put(id: Long, weapon: Weapon)
    fun findOne(id: Long): Weapon
}