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



class StepDefinitionsA {

	@Given("I login to Bhinneka Web")
	def I_login_to_Bhinneka_Web() {

		WebUI.callTestCase(findTestCase('Login'), [:], FailureHandling.STOP_ON_FAILURE)
	}

	@When("I search for products from search feature")
	def I_search_for_products_from_search_feature() {

		WebUI.setText(findTestObject('Pages/Main/Search'), 'Mousepad')
		WebUI.sendKeys(findTestObject('Pages/Main/Search'), Keys.chord(Keys.ENTER))
		WebUI.waitForPageLoad(GlobalVariable.Timeout)
		WebUI.click(findTestObject('Pages/Search/Produk Mousepad'))
		WebUI.waitForPageLoad(GlobalVariable.Timeout)
	}

	@And("I increase the number of products")
	def I_increase_the_number_of_products() {

		WebUI.click(findTestObject('Pages/Detail/Tambah'))
		WebUI.click(findTestObject('Pages/Detail/Tambah'))
	}

	@And("add product to cart")
	def add_product_to_cart() {

		WebUI.click(findTestObject('Pages/Detail/Tambah ke Keranjang'))
		WebUI.click(findTestObject('Pages/Detail/Lanjut ke Keranjang'))
		WebUI.click(findTestObject('Pages/Cart/Tambah'))
		WebUI.click(findTestObject('Pages/Cart/Beli Sekarang'))
		WebUI.waitForPageLoad(GlobalVariable.Timeout)
	}

	@Then("I verify the current page is checkout page")
	def I_verify_the_current_page_is_checkout_page() {

		WebUI.verifyElementText(findTestObject('Pages/Checkout/Text Checkout'), 'Checkout')
		def geturl = WebUI.getUrl()
		System.out.println(geturl)
		WebUI.verifyMatch(geturl, 'https://www.bhinneka.com/checkout', false)
	}

	@And("I verify the product quantity")
	def I_verify_the_product_quantity() {

		def total = WebUI.getText(findTestObject('Pages/Checkout/Label Pembelian'))
		System.out.println(total)
		WebUI.verifyMatch(total, 'Total Pembelian (4)', false)
		WebUI.closeBrowser()
	}
}