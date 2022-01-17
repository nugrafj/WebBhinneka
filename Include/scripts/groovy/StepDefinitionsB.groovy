import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable

public class StepDefinitionsB {

	@Given("I login to Bhinneka Web")
	def I_login_to_Bhinneka_Web() {

		WebUI.callTestCase(findTestCase('Login'), [:], FailureHandling.STOP_ON_FAILURE)
	}

	@When("I search for products from category")
	def I_search_for_products_from_category() {

		WebUI.click(findTestObject('Pages/Main/Lainnya'))
		WebUI.click(findTestObject('Pages/Main/Gadget'))
		WebUI.waitForPageLoad(GlobalVariable.Timeout)
	}

	@And("I use filters for product")
	def I_use_filters_for_product() {

		WebUI.click(findTestObject('Pages/Search/Checkbox Xiaomi'))
		WebUI.waitForPageLoad(GlobalVariable.Timeout)
		WebUI.click(findTestObject('Pages/Search/Checkbox Denpasar'))
		WebUI.waitForPageLoad(GlobalVariable.Timeout)
	}

	@And("add product to cart")
	def add_product_to_cart() {

		WebUI.click(findTestObject('Pages/Search/Xiaomi Grey'))
		WebUI.waitForPageLoad(GlobalVariable.Timeout)
		WebUI.click(findTestObject('Pages/Detail/Tambah ke Keranjang'))
		WebUI.click(findTestObject('Pages/Detail/Lanjut ke Keranjang'))
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

	@And("I verify the product")
	def I_verify_the_product() {

		def produk = WebUI.getText(findTestObject('Object Repository/Pages/Checkout/Produk checkout'))
		System.out.println(produk)
		WebUI.verifyMatch(produk, 'Xiaomi Redmi 9A 2/32 GB', false)
		def warna = WebUI.getText(findTestObject('Object Repository/Pages/Checkout/Warna'))
		System.out.println(warna)
		WebUI.verifyMatch(warna, 'Warna Grey', false)
		WebUI.closeBrowser()
	}
}
