package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.ComputerDatabaseHomePage;
import utilities.Logging;

public class GetComputerCount {
	/**
	 * This method is used for getting the updated count of computers after addition, updation & deletion
	 * @param iTestCaseRow
	 * @throws Exception
	 */
	public static void getComputerCount(int iTestCaseRow) throws Exception {
		String sComputerCountMessage;
		String[] aCompCount;
		String sComputerCount;
		int iComputerCount;
		String sUpdComputerCountMessage;
		String[] aUpdCompCount;
		String sUpdComputerCount;
		int iUpdComputerCount;

		final WebDriverWait wait = new WebDriverWait(ComputerDatabaseHomePage.driver, 10);
		
	//Addition of Computers
		//Clicking on Home link
		ComputerDatabaseHomePage.homeLink().click();
		Logging.info("Play sample application link clicked successfully.");

		//Waiting for an element to load on page completely
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("searchbox"))));	
		
		//Getting the count of computers
		sComputerCountMessage = ComputerDatabaseHomePage.computerCount().getText();
		aCompCount = sComputerCountMessage.split(" ");
		sComputerCount = aCompCount[0];
		iComputerCount = Integer.parseInt(sComputerCount);
		
		//Calling add new computer method
		AddNewComputer.addNewComputer(iTestCaseRow);
		
		//Clicking on Home link
		ComputerDatabaseHomePage.homeLink().click();
		Logging.info("Play sample application link clicked successfully.");
		
		//Waiting for an element to load on page completely
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("searchbox"))));	
		
		//Getting the count of computers
		sUpdComputerCountMessage = ComputerDatabaseHomePage.computerCount().getText();
		aUpdCompCount = sUpdComputerCountMessage.split(" ");
		sUpdComputerCount = aUpdCompCount[0];
		iUpdComputerCount = Integer.parseInt(sUpdComputerCount);
		
		//Checking if computer count increased after addition
		if(iUpdComputerCount == iComputerCount + 1){
			Logging.info("Computer count after addition is updated successfully.");
		}
		else{
			Logging.info("Computer count after addition is not updated successfully.");
		}
		
	//Update of Computers
		//Waiting for an element to load on page completely
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("searchbox"))));		
		
		//Getting the count of computers
		sComputerCountMessage = ComputerDatabaseHomePage.computerCount().getText();
		aCompCount = sComputerCountMessage.split(" ");
		sComputerCount = aCompCount[0];
		iComputerCount = Integer.parseInt(sComputerCount);
		
		//Calling update computer method
		UpdateComputerDetails.updateComputerDetails(iTestCaseRow);
		
		//Clicking on Home link
		ComputerDatabaseHomePage.homeLink().click();
		Logging.info("Play sample application link clicked successfully.");
		
		//Waiting for an element to load on page completely
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("searchbox"))));		
		
		//Getting the count of computers
		sUpdComputerCountMessage = ComputerDatabaseHomePage.computerCount().getText();
		aUpdCompCount = sUpdComputerCountMessage.split(" ");
		sUpdComputerCount = aUpdCompCount[0];
		iUpdComputerCount = Integer.parseInt(sUpdComputerCount);
		
		//Checking if computer count is same as before after update
		if(iUpdComputerCount == iComputerCount){
			Logging.info("Computer count after update is updated successfully.");
		}
		else{
			Logging.info("Computer count after update is not updated successfully.");
		}
		
	//Delete of Computers
		//Waiting for an element to load on page completely
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("searchbox"))));
		
		//Getting the count of computers
		sComputerCountMessage = ComputerDatabaseHomePage.computerCount().getText();
		aCompCount = sComputerCountMessage.split(" ");
		sComputerCount = aCompCount[0];
		iComputerCount = Integer.parseInt(sComputerCount);	
		
		//Waiting for an element to load on page completely
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("searchbox"))));		
		
		//Calling delete computer method
		DeleteComputer.deleteComputer(iTestCaseRow);
		
		//Clicking on Home link
		ComputerDatabaseHomePage.homeLink().click();
		Logging.info("Play sample application link clicked successfully.");
		
		//Waiting for an element to load on page completely
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id("searchbox"))));		
		
		//Getting the count of computers
		sUpdComputerCountMessage = ComputerDatabaseHomePage.computerCount().getText();
		aUpdCompCount = sUpdComputerCountMessage.split(" ");
		sUpdComputerCount = aUpdCompCount[0];
		iUpdComputerCount = Integer.parseInt(sUpdComputerCount);
		
		//Checking if computer count is decresed after deletion
		if(iUpdComputerCount == iComputerCount-1){
			Logging.info("Computer count after deletion is updated successfully.");
		}
		else{
			Logging.info("Computer count after deletion is not updated successfully.");
		}	
	}	
}
