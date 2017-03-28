package utilities;

public class Constant {
	public static final String URL = "http://computer-database.herokuapp.com/computers";
	public static final String pathTestData = System.getProperty("user.dir")+"\\src\\testCases\\";
	public static final String fileTestData = "TestCase.xlsx";
	public static final String pathScreenShots = System.getProperty("user.dir")+"\\src\\results\\Screenshots\\";
	
	//Test Data Sheet Columns
	public static final int colExecutionFlag = 0;
	public static final int colTestCaseID = 1;
	public static final int colExecutionStatus = 3;
	public static final int colComputerName = 4;
	public static final int colIntroducedDate = 5;
	public static final int colDiscontinuedDate = 6;
	public static final int colCompany = 7;
}
