package enchantment.domain

class Weapon(name: String, val damageMin: Int, val damageMax: Int, val attackSpeed: Double) {
    private val baseName = name
    var enchantment: Enchantment? = null; private set
    val attribute get() = enchantment?.enchantment

    val name get() = if (enchantment == null) baseName else "${enchantment!!.prefix} $baseName"
    fun add(enchantment: Enchantment) {
        this.enchantment = enchantment
    }

    fun hasEnchantment() = enchantment != null
    fun removeEnchantment() {
        enchantment = null
    }
}