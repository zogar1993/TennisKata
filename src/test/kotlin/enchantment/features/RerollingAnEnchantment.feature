Feature: Rerolling an enchantment

  Background:
    Given all state is cleaned

  Scenario Outline: Weapon enchantments may be rerolled
    Given a weapon enchanted with <enchantment>
    Given rerolling an enchantment will use the <new_enchantment> enchantment
    When the weapons enchantment is rerolled
    Then the weapons name should be prefixed with <prefix>
    Then the weapon should have the attribute <attribute>
    Examples:
      | enchantment | new_enchantment | prefix    | attribute        |
      | "Fire"      | "Ice"           | "Icy"     | "+5 ice damage"  |
      | "Ice"       | "Fire"          | "Inferno" | "+5 fire damage" |
      | "Ice"       | "Lifesteal"     | "Vampire" | "+5 lifesteal"   |
      | "Ice"       | "Agility"       | "Quick"   | "+5 agility"     |
      | "Ice"       | "Strength"      | "Angry"   | "+5 strength"    |

  Scenario: Weapon may be disenchanted
    Given an enchanted weapon
    Given rerolling an enchantment will cause a disenchantment
    When the weapons enchantment is rerolled
    Then the weapon should be disenchanted

  Scenario: Non enchanted weapons cannot be rerolled an enchantment
    Given a weapon
    When the weapons enchantment is rerolled, it should fail because it was not enchanted