Feature: Up to three enchantments

  Background:
    Given all state is cleaned

  Scenario Outline: Weapon enchantments should have all attributes
    Given a weapon enchanted with <enchantment_1>
    Given the weapon is enchanted with <enchantment_2>
    Given enchanting a weapon will use the <enchantment_3> enchantment
    When the weapon is enchanted
    Then the weapon should have the attributes <attribute_1> <attribute_2> <attribute_3>
    Examples:
      | enchantment_1 | enchantment_2 | enchantment_3 | attribute_1      | attribute_2     | attribute_3    |
      | "Fire"        | "Ice"         | "Lifesteal"   | "+5 fire damage" | "+5 ice damage" | "+5 lifesteal" |
      | "Agility"     | "Strength"    | "Lifesteal"   | "+5 agility"     | "+5 strength"   | "+5 lifesteal" |

  Scenario Outline: Weapon enchantments should have all prefixes
    Given a weapon enchanted with <enchantment_1>
    Given the weapon is enchanted with <enchantment_2>
    Given enchanting a weapon will use the <enchantment_3> enchantment
    When the weapon is enchanted
    Then the weapon should have the prefixes <prefix_1> <prefix_2> <prefix_3>
    Examples:
      | enchantment_1 | enchantment_2 | enchantment_3 | prefix_1  | prefix_2 | prefix_3  |
      | "Fire"        | "Ice"         | "Lifesteal"   | "Inferno" | "Icy"    | "Vampire" |
      | "Agility"     | "Strength"    | "Lifesteal"   | "Quick"   | "Angry"  | "Vampire" |

  Scenario: Weapons may not be enchanted more than 3 times
    Given a weapon enchanted 3 times
    When the weapon is enchanted, it should fail because it was already enchanted