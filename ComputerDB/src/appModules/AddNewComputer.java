package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import pageObjects.AddANewComputerPage;
import pageObjects.ComputerDatabaseHomePage;
import utilities.Constant;
import utilities.ExcelUtils;
import utilities.Logging;

public class AddNewComputer {
	/**
	 * This method will add a new computer in Computer Database
	 * @param iTestCaseRow : Row number of a test case
	 * @throws Exception : Throw exception if any error comes while adding a new computer
	 */
	public static void addNewComputer(int iTestCaseRow) throws Exception{
		//Clicking on a Add a new computer button
		ComputerDatabaseHomePage.btnAddANewComputer().click();
		Logging.info("Add a new computer button clicked successfully.");
		
		//Getting computer name from excel sheet and entering it in Computer name text box
		String sComputerName = ExcelUtils.getCellData(iTestCaseRow, Constant.colComputerName);
		AddANewComputerPage.txtComputerName().sendKeys(sComputerName);
		Logging.info(sComputerName + " is entered in Computer Name text box.");
		
		//Getting Introduced Date from excel sheet and entering it in Introduced Date text box
		String sIntroducedDate = ExcelUtils.getCellData(iTestCaseRow, Constant.colIntroducedDate);
		AddANewComputerPage.txtIntroducedDate().sendKeys(sIntroducedDate);
		Logging.info(sIntroducedDate + " is entered in Introduced Date text box.");
		
		//Getting Discontinued Date from excel sheet and entering it in Discontinued Date text box
		String sDiscontinuedDate = ExcelUtils.getCellData(iTestCaseRow, Constant.colDiscontinuedDate);
		AddANewComputerPage.txtDiscontinuedDate().sendKeys(sDiscontinuedDate);
		Logging.info(sDiscontinuedDate + " is entered in Discontinued Date text box.");
		
		//Getting Company Name from Excel Sheet and selecting it from Company drop down
		String sCompany = ExcelUtils.getCellData(iTestCaseRow, Constant.colCompany);
		AddANewComputerPage.selCompany().selectByVisibleText(sCompany);
		Logging.info(sCompany + " is selected from Company drop down.");
		
		//Clicking on Create this computer button
		AddANewComputerPage.btnCreateThisComputer().click();
		Logging.info("Create this computer button clicked successfully.");
		
		//Checking if Success Message displayed on page
		boolean bAlertPresent = ComputerDatabaseHomePage.alertComputerAdded().isDisplayed();
		if (bAlertPresent == true){
			Logging.info("Success Message displayed on page.");
		}
		else {
			Logging.error("Success Message not displayed on page.");
		}
		
		Reporter.log("New computer added successfully.");	
	}
	
	/**
	 * This method will check whether Computer name text box is highlighted if name not provided
	 * @param iTestCaseRow : Row number of a test case
	 * @throws Exception : Throws exception if any unexpected issues comes while adding new computer without name
	 */
	public static void addNewComputerWithoutName(int iTestCaseRow) throws Exception{
		//Clicking on Add A New Computer Button
		ComputerDatabaseHomePage.btnAddANewComputer().click();
		Logging.info("Add a new computer button clicked successfully.");		
		
		//Clicking on Create this computer button
		AddANewComputerPage.btnCreateThisComputer().click();
		Logging.info("Create this computer button clicked successfully.");
		
		//Waiting to load the page completely
		final WebDriverWait wait = new WebDriverWait(AddANewComputerPage.driver, 10);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='clearfix error']"))));
		
		//Getting class of webelement which is highlighted
		String sErrorClass = AddANewComputerPage.divComputerName().getAttribute("class");
		
		//Checking if the text box is highlighted
		if(sErrorClass.equalsIgnoreCase("clearfix error")){
			Logging.info("Text field highlighted while saving computer without name.");
			Reporter.log("Text field highlighted while saving computer without name.");
		}
		else{
			Logging.error("Text field not highlighted while saving computer without name.");
			Reporter.log("Text field not highlighted while saving computer without name.");
		}
	}
	
	/**
	 * This method will check whether Introduced date text box is highlighted if date provided in wrong format
	 * @param iTestCaseRow : Row number of a test case
	 * @throws Exception : Throws exception if any unexpected issues comes while adding new computerif date provided in wrong format
	 */
	public static void addNewComputerWithWrongDate(int iTestCaseRow) throws Exception{
		//Clicking on Add a new computer button
		ComputerDatabaseHomePage.btnAddANewComputer().click();
		Logging.info("Add a new computer button clicked successfully.");
		
		//Getting computer name from excel sheet and entering it in Computer name text box
		String sComputerName = ExcelUtils.getCellData(iTestCaseRow, Constant.colComputerName);
		AddANewComputerPage.txtComputerName().sendKeys(sComputerName);
		Logging.info(sComputerName + " is entered in Computer Name text box.");
		
		//Getting Introduced Date from excel sheet and entering it in Introduced Date text box
		String sIntroducedDate = ExcelUtils.getCellData(iTestCaseRow, Constant.colIntroducedDate);
		AddANewComputerPage.txtIntroducedDate().sendKeys(sIntroducedDate);
		Logging.info(sIntroducedDate + " is entered in Introduced Date text box.");		
		
		//Clicking on Create this computer button
		AddANewComputerPage.btnCreateThisComputer().click();
		Logging.info("Create this computer button clicked successfully.");
		
		//Waiting to load the page completely
		final WebDriverWait wait = new WebDriverWait(AddANewComputerPage.driver, 10);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='clearfix error']"))));
		
		//Getting class of webelement which is highlighted
		String sErrorClass = AddANewComputerPage.divIntroducedDate().getAttribute("class");
		
		//Checking if the text box is highlighted
		if(sErrorClass.equalsIgnoreCase("clearfix error")){
			Logging.info("Text field highlighted while saving computer with wrong date format.");
			Reporter.log("Text field highlighted while saving computer with wrong date format.");
		}
		else{
			Logging.error("Text field not highlighted while saving computer with wrong date format.");
			Reporter.log("Text field not highlighted while saving computer with wrong date format.");
		}
	}	
	
	/**
	 * This method will check whether Play sample application link is working
	 * @param iTestCaseRow : Row number of a test case
	 * @throws Exception : Throws exception if any unexpected issues comes while verifying the Play sample application link
	 */
	public static void verifyHomeLink(int iTestCaseRow) throws Exception{
		//Clicking on Create this computer button
		ComputerDatabaseHomePage.btnAddANewComputer().click();
		Logging.info("Add a new computer button clicked successfully.");

		//Waiting to load the page completely
		final WebDriverWait wait = new WebDriverWait(AddANewComputerPage.driver, 10);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("introduced"))));
		
		//Clicking on a Home Link
		AddANewComputerPage.homeLink().click();
		Logging.info("Home link clicked successfully.");
		
		//Waiting to load the page completely
		final WebDriverWait waits = new WebDriverWait(ComputerDatabaseHomePage.driver, 10);
		waits.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("searchbox"))));
		
		//Checking if heading is displayed on page
		boolean bAlertPresent = ComputerDatabaseHomePage.computerCount().isDisplayed();
		if (bAlertPresent == true){
			Logging.info("Navigated to home page.");
		}
		else {
			Logging.error("Not navigated to hoem page.");
		}
	}	
}
