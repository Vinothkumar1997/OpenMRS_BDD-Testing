Feature: OpenMRS Login Page
	
  Scenario: Login should be successfull
    Given User enter the username as "admin"
    Given User enter the password as "Admin123"
    Given User should select Location for this session
    When User click on login button
    Then user can login successfull

  Scenario Outline: Login should be fail(Invalid Credentials)
    Given User enter the username as "<Username>"
    Given User enter the password as "<Password>"
    Given User should select Location for this session
    When User click on login button
    Then user cannot login

    Examples: 
      | Username  | Password  |
      | admin123  | Admin123  |
      | admin     | Admin     |
      | admin1234 | Admin1234 |

  
  Scenario Outline: validation of Location for this session
    Given User enter the login credentials as "admin" and "Admin123"
    Given Verify The session count
    Given User should select any one "<session>"
    When User click on login button
    Then User can navigate to paticular session

    Examples: 
      | session           |
      | Inpatient Ward    |
      | Isolation Ward    |
      | Laboratory        |
      | Outpatient Clinic |
      | Pharmacy          |
      | Registration Desk |
	
  Scenario: Login should be fail(Invalid Location for this session)
    Given User enter the username as "admin"
    Given User enter the password as "Admin123"
    When User click on login button without select Location for this session
    Then user cannot login without paticular location

  Scenario: User not possible to Login
    Given User enter the username as "admin"
    Given User enter the password as "Admin123"
    Given User should select Location for this session
    When User clicks on cannot login?
    Then User can find the solution
