package com.testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.Skillrary.PomPages.Profile;
import com.Skillrary.PomPages.SkillraryDemoLogin;
import com.Skillrary.PomPages.SkillraryLogin;
import com.Skillrary.PomPages.UpdateProfile;
import com.Skillrary.genericlib.Autoconstant;
import com.Skillrary.genericlib.Baseclass;

public class UpdateProffile extends Baseclass{
@Test
public void updateProfile() throws FileNotFoundException, IOException {
	test=reports.createTest("updateProfile");

	utilies.switchtab(driver);
	l.logincredentail(utilies.getPropertyData("email"),utilies.getPropertyData("password"));
	Profile p1=new Profile(driver);
	UpdateProfile u = p1.editProfile();
	u.firstname(utilies.getPropertyData("name"));
	//utilies.dropDown(u.getAddressdd(),utilies.getPropertyData("addresstb"));
	utilies.fileupload(Autoconstant.profilephoto);
	u.curentpasswordt(utilies.getPropertyData("cpassword"));
	
	
}
}
