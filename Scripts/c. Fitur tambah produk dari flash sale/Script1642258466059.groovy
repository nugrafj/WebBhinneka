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

WebUI.comment('Story: Add product from flash sale')

WebUI.comment('Given I login to Bhinneka Web')

WebUI.callTestCase(findTestCase('Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('When I search for products flash sale')

WebUI.click(findTestObject('Pages/Main/Promo Aksesoris'))

WebUI.waitForPageLoad(GlobalVariable.Timeout)

WebUI.comment('And add two products to cart')

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

WebUI.comment('Then I verify the current page is checkout page')

WebUI.verifyElementText(findTestObject('Pages/Checkout/Text Checkout'), 'Checkout')

geturl = WebUI.getUrl()

System.out.println(geturl)

WebUI.verifyMatch(geturl, 'https://www.bhinneka.com/checkout', false)

WebUI.comment('And I verify the name of each product')

produk1 = WebUI.getText(findTestObject('Object Repository/Pages/Checkout/Produk1'))

System.out.println(produk1)

WebUI.verifyMatch(produk1, 'PHILIPS Rain USB 2.0 Flash Drive 32GB', false)

produk2 = WebUI.getText(findTestObject('Object Repository/Pages/Checkout/Produk2'))

System.out.println(produk2)

WebUI.verifyMatch(produk2, 'WD Blue 1TB WD10EZEX', false)

WebUI.comment('And I verify the number of items purchased')

total = WebUI.getText(findTestObject('Pages/Checkout/Label Pembelian'))

System.out.println(total)

WebUI.verifyMatch(total, 'Total Pembelian (2)', false)

WebUI.closeBrowser()

