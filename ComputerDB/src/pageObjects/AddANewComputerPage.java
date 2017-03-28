package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.Logging;

public class AddANewComputerPage extends BaseClass{
	private static WebElement element = null;
	private static Select elementSel = null;
	
	public AddANewComputerPage(WebDriver driver){
		super(driver);
	}

	public static WebElement txtComputerName() throws Exception{
		try{
			element = driver.findElement(By.xpath(".//*[@id='name']"));
			Logging.info("Computer Name text box found on page.");
		}
		catch (Exception e){
			Logging.error("Computer Name text box not found on page.");
			throw(e);
		}
		return element;
	}
	
	public static WebElement txtIntroducedDate() throws Exception{
		try{
			element = driver.findElement(By.id("introduced"));
			Logging.info("Introduced Date text box found on page.");
		}
		catch (Exception e){
			Logging.error("Introduced Date text box not found on page.");
			throw(e);
		}
		return element;
	}

	public static WebElement txtDiscontinuedDate() throws Exception{
		try{
			element = driver.findElement(By.id("discontinued"));
			Logging.info("Discontinued Date text box found on page.");
		}
		catch (Exception e){
			Logging.error("Discontinued Date text box not found on page.");
			throw(e);
		}
		return element;
	}	
	
	public static Select selCompany() throws Exception{
		try{
			elementSel = new Select(driver.findElement(By.id("company")));
			Logging.info("Company drop down found on page.");
		}
		catch (Exception e){
			Logging.error("Company drop down not found on page.");
			throw(e);
		}
		return elementSel;
	}
	
	public static WebElement btnCreateThisComputer() throws Exception{
		try{
			element = driver.findElement(By.xpath(".//*[@id='main']/form/div/input"));
			Logging.info("Create this computer button found on page.");
		}
		catch (Exception e){
			Logging.error("Create this computer button not found on page.");
			throw(e);
		}
		return element;
	}
	
	public static WebElement divComputerName() throws Exception{
		try{
			element = driver.findElement(By.xpath(".//*[@id='main']/form/fieldset/div[1]"));
		}
		catch (Exception e){
			throw(e);
		}
		return element;
	}
	
	public static WebElement divIntroducedDate() throws Exception{
		try{
			element = driver.findElement(By.xpath(".//*[@id='main']/form/fieldset/div[2]"));
		}
		catch (Exception e){
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
