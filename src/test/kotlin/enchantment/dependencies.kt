package enchantment

import enchantment.actions.EnchantWeapon
import enchantment.domain.Enchantments
import enchantment.infrastructure.WeaponsInMemory
import io.mockk.spyk

val weapons = WeaponsInMemory()
val enchantments = spyk(Enchantments())
val enchantWeapon = EnchantWeapon(weapons, enchantments)