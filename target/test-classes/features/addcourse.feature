@tag
Feature: Add Course module

  Background: Loggedin with valid credentials
    Given admin opens the "https://swhizz.com/site_staging/admin" in the "chrome" browser
    And enters the username "admin@admin.com" and password "12345"
    When click on the login button
    Then then admin views the dashboard with "Welcome Admin" message
    Then driver present in the dashborad

  @tag1
  Scenario: Display the Courses List
    When admin clicks on courses list option
    Then browser navigates to courses list page
    When admin clicks on the add course button
    Then browser naviagtes to add course page
    Given following course details
      | Category           | Java Fullstack                                                                |
      | Course Name        | Core Java                                                            |
      | Course URL         | www.oracle.com/java                                                  |
      | choose file        | /admin-portal/src/test/resources/temp/index.html											|
      | course video link  | www.oracle.com/java.mp4                                              |
      | is popular         | Yes                                                                  |
      | sort order         |                                                                    2 |
      | rating             | ****                                                                 |
      | Leraners           | corporate students                                                   |
      | certified          | No certigication                                                     |
      | meta title         | java course                                                          |
      | meta desrciption   | java full stack course                                               |
      | meta keywords      | java,java full stack ,node js, java hibernate                        |
      | Google code script | .java                                                                |
    And admin close the browser
