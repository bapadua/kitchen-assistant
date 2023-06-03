Feature: the ingredient should be maintained

  Scenario: ingredient is created
    Given the user tries to save the following ingredient
      | id   | name    | description      |
      | null | Tapioca | Tapioca da terra |
    When the user calls /ingredient post
    Then the ingredient is returned
      | id   | name    | description      |
      | null | Tapioca | Tapioca da terra |


  Scenario: the user search by name
    Given the user look up for the ingredient
    When the user calls /ingredient get with path 'Tapioca'
    Then the ingredient is returned
      | id   | name    | description      |
      | null | Tapioca | Tapioca da terra |