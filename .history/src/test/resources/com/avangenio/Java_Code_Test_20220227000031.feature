Feature: Java Code Test


  @Public_leak_file
  Scenario Outline: This scenario will test for correct format in a text file
    Given this file with an extension ".txt"
    When found "<format>"
    Then divider is "<separator>"
    And ID format must be like "<IDF>"

    Examples:
      | format | separator | IDF |
      | f1 | "," | [0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z] |
      | f2 | " ; " | [0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]-[A-Z] |
