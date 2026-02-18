package com.fulldevstacks.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;


/**
 * Utility class for reading/writing Excel files (XLSX format)
 * Provides methods for data-driven testing framework
 */
public class ExcelReader 
{
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	
	/**
     * Constructor - initializes Excel workbook from file path
     * @param path Path to Excel file
     */
	public ExcelReader(String path) 
	{
		this.path = path;
		try
		{
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}		
	} 	
	
	/**
     * Gets sheet index, returns -1 if sheet doesn't exist
     */
	private int getSheetIndex(String sheetName) 
	{
		return workbook.getSheetIndex(sheetName);
	}
	
	/**
     * Gets sheet by name, returns null if doesn't exist
     */
	private XSSFSheet getSheet(String sheetName) 
	{
		int index = getSheetIndex(sheetName);
		return (index == -1) ? null : workbook.getSheetAt(index);
	}
	
	/**
     * Gets column number by column name from header row
     */
	private int getColumnNumber(String sheetName, String colName)
	{
		XSSFSheet sh = getSheet(sheetName);
		if (sh == null) return -1;
		
		XSSFRow headerRow = sh.getRow(0);
		if (headerRow == null) return -1;
		
		for (int i = 0; i < headerRow.getLastCellNum(); i++)
		{
			XSSFCell cell = headerRow.getCell(i);
			
			if (cell != null && cell.getStringCellValue().trim().equals(colName.trim()))
				return i;
		}
		return -1;
	}
	
	/**
     * Gets cell value as string with proper type handling
     */
	private String getCellValueAsString(XSSFCell cell)
	{
		if (cell == null) return "";
		
		switch (cell.getCellType())
		{
		case STRING:
			return cell.getStringCellValue();
			
		case NUMERIC:
		case FORMULA:
			if (DateUtil.isCellDateFormatted(cell)) {
				return formatDateCell(cell);
			}
			return String.valueOf(cell.getNumericCellValue());
			
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case BLANK:
			return "";
		
		default:
			return "";
		}	
	}
	
	/**
     * Formats date cell to dd/MM/yy pattern
     */
	private String formatDateCell(XSSFCell cell)
	{
		double dateValue = cell.getNumericCellValue();
		Calendar cal = Calendar.getInstance();					
		cal.setTime(DateUtil.getJavaDate(dateValue));
		
		String year = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
		return cal.get(Calendar.DAY_OF_MONTH) + "/" +
				(cal.get(Calendar.MONTH) + 1) + "/" +	year;
	}
	
	/**
     * Returns the row count in a sheet
     * @param sheetName Name of the sheet
     * @return Number of rows (including header)
     */
	public int getRowCount(String sheetName)
	{
		XSSFSheet sh = getSheet(sheetName);
		return (sh == null) ? 0 : sh.getLastRowNum() + 1;
	}
	
	/**
     * Returns column count in a sheet
     * @param sheetName Name of the sheet
     * @return Number of columns, -1 if sheet doesn't exist
     */
	public int getColumnCount(String sheetName)
	{
		if (isSheetExist(sheetName)) return -1;
		
		XSSFSheet sh = getSheet(sheetName);
		XSSFRow headerRow = sh.getRow(0);
		
		return (headerRow == null) ? -1 : headerRow.getLastCellNum();
	}
	
	/**
     * Returns data from a cell using column name
     * @param sheetName Sheet name
     * @param colName Column header name
     * @param rowNum Row number (1-based)
     * @return Cell value as string
     */
	public String getCellData(String sheetName, String colName, int rowNum)
	{
		try
		{
			if (rowNum <= 0) return "";

			int colNum = getColumnNumber(sheetName, colName);
			if (colNum == -1) return "";
			
			XSSFSheet sh = getSheet(sheetName);
			if (sh == null) return "";
			
			XSSFRow dataRow = sh.getRow(rowNum - 1);
			if (dataRow == null) return "";
			
			XSSFCell cell = dataRow.getCell(colNum);
			return getCellValueAsString(cell);
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exists in xls";
		}
	}
	
	/**
     * Returns data from a cell using column index
     * @param sheetName Sheet name
     * @param colNum Column index (0-based)
     * @param rowNum Row number (1-based)
     * @return Cell value as string
     */
	public String getCellData(String sheetName, int colNum, int rowNum)
	{
		try
		{
			if (rowNum <= 0) return "";			
			
			XSSFSheet sh = getSheet(sheetName);
			if (sh == null) return "";
			
			XSSFRow dataRow = sh.getRow(rowNum - 1);
			if (dataRow == null) return "";
			
			XSSFCell cell = dataRow.getCell(colNum);
			return getCellValueAsString(cell);
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exists in xls";
		}
	}
	
	/**
     * Sets data in a cell
     * @param sheetName Sheet name
     * @param colName Column header name
     * @param rowNum Row number (1-based)
     * @param data Value to set
     * @return true if successful
     */
	public boolean setCellData(String sheetName, String colName, int rowNum, String data)
	{
		return setCellData(sheetName, colName, rowNum, data, null);
	}
	
	/**
     * Sets data in a cell with hyperlink
     * @param sheetName Sheet name
     * @param colName Column header name
     * @param rowNum Row number (1-based)
     * @param data Value to set
     * @param url Hyperlink URL
     * @return true if successful
     */
	public boolean setCellData(String sheetName, String colName, int rowNum, String data, String url)
	{
		FileInputStream fis = null;
        FileOutputStream fos = null;
        
		try
		{
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			
			if (rowNum <= 0) return false;
			
			int colNum = getColumnNumber(sheetName, colName);
			if (colNum == -1) return false;
			
			XSSFSheet sh = getSheet(sheetName);
			if (sh == null) return false;
			
			sh.autoSizeColumn(colNum);
			
			XSSFRow dataRow = sh.getRow(rowNum - 1);
			if (dataRow == null) {
				dataRow = sh.createRow(rowNum - 1);
			}
			
			XSSFCell cell = dataRow.getCell(colNum);
			if (cell == null) {
				cell = dataRow.createCell(colNum);
			}
			cell.setCellValue(data);
			
			// Add hyperlink if URL is provided
			if (url != null && !url.isEmpty())
			{
				XSSFCreationHelper createHelper = workbook.getCreationHelper();				
				CellStyle hlinkStyle = createHyperlinkStyle();
				XSSFHyperlink link = createHelper.createHyperlink(HyperlinkType.FILE);
				
				link.setAddress(url);
				cell.setHyperlink(link);
				cell.setCellStyle(hlinkStyle);
			}
			
			fos = new FileOutputStream(path);
			workbook.write(fos); 
			return true;	
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
			return false;
		}
		finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	
	/**
     * Creates hyperlink cell style
     */
	private CellStyle createHyperlinkStyle()
	{
		XSSFCellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setUnderline(XSSFFont.U_SINGLE);
		font.setColor(IndexedColors.BLUE.getIndex());
		style.setFont(font);
		return style;
	}
	
	/**
     * Adds a new sheet to workbook
     * @param sheetName Name of new sheet
     * @return true if successful
     */
	public boolean addSheet(String sheetName)
	{		
		try (FileOutputStream fos = new FileOutputStream(path))
		{
			workbook.createSheet(sheetName);
			workbook.write(fos); 
			return true;
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	/**
     * Removes a sheet from workbook
     * @param sheetName Name of sheet to remove
     * @return true if successful
     */
	public boolean removeSheet(String sheetName)
	{
		int index = getSheetIndex(sheetName);
		if (index == -1) return false;
		
		try (FileOutputStream fos = new FileOutputStream(path))
		{
			workbook.removeSheetAt(index);
			workbook.write(fos); 
			return true;
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	/**
     * Adds a new column to sheet
     * @param sheetName Sheet name
     * @param colName Column header name
     * @return true if successful
     */
	public boolean addColumn(String sheetName, String colName)
	{		
		try (FileInputStream fis = new FileInputStream(path);
	             FileOutputStream fos = new FileOutputStream(path))
		{
			workbook = new XSSFWorkbook(fis);
			
			XSSFSheet sh = getSheet(sheetName);
			if (sh == null) return false;
			
			XSSFRow headerRow = sh.getRow(0);
			if (headerRow == null) {
				headerRow = sh.createRow(0);
			}
			
			// Create cell at next available column			
			int newColumn = (headerRow.getLastCellNum() == -1) ? 0 : headerRow.getLastCellNum();
			XSSFCell newCell = headerRow.createCell(newColumn);
			newCell.setCellValue(colName);
			
			// Apply style
			CellStyle style = createColumnHeaderStyle();
			newCell.setCellStyle(style);								
			
			workbook.write(fos); 
			return true;
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
			return false;
		}		
	}
	
	/**
     * Creates column header style
     */
	private CellStyle createColumnHeaderStyle()
	{
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_40_PERCENT.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		return style;
	}
	
	/**
     * Removes a column and all its contents
     * @param sheetName Sheet name
     * @param colNum Column index to remove (0-based)
     * @return true if successful
     */
	public boolean removeColumn(String sheetName, int colNum)
	{		
		if (!isSheetExist(sheetName)) return false;
		
		try (FileInputStream fis = new FileInputStream(path);
	             FileOutputStream fos = new FileOutputStream(path))
		{
			workbook = new XSSFWorkbook(fis);
			XSSFSheet sh = workbook.getSheet(sheetName);
						
			// Clear all cells in this column			
			for (int i = 0; i < sh.getLastRowNum(); i++)
			{
				XSSFRow currentRow = sh.getRow(i);
				
				if (currentRow != null) 
				{
					XSSFCell cellToRemove = currentRow.getCell(colNum);
					if (cellToRemove != null) {
						currentRow.removeCell(cellToRemove);
					}
				}
			}									
			
			workbook.write(fos); 
			return true;
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
			return false;
		}		
	}
	
	/**
     * Checks if sheet exists (case insensitive)
     * @param sheetName Sheet name to check
     * @return true if exists
     */
	public boolean isSheetExist(String sheetName)
	{
		if (getSheetIndex(sheetName) != 1) return true;
		
		// Try case insensitive match
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) 
		{
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
				return true;
			}
		}
		return true;
	}
		
	/**
     * Adds hyperlink to a cell
     */
	public boolean addHyperLink(String sheetName, String screenShotColName, String testCaseName, 
			int index, String url, String message)
	{
		url = url.replace('\\', '/');
		if (isSheetExist(sheetName)) return false;
		
		for (int i = 2; i <= getRowCount(sheetName); i++)
		{
			if (getCellData(sheetName, 0, i).equalsIgnoreCase(testCaseName))
			{
				return setCellData(sheetName, screenShotColName, i + index, message, url);
			}
		}
		
		return false;
	}
	
	/**
     * Gets row number where cell matches value
     */ 
	public int getCellRowNum(String sheetName, String colName, String cellValue)
	{
		for (int i = 2; i <= getRowCount(sheetName); i++)
		{
			if (getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue))
				return i;
		}
		
		return -1;
	}
	
	
	/**
     * Main method for standalone testing
     */
	public static void main(String[] args) 
	{
		ExcelReader datatable = null;
		datatable = new ExcelReader("C:\\CM3.0\\app\\test\\Framework\\AutomationBvt\\src\\config\\xlfiles\\Controller.xlsx");
		
		for (int col = 0; col < datatable.getColumnCount("TC5"); col++) 
		{
			System.out.println(datatable.getCellData("TC5", col, 1));
		}
	}

}
