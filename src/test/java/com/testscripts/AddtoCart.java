package com.testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.text.Utilities;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.Skillrary.PomPages.AddCart;
import com.Skillrary.PomPages.SkillraryDemoLogin;
import com.Skillrary.PomPages.SkillraryLogin;
import com.Skillrary.genericlib.Baseclass;
import com.Skillrary.genericlib.FileUtilies;


public class AddtoCart extends Baseclass {
	
	@Test
	public void addingcourseTocart() throws SQLException, FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {
		test = reports.createTest("addingcourseTocart");
		utilies.switchtab(driver);
		utilies.mouseHover(driver, l.getCourseTab());
		AddCart c = l.clickCource();
		//c.addtocartBtn();
		//utilies.alert(driver);
		String query="select * from courseprice";
	String data = FileUtilies.queryexecution(query,1,"INR 0.00");
		utilies.verify(data,f.getPropertyData("price"),"price");
		
		f.compare(driver);
		
		
		
		
		
		}}











