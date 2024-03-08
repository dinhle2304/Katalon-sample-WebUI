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

/*
2. Verify SKU, info all listiterm vissible and get text 
*/

try {
	WebUI.openBrowser(GlobalVariable.PD_CE_Url)

	WebUI.delay(5)
	
	CustomKeywords.'Cookie.AcceptCookie'()
	
/*/ get text merchandising flag	
	WebUI.waitForElementPresent(findTestObject("Object Repository/PD/mechandisingFlag_area"), 5, FailureHandling.OPTIONAL)
	
	String mechandisingFlag = WebUI.getText(findTestObject("Object Repository/PD/mechandisingFlag_area"))

	println("mechandisingFlag la " + mechandisingFlag)

//	get text deviceName	
	WebUI.waitForElementPresent(findTestObject("Object Repository/PD/deviceName_area"), 5, FailureHandling.OPTIONAL)
	
	String deviceName = WebUI.getText(findTestObject("Object Repository/PD/deviceName_area"))

	println("deviceName la " + deviceName)
	
//	get text deviceSKU
	WebUI.waitForElementPresent(findTestObject("Object Repository/PD/deviceSKU_area"), 5, FailureHandling.OPTIONAL)
	
	String deviceSKU = WebUI.getText(findTestObject("Object Repository/PD/deviceSKU_area"))

	println("deviceSKU la " + deviceSKU)
	
//	get text ratingPoint
	WebUI.waitForElementPresent(findTestObject("Object Repository/PD/ratingPoint_area"), 5, FailureHandling.OPTIONAL)
	
	String ratingPoint = WebUI.getText(findTestObject("Object Repository/PD/ratingPoint_area"))

	println("ratingPoint la " + ratingPoint)
	
//	get ratingReviewCount
	WebUI.waitForElementPresent(findTestObject("Object Repository/PD/ratingReviewCount_area"), 5, FailureHandling.OPTIONAL)
	
	String ratingReviewCount = WebUI.getText(findTestObject("Object Repository/PD/ratingReviewCount_area"))

	println("ratingReviewCount la " + ratingReviewCount)
*/
	
//	get bulletFeature

	int count = WebUI.countElements(findTestObject('Object Repository/PD/bulletFeatureNormal_area'))
	
/*	for () {
	WebUI.waitForElementPresent(findTestObject("Object Repository/PD/bulletFeatureNormal_area"), 5, FailureHandling.OPTIONAL)
	
	String bulletFeature = WebUI.getText(findTestObject("Object Repository/PD/bulletFeatureNormal_area"))

	println("bullet feature la " + bulletFeature)
	}
	*/
}
catch (Exception e) {
	println("exception occurs " + e.getMessage())
}
finally {
}