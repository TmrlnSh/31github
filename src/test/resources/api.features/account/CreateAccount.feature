Feature: Create Account Test

  Scenario:  Create a valid account
    Given the following user is in the db
      | title | firstName | lastName | gender | dob        | ssn       | email           | password  | address         | locality | region | postalCode | country | homePhone  | mobilePhone | workPhone |
      | Mr.   | Steve     | Jobs     | M      | 03/20/1954 | 122443122 | steve@apple.com | Test123$$ | 1 infinite loop | CA       | CA     | 4444312    | US      | 444-221233 |             |           |








  Scenario: Create an account with wrong Account Name

  Scenario: Create an account with wrong Account Type code

  Scenario: Create an account with wrong opening Deposit

  Scenario: Create an account with wrong ownerTypeCode




    #{
    #  "address": "123 Main st",
    #  "country": "US",
    #  "dob": "01/30/1999",
    #  "emailAddress": "Mark@gmail.com",
    #  "firstName": "Mark",
    #  "gender": "M",
    #  "homePhone": "9863548734",
    #  "lastName": "Zuckerberg",
    #  "locality": "CA",
    #  "mobilePhone": "",
    #  "password": "Test@123",
    #  "postalCode": "43545",
    #  "region": "Palo Alto",
    #  "ssn": "945634022",
    #  "title": "Mr.",
    #  "workPhone": ""
    #}