@Ithuba @HomePage 
Feature: Reach to LottoWeaver HomePage 
@ValidLogin 
Scenario Outline: Browser Launch and Reach Home Page 
	Given User Open Browser any particuler browser 
	When Enter the Url of Website 
	Then Title Of Website is <Title> 
	
	Examples: 
		| Title                           |
		| Ithuba National Lottery * Home  |