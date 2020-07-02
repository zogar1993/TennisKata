package enchantment.domain

enum class Enchantment(val prefix: String, val attribute: String) {
    Ice(prefix = "Icy", attribute = "+5 ice damage"),
    Fire(prefix = "Inferno", attribute = "+5 fire damage"),
    Lifesteal(prefix = "Vampire", attribute = "+5 lifesteal"),
    Agility(prefix = "Quick", attribute = "+5 agility"),
    Strength(prefix = "Angry", attribute = "+5 strength");

    companion object {
        fun from(name: String): Enchantment {
            return values().find { it.name == name } ?: throw Exception()
        }
    }
}