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
1. Verify header-navigation same product name
 */
try {
    WebUI.openBrowser(GlobalVariable.PD_CE_Url)

    WebUI.delay(10)
	
	CustomKeywords.'Cookie.AcceptCookie'()
	
	WebUI.waitForElementPresent(findTestObject("Object Repository/PD/headerNavigation_txt"), 5, FailureHandling.OPTIONAL)
	
	String headerNavigation = WebUI.getText(findTestObject("Object Repository/PD/headerNavigation_txt"))
	
	String expectedText = GlobalVariable.PD_CE_DeviceName
	
// kiem tra same text
    if (headerNavigation.equals(expectedText)) {
        println("Pass")
		println("headerNavigation = " + headerNavigation)
		println("expected Text = " + expectedText)
    }else {
		println("Fail")
	}
}
catch (Exception e) {
    println("exception occurs " + e.getMessage())
} 
finally { 
}

