package com.testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Skillrary.PomPages.JavaTraining;
import com.Skillrary.PomPages.Selenium;
import com.Skillrary.PomPages.SkillraryLogin;
import com.Skillrary.genericlib.Baseclass;

public class TakeingCourse extends Baseclass {
	@Test
	public void takecourse() throws FileNotFoundException, IOException, InterruptedException {
	test=reports.createTest("takeingCourse");
	SkillraryLogin l=new SkillraryLogin(driver);
	Selenium s = l.serachForCourse( utilies.getPropertyData("coursename"));
	JavaTraining c = s.corejavacourse();
    utilies.switchFrame(driver);
     c.playVideo();
     utilies.switchbackframe(driver);
     c.takeCouseBtn();
     Assert.assertTrue(false);

}}
