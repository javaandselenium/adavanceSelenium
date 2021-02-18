package com.Skillrary.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.mysql.cj.jdbc.Driver;

public class FileUtilies {
	public static Connection con;
	public FileInputStream fin;
	public FileOutputStream fout;
	public Sheet sh;
	public Workbook wb;
	public Row row;
	public Cell cell;
	/**
	 * To read the data from propertyfile
	 * 
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public  String getPropertyData(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileInputStream(Autoconstant.propertyFilepath));
		return p.getProperty(key);
	}
	
	/**
	 * To readthe data from excel sheet
	 * 
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InvalidFormatException 
	 */

	public String getExcelreadData(String sheetname, int rownum, int cellnum)
			throws EncryptedDocumentException, IOException, InvalidFormatException {
	 fin = new FileInputStream(Autoconstant.excelFilepath);
		 wb = WorkbookFactory.create(fin);
		  sh = wb.getSheet(sheetname);
		 row = sh.getRow(rownum);
		 cell = row.getCell(cellnum);
		return cell.getStringCellValue();

	}
	public void writedataexcel(int rownum,int cellnum,String data) throws IOException {
		row=sh.getRow(rownum);
		cell=row.getCell(cellnum);
		cell.setCellValue(data);
		fout=new FileOutputStream(Autoconstant.excelFilepath);
		wb.write(fout);
	}
	
	public String compare(WebDriver driver) throws IOException, EncryptedDocumentException, InvalidFormatException {
		
//		System.out.println(rownum);
//		for(int i=1;i<=rownum;i++) {
			 String title = getExcelreadData("Sheet1",1,0);
			String srtitle = driver.getTitle();
			System.out.println(srtitle);
		writedataexcel(1,1,srtitle);
		
		if(title.equals(srtitle)) {
			writedataexcel(1,2,"PASS");
		}
		else
		{
			writedataexcel(1,2,"FAIL");
		}
		return srtitle;
		
	}
	/**
	 * To validate the data from excel
	 * @return
	 * @throws SQLException
	 */
	
	public static Connection getDataDb() throws SQLException {
		Driver driveref=new Driver();
		DriverManager.registerDriver(driveref);
	 return con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skillrary","root","root");
	}
	
	public static String queryexecution(String query,int column,String Exceptedata) throws SQLException {
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		while(result.next()) {
			if(result.getString(column).equals(Exceptedata))
			{
			break;	
			}
			else
			{
				Reporter.log("data not matching",true);
			}
		}
		return Exceptedata;
	}
	
	public static void closedb() throws SQLException {
		con.close();
	}
	
	
	
	
	
	
	
	
	
	

}
