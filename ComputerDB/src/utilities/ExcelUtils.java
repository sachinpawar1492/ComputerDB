package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class ExcelUtils {
	public static XSSFWorkbook ExcelWorkBook;
	public static XSSFSheet ExcelWorkSheet;
	public static XSSFCell Cell;
	public static XSSFRow Row;
	public static FileOutputStream fileOut;
	
	/**
	 * This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	 * @param excelPath : Path of an Excel
	 * @param excelSheetName : Name of the Excel Sheet
	 * @throws Exception throws exception if there is any problem getting excel file from inputstream.
	 */
	public static void setExcelFile(String excelPath, String excelSheetName) throws Exception{
		try{
			//Open The Excel File
			FileInputStream ExcelFile = new FileInputStream(excelPath);
			
			//Access the required test data sheet
			ExcelWorkBook = new XSSFWorkbook(ExcelFile);
			ExcelWorkSheet = ExcelWorkBook.getSheet(excelSheetName);
			
			Logging.info("Excel sheet has been opened !");
		}  
		catch (Exception e){
			throw (e);
		}
	}
	
    /**
     * This method is to read the test data from the Excel cell
     * @param RowNum : Row number a excel cell from which data needs to be picked up
     * @param ColNum : Column number a excel cell from which data needs to be picked up
     * @return : blank
     * @throws Exception : Throws exception if any issue comes while getting data from Excel
     */
    public static String getCellData(int RowNum, int ColNum) throws Exception{
    	try{
    		Cell = ExcelWorkSheet.getRow(RowNum).getCell(ColNum);
    		String CellData = Cell.getStringCellValue();

    		return CellData;
    	}
    	catch (Exception e) {
                return "";
    	}
    }


    @SuppressWarnings("static-access")

    /**
     * This method is to write in the Excel cell
     * @param Result : Data which needs to be write in Excel
     * @param RowNum : Row number a excel cell in which data needs to be writen
     * @param ColNum : Column number a excel cell in which data needs to be writen
     * @throws Exception : Throws exception if any issue comes while setting data into Excel
     */
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
    	try{    		
    		Row  = ExcelWorkSheet.getRow(RowNum);
            Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
            if (Cell == null) {
                Cell = Row.createCell(ColNum);
                Cell.setCellValue(Result);
            }
            else {
            	Cell.setCellValue(Result);
            }

            //Constant variables Test Data path and Test Data file name
            fileOut = new FileOutputStream(Constant.pathTestData + Constant.fileTestData);
    	}
    	catch(Exception e){
    		throw (e);
    	}
    }

	/**
	 * This method will give a row number based on a test case name
	 * @param sTestCaseName : Name of the test case
	 * @param colNum : Column number from which data need to be picked up
	 * @return iCounter : Row number of expected data 
	 * @throws Exception : Throws exception if any error comes while getting row number
	 */
	public static int getRowContains(String sTestCaseName, int colNum) throws Exception{
		int iCounter;

		try {
			int rowCount = ExcelUtils.getRowUsed();
			
			for (iCounter=0 ; iCounter<=rowCount; iCounter++){
				if (ExcelUtils.getCellData(iCounter,colNum).equalsIgnoreCase(sTestCaseName)){
					break;
				}
			}

			return iCounter;
		}
		catch (Exception e){
			Logging.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());

			throw(e);
		}
	}

	/**
	 * This method gives the used rows count of an Excel
	 * @return : Returns row count of a excel
	 * @throws Exception : Throws exception if any error comes while getting used rows
	 */
	public static int getRowUsed() throws Exception {
		try{
			int RowCount = ExcelWorkSheet.getLastRowNum();
			
			Logging.info("Total number of Row used return as :" + RowCount + ".");		

			return RowCount;
		}
		catch (Exception e){
			Logging.error("Class ExcelUtil | Method getRowUsed | Exception desc : "+e.getMessage());

			System.out.println(e.getMessage());

			throw (e);
		}
	}
}
