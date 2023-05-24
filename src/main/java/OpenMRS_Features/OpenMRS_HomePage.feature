Feature: OpenMRS Home Page

  Background: 
    Given User should login

  @ActiveLink
  Scenario: User navigate to Active Visit page
    When User click on Active Visit Link
    Then User navigate to Active Visit page

  @ActiveLink
  Scenario: Active Visit Table coloumn count
    When User click on Active Visit Link
    Then User can see patient Visit details(ByTableHeader)

  @ActiveLink
  Scenario: Verify that patient Ids and names available on table header
    Given User click on Active Visit Link
    When User can see patient Ids list
    Then User can see name list

  @ActiveLink
  Scenario Outline: Verify the Active Visis search box (Using Ids)
    Given User click on Active Visit Link
    When User enter any one patient ID "<ID>" into search box
    Then User can get the paticular Name "<Name>"

    Examples: 
      | ID     | Name                    |
      | 100HRU | Chris Soo-Jin Demetriou |

  @ActiveLink
  Scenario Outline: Verify the Active Visis search box (Using Name)
    Given User click on Active Visit Link
    When User enter any one patient Name "<Name>" into search box
    Then User can get the paticular ID "<ID>"

    Examples: 
      | ID     | Name                    |
      | 100HRU | Chris Soo-Jin Demetriou |

  @ActiveLink
  Scenario: verify with wrong credential in search box
    Given User click on Active Visit Link
    When User enter the wrong data on search box
    Then User get no entries text

  @Appointmentscheduling
  Scenario: User navigate to Appointment scheduling page
    When User click on Appointment scheduling Link
    Then User navigate to Appointment scheduling page

  @Appointmentscheduling
  Scenario Outline: verify the links presented in Appointment scheduling page
    When User click on Appointment scheduling Link
    Then User can use following links "<Links>"

    Examples: 
      | Links                     |
      | Manage Service Types      |
      | Manage Provider Schedules |
      | Manage Appointments       |
      | Daily Appointments        |
      | Appointment Requests      |

  @Appointmentscheduling
  Scenario Outline: Verify the Manage Service Types
    Given User click on Appointment scheduling Link
    When User click on Manage Service Types link
    Then User can check the available services "<Service>"

    Examples: 
      | Service          |
      | General Medicine |
      | Dermatology      |
      | Gynecology       |
      | Dental           |

  @Appointmentscheduling
  Scenario: Verify the Manage Provider Schedules
    Given User click on Appointment scheduling Link
    When User click on Manage Provider Schedules link
    Then User can check the available services

  @Appointmentscheduling
  Scenario: Verify the Manage Appointments
    Given User click on Appointment scheduling Link
    When User click on Manage Appointments link
    Then User can manage the Appointments services

  @Appointmentscheduling
  Scenario: Verify the Daily Appointments
    Given User click on Appointment scheduling Link
    When User click on Daily Appointments link
    Then User can check the Daily Appointments services

  @Appointmentscheduling
  Scenario: Verify the Appointment Requests
    Given User click on Appointment scheduling Link
    When User click on Appointment Requests link
    Then User can check the Appointment Requests services

  @CaptureVitals
  Scenario: User navigate to Capture vitals page
    Given User should click on Capture vitals link
    Then User can navigate to Capture vitals page

  @CaptureVitals
  Scenario: Capture vitals Table coloumn count
    Given User should click on Capture vitals link
    Then User can see patient details(ByTableHeader)

  @CaptureVitals
  Scenario Outline: Verify the FP search box
    Given User should click on Capture vitals link
    When User enter patient "<ID>" into search box
    Then User can find the paticular patient details

    Examples: 
      | ID     |
      | 100HRU |
      | 100H0D |

  @CaptureVitals
  Scenario: Verify the patient full details
    Given User should click on Capture vitals link
    Given User enter patient ID "100HRU" on serachbox
    When User click on paticular patient ID
    Then User can Know the full details of paticular patient

  @CaptureVitals
  Scenario: verify with wrong credential in search box
    Given User should click on Capture vitals link
    When User enter the wrong ID on search box
    Then User get No matching found text

  @MetaData
  Scenario: User navigate to Configure MetaData
    When User should click on Configure MetaData link
    Then User can navigate to Configure MetaData

  @MetaData
  Scenario: Verify configuration count
    When User should click on Configure MetaData link
    Then User can see ten configuration data.

  @MetaData
  Scenario: Add new Encounter Role
    Given User should click on Configure MetaData link
    Given User should click manage encounter role
    And User click on add new encounter
    And User enter the role name
    And User write the description
    When User click save button
    Then new role created succefully

  @MetaData
  Scenario Outline: Manage the Encounter type
    Given User should click on Configure MetaData link
    When User should click manage Encounter type
    Then User can see the all encounter type "<EncounterName>"

    Examples: 
      | EncounterName     |
      | Admission         |
      | Attachment Upload |
      | Check In          |
      | Check Out         |
      | Discharge         |
      | Vitals            |

  @MetaData
  Scenario: Add the Encounter type
    Given User should click on Configure MetaData link
    When User should click manage Encounter type
    And User click on add new encounter type
    And User enter the role name
    And User write the description
    When User click save button
    Then new role created succefully

  @MetaData
  Scenario Outline: Manage Forms
    Given User should click on Configure MetaData link
    When User should click on manage form link
    Then User can see the available forms "<AvailableForm>"

    Examples: 
      | AvailableForm                     |
      | Admission (Simple)                |
      | Discharge (Simple)                |
      | Transfer Within Hospital (Simple) |
      | Visit Note                        |
      | Vitals                            |

  @MetaData
  Scenario Outline: Verify locations sessions
    Given User should click on Configure MetaData link
    When User click on manage locations
    Then User can see the available locations "<locations>"

    Examples: 
      | locations         |
      | Inpatient Ward    |
      | Isolation Ward    |
      | Laboratory        |
      | Outpatient Clinic |
      | Pharmacy          |
      | Registration Desk |

  @MetaData
  Scenario Outline: Verify patient identifier type
    Given User should click on Configure MetaData link
    When User click on manage patient identifier type
    Then user can see the patient identifier type "<Identifier>"

    Examples: 
      | Identifier                    |
      | OpenMRS ID                    |
      | Old Identification Number     |
      | OpenEMPI ID                   |
      | OpenMRS Identification Number |

  @MetaData
  Scenario: Verify the Roles and Privileges
    Given User should click on Configure MetaData link
    When User click on manage Privileges
    Then User can see the Privileges

  @Datamanagement
  Scenario: Verify Merge Patient Electronic Records
    Given User click on DataManagement Link
    And User navigate to DataManagement page
    When User click merge patient link
    Then User can merge the two paitent

  @Findpatientrecord
  Scenario: User navigate to Find patient page
    When User click on find patient link
    Then User navigate to find patient link

  @Findpatientrecord
  Scenario: FP Table coloumn count
    When User click on find patient link
    Then User can see patient details(ByTableHeader)

  @Findpatientrecord
  Scenario Outline: Verify Find Patient record
    When User click on find patient link
    Then User can see patient record "<TableHeader>"

    Examples: 
      | TableHeader |
      | Identifier  |
      | Name        |
      | Gender      |
      | Age         |
      | Birthdate   |

  @Findpatientrecord
  Scenario Outline: Verify the FP search box
    Given User click on find patient link
    When User enter patient "<ID>" into search box
    Then User can find the paticular patient details

    Examples: 
      | ID     |
      | 100FL5 |

  @Findpatientrecord
  Scenario: Verify the patient full details
    Given User click on find patient link
    Given User enter patient "100FL5"
    When User click on paticular patient details
    Then User can find the full details of paticular patient

  @Findpatientrecord
  Scenario Outline: Verify patient medical information
    Given User click on find patient link
    Given User enter patient "100FL5"
    When User click on paticular patient details
    Then User can get all medical information
    Then User can see patient medical record "<Record>"

    Examples: 
      | Record               |
      | DIAGNOSES            |
      | LATEST OBSERVATIONS  |
      | HEALTH TREND SUMMARY |
      | WEIGHT GRAPH         |
      | VITALS               |
      | APPOINTMENTS         |
      | RECENT VISITS        |
      | ALLERGIES            |

  @Findpatientrecord
  Scenario: verify with wrong credential in search box
    Given User click on find patient link
    When User enter the wrong ID on search box
    Then User get No matching found text

  @registerpatient
  Scenario: User navigate to Register Patient page
    Given User should click on Register Patient link
    Then User can navigate to Register Patient page

  @registerpatient
  Scenario: Verify patient Demographics registeration
    Given User should click on Register Patient link
    Given User enter the Patient given name
    Given User enter the Patient middle name
    Given User enter the Patient family name
    And User click on next button
    And User should select the gender and click next
    When User should select the patient DOB
    Then User should enter the patient address

  @registerpatient
  Scenario: Verify required field in name registration
    Given User should click on Register Patient link
    When User click without entering name
    Then User cannot navigate to further page

  @registerpatient
  Scenario: Verify required field in Gender registration
    Given User should click on Register Patient link
    Given User enter the Patient given name
    Given User enter the Patient middle name
    Given User enter the Patient family name
    And User click on next button
    When User click next button without entering gender
    Then User get error message

  @registerpatient
  Scenario: Verify required field in DOB registration
    Given User should click on Register Patient link
    Given User enter the Patient given name
    Given User enter the Patient middle name
    Given User enter the Patient family name
    And User click on next button
    And User should select the gender and click next
    When User click next button without entering DOB
    Then User get Required error message

  @registerpatient
  Scenario: Unidentified patient registration
    Given User should click on Register Patient link
    Given user click on unidentified patient
    And User click on next button
    And User should select the gender and click next
    When User click confirm
    Then Unidentified Patient registration will be successfull

  @Report
  Scenario: User navigate to Reports page
    When User should click on Reports page link
    Then User can navigate to Reports page

  @Report
  Scenario: Reports page header verification
    When User should click on Reports page link
    Then User can see the header

  @SystemAdministration
  Scenario: User navigate to System Administration page
    Given User click on System Administration Link
    When User navigate to System Administration page
    Then User can see Administration services

  @SystemAdministration
  Scenario Outline: Verify the Manage Extensions
    Given User click on System Administration Link
    When User click Manage Extensions link
    Then User can see the extensions "<extensions>"

    Examples: 
      | extensions   |
      | Extension ID |
      | Status       |
      | Actions      |

  @SystemAdministration
  Scenario: Verify the Manage APP
    Given User click on System Administration Link
    When User click Manage APP link
    Then User can manage the App definitions using "App ID"

  @SystemAdministration
  Scenario Outline: Verify the Manage Global Properties
    Given User click on System Administration Link
    When User click Manage Global Properties link
    Then User can see the global property "<Property>"

    Examples: 
      | Property |
      | Name     |
      | Value    |
      | Action   |

  @SystemAdministration
  Scenario: Verify the Manage Accounts
    Given User click on System Administration Link
    When User click Manage Accounts link
    Then User can see Accounts details

  @SystemAdministration
  Scenario Outline: Verify the Style Guide
    Given User click on System Administration Link
    When User click Style Guide link
    Then User can see available style "<Style>"

    Examples: 
      | Style      |
      | Base Style |
      | Javascript |
      | Test Pages |

  @SystemAdministration
  Scenario Outline: Verify the Base Style Variable
    Given User click on System Administration Link
    When User click Style Guide link
    Then User can customize the design by "<Variables>"

    Examples: 
      | Variables |
      | Colors    |
      | Fonts     |
      | Icons     |

  @SystemAdministration
  Scenario Outline: Verify the Base Style Fragments
    Given User click on System Administration Link
    When User click Style Guide link
    Then User can customize the design by Fragments "<Fragments>"

    Examples: 
      | Fragments        |
      | Navigation       |
      | Dialogs          |
      | Notifications    |
      | Toast Messages   |
      | Search Box       |
      | Tabs             |
      | Forms            |
      | Tables           |
      | Status Container |
      | Usage Examples   |

  @SystemAdministration
  Scenario: Verify the Advanced Administration
    Given User click on System Administration Link
    When User click Advanced Administration link
    Then User can navigate to Administrationpage

  @SystemAdministration @Second
  Scenario Outline: Verify the Advanced Administration Record
    Given User click on System Administration Link
    When User click Advanced Administration link
    Then User can get provided featutres "<Features>"

    Examples: 
      | Features                   |
      | Users                      |
      | Patients                   |
      | Visits                     |
      | Encounters                 |
      | ID Generation              |
      | Appointment Module         |
      | Analysis & Reporting       |
      | HTML Form Entry            |
      | Manage Report Definitions  |
      | Metadata Mapping           |
      | Open Web Apps Module       |
      | REST Web Services          |
      | Provider Management Module |
      | Data Exchange Module       |
      | Maintenance                |

  @SystemAdministration
  Scenario: Verify the Advanced Administration Services
    Given User click on System Administration Link
    When User click Advanced Administration link
    Then User can do mulitple Advanced settings
