package testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;


import jxl.read.biff.BiffException;
import testscripts.DriverScript;
import testscripts.FacebookLibrary;
import testscripts.FunctionLibrary;


public class VerifySignUpPage extends DriverScript{

	//Page Titles
	public static String signUpPageTitle = "Sign up for Facebook | Facebook";

	/* .............. Name of the WebElements present on the WebPage ................. */
	public static String nameSignUpForFacebookLink = "'Sign up for Facebook' Link";
	public static String nameFirstNameInputBox = "'FirstName' Input-box";
	public static String nameSurNameInputBox = "'SurName' Input-box";
	public static String nameEmailOrMobileNumberInputBox = "'Email or mobile number' Input-box";
	public static String nameReEnterEmailOrMobileNumberInputBox = "'Re-enter email or mobile number' Input-box";
	public static String nameNewPasswordInputBox = "'New password' Input-box";
	public static String nameBirthdayDayDropDown = "'Birthday Day' Drop-down";
	public static String nameBirthdayMonthDropDown = "'Birthday Month' Drop-down";
	public static String nameBirthdayYearDropDown = "'Birthday Year' Drop-down";
	public static String nameMaleRadioButton = "'Male' Radio-button";
	public static String nameFemaleRadioButton = "'Female' Radio-button";
	public static String nameMaleorFemaleRadioButton = "'Male or Female' Radio-button";
	public static String nameSignUpButton = "'SignUp' Button";
	public static String nameAlert = "Find your Friends Alert' !";

	/* .............. Locators for the test ................. */
	public static By locatorSignUpforFacebookLink = By
			.xpath("//a[contains(text(),'Sign up for Facebook')]");
	public static By locatorFirstNameInputBox = By
			.xpath("//input[@id='u_0_0']");
	public static By locatorSurNameInputBox = By
			.xpath("//input[@id='u_0_1']");
	public static By locatorEmailOrMobileNumberInputBox = By
			.xpath("//input[@id='u_0_2']");
	public static By locatorReEnterEmailOrMobileNumberInputBox = By
			.xpath("//input[@id='u_0_4']");
	public static By locatorNewPasswordInputBox = By
			.xpath("//input[@id='u_0_5']");
	public static By locatorBirthdayDayDropDown = By
			.xpath("//select[@id='day']");
	public static By locatorBirthdayMonthDropDown = By
			.xpath("//select[@id='month']");
	public static By locatorBirthdayYearDropDown = By
			.xpath("//select[@id='year']");
	public static By locatorRadioButton = By
			.name("sex");
	public static By locatorMaleRadioButton = By
			.xpath("//label[text()='Male']/preceding-sibling::input[@type='radio']");
	public static By locatorFemaleRadioButton = By
			.xpath("//label[text()='Female']/preceding-sibling::input[@type='radio']");
	public static By locatorSignUpButton = By
			.xpath("//button[@id='u_0_9']");

	// Verify Elements on Facebook Sign up Page
	public static String verifySignUpPageElements() throws MalformedURLException, InterruptedException {

		APPLICATION_LOGS.debug("Executing test case : "
				+ "Verifying all elements on Facebook Sign-Up page...");


		//Navigate to Facebook Login Page
		methodReturnResult = FacebookLibrary.navigate();
		if(methodReturnResult.contains(failTest)){
			return methodReturnResult;
		}


		//Check for Sign-Up for Facebook Link on Facebook Login Page
		Boolean signUpForFacebookLinkPresent = FunctionLibrary.isElementPresent(locatorSignUpforFacebookLink, nameSignUpForFacebookLink);
		if(!signUpForFacebookLinkPresent){
			return "Fail : 'Sign up for Facebook' link on present on Facebook Login Page ";  
		}

		//Click on Sign up for Facebook Link 
		methodReturnResult = FunctionLibrary.clickAndWait(locatorSignUpforFacebookLink, nameSignUpForFacebookLink);
		if(methodReturnResult.contains(failTest)){
			return methodReturnResult;
		}

		expectedTitle = signUpPageTitle;

		methodReturnResult = FunctionLibrary.assertTitle(expectedTitle);
		if (methodReturnResult.contains(failTest)) {

			// Log result
			APPLICATION_LOGS.debug("Not navigated to the "+signUpPageTitle+" page");
			System.err.println("Not navigated to the "+signUpPageTitle+" page");
			return methodReturnResult;

		}

		//Verify all the Elements on SignUp page once the Sign Up page loads
		Boolean firstNameInputBoxPresent = FunctionLibrary.isElementPresent(locatorFirstNameInputBox, nameFirstNameInputBox);
		if(!firstNameInputBoxPresent){
			return "Fail : First name Input-box is not present on" + expectedTitle +" page";
		}

		Boolean surNameInputBoxPresent = FunctionLibrary.isElementPresent(locatorSurNameInputBox, nameSurNameInputBox);
		if(!surNameInputBoxPresent){
			return "Fail : Surname Input-box is not present on" + expectedTitle +" page";
		}

		Boolean emailOrMobileNumberInputBoxPresent = FunctionLibrary.isElementPresent(locatorEmailOrMobileNumberInputBox, nameEmailOrMobileNumberInputBox);
		if(!emailOrMobileNumberInputBoxPresent){
			return "Fail : Email or mobile number Input-box is not present on" + expectedTitle +" page";
		}

		Boolean reEnterEmailOrMobileNoInputBoxPresent = FunctionLibrary.isElementPresent(locatorReEnterEmailOrMobileNumberInputBox, nameReEnterEmailOrMobileNumberInputBox);
		if(!reEnterEmailOrMobileNoInputBoxPresent){
			return "Fail : Re-enter email or mobile number Input-box is not present on" + expectedTitle +" page";
		}

		Boolean newPasswordInputBoxPresent = FunctionLibrary.isElementPresent(locatorNewPasswordInputBox, nameNewPasswordInputBox);
		if(!newPasswordInputBoxPresent){
			return "Fail : New password Input-box is not present on" + expectedTitle +" page";
		}

		Boolean birthdayDayDropDownPresent = FunctionLibrary.isElementPresent(locatorBirthdayDayDropDown, nameBirthdayDayDropDown);
		if(!birthdayDayDropDownPresent){
			return "Fail : Birthday Day Drop-Down is not present on" + expectedTitle +" page";
		}

		Boolean birthdayMonthDropDownPresent = FunctionLibrary.isElementPresent(locatorBirthdayMonthDropDown, nameBirthdayMonthDropDown);
		if(!birthdayMonthDropDownPresent){
			return "Fail : Birthday Month Drop-down is not present on" + expectedTitle +" page";
		}
		Boolean birthdayYearDropDownPresent = FunctionLibrary.isElementPresent(locatorBirthdayYearDropDown, nameBirthdayYearDropDown);
		if(!birthdayYearDropDownPresent){
			return "Fail : Birthday Year Drop-down is not present on" + expectedTitle +" page";
		}

		Boolean femaleRadioButtonPresent = FunctionLibrary.isElementPresent(locatorFemaleRadioButton, nameFemaleRadioButton);

		if(!femaleRadioButtonPresent){
			return "Fail : Female Radio Button is not present on" + expectedTitle +" page";
		}

		Boolean maleRadioButtonPresent = FunctionLibrary.isElementPresent(locatorMaleRadioButton, nameMaleRadioButton);
		if(!maleRadioButtonPresent){
			return "Fail : Male Radio button is not present on" + expectedTitle +" page";
		}

		Boolean signUpButton = FunctionLibrary.isElementPresent(locatorSignUpButton, nameSignUpButton);
		if(!signUpButton){
			return "Fail : First name Input-box is not present on" + expectedTitle +" page";
		}
		return "Pass : All elements are present on "+ expectedTitle + " Page ";
	}


	public static String signUpForFacebook() throws InterruptedException, IOException, BiffException {

		APPLICATION_LOGS.debug("Executing test case : "
				+ "Verifying if the User can create a new Account entering all fields on Sign-Up page...");

		//Navigate to Facebook Login Page
		methodReturnResult = FacebookLibrary.navigate();
		if(methodReturnResult.contains(failTest)){
			return methodReturnResult;
		}


		//Check for Sign-Up for Facebook Link on Facebook Login Page
		Boolean signUpForFacebookLinkPresent = FunctionLibrary.isElementPresent(locatorSignUpforFacebookLink, nameSignUpForFacebookLink);
		if(!signUpForFacebookLinkPresent){
			return "Fail : 'Sign up for Facebook' link on present on Facebook Login Page ";  
		}

		//Click on Sign up for Facebook Link 
		methodReturnResult = FunctionLibrary.clickAndWait(locatorSignUpforFacebookLink, nameSignUpForFacebookLink);
		if(methodReturnResult.contains(failTest)){
			return methodReturnResult;
		}

		//Check the Title of Page displayed after the user clicks on Sign In page
		expectedTitle = signUpPageTitle;

		methodReturnResult = FunctionLibrary.assertTitle(expectedTitle);
		if (methodReturnResult.contains(failTest)) {

			// Log result
			APPLICATION_LOGS.debug("Not navigated to the "+signUpPageTitle+" page");
			System.err.println("Not navigated to the "+signUpPageTitle+" page");
			return methodReturnResult;

		}

		//Verify First Name Input Box on SignUp page
		Boolean firstNameInputBoxPresent = FunctionLibrary.isElementPresent(locatorFirstNameInputBox, nameFirstNameInputBox);
		if(!firstNameInputBoxPresent){
			return "Fail : First name Input-box is not present on" + expectedTitle +" page";
		}
		
		int row_No = 4;

		//Enter Firstname
		methodReturnResult = FacebookLibrary.enterDataonFacebookSignUpPage("Firstname_In", row_No, locatorFirstNameInputBox, nameFirstNameInputBox);
		if (methodReturnResult.contains(failTest)) {

			return methodReturnResult;

		}

		//Verify Surname Input Box on SignUp page
		Boolean surNameInputBoxPresent = FunctionLibrary.isElementPresent(locatorSurNameInputBox, nameSurNameInputBox);
		if(!surNameInputBoxPresent){
			return "Fail : Surname Input-box is not present on" + expectedTitle +" page";
		}

		//Enter Surname in Surname Input Box
		methodReturnResult = FacebookLibrary.enterDataonFacebookSignUpPage("Surname_In", row_No, locatorSurNameInputBox, nameSurNameInputBox);
		if (methodReturnResult.contains(failTest)) {

			return methodReturnResult;

		}

		//Verify Email Or mobile number Input Box on SignUp page
		Boolean emailOrMobileNumberInputBoxPresent = FunctionLibrary.isElementPresent(locatorEmailOrMobileNumberInputBox, nameEmailOrMobileNumberInputBox);
		if(!emailOrMobileNumberInputBoxPresent){
			return "Fail : Email or mobile number Input-box is not present on" + expectedTitle +" page";
		}

		//Enter data into Email Or mobile number Input Box
		methodReturnResult = FacebookLibrary.enterDataonFacebookSignUpPage("EmailOrMobileNo_In", row_No, locatorEmailOrMobileNumberInputBox, nameEmailOrMobileNumberInputBox);
		if (methodReturnResult.contains(failTest)) {

			return methodReturnResult;

		}

		//Verify Re-enter Email Or mobile number Input Box on SignUp page
		Boolean reEnterEmailOrMobileNoInputBoxPresent = FunctionLibrary.isElementPresent(locatorReEnterEmailOrMobileNumberInputBox, nameReEnterEmailOrMobileNumberInputBox);
		if(!reEnterEmailOrMobileNoInputBoxPresent){
			return "Fail : Re-enter email or mobile number Input-box is not present on" + expectedTitle +" page";
		}

		//Enter data into Re-enter email rr mobile number Input Box
		methodReturnResult = FacebookLibrary.enterDataonFacebookSignUpPage("Re-enterEmailOrMobileNo_In", row_No, locatorReEnterEmailOrMobileNumberInputBox, nameReEnterEmailOrMobileNumberInputBox);
		if (methodReturnResult.contains(failTest)) {

			return methodReturnResult;

		}

		//Verify New password Input Box on SignUp page
		Boolean newPasswordInputBoxPresent = FunctionLibrary.isElementPresent(locatorNewPasswordInputBox, nameNewPasswordInputBox);
		if(!newPasswordInputBoxPresent){
			return "Fail : New password Input-box is not present on" + expectedTitle +" page";
		}

		//Enter data into New password Input Box Input Box
		methodReturnResult = FacebookLibrary.enterDataonFacebookSignUpPage("Newpassword_In", row_No, locatorNewPasswordInputBox, nameNewPasswordInputBox);
		if (methodReturnResult.contains(failTest)) {

			return methodReturnResult;

		}

		//Verify Birthday-Day Dropdown on SignUp page
		Boolean birthdayDayDropDownPresent = FunctionLibrary.isElementPresent(locatorBirthdayDayDropDown, nameBirthdayDayDropDown);
		if(!birthdayDayDropDownPresent){
			return "Fail : Birthday Day Drop-Down is not present on" + expectedTitle +" page";
		}

		//Select value from testdata.xls into Birthday-Day Dropdown
		methodReturnResult = FacebookLibrary.selectValueFromDropdown("BirthDay_Day_Select", row_No, locatorBirthdayDayDropDown, nameBirthdayDayDropDown);
		if (methodReturnResult.contains(failTest)) {

			return methodReturnResult;

		}

		//Verify Birthday-Month Dropdown on SignUp page
		Boolean birthdayMonthDropDownPresent = FunctionLibrary.isElementPresent(locatorBirthdayMonthDropDown, nameBirthdayMonthDropDown);
		if(!birthdayMonthDropDownPresent){
			return "Fail : Birthday Month Drop-down is not present on" + expectedTitle +" page";
		}

		//Select value from testdata.xls into Birthday-Month Dropdown
		methodReturnResult = FacebookLibrary.selectValueFromDropdown("BirthDay_Month_Select", row_No, locatorBirthdayMonthDropDown, nameBirthdayMonthDropDown);
		if (methodReturnResult.contains(failTest)) {

			return methodReturnResult;

		}

		//Verify Birthday-Year Dropdown on SignUp page
		Boolean birthdayYearDropDownPresent = FunctionLibrary.isElementPresent(locatorBirthdayYearDropDown, nameBirthdayYearDropDown);
		if(!birthdayYearDropDownPresent){
			return "Fail : Birthday Year Drop-down is not present on" + expectedTitle +" page";
		}

		Thread.sleep(3000L);

		//Select value from testdata.xls into Birthday-Year Dropdown
		methodReturnResult = FacebookLibrary.selectValueFromDropdown("BirthDay_Year_Select", row_No, locatorBirthdayYearDropDown, nameBirthdayYearDropDown);
		if (methodReturnResult.contains(failTest)) {

			return methodReturnResult;

		}

		//Select Male or Female Radio button 
		//Click on a Radio Button 
		/*String radioButtonToSelect = testData.getCellData("Sign up for Facebook", "MaleOrFemaleRadioButton", 1);

		methodReturnResult = FunctionLibrary.clickRadioButton(locatorRadioButton, nameMaleorFemaleRadioButton ,radioButtonToSelect);
		if (methodReturnResult.contains(failTest)) {

			return methodReturnResult;

		}*/

		//Click on a Radio Button
		String radioButtonToSelect = testData.getCellData("Sign up for Facebook", "MaleOrFemaleRadioButton", row_No);
		if(radioButtonToSelect.equals("M")){
			FunctionLibrary.checkCheckBox(locatorMaleRadioButton, nameMaleRadioButton);

		}
		if(radioButtonToSelect.equals("F")){
			FunctionLibrary.checkCheckBox(locatorFemaleRadioButton, nameFemaleRadioButton);

		}

		//Click on Sign Up button
		methodReturnResult = FunctionLibrary.clickAndWait(locatorSignUpButton, nameSignUpButton);
		if (methodReturnResult.contains(failTest)) {

			return methodReturnResult;

		}

		//hANDLE pOPUP
		//Switch to All PopUp windows and Close Them
		methodReturnResult = FacebookLibrary.switchtoPopUpAndClosePopUp();
		if (methodReturnResult.contains(failTest)) {

			// Log result
			APPLICATION_LOGS.debug("Not able to switch to Popup window "
					+ "and Close it on test site - ");
			
			return methodReturnResult;

		}
		

		methodReturnResult = VerifyProfileData.verifySignUpNewUser();
		if (methodReturnResult.contains(failTest)) {

			return methodReturnResult;

		}
		return "Pass : Sign Up for the User is Succesful";
	}

}
