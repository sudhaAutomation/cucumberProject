@tag
Feature: Admin portal Login

  @tag1
  Scenario: Loggedin with valid credentials
    Given admin opens the "http://integratedtoolingsystems.in/1swishzz_staging/admin" in the "chrome" browser
    And enters the username "admin@admin.com" and password "123456"
    When click on the login button
    Then then admin views the dashboard with "Welcome Admin" message
    And admin close the browser

  Scenario Outline: Loggedin with invalid credentials
    Given admin opens the "http://integratedtoolingsystems.in/1swishzz_staging/admin" in the "chrome" browser
    And enters the username <username> and password <password>
    When click on the login button
    Then admin view the error message as "Please login with valid credentials"
    And admin close the browser

    Examples: 
      | username         | password    |
      | "admin@123"      | "admin"     |
      | "mohan@chin"     | "thirisha"  |
      | "sudha@mail.com" | "sudha"     |
      | "123456@12.3"    | "admin.com" |
