package mainDriver;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appModules.AddNewComputer;
import appModules.DeleteComputer;
import appModules.GetComputerCount;
import appModules.ReadComputerDetails;
import appModules.UpdateComputerDetails;
import pageObjects.BaseClass; 
import utilities.Constant;
import utilities.ExcelUtils;
import utilities.Logging;
import utilities.Utils;

public class DriverScript {
	public WebDriver driver;
	private String sTestCaseName;
	private int iUsedRows;
	private int iTestCaseRow;
	

@BeforeMethod
	/**
	 * This method is for initial set up before running the test cases
	 * @throws Exception : Throws excpetion if any error comes while initialising log4j.xml, setting Excel file
	 */
	public void beforeMethod() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		
		ExcelUtils.setExcelFile(Constant.pathTestData + Constant.fileTestData, "TestCases");
		
		iUsedRows = ExcelUtils.getRowUsed();
	}


@Test
	/**
	 * This method is the main driver to execute entire framework
	 * @throws IOException
	 */
	public void main() throws IOException{
		try{
			//Initialising the loop in order to iterate through all the rows(test case)
			for (int iRow=1; iRow<=iUsedRows; iRow++) {
				try{
					//Getting the test case name from the excel
					sTestCaseName = ExcelUtils.getCellData(iRow, Constant.colTestCaseID);
				
					Logging.startTestCase(sTestCaseName);
					
					//Getting the row number of test case
					iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.colTestCaseID);
					
					//Getting the flag from excel which will decide whether to run the test case or skip it
					String sExecutionFlag = ExcelUtils.getCellData(iRow, Constant.colExecutionFlag);
				
					//Deciding whether to execute the test case or skip it
					if (sExecutionFlag.equalsIgnoreCase("YES")) {

						//Opening the URL
						driver = Utils.OpenBrowser(iTestCaseRow);
					
						new BaseClass(driver);
					
						//Switch case for individual test case
						switch(sTestCaseName){
						case "TC_1" :
							AddNewComputer.addNewComputer(iTestCaseRow);
							break;
						case "TC_2" :
							ReadComputerDetails.readComputer(iTestCaseRow);
							break;
						case "TC_3" :
							UpdateComputerDetails.updateComputerDetails(iTestCaseRow);
							break;
						case "TC_4" :
							DeleteComputer.deleteComputer(iTestCaseRow);
							break;
						case "TC_5" :
							GetComputerCount.getComputerCount(iTestCaseRow);
							break;
						case "TC_6" :
							AddNewComputer.addNewComputerWithoutName(iTestCaseRow);
							break;
						case "TC_8" :
							AddNewComputer.addNewComputerWithWrongDate(iTestCaseRow);
							break;
						case "TC_10" :
							AddNewComputer.verifyHomeLink(iTestCaseRow);
							break;
						default :
							Logging.info("No such test case.");
							break;
						}
							
						//Checking whether test passed or failed
						if (BaseClass.bResult == true){
							ExcelUtils.setCellData("PASS", iTestCaseRow, Constant.colExecutionStatus);
						}
						else {
							throw new Exception("Test Case Failed because of Verification.");
						}
					
						//Closing the browser
						driver.quit();
					}
					else{
						Logging.info(sTestCaseName + " skipped.");
					}
				}
				catch (Exception e){
					ExcelUtils.setCellData("FAIL", iTestCaseRow, Constant.colExecutionStatus);
					Utils.takeScreenshot(driver, sTestCaseName);
					Logging.error(e.getMessage());
				}
			}
		}
		catch (Exception e){
			Logging.error(e.getMessage());
		}	
		finally{
			//Writing and closing excel all at once
			ExcelUtils.ExcelWorkBook.write(ExcelUtils.fileOut);
			ExcelUtils.fileOut.close();
		}
	}

@AfterMethod

	public void afterMethod(){
		Logging.endTestCase(sTestCaseName);
	}

}
