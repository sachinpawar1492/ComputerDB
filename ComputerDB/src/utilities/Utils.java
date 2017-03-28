package utilities;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	public static WebDriver driver = null;
	
	/**
	 * This method is for opening the browser and URL
	 * @param iTestCaseRow : Row number a test case
	 * @return : Return browser driver
	 * @throws Exception : Throws exception if any issue comes while opening a browser
	 */
	public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception{
		
		try{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			
			driver = new FirefoxDriver();
			Logging.info("New driver instantiated.");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Logging.info("Implicit wait applied on the driver for 5 seconds.");
			
			driver.get(Constant.URL);
			Logging.info("Web application launched successfully.");
		}
		catch(Exception e){
			Logging.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
		}
		
		return driver;
	}
 
	/**
	 * This method is used to wait for a moment while the element is loaded on page
	 * @param element : WebElement object for which script needs to wait
	 */
	public static void waitForElement(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
 
	/**
	 * This method is used to take screenshot when test case fails
	 * @param driver : Browser object
	 * @param sTestCaseName : Name of the test case
	 * @throws Exception : Throws exception if any issue comes while taking screenshot
	 */
	public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
		try{ 
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Constant.pathScreenShots + sTestCaseName +".jpg"));	
		}
		catch (Exception e){
			Logging.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
			throw new Exception();
		}
	}	
}
