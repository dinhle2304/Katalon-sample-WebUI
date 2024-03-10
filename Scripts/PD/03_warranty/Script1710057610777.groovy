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
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebElement as Keys

/*
3. Verify all warranty type can add success (1,2,3,4,none)
*/

try {
	WebUI.openBrowser(GlobalVariable.PD_CE_Url)

	WebUI.delay(5)
	
	CustomKeywords.'Cookie.AcceptCookie'()
	
//	get list warranty
	WebUI.waitForElementPresent(findTestObject("Object Repository/PD/pdSamsungCareOptionSelector_txt"), 5, FailureHandling.OPTIONAL)
	
	searchedWarrantyList = WebUI.findWebElements(findTestObject("Object Repository/PD/pdSamsungCareOptionSelector_txt"), 5, FailureHandling.STOP_ON_FAILURE)
	
	println("Ket qua tim kiem list Web Element Warranty la " + searchedWarrantyList)
	
	int index = 1
	
//	vong lap for qua tung WebElement cua searchedWarrantyList
	for (WebElement warrantyListElement : searchedWarrantyList) {

//	get text cua WebElement
	String text = warrantyListElement.getText()
	
	WebUI.delay(2)

//	add Warranty
	warrantyListElement.click()
//	voi truong hop Maintext # None
		if(text != 'None') {
	
			WebUI.delay(3)
	
			WebUI.click(findTestObject('Object Repository/PD/warrantyConfirmPopupTnC_chk'), FailureHandling.OPTIONAL)
	
			WebUI.delay(3)
	
			WebUI.click(findTestObject('Object Repository/PD/warrantyConfirmPopupContinue_btn'), FailureHandling.OPTIONAL)
	
			WebUI.waitForElementPresent(findTestObject("Object Repository/PD/warrantySKU"), 5, FailureHandling.OPTIONAL)
			
//			lay warranty SKU
			String warrantySKU = WebUI.getAttribute(findTestObject("Object Repository/PD/warrantySKU"), 'data-model-code', FailureHandling.OPTIONAL)
			
//			khai bao bien List Warranty_SKU_List, gia tri tu bien Global
			List Warranty_SKU_List = GlobalVariable.PD_CE_warranty_SKU_List
			
//			kiem tra warrantySKU co ton tai trong Profile hay ko
			if (Warranty_SKU_List.contains(warrantySKU)) {
				println("Add thanh cong Warranty " + text + " voi SKU tuong ung la " + warrantySKU)
			}else {
				println("Exception warrantySKU khong thuoc list duoc setup")
			}			
			index++
		}

//	voi truong hop Maintext = None
		else {
			WebUI.delay(3)
			
			WebUI.click(findTestObject('Object Repository/PD/warrantyResetPopupContinue_btn'), FailureHandling.OPTIONAL)
			
			WebUI.waitForElementPresent(findTestObject("Object Repository/PD/warrantySKU"), 5, FailureHandling.OPTIONAL)
			
//			lay warrantySKU
			String warrantySKU = WebUI.getAttribute(findTestObject("Object Repository/PD/warrantySKU"), 'data-model-code', FailureHandling.OPTIONAL)

			if (warrantySKU == null) {
				println ("remove warranty SKU successfully")
			}else {
				println ("fail, warranty SKU still visible after add None")
			}
		}
	}
}
catch (Exception e) {
	println("exception occurs " + e.getMessage())
}
finally {
}