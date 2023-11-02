import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class LoginOTP {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("user navigate to login page")
	public void NavigateToLoginPage() {
		WebUI.openBrowser('')

		WebUI.navigateToUrl('http://10.0.0.112:3000/login')
	}

	@When("user enters (.*)")
	public void enterCredentials(String username) {
		WebUI.setText(findTestObject('Object Repository/LoginOTP/Page_EHR - Electronic Healthcare/input_Email___BVID__17'), username)
	}

	@And("click submit button")
	public void clicksubmit() {
		WebUI.click(findTestObject('Object Repository/LoginOTP/Page_EHR - Electronic Healthcare/button_Submit'))
	}

	@And("enter (.*)")
	public void clockLogin(String otp) {
		WebUI.setText(findTestObject('Object Repository/LoginOTP/Page_EHR - Electronic Healthcare/input_Verification OTP___BVID__20'),
				otp)
	}

	@And("click on submit button")
	public void Login() {
		WebUI.click(findTestObject('Object Repository/LoginOTP/Page_EHR - Electronic Healthcare/button_Submit'))
	}

	@Then("user is navigate to homepage")
	public void ToHomepage() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginOTP/Page_EHR - Electronic Healthcare/div_ZP                     Welcome back,   _4ab6cf'),
				5)
	}
}