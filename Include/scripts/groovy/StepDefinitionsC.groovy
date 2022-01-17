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

public class StepDefinitionsC {
	
	@Given("I login to Bhinneka Web")
	def I_login_to_Bhinneka_Web() {
		
		WebUI.callTestCase(findTestCase('Login'), [:], FailureHandling.STOP_ON_FAILURE)
	}

	@When("I search for products flash sale")
	def I_search_for_products_flash_sale() {
				
		WebUI.click(findTestObject('Pages/Main/Promo Aksesoris'))
		WebUI.waitForPageLoad(GlobalVariable.Timeout)
	}
	
	@And("add two products to cart")
	def add_two_products_to_cart() {
		
		WebUI.click(findTestObject('Pages/Promo/Penyimpanan data'))
		WebUI.click(findTestObject('Pages/Promo/PHILIPS Rain USB'))
		WebUI.waitForPageLoad(GlobalVariable.Timeout)
		WebUI.click(findTestObject('Pages/Detail/Tambah ke Keranjang'))
		WebUI.click(findTestObject('Pages/Detail/Kembali Berbelanja Philips'))
		WebUI.click(findTestObject('Pages/Main/Bhinneka'))
		WebUI.waitForPageLoad(GlobalVariable.Timeout)
		WebUI.click(findTestObject('Pages/Main/Promo Aksesoris'))
		WebUI.waitForPageLoad(GlobalVariable.Timeout)
		WebUI.click(findTestObject('Pages/Promo/Hard drive'))
		WebUI.click(findTestObject('Pages/Promo/WD Blue'))
		WebUI.waitForPageLoad(GlobalVariable.Timeout)
		WebUI.click(findTestObject('Pages/Detail/Tambah ke Keranjang'))
		WebUI.click(findTestObject('Pages/Detail/Lanjut ke Keranjang WD Blue'))
		WebUI.waitForPageLoad(GlobalVariable.Timeout)
		WebUI.click(findTestObject('Pages/Cart/Beli Sekarang 2 Produk'))
		WebUI.waitForPageLoad(GlobalVariable.Timeout)
	}
	
	@Then("I verify the current page is checkout page")
	def I_verify_the_current_page_is_checkout_page() {
		
		WebUI.verifyElementText(findTestObject('Pages/Checkout/Text Checkout'), 'Checkout')	
		def geturl = WebUI.getUrl()
		System.out.println(geturl)
		WebUI.verifyMatch(geturl, 'https://www.bhinneka.com/checkout', false)
	}
	
	@And("I verify the name of each product")
	def I_verify_the_name_of_each_product() {
		
		def produk1 = WebUI.getText(findTestObject('Object Repository/Pages/Checkout/Produk1'))
		System.out.println(produk1)
		WebUI.verifyMatch(produk1, 'PHILIPS Rain USB 2.0 Flash Drive 32GB', false)
		def produk2 = WebUI.getText(findTestObject('Object Repository/Pages/Checkout/Produk2'))
		System.out.println(produk2)
		WebUI.verifyMatch(produk2, 'WD Blue 1TB WD10EZEX', false)
	}
	
	@And("I verify the number of items purchased")
	def I_verify_the_number_of_items_purchased() {
		
		def total = WebUI.getText(findTestObject('Pages/Checkout/Label Pembelian'))
		System.out.println(total)
		WebUI.verifyMatch(total, 'Total Pembelian (2)', false)
		WebUI.closeBrowser()
	}
	
}
