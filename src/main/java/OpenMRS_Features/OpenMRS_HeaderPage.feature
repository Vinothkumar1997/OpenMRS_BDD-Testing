Feature: OpenMRS Header Page

  Background: 
    Given User should login

  Scenario: My account Page
    Given User click on admin
    Given User click on my account
    When User can navigate into My account
    Then User can do settings

  Scenario: Change password settings
    Given User click on admin
    Given User click on my account
    Given User click on change password
    Given User Enter the oldpassword as "Admin123"
    Given User Enter the newpassword as "Admin12345"
    Given User enter the confirmpassword as "Admin12345"
    When user click the save button
    Then User can get the update

  Scenario Outline: My language settings
    Given User click on admin
    Given User click on my account
    Given User click on my languages
    Given User select primary languages "<PrimaryLang>"
    Given User select Proficient Languages "<ProficientLang>"
    When User click save
    Then User can get notification

    Examples: 
      | PrimaryLang              | ProficientLang           |
      | English (United Kingdom) | English (United Kingdom) |
      | Spanish                  | Spanish                  |
      | French                   | French                   |
      | Italian                  | Italian                  |
      | Portuguese (Brazil)      | Portuguese               |

  Scenario Outline: Location of session
    Given User click on loction dropdown
    Given User click on paticular location as "<Location>"
    When User referesh the page
    Then User can navigate to paticular location

    Examples: 
      | Location          |
      | Isolation Ward    |
      | Laboratory        |
      | Outpatient Clinic |
      | Pharmacy          |
      | Registration Desk |

  
  Scenario: User should Logut Successfull
    When User click logout button
    Then User can logout
