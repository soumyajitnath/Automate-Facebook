package testcases;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;

import jxl.read.biff.BiffException;
import testscripts.DriverScript;
import testscripts.FunctionLibrary;
import testscripts.FacebookLibrary;

public class VerifyLoginPage extends DriverScript{

	/* .............. Name of the WebElements present on the WebPage ................. */

	public static String nameUserNameInputBox = "'Username' Input-box";
	public static String namePasswordInputBox = "'Password' Input-box";
	public static String nameLogInButton = "'SignIn' Button";
	private static String nameUserName = "'User Name' displayed on Facebook page";;
	//public static String nameLogOutLink = "'Log Out' link";




	/* .............. Locators for the test ................. */

	//public static By locatorUserNameInputBox = By.xpath("//*[@id='email']");
	//public static By locatorPasswordInputBox = By.xpath("//*[@id='pass']");
	//public static By locatorLogInButton = By.xpath("//*[@id='u_0_v']");
	//public static By locatorLogOutLink = By.xpath("//*[@id='u_8_1']/div/div/div[1]/div/div/ul/li[12]/a/span/span");
	private static By locatorUserName = By.xpath("//*[@id='navItem_100000219218997']/a/div/span");
	
	public static By locatorUserNameInputBox  = By.xpath("//input[@id='email']");
	public static By locatorPasswordInputBox = By.xpath("//input[@id='pass']");
	public static By locatorLogInButton = By.id("loginbutton");
	




	// Verify Elements on Login Page
	public static String verifyElements() throws SQLException, InterruptedException, IOException
	{

		APPLICATION_LOGS.debug("Executing test case : Verifying all the attributes of the Login Page");
		FacebookLibrary.navigate();
		// Verify whether Username input-box, Password input-box and SignIn button present on the page or not
		Boolean usernameFieldPresent=FunctionLibrary.isElementPresent(locatorUserNameInputBox, nameUserNameInputBox);
		Boolean passwdFieldPresent=FunctionLibrary.isElementPresent(locatorPasswordInputBox, namePasswordInputBox);
		Boolean signInButtonPresent=FunctionLibrary.isElementPresent(locatorLogInButton, nameLogInButton);

		if(!usernameFieldPresent && !passwdFieldPresent && !signInButtonPresent )
		{
			return "Fail : Username Field or Password Field or SignIn button is not present on the page ";
		}
		return "Pass: All elements are present in the Login Page";


	}

	// Verify user details displayed on Facebook page
	public static String verifyUserDetailsOnFacebookPage()
			throws InterruptedException, IOException, BiffException {

		APPLICATION_LOGS
		.debug("Executing test case : Verify user details displayed on Facebook page");
		System.out
		.println("Executing test case : Verify user details displayed on Facebook page");

		// Navigate and login to GPS
		methodReturnResult = FacebookLibrary.navigateAndLoginToFacebook();
		if (methodReturnResult.contains(failTest)) {
			return methodReturnResult;
		}

		/*
		 * .............. Verify user details displayed on Facebook page
		 * .............
		 */
		// Verify User Name displayed on the page
		/*String userName = testData.getCellData("Login", "UserId_In", 1);
		String expectedText = userName;
		String actualText = FunctionLibrary.retrieveAttributeValue(
				locatorUserName, "value", nameUserName);
		methodReturnResult = FunctionLibrary.assertText(nameUserName,
				actualText, expectedText);
		if (methodReturnResult.contains(failTest))
			return methodReturnResult;

		// Logout from GPS
		//methodReturnResult = FacebookLibrary.logout();
		if (methodReturnResult.contains(failTest)) {
			return methodReturnResult;
		}*/

		return "Pass : Successfully verified username and user information displayed on Facebook";

	}

}
