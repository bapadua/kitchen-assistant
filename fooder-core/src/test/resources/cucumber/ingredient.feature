Feature: the ingredient should be maintained
  Scenario: ingredient is valid
    Given the repository receive a valid ingredient
    When the ingredient should be persisted
    Then the ingredient should be found on database

  Scenario: look for existing ingredient by name
    When the user look up for the ingredient 'Tapioca'
    Then the ingredient is found

  Scenario: look for non existing ingredient by name
    When the user look up for the ingredient 'Pasta de dentes'
    Then the ingredient is not found