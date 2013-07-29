Feature: Currency Cloud Contact Us Form
  In order contact currency cloud
  As a prospect user
  I want to submit the contact us form

Background:
    Given I go to The Currency Cloud website
    And I visit Contact Us page


Scenario: Contact us form validation
    When I click on Submit button
    Then I see the global error message 'There was a problem with your submission. Errors have been highlighted below.'
    And I see the following field error messages :
      | fieldName              | errorMessage            |
      | First Name             | This field is required. |
      | Last Name              | This field is required. |
      | Company                | This field is required. |
      | Email                  | This field is required. |
      | Phone No               | This field is required. |
      | Nature of your enquiry | This field is required. |
