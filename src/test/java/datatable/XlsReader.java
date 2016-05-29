package datatable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import jxl.Cell;
import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class XlsReader {

	public  String path;
	public  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;



	/*   
	 public Xls_Reader(String path) method specification :-

	 1)  Specify the path of the xls file and set a file input stream with the file.
	 2)  path -> Path of the xls file 
	 3)  FileInputStream -> To take input from specified xls file.

	 */

	public XlsReader(String path) 
	{
		this.path=path;
		try 
		{
			fis = new FileInputStream(path);
			fis.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 	
	}	


	/*   
	 public int getRowCount(String sheetName) method specification :-

	 1)  Return total number of rows in specified excel sheet.
	 2)  sheetName -> name of the excel sheet. 
	 3)  Workbook -> Refer to the whole xls file.
	 4)  Sheet -> Refer to an individual sheet within that workbook.
	 5)  sheet.getRows() -> returns total number of rows present within a particular sheet.

	 */

	public int getRowCount(String sheetName) throws JXLException, IOException 
	{
		File inputWorkbook = new File(path);
		Workbook w;
		w = Workbook.getWorkbook(inputWorkbook);
		Sheet sheet = w.getSheet(sheetName); 
		int row_count=0;
		for (int i = 0; i < sheet.getRows(); i++) 
		{
			row_count++;
		} 
		return row_count;
	}


	/*   
	 public String getCellData(String sheetName, int colNum,int rowNum) method specification :-

	 1)  Return cell data (string format) from specified excel sheet.
	 2)  sheetName -> name of the excel sheet. 
	 3)  colNum, rowNum -> column no. and row no. respectively within the sheet. 
	 4)  Workbook -> Refer to the whole xls file.
	 5)  Sheet -> Refer to an individual sheet within that workbook.
	 6)  sheet.getCell() -> Used to hold the control of a particular cell specified by colNum and rowNum.
	 7)  cell.getContents() -> return content of a cell.

	 */

	public String getCellData(String sheetName, int colNum,int rowNum) throws BiffException, IOException
	{
		File inputWorkbook = new File(path);
		Workbook w;
		w = Workbook.getWorkbook(inputWorkbook);
		Sheet sheet = w.getSheet(sheetName); 
		Cell cell = sheet.getCell(colNum, rowNum);
		return cell.getContents();
	}


	/*   
	 public String getCellData(String sheetName, String colName,int rowNum) method specification :-

	 1)  Return cell data (string format) from specified excel sheet.
	 2)  sheetName -> name of the excel sheet. 
	 3)  colName, rowNum -> column name and row no. respectively within the sheet. 
	 4)  Workbook -> Refer to the whole xls file.
	 5)  Sheet -> Refer to an individual sheet within that workbook.
	 6)  sheet.getCell() -> Used to hold the control of a particular cell specified by colNum and rowNum.
	 7)  cell.getContents() -> return content of a cell.

	 */

	public String getCellData(String sheetName, String colName,int rowNum) throws BiffException, IOException
	{
		File inputWorkbook = new File(path);
		Workbook w;
		w = Workbook.getWorkbook(inputWorkbook);
		Sheet sheet = w.getSheet(sheetName);
		int i=0;
		int colNum; 

		for(i=0; i<sheet.getColumns(); i++)
		{	
			if(sheet.getCell(i, 0).getContents().equals(colName))
			{
				break;
			}
		}

		colNum=i;

		Cell cell = sheet.getCell(colNum, rowNum);
		return cell.getContents();
	}



	
	/*   
	 public String getFirstSheetname() method specification :-

	 1) Returns first sheet name  from specified excel sheet
	 2) Workbook -> Refer to the whole xls workbook file
	 3) Workbook.getWorkbook(<xls workbook file>) -> Load the xls workbook flie
	 4) w.getSheet(0).getName() -> Give the first sheet name

	 */
	
	public String getFirstSheetname() throws BiffException, IOException
	{

		File inputWorkbook = new File(path);
		Workbook w;
		w = Workbook.getWorkbook(inputWorkbook);
		String  sheet = w.getSheet(0).getName();
		return sheet;
		
	}

}
