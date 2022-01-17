import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.comment('Story: Add product from search feature')

WebUI.comment('Given I login to Bhinneka Web')

WebUI.callTestCase(findTestCase('Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('When I search for products from search feature')

WebUI.setText(findTestObject('Pages/Main/Search'), 'Mousepad')

WebUI.sendKeys(findTestObject('Pages/Main/Search'), Keys.chord(Keys.ENTER))

WebUI.waitForPageLoad(GlobalVariable.Timeout)

WebUI.click(findTestObject('Pages/Search/Produk Mousepad'))

WebUI.waitForPageLoad(GlobalVariable.Timeout)

WebUI.comment('And I increase the number of products')

WebUI.click(findTestObject('Pages/Detail/Tambah'))

WebUI.click(findTestObject('Pages/Detail/Tambah'))

WebUI.comment('And add product to cart')

WebUI.click(findTestObject('Pages/Detail/Tambah ke Keranjang'))

WebUI.click(findTestObject('Pages/Detail/Lanjut ke Keranjang'))

WebUI.click(findTestObject('Pages/Cart/Tambah'))

WebUI.click(findTestObject('Pages/Cart/Beli Sekarang'))

WebUI.waitForPageLoad(GlobalVariable.Timeout)

WebUI.comment('Then I verify the current page is checkout page')

WebUI.verifyElementText(findTestObject('Pages/Checkout/Text Checkout'), 'Checkout')

geturl = WebUI.getUrl()

System.out.println(geturl)

WebUI.verifyMatch(geturl, 'https://www.bhinneka.com/checkout', false)

WebUI.comment('And I verify the product quantity')

total = WebUI.getText(findTestObject('Pages/Checkout/Label Pembelian'))

System.out.println(total)

WebUI.verifyMatch(total, 'Total Pembelian (4)', false)

WebUI.closeBrowser()

