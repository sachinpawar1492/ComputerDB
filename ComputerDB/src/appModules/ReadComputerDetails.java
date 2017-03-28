package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import pageObjects.ComputerDatabaseHomePage;
import pageObjects.EditComputerPage;
import utilities.Constant;
import utilities.ExcelUtils;
import utilities.Logging;

public class ReadComputerDetails {
	/**
	 * This method read the computer details and stores back to excel
	 * @param iTestCaseRow : Row number of a test case
	 * @throws Exception : Thorows exception if any error comes while reading computer details
	 */
	public static void readComputer(int iTestCaseRow) throws Exception {
		//Getting computer name from excel and entering it into application
		String sComputerName = ExcelUtils.getCellData(iTestCaseRow, Constant.colComputerName);
		ComputerDatabaseHomePage.txtFilterByCompName().sendKeys(sComputerName);
		Logging.info(sComputerName + " is entered in Filter by computer name text box.");
		
		//Clicking on Filter by name button
		ComputerDatabaseHomePage.btnFilterByName().click();
		Logging.info("Filter by name button clicked successfully.");
		
		//Selecting computer name
		ComputerDatabaseHomePage.computerName(sComputerName).click();
		Logging.info("Computer " + sComputerName + " found and opened successfully.");
		
		//Waiting for an element to be available on page
		final WebDriverWait wait = new WebDriverWait(EditComputerPage.driver, 10);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("introduced"))));
		
		//Checking whether Edit computer page is loaded or not
		boolean bHeading = EditComputerPage.lblEditComputer().isDisplayed();
		if (bHeading == true){
			Logging.info("Edit computer heading displayed on page.");
		}
		else {
			Logging.info("Edit computer heading not displayed on page.");
		}
		
		//Getting the computer name from application and wrting it back to excel
		String sCompName = EditComputerPage.txtComputerName().getAttribute("value");
		ExcelUtils.setCellData(sCompName, iTestCaseRow, Constant.colComputerName);
		Logging.info("Computer Name : " + sCompName + " saved successfully in excel sheet.");
		
		//Getting the introduced date from application and wrting it back to excel
		String sIntroducedDate = EditComputerPage.txtIntroducedDate().getAttribute("value");
		ExcelUtils.setCellData(sIntroducedDate, iTestCaseRow, Constant.colIntroducedDate);
		Logging.info("Intoduced Date :" + sIntroducedDate + " saved successfully in excel sheet.");
		
		//Getting the discontinued date from application and wrting it back to excel
		String sDiscontinuedDate = EditComputerPage.txtDiscontinuedDate().getAttribute("value");
		ExcelUtils.setCellData(sDiscontinuedDate, iTestCaseRow, Constant.colDiscontinuedDate);
		Logging.info("Discontinued Date :" + sDiscontinuedDate + " saved successfully in excel sheet.");
		
		//Getting the company name from application and wrting it back to excel
		WebElement sCompnay = EditComputerPage.selCompany().getFirstSelectedOption();
		ExcelUtils.setCellData(sCompnay.getText(), iTestCaseRow, Constant.colDiscontinuedDate);
		Logging.info("Company Name :" + sCompnay + " saved successfully in excel sheet.");
		
		//Clicking on cancel button
		EditComputerPage.btnCancel().click();
		Logging.info("Cancel button clicked successfully.");
		
		Reporter.log("Computer data read successfully.");
	}
}
