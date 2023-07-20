Feature: Test Computer DB filter

 Background: Navigate to Computer DB Site
   Given I navigate to the computer db site

  @Regression
 Scenario Outline: As a final user, I want to search a computer
   When I enter <computer> computer
   And I click filter by name button
   Then I get the computer I wanted <computerwanted>
   Examples:
     | computer | computerwanted |
     | ACE | ACE |

  @Regression
  Scenario Outline: As a final user, I want to search a not listed computer
    When I enter <cname> computer
    And I click filter by name button
    Then The not listed computer should not appear
    Examples:
      | cname      |
      | juju |