package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Logging;

public class ComputerDatabaseHomePage extends BaseClass{
	private static WebElement element = null;
	
	public ComputerDatabaseHomePage(WebDriver driver){
		super(driver);
	}

	public static WebElement btnAddANewComputer() throws Exception{
		try{
			element = driver.findElement(By.id("add"));
			Logging.info("Add a new computer button found on page.");
		}
		catch (Exception e){
			Logging.error("Add a new computer button not found on page.");
			throw(e);
		}
		return element;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public static WebElement txtFilterByCompName() throws Exception{
		try{
			element = driver.findElement(By.id("searchbox"));
			Logging.info("Filter by computer name text box found on page.");
		}
		catch (Exception e){
			Logging.error("Filter by computer name text box not found on page.");
			throw(e);
		}
		return element;
	}
	
	public static WebElement btnFilterByName() throws Exception{
		try{
			element = driver.findElement(By.id("searchsubmit"));
			Logging.info("Filter by name button found on page.");
		}
		catch (Exception e){
			Logging.error("Filter by name button not found on page.");
			throw(e);
		}
		return element;
	}	
	
	public static WebElement alertComputerAdded() throws Exception{
		try{
			element = driver.findElement(By.xpath(".//*[@id='main']/div[1]"));
			Logging.info("Success Message : Computer added found on page.");
		}
		catch (Exception e){
			Logging.error("Success Message : Computer Added not found on page.");
			throw(e);
		}
		return element;
	}
	
	public static WebElement computerName(String sLinkText) throws Exception{
		try{
			element = driver.findElement(By.partialLinkText(sLinkText));
			Logging.info("Link : " + sLinkText +  " found on page.");
		}
		catch (Exception e){
			Logging.info("Link : " + sLinkText +  " not found on page.");
			throw(e);
		}
		return element;
	}
	
	public static WebElement computerCount() throws Exception{
		try{
			element = driver.findElement(By.xpath(".//*[@id='main']/h1"));
			Logging.info("Computer count found on page.");
		}
		catch (Exception e){
			Logging.info("Computer count not found on page.");
			throw(e);
		}
		return element;
	}

	
	public static WebElement homeLink() throws Exception{
		try{
			element = driver.findElement(By.partialLinkText("Play sample application"));
			Logging.info("Home link found on page.");
		}
		catch (Exception e){
			Logging.info("Home link not found on page.");
			throw(e);
		}
		return element;
	}	
}

