package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Logging;

public class EditComputerPage extends BaseClass{
	private static WebElement element = null;
	private static Select elementSel = null;
	
	public EditComputerPage(WebDriver driver){
		super(driver);
	}

	static WebDriverWait wait = new WebDriverWait(driver, 30);
	
	public static WebElement lblEditComputer() throws Exception{
		try{
			//element = (WebElement) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[@id='main']/h1")));
			element = driver.findElement(By.xpath(".//*[@id='main']/h1"));
			Logging.info("Edit computer heading found on page.");
		}
		catch (Exception e){
			Logging.error("Edit computer heading not found on page.");
			throw(e);
		}
		return element;
	}
	
	public static WebElement txtComputerName() throws Exception{
		try{
			//element = (WebElement) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("name")));
			element = driver.findElement(By.id("name"));
			Logging.info("Computer name text box found on page.");
		}
		catch (Exception e){
			Logging.error("Computer name text box not found on page.");
			throw(e);
		}
		return element;
	}
	
	public static WebElement txtIntroducedDate() throws Exception{
		try{
			//element = (WebElement) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("introduced")));
			element = driver.findElement(By.id("introduced"));
			Logging.info("Introduced date text box found on page.");
		}
		catch (Exception e){
			Logging.error("Introduced date text box not found on page.");
			throw(e);
		}
		return element;
	}
	
	public static WebElement txtDiscontinuedDate() throws Exception{
		try{
			//element = (WebElement) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("discontinued")));
			element = driver.findElement(By.id("discontinued"));
			Logging.info("Discontinued date text box found on page.");
		}
		catch (Exception e){
			Logging.error("Discontinued date text box not found on page.");
			throw(e);
		}
		return element;	
	}
	
	public static Select selCompany() throws Exception{
		try{
			//elementSel = (Select) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[@id='company']")));
			elementSel = new Select(driver.findElement(By.xpath(".//*[@id='company']")));
			Logging.info("Company drop down found on page.");
		}
		catch (Exception e){
			Logging.error("Company drop down not found on page.");
			throw(e);
		}
		return elementSel;
	}
	
	public static WebElement btnSaveThisComputer() throws Exception{
		try{
			element = driver.findElement(By.xpath(".//*[@id='main']/form[1]/div/input"));
			Logging.info("Save this computer button found on page.");
		}
		catch (Exception e){
			Logging.error("Save this computer button not found on page.");
			throw(e);
		}
		return element;	
	}	
	
	public static WebElement btnDeleteThisComputer() throws Exception{
		try{
			element = driver.findElement(By.xpath(".//*[@id='main']/form[2]/input"));
			Logging.info("Delete this computer button found on page.");
		}
		catch (Exception e){
			Logging.error("Delete this computer button not found on page.");
			throw(e);
		}
		return element;	
	}
	
	public static WebElement btnCancel() throws Exception{
		try{
			element = driver.findElement(By.xpath(".//*[@id='main']/form[1]/div/a"));
			Logging.info("Cancel button found on page.");
		}
		catch (Exception e){
			Logging.error("Cancel button not found on page.");
			throw(e);
		}
		return element;	
	}	
}
