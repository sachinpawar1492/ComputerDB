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

public class UpdateComputerDetails {
	/**
	 * This method id for updating the computer details
	 * @param iTestCaseRow : Row number of a test case
	 * @throws Exception : Throws exception if any error comes while updating computer details
	 */
	public static void updateComputerDetails(int iTestCaseRow) throws Exception{
		
		String sComputerName = ExcelUtils.getCellData(iTestCaseRow, Constant.colComputerName);
		ComputerDatabaseHomePage.txtFilterByCompName().clear();
		ComputerDatabaseHomePage.txtFilterByCompName().sendKeys(sComputerName);
		Logging.info(sComputerName + " is entered in Filter by computer name text box.");
		
		ComputerDatabaseHomePage.btnFilterByName().click();
		Logging.info("Filter by name button clicked successfully.");
		
		ComputerDatabaseHomePage.computerName(sComputerName).click();
		Logging.info("Computer " + sComputerName + " found and opened successfully.");
		
		final WebDriverWait wait = new WebDriverWait(EditComputerPage.driver, 10);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("introduced"))));
		
		boolean bHeading = EditComputerPage.lblEditComputer().isDisplayed();
		if (bHeading == true){
			Logging.info("Edit computer heading displayed on page.");
		}
		else {
			Logging.info("Edit computer heading not displayed on page.");
		}
		
		String sIntroducedDate = ExcelUtils.getCellData(iTestCaseRow, Constant.colIntroducedDate);
		EditComputerPage.txtIntroducedDate().clear();
		EditComputerPage.txtIntroducedDate().sendKeys(sIntroducedDate);
		Logging.info(sIntroducedDate + " is entered in Introduced Date text box.");
		
		String sDiscontinuedDate = ExcelUtils.getCellData(iTestCaseRow, Constant.colDiscontinuedDate);
		EditComputerPage.txtDiscontinuedDate().clear();
		EditComputerPage.txtDiscontinuedDate().sendKeys(sDiscontinuedDate);
		Logging.info(sDiscontinuedDate + " is entered in Discontinued Date text box.");
		
		String sCompany = ExcelUtils.getCellData(iTestCaseRow, Constant.colCompany);
		EditComputerPage.selCompany().selectByVisibleText(sCompany);
		Logging.info(sCompany + " is selected from Company drop down.");
		
		EditComputerPage.btnSaveThisComputer().click();
		Logging.info("Save this computer button clicked successfully.");
		
		Reporter.log("Computer details updated successfully.");		
	}
}
