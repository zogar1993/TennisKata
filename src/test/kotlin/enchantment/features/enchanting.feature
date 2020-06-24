Feature: Enchanting a weapon

  Background:

  Scenario Outline: Enchanted weapons display their name correctly
    Given a weapon
    Given enchanting a weapon will use the <enchantment> enchantment
    When the weapon is enchanted
    Then the weapons name should be prefixed with <prefix>
    Examples:
      | enchantment | prefix    |
      | "Ice"       | "Icy"     |
      | "Fire"      | "Inferno" |
      | "Lifesteal" | "Vampire" |
      | "Agility"   | "Quick"   |
      | "Strength"  | "Angry"   |


  Scenario Outline: Enchanted weapons display their attributes correctly
    Given a weapon
    Given enchanting a weapon will use the <enchantment> enchantment
    When the weapon is enchanted
    Then the weapon should have the attribute <attribute>
    Examples:
      | enchantment | attribute        |
      | "Ice"       | "+5 ice damage"  |
      | "Fire"      | "+5 fire damage" |
      | "Lifesteal" | "+5 lifesteal"   |
      | "Agility"   | "+5 agility"     |
      | "Strength"  | "+5 strength"    |