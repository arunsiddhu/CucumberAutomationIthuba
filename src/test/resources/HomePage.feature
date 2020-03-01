@HomePage
Feature: Reach to LottoWeaver HomePage

  Scenario Outline: : Browser Lauch and Reach Home Page
    Given User Open Browser any particuler browser
    When Enter the Url of Website
    Then Title Of Website is <Title>

    Examples: 
      | Title                           |
      | Ithuba National Lottery \| Home |
