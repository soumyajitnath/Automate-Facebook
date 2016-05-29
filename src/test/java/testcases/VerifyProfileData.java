package testcases;

import java.io.IOException;

import org.openqa.selenium.By;

import jxl.read.biff.BiffException;
import testscripts.DriverScript;
import testscripts.FacebookLibrary;
import testscripts.FunctionLibrary;

public class VerifyProfileData extends DriverScript {

	//Page Titles
	public static String userName;
	public static String pageTitlenewUserLoginforfirstTime = "Facebook";

	public static String messageOnWelcomeDashBoard = "Search your email "
			+ "for friends already on Facebook";
	public static String expectedEmailId;
	//take from Excelsheet"soumyajitnath09@gmail.com";

	/* .............. Name of the WebElements present on the WebPage ................. */

	public static String emailIdBox = "'EmailId' Input-box ";

	public static String nameUserName = "'User Name' displayed on Profile after Login";
	
	public static String nameMessageIcon = "'Message' Icon";
	public static String nameConfirmNowButton = "'Confirm Now' Button";;
	public static String nameReSendEmailLink = "'Re-send email' Link";
	public static String nameEnterCodeLink = "'Enter code:' Link";
	public static String nameChangeEmailAddress = "'Change email address' Link";
	public static String nameEmailAddress = "'Your Email Address' Text";
	public static String nameConnectToGmailButton ="'ConnectToGmail' Button";

	public static String nameWelcomeMessage = "'Welcome Message'";
	public static String nameWelcomeDashBoardFirstHeaderText = "'Welcome DashBoard First Header' Text";

	public static String nameEmailInputbox = "'Email' Input-box";
	public static String nameFindFriendsButton = "'Find Friends' Button";
	public static String nameWelcomeDashBoardSecondHeaderText = "'Welcome DashBoard Second Header' Text";
	public static String nameTakeAPrivacyTourButton = "'Take A Privacy Tour' Button";
	public static String nameWelcomeDashBoardThirdHeaderText = "'Welcome DashBoard Third Header' Text";
	public static String nameAddPhotoImage = "'Add Photo' Image";
	public static String nameTakeAPhoto = "'Take a photo' Link";
	public static String nameAddPictureButton = "'Add Picture' Button";
	public static String nameFindPeopleYouKnowLink = "'Find people you know' Link";
	public static String nameEnterANameOrEmail = "'Enter a name or email' Input-box";
	public static String nameSearchFriendsButton = "'Search Friends' Button";


	/* .............. Locators for the test ................. */
	public static By locatorUserName = By
			.xpath("//div[@id='u_0_1']//div/a/span");
	public static By locatorMessageforNewUser = By
			.xpath("//div[@id='yellowbanner']/div/table/tbody/tr/td[2]/span");
	public static By locatorMessageIcon = By
			.xpath("//div[@id='yellowbanner']/div/table/tbody/tr/td[1]/i");
	public static By locatorConfirmNowButton = By
			.xpath("//input[starts-with(@value,'Confirm Now')]");
	public static By locatorReSendEmailLink = By
			.linkText("Re-send email");
	/*.xpath("//a[text()='Re-send email']");*/
	public static By locatorEnterCodeLink = By
			.linkText("Enter code:");
	public static By locatorChangeEmailAddress = By
			.linkText("Change email address");
	public static By locatorEmailAddress = By
			.xpath("//form[@id='u_0_0_ci_form']/table/tbody/tr[2]/td/div[1]/strong");
	public static By locatorConnectToGmailButton = By
			.xpath("//*[@id='confirm_center']/div/div[3]/div/div[1]/button");

	public static By locatorWelcomeMessage = By
			.xpath("//*[@id='pagelet_welcome']/div/div/div[2]/h2");
	public static By locatorWelcomeDashBoardFirstHeaderText = By
			.xpath("//*[@id='welcome_dashboard']/li[1]/div/h3");
	//.cssSelector("h3:contains("Search your email for friends already on Facebook")");
	public static By locatorEmailInputbox = By.name("login_str");
			
	//use retrieveAttributeValue actual emailId =soumyajitnath09@gmail.com"/>
	public static By locatorFindFriendsButton = By
			.xpath("//button[text()='Find Friends']");
	public static By locatorWelcomeDashBoardSecondHeaderText = By
			.xpath("//*[@id='welcome_dashboard']/li[2]/div/h3");
	public static By locatorTakeAPrivacyTourButton = By
			.xpath("//*[@id='welcome_dashboard']/li[2]/div/div/div/a");
	public static By locatorWelcomeDashBoardThirdHeaderText = By
			.xpath("//*[@id='welcome_dashboard']/li[3]/div/h3");
	public static By locatorAddPhotoImage = By
			.xpath("img[contains(@src,'/images/wizard/add-photo-male.png')]");
	public static By locatorTakeAPhoto = By
			.linkText("Take a photo");
	public static By locatorAddPictureButton = By
			.id("js_0");
	public static By locatorFindPeopleYouKnowLink = By
			.linkText("Find people you know");
	public static By locatorEnterANameOrEmail = By
			.xpath("//input[contains(@title,'Enter a name or email')]");
	public static By locatorSearchFriendsButton = By
			.xpath("//*[@id='findfriends_search']/label/span");

	//Verify the user just logged in for the first time
	//and also verify the other page elements

	/*public static String verifySignUpNewUser() throws BiffException,
	IOException, InterruptedException{

		APPLICATION_LOGS.debug("Executing test case : "
				+ "Verifying UserName is getting displayed on Profile Page"
				+ "after User has Logged in for first Time...");


			//Verify the title of page
			//expectedTitle = pageTitlenewUserLoginforfirstTime;
			//methodReturnResult = FunctionLibrary.assertTitle(expectedTitle);

			/*if (methodReturnResult.contains(failTest)) {

				// Log result
				APPLICATION_LOGS.debug("Not navigated to the "+pageTitlenewUserLoginforfirstTime+" page");
				//System.err.println("Not navigated to the "+pageTitlenewUserLoginforfirstTime+" page");
				return methodReturnResult;

			}

		    FunctionLibrary.waitForPageToLoad();

			userName = testData.getCellData("Login", "UserName", 4);
			expectedEmailId = testData.getCellData("Sign up for Facebook", "EmailOrMobileNo_In", 4);

			APPLICATION_LOGS
			.debug("Successfully Retrieved data from Xls File :-  Username : "
					+ userName );
			APPLICATION_LOGS
			.debug("Successfully Retrieved data from Xls File :-  Username : "
					+ expectedEmailId );

			//Get the Actual User Name from AUT
			String actualUserName = FunctionLibrary.retrieveText(locatorUserName, nameUserName);

			//Compare the Actual UserName with Expected UserName
			methodReturnResult = FunctionLibrary.assertText(nameUserName, actualUserName, userName);

			if(methodReturnResult.contains(failTest)){
				return methodReturnResult;
			}

			return "Pass : "+ userName + "displayed on Profile after User"
					+ " logs into Facebook for firsttime";


	}*/

	public static String verifySignUpNewUser() throws BiffException,
	IOException, InterruptedException{

		try{
			
			APPLICATION_LOGS.debug("Executing test case : "
					+ "Verifying UserName is getting displayed on Profile Page"
					+ "after User has Logged in for first Time...");

			// Navigate to GPS
			methodReturnResult = FacebookLibrary.navigate();
			if (methodReturnResult.contains(failTest)) {
				return methodReturnResult;
			}

			// Login to Facebook
			methodReturnResult = FacebookLibrary.login(5);
			if (methodReturnResult.contains(failTest)) {
				return methodReturnResult;
			}


			//Verify the title of page
			//expectedTitle = pageTitlenewUserLoginforfirstTime;
			//methodReturnResult = FunctionLibrary.assertTitle(expectedTitle);

			/*if (methodReturnResult.contains(failTest)) {

					// Log result
					APPLICATION_LOGS.debug("Not navigated to the "+pageTitlenewUserLoginforfirstTime+" page");
					//System.err.println("Not navigated to the "+pageTitlenewUserLoginforfirstTime+" page");
					return methodReturnResult;

				}*/

			FunctionLibrary.waitForPageToLoad();
			
			//Verify Username 
			userName = testData.getCellData("Login", "UserName", 5);
			expectedEmailId = testData.getCellData("Sign up for Facebook", "EmailOrMobileNo_In", 4);

			APPLICATION_LOGS
			.debug("Successfully Retrieved data from Xls File :-  Username : "
					+ userName );
			APPLICATION_LOGS
			.debug("Successfully Retrieved data from Xls File :-  EmailId : "
					+ expectedEmailId );

			//Get the Actual User Name from AUT
			String actualUserName = FunctionLibrary.retrieveText(locatorUserName, nameUserName);

			//Compare the Actual UserName with Expected UserName
			methodReturnResult = FunctionLibrary.assertText(nameUserName, actualUserName, userName);

			if(methodReturnResult.contains(failTest)){
				return methodReturnResult;
			}
			
		}
		catch(Throwable e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		

		return "Pass : "+ userName + "displayed on Profile after User"
		+ " logs into Facebook for firsttime";
		//return "Pass : ";


	}
	
	//Verify the page elements displayed only for a user logged in for first time
	
	public static String verifyElementsNewUserAfterLogin() throws BiffException,
	IOException, InterruptedException{

		APPLICATION_LOGS.debug("Executing test case : "
				+ "Verifying all the page elemenst getting displayed on Profile Page"
				+ "after User has Logged in for first Time...");
		
		methodReturnResult = VerifyProfileData.verifySignUpNewUser();
		if(methodReturnResult.contains(failTest)){
			return methodReturnResult;
		}
		
		APPLICATION_LOGS.debug(methodReturnResult);
		
		userName = testData.getCellData("Login", "UserName", 5);
		expectedEmailId = testData.getCellData("Sign up for Facebook", "EmailOrMobileNo_In", 4);

		APPLICATION_LOGS
		.debug("Successfully Retrieved data from Xls File :-  Username : "
				+ userName );
		APPLICATION_LOGS
		.debug("Successfully Retrieved data from Xls File :-  EmailId : "
				+ expectedEmailId );
		
		//Verify the expected message on yellow banner 
		String nameMessageforNewUser = userName + ", go to "+ expectedEmailId +" to complete the sign-up process.";
		String expectedMessage = nameMessageforNewUser;
		String actualMessage = FunctionLibrary.retrieveText(locatorMessageforNewUser, nameMessageforNewUser);
		
		methodReturnResult = FunctionLibrary.assertText(nameMessageforNewUser, actualMessage, expectedMessage);
		if(methodReturnResult.contains(failTest)){
			return methodReturnResult;
		}
		
		//Verify the MessageIcon
		Boolean messageIconPresent = FunctionLibrary.isElementPresent(locatorMessageIcon, nameMessageIcon);
		if(!messageIconPresent){
			return "Fail : Message Icon is not displayed on the Profile"
					+ " after User has Logged in for first Time";
		}
		//Verify the ConfirmNow button
		Boolean confirmNowButtonPresent = FunctionLibrary.isElementPresent(locatorConfirmNowButton, nameConfirmNowButton);
		if(!confirmNowButtonPresent){
			return "Fail : Message Icon is not displayed on the Profile"
					+ " after User has Logged in for first Time";
		}
		//Verify the Re-send Email Link
		Boolean reSendEmailLinkPresent = FunctionLibrary.isElementPresent(locatorReSendEmailLink, nameReSendEmailLink);
		if(!reSendEmailLinkPresent){
			return "Fail : Re-send Email Link is not displayed on the Confirm Now Page";
		}
		
		//Verify the 'Enter Code :' link
		Boolean enterCodeLinkPresent = FunctionLibrary.isElementPresent(locatorEnterCodeLink, nameEnterCodeLink);
		if(!enterCodeLinkPresent){
			return "Fail : 'Enter Code :' Link is not displayed on the Confirm Now page";
		}
		
		//Verify Change email address link
		Boolean changeEmailAddressLinkPresent = FunctionLibrary.isElementPresent(locatorChangeEmailAddress, nameChangeEmailAddress);
		if(!changeEmailAddressLinkPresent){
			return "Fail : 'Enter Code :' Link is not displayed on the Confirm Now page";
		}
		
		//Verify the EmailAddress displayed on Confirm Page
		/*String actualEmailAddress = FunctionLibrary.retrieveText(locatorEmailAddress, nameEmailAddress);
		//.retrieveAttributeValue(locatorEmailAddress, "value", nameEmailAddress);
		//Compare the actualEmailAddress with Expected EmailAddress retrieved from xls
		String expectedEmailAddress = expectedEmailId;
		methodReturnResult = FunctionLibrary.assertText(nameEmailAddress, actualEmailAddress, expectedEmailAddress);
		if(methodReturnResult.contains(failTest)){
			return methodReturnResult;
		}
		String expectedYourEmailMessage = "Your Email " + expectedEmailAddress;
		
		APPLICATION_LOGS.debug( "' " +expectedYourEmailMessage + " '" +"Message displayed");
		
		//Verify Button Text
		String buttonText = FunctionLibrary.retrieveText(locatorConnectToGmailButton, nameConnectToGmailButton);
		String actualButtonText = buttonText;
		String expectedButtonText = "Connect to Gmail";
		methodReturnResult = FunctionLibrary.assertText(expectedButtonText, actualButtonText);
		if(methodReturnResult.contains(failTest)){
			return methodReturnResult;
		}
		
		//Click on ConfirmNow button
		/*methodReturnResult = FunctionLibrary.clickAndWait(locatorConfirmNowButton, nameConfirmNowButton);
		if(methodReturnResult.contains(failTest)){
			return methodReturnResult;
		}*/
		
		String actualEmailId = FunctionLibrary.retrieveAttributeValue(locatorEmailInputbox, "value", nameEmailInputbox);
		//String actualEmailId = FunctionLibrary.retrieveText(locatorEmailInputbox, nameEmailInputbox);
		methodReturnResult=FunctionLibrary.assertText(nameEmailInputbox, actualEmailId, expectedEmailId);
		if(methodReturnResult.contains(failTest)){
			return methodReturnResult;
		}
		return "Pass :" +actualMessage + messageIconPresent + "All Elements present on the Yellow Banner";
	}
	


}
