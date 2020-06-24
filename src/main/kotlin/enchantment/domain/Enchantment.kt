package enchantment.domain

enum class Enchantment(val prefix: String, val enchantment: String) {
    Ice(prefix = "Icy", enchantment = "+5 ice damage"),
    Fire(prefix = "Inferno", enchantment = "+5 fire damage"),
    Lifesteal(prefix = "Vampire", enchantment = "+5 lifesteal"),
    Agility(prefix = "Quick", enchantment = "+5 agility"),
    Strength(prefix = "Angry", enchantment = "+5 strength");

    companion object {
        fun from(name: String): Enchantment {
            return values().find { it.name == name } ?: throw Exception()
        }
    }
}