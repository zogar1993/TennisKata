package enchantment.domain

class Weapon(name: String, val damageMin: Int, val damageMax: Int, val attackSpeed: Double) {
    private val baseName = name
    private val _enchantments: MutableList<Enchantment> = mutableListOf()
    val enchantments: List<Enchantment> = _enchantments
    val attributes get() = enchantments.map { it.attribute }

    val name get() = if (enchantments.isEmpty()) baseName else "${enchantments[0].prefix} $baseName"
    fun add(enchantment: Enchantment) {
        _enchantments.add(enchantment)
    }

    fun removeEnchantment() {
        _enchantments.removeAt(0)
    }

    fun mayBeEnchanted() = _enchantments.size < MAX_ENCHANTMENTS
    fun isEnchanted() = enchantments.isNotEmpty()
}

private const val MAX_ENCHANTMENTS = 3