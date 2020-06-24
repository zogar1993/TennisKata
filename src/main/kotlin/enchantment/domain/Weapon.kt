package enchantment.domain

class Weapon(name: String, val damageMin: Int, val damageMax: Int, val attackSpeed: Double) {
    private val baseName = name
    private var enchantment: Enchantment? = null
    val attribute get() = enchantment?.enchantment

    val name get() = if (enchantment == null) baseName else "${enchantment!!.prefix} $baseName"
    fun add(enchantment: Enchantment) {
        this.enchantment = enchantment
    }

}