@namegame
  Feature: Log on the Name Game Application

    @demo
    Scenario: Verify the "streak" counter is incrementing on correct selections
      When User is lands on the "http://www.ericrochester.com/name-game/"
      Then Verify the streak counter is incrementing on correct selections


