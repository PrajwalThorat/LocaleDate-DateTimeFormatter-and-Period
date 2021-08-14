## Problem Statement: LocaleDate, DateTimeFormatter and Period ##

This exercise should be completed using Test Driven Development Technique

  - Write Test classes in the TDD approach 
  - Functionality of methods should be completed, such that all the test cases pass 
  - Some requirements/hints are mentioned below
  
  ```
   In this problem, Given the investment date as input then duration and maturity date are manipulated  
        
   - Following functionality needs to be implemented in the TDD approach
   
            - Should return the maturity date given the investment date and duration 
            - Should return the duration given investment date and maturity date
   
   - Empty and null inputs should be checked 
  
Class BankDeposit  must be implemented using TDD for the following methods  
 
   - This method adds the duration of deposit to the investment date and returns the maturity date 
     in the format <dd/mm/yyyy>

        + getMaturityDate(String investmentDate, Period duration):String  

   - This method returns the duration of deposit between the investment date and maturity date
     in the format <years,months,days>  

        + getInvestmentDuration(String investmentDate, String maturityDate):String  
 
  ```
 **Note**: Use DateTimeFormatter and Period  
 
 - Write the test cases in the class `BankDepositTests`.    
 - Minimum test cases expected: 11
 - Test cases should be written for positive and negative scenarios, wherever applicable
 - Test methods should follow (given...ThenShould) naming convention.
     - For example: `givenTwoIntegersWhenAddedThenShouldReturnSum`. If the method name is very long,then you can skip `when` part.
 - Test coverage should be 100%   
 
## Instructions
- Avoid printing unnecessary values other than expected output as given in the sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding  

## Code coverage 

 - Run mvn test, the JaCoCo code coverage report will be generated at target/site/jacoco/*
 - Open the target/site/jacoco/index.html file, review the code coverage report 
 
            - Green – Code is tested or covered.
            - Red – Code is not tested or covered.
            - Yellow – Code is partially tested or covered.
 - Make sure lines coverage must meet the minimum 90%
