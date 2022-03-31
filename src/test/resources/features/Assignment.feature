Feature: User

  Background:
    Given I have opened the "chrome" browser

  Scenario: Create a user and everything goes as expected
    Given I write an Email "DarkWitch@gmail.com"
    Given I write a username "Darkinthewood3786"
    Given I write a password "Häxan123?!"
    When I click the sign up button
    Then I get the result "Check your email" when I sign up

  Scenario: Create a user with a username longer then 100 characters
    Given I write an Email "lillaloppan@hotmail.com"
    Given I write a username "lillaloppaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaannnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
    Given I write a password "HejSvej123?"
    When I click the sign up button
    Then I get the result "Enter a value less than 100 characters long"

  Scenario: Create a user that already exist
    Given I write an Email "pa@hotmail.com"
    Given I write a username "Darkinthewood"
    Given I write a password "Hej123?!"
    When I click the sign up button
    Then I get the result "Another user with this username already exists. Maybe it's your evil twin. Spooky."

  Scenario: Create a user where the email is missing
    Given I write a username "SolenSkiner"
    Given I write a password "Hallå12!"
    When I click the sign up button
    Then I get the result "Please enter a value"

