@Ithuba @LoginPage 
Feature: Login Page Setup Feature 
	As a Tester want to use this template for my Login feature file
@ValidLogin 
Scenario Outline: login to Website 
	Given Navigate To LoginPage 
	When Enter Credentials <username> <Password> 
	And Submit Login Button 
	Then Get Logout Button 
	
	Examples: 
		| username   | Password | status  |
		| 0800123456 |    45321 | success |
