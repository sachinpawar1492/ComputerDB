package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import pageObjects.ComputerDatabaseHomePage;
import pageObjects.EditComputerPage;
import utilities.Constant;
import utilities.ExcelUtils;
import utilities.Logging;

public class DeleteComputer {
	/**
	 * This method is for deleting the Computer
	 * @param iTestCaseRow : Row number of a test case
	 * @throws Exception : Throws exception if any error comes while deleting the computer
	 */
	public static void deleteComputer(int iTestCaseRow) throws Exception{
		//Getting Computer name from excel and entering it in application
		String sComputerName = ExcelUtils.getCellData(iTestCaseRow, Constant.colComputerName);
		ComputerDatabaseHomePage.txtFilterByCompName().clear();
		ComputerDatabaseHomePage.txtFilterByCompName().sendKeys(sComputerName);
		Logging.info(sComputerName + " is entered in Filter by computer name text box.");
		
		//Waiting to load element objects of a browser
		final WebDriverWait wait = new WebDriverWait(ComputerDatabaseHomePage.driver, 15);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("searchbox"))));		
		
		//Clicking on a Filter by name button
		ComputerDatabaseHomePage.btnFilterByName().click();
		Logging.info("Filter by name button clicked successfully.");
		
		//Clicking on a computer
		ComputerDatabaseHomePage.computerName(sComputerName).click();
		Logging.info("Computer " + sComputerName + " found and opened successfully.");
		
		//Waiting to load element objects of a browser
		final WebDriverWait waits = new WebDriverWait(EditComputerPage.driver, 10);
		waits.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("introduced"))));
		
		//Checking whether Edit Computer page loaded or not
		boolean bHeading = EditComputerPage.lblEditComputer().isDisplayed();
		if (bHeading == true){
			Logging.info("Edit computer heading displayed on page.");
		}
		else {
			Logging.info("Edit computer heading not displayed on page.");
		}
		
		//Checking for the success message
		EditComputerPage.btnDeleteThisComputer().click();
		Logging.info("Delete this computer button clicked successfully.");
		
		Reporter.log("Computer deleted successfully.");
	}
}
