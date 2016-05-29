package testscripts;

import java.io.IOException;
import java.sql.SQLException;

import jxl.read.biff.BiffException;
import testcases.VerifyLoginPage;
import testcases.VerifyProfileData;
import testcases.VerifySignUpPage;


public class Keywords extends DriverScript{

	// Navigate to Facebook page
	public static String verifyElements() throws InterruptedException,
	IOException, BiffException, SQLException {

		return VerifyLoginPage.verifyElements();

	}

	// Navigate and login to Facebook page
	public static String verifyUserDetailsOnFacebookPage() throws InterruptedException,
	IOException, BiffException {

		return VerifyLoginPage.verifyUserDetailsOnFacebookPage();

	}

	//Verify Sign-Up Page Elements
	public static String verifySignUpPageElements() throws InterruptedException,
	IOException, BiffException  {
		return VerifySignUpPage.verifySignUpPageElements();
	}

	//Sign Up for Facebook
	public static String signUpForFacebook()throws InterruptedException,
	IOException, BiffException  {

		return VerifySignUpPage.signUpForFacebook();

	}

	//Verify the User loggged on for first timeSign in Facebook

	public static String verifySignUpNewUser() throws InterruptedException,
	IOException, BiffException  {

		return VerifyProfileData.verifySignUpNewUser();

	}

	//Verify the User and the page elements displayed for a user
	//loggged on for first timeSign in Facebook
	public static String verifyElementsNewUserAfterLogin() throws BiffException, IOException, InterruptedException{
		
		return VerifyProfileData.verifyElementsNewUserAfterLogin();
				
	}

}
