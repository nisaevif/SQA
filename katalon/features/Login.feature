Feature: Login Stetosco

	Scenario Outline: Test Login with OTP
		
		Given user navigate to login page
		When user enters <username>
		And click submit button 
		And enter <otp>
		And click on submit button
		Then user is navigate to homepage
		
	Examples: 
	| username 									| otp      |
	| nisaevifauziah@gmail.com  | 123456   |