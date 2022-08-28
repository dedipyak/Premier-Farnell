Feature: Test scenarios

@register_account
Scenario: User register account
	Given User has navigated to website
	When User clicks on the register button
	Then User enters the required details
	Then User clicks on join now button



