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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.Url)

WebUI.waitForPageLoad(GlobalVariable.Timeout)

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Pages/Main/Block'), 5, FailureHandling.CONTINUE_ON_FAILURE) == true)
	{
	   WebUI.click(findTestObject('Object Repository/Pages/Main/Block'));
	}

WebUI.click(findTestObject('Pages/Main/Login'))

WebUI.setText(findTestObject('Pages/Login/Input Email'), GlobalVariable.Email)

WebUI.click(findTestObject('Pages/Login/Selanjutnya'))

WebUI.setEncryptedText(findTestObject('Pages/Login/Input Password'), 'EvaxILliuri26FRWYzY2Ug==')

WebUI.click(findTestObject('Pages/Login/Masuk'))

WebUI.waitForPageLoad(GlobalVariable.Timeout)

