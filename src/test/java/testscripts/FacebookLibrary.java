package testscripts;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import jxl.read.biff.BiffException;

public class FacebookLibrary extends DriverScript {

	// Stores current window handle
	public static String currentWindowHandle;



	// Site name
	public static String testSiteName = "Facebook";

	// User name
	public static String userName = null;

	// Expected page titles
	public static String fbLoginPageTitle = "Log in to Facebook | Facebook";
	public static String fbPageTitle = null;
	public static String fbMyProfilePageTitle = null;

	/*
	 * .............. Name of the WebElements present on the WebPage
	 * .................
	 */

	public static String nameEmailOrPhoneInputBox = "'Email' Input-box";
	public static String namePasswordInputBox = "'Password' Input-box";
	public static String nameLogInButton = "'LogIn' Button";
	public static String nameNavigateToLogOutLink = "'Navigate To Log Out' link";
	public static String nameLogOutLink = "'Log Out' link";
	public static String nameUserName = "User name";


	/* .............. Locators for the test ................. */

	//public static By locatorEmailOrPhoneInputBox = By.xpath("//*[@id='email']");//input[@id='email']
	public static By locatorEmailOrPhoneInputBox = By.xpath("//input[@id='email']");
	public static By locatorPasswordInputBox = By.xpath("//input[@id='pass']");////*[@id='pass']");
	public static By locatorLogInButton = By.id("loginbutton");

	private static By locatorUserName = By.xpath("//*[@id='navItem_100000219218997']/a/div/span");
	public static By locatorNavigatetoLogOutLink = By.xpath("//*[@id='userNavigationLabel']");
	public static By locatorLogOutLink = By.xpath("//*[@id='u_8_1']/div/div/div[1]/div/div/ul/li[12]/a/span/span");

	//private static By locatorUserName=By.xpath("//*[@id='u_0_1']/div[1]/div[1]/div/a/span");


	// Create a browser instance and navigate to the test site
	public static String navigate() throws MalformedURLException,
	InterruptedException {

		APPLICATION_LOGS.debug("Navigating to the test site - " + testSiteName
				+ " ...");

		// Open a driver instance if not opened already

		try {

			if (wbdv == null) {

				if (CONFIG.getProperty("is_remote").equals("true")) {

					// Generate Remote address
					String remote_address = "http://"
							+ CONFIG.getProperty("remote_ip") + ":4444/wd/hub";
					remote_url = new URL(remote_address);

					if (CONFIG.getProperty("test_browser").equals(
							"InternetExplorer"))
						dc = DesiredCapabilities.internetExplorer();

					else if (CONFIG.getProperty("test_browser").equals(
							"Firefox"))
						dc = DesiredCapabilities.firefox();

					else if (CONFIG.getProperty("test_browser")
							.equals("Chrome"))
						dc = DesiredCapabilities.chrome();

					// Initiate Remote Webdriver instance
					wbdv = new RemoteWebDriver(remote_url, dc);

				}

				else {

					if (CONFIG.getProperty("test_browser").equals(
							"InternetExplorer"))
						wbdv = new InternetExplorerDriver();

					else if (CONFIG.getProperty("test_browser").equals(
							"Firefox")){
						//Create a FirefoxProfile Instance
						/*FirefoxProfile profile = new FirefoxProfile();

						profile.setPreference("browser.startup.homepage", "http://www.google.com");

						wbdv = new FirefoxDriver(profile);*/

						wbdv = new FirefoxDriver();
					}


					else if (CONFIG.getProperty("test_browser")
							.equals("Chrome")){
						System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
						wbdv = new ChromeDriver();

						/*String userProfile= "C:\\Users\\soumyajitn\\AppData\\Local\\Google\\Chrome\\User Data\\";
						ChromeOptions options = new ChromeOptions();
						options.addArguments("user-data-dir="+userProfile);
						options.addArguments("--start-maximized");
						System.setProperty("webdriver.chrome.driver",
								"C:\\Users\\soumyajitn\\Downloads\\chromedriver_win32\\chromedriver.exe");
						wbdv = new ChromeDriver(options);*/

					}


				}

			}

		}

		catch (Throwable initException) {

			APPLICATION_LOGS.debug("Error came while initiating driver : "
					+ initException.getMessage());
			System.err.println("Error came while initiating driver : "
					+ initException.getMessage());

		}

		// Initiate Event Firing Web Driver instance
		driver = new EventFiringWebDriver(wbdv);

		// Implicitly wait for 30 seconds for browser to open
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Delete all browser cookies
		driver.manage().deleteAllCookies();

		// Navigate to Curaspan application
		driver.navigate().to(CONFIG.getProperty("test_site_url"));

		// Maximize browser window
		driver.manage().window().maximize();

		// Verify Login page appears
		expectedTitle = fbLoginPageTitle;
		methodReturnResult = FunctionLibrary.assertTitle(expectedTitle);
		if (methodReturnResult.contains(failTest)) {

			// Log result
			APPLICATION_LOGS.debug("Not navigated to the test site - "
					+ testSiteName);
			System.err.println("Not navigated to the test site - "
					+ testSiteName);
			return methodReturnResult;

		}

		APPLICATION_LOGS.debug("Navigated to the test site - " + testSiteName);
		System.out.println("Navigated to the test site - " + testSiteName);

		return "Pass : Navigated to the test site - " + testSiteName;

	}

	// Login to the application
	public static String login(int Data_Row_No) throws InterruptedException,
	IOException {

		APPLICATION_LOGS.debug("Logging in to the test site - " + testSiteName);

		String userName = null;
		String password = null;

		try {

			userName = testData.getCellData("Login", "UserId_In", Data_Row_No);

			password = testData
					.getCellData("Login", "Password_In", Data_Row_No);

			APPLICATION_LOGS
			.debug("Successfully Retrieved data from Xls File :-  Username : "
					+ userName + " and Password : " + password);

		}

		catch (Exception e) {

			APPLICATION_LOGS.debug("Error while retrieving data from xls file"
					+ e.getMessage());
			System.out.println("Error while retrieving data from xls file"
					+ userName);
			return "Fail : Error while retrieving data from xls file";

		}

		// Verify whether Username input-box, Password input-box and SignIn
		// button present on the page or not
		Boolean usernameFieldPresent = FunctionLibrary.isElementPresent(
				locatorEmailOrPhoneInputBox, nameEmailOrPhoneInputBox);
		Boolean passwdFieldPresent = FunctionLibrary.isElementPresent(
				locatorPasswordInputBox, namePasswordInputBox);
		Boolean signInButtonPresent = FunctionLibrary.isElementPresent(
				locatorLogInButton, nameLogInButton);

		if (!usernameFieldPresent && !passwdFieldPresent
				&& !signInButtonPresent) {
			return "Fail : Username Field or Password Field or SignIn button is not present on the page ";
		}

		// Clear Username input-box and input username
		FunctionLibrary.clearField(locatorEmailOrPhoneInputBox,
				nameEmailOrPhoneInputBox);
		FunctionLibrary.input(locatorEmailOrPhoneInputBox, nameEmailOrPhoneInputBox,
				userName);

		// Clear Password input-box and input password
		FunctionLibrary.clearField(locatorPasswordInputBox,
				namePasswordInputBox);
		FunctionLibrary.input(locatorPasswordInputBox, namePasswordInputBox,
				password);

		// Click on the Log in button
		methodReturnResult = FunctionLibrary.clickAndWait(locatorLogInButton, nameLogInButton);
		if(methodReturnResult.equals(failTest)){
			return methodReturnResult;
		}
		APPLICATION_LOGS.debug("Successfully logged in to the test site - "
				+ testSiteName);
		System.out.println("Successfully logged in to the test site - "
				+ testSiteName);

		return "Pass : Logged in to the test site - " + testSiteName;

	}

	// Navigate and login to GPS
	public static String navigateAndLoginToFacebook() throws InterruptedException,
	IOException, BiffException {

		// Navigate to GPS
		methodReturnResult = FacebookLibrary.navigate();
		if (methodReturnResult.contains(failTest)) {
			return methodReturnResult;
		}

		// Login to Facebook
		methodReturnResult = FacebookLibrary.login(2);
		if (methodReturnResult.contains(failTest)) {
			return methodReturnResult;
		}

		// Verify Facebook page appears
		methodReturnResult = FacebookLibrary.verifyFacebookPage();
		if (methodReturnResult.contains(failTest)) {
			return methodReturnResult;
		}

		return "Pass : Navigated and logged in to Facebook";

	}

	// Login to the application
	public static String verifyFacebookPage() throws BiffException,
	IOException {

		APPLICATION_LOGS.debug("Verifying Facebook page appears");
		System.out.println("Verifying Facebook page appears");

		// Verify user goal sheet page appears
		userName = testData.getCellData("Login", "UserName", 2);

		//fbPageTitle = "Facebook";
		//expectedTitle = fbPageTitle;

		//methodReturnResult = FunctionLibrary.assertTitle(expectedTitle);
		/*if (methodReturnResult.contains(failTest)) {

				// Log result
				APPLICATION_LOGS.debug("Not navigated to the Goal Sheet page");
				System.err.println("Not navigated to the Goal Sheet page");
				return methodReturnResult;

			}*/

		// Verify User name appears on Goal Sheet page
		userName = testData.getCellData("Login", "UserName", 1);
		String expectedUserName = userName;
		String actualUserName = FunctionLibrary.retrieveText(locatorUserName,
				nameUserName);
		methodReturnResult = FunctionLibrary.assertText(nameUserName,
				actualUserName, expectedUserName);
		if (methodReturnResult.contains(failTest)) {

			// Log result
			APPLICATION_LOGS
			.debug("User name appears on Facebook page is not correct");
			System.err
			.println("User name appears on Facebook page is not correct");
			return methodReturnResult;

		}

		return "Pass : Facebook page appears";

	}


	// Logout from the application
	public static String logout() throws InterruptedException {

		APPLICATION_LOGS
		.debug("Logging out of the test site - " + testSiteName);
		System.out.println("Logging out of the test site - " + testSiteName);

		// Click on 'Log Out'

		methodReturnResult = FunctionLibrary.clickLink(locatorLogOutLink,
				nameLogOutLink);
		Thread.sleep(5000L);
		FunctionLibrary.waitForPageToLoad();
		if (methodReturnResult.contains(failTest)) {
			return methodReturnResult;
		}

		// Delete all cookies
		try {
			driver.manage().deleteAllCookies();
		}

		catch (Throwable deleteCookieException) {

			APPLICATION_LOGS.debug("Error came while clearing cookies : "
					+ deleteCookieException.getMessage());
			System.err.println("Error came while clearing cookies : "
					+ deleteCookieException.getMessage());

		}

		// Verify user logged out successfully
		expectedTitle = fbLoginPageTitle;
		methodReturnResult = FunctionLibrary.assertTitle(expectedTitle);
		if (methodReturnResult.contains(failTest)) {

			// Log result
			APPLICATION_LOGS.debug("User not logged out of the test site - "
					+ testSiteName);
			System.err.println("User not logged out of the test site - "
					+ testSiteName);
			return methodReturnResult;

		}

		APPLICATION_LOGS.debug("Successfully logged out of  the test site - "
				+ testSiteName);
		System.out.println("Successfully logged out of the test site - "
				+ testSiteName);

		return "Pass : Logged out the test site - " + testSiteName;

	}

	// Enter Data from Xls into Input boxes on WebPage
	public static String enterDataonFacebookSignUpPage(String colName,int Data_Row_No,By locatorInputBox,String inputLabel) throws InterruptedException,
	IOException {

		APPLICATION_LOGS.debug("Entering data in to" + inputLabel 
				+"on the test site - " + testSiteName);
		System.out.println("Entering data in to" + inputLabel 
				+"on the test site - " + testSiteName);

		String text = null;


		try {

			text = testData.getCellData("Sign up for Facebook", colName, Data_Row_No);

			APPLICATION_LOGS
			.debug("Successfully Retrieved data from Xls File :- "
					+ "for " + inputLabel);
			System.out
			.println("Successfully Retrieved data from Xls File :-  Username : "
					+ "for " + inputLabel);

		}

		catch (Exception e) {

			APPLICATION_LOGS.debug("Error while retrieving data from xls file"
					+ e.getMessage());
			System.out.println("Error while retrieving data from xls file"
					+ "for " + inputLabel);
			return "Fail : Error while retrieving data from xls file";

		}

		//Clear the Input-Box 
		methodReturnResult = FunctionLibrary.clearField(locatorInputBox, inputLabel);
		if (methodReturnResult.contains(failTest)) {
			return methodReturnResult;
		}


		// Enter data into Input box
		methodReturnResult = FunctionLibrary.input(locatorInputBox, inputLabel, text);
		if (methodReturnResult.contains(failTest)) {
			return methodReturnResult;
		}

		APPLICATION_LOGS.debug("Successfully typed '" +text+ "' in to the Field - "
				+ inputLabel + "on test site - " + testSiteName);
		System.out.println("Successfully typed '" +text+ "' in to the Field - "
				+ inputLabel + "on test site - " + testSiteName);



		return "Pass : Typed in to the field - " + inputLabel + "on test site - " + testSiteName;

	}

	// Enter Data from Xls into Input boxes on WebPage
	public static String selectValueFromDropdown(String colName,int Data_Row_No,By locatorDropDown,String dropdownLabel) throws InterruptedException,
	IOException, BiffException {

		APPLICATION_LOGS.debug("Entering data in to" + dropdownLabel 
				+"on the test site - " + testSiteName);
		System.out.println("Entering data in to" + dropdownLabel 
				+"on the test site - " + testSiteName);

		String text = null;


		try {

			text = testData.getCellData("Sign up for Facebook", colName, Data_Row_No);

			APPLICATION_LOGS
			.debug("Successfully Retrieved data from Xls File :- "
					+ "for " + dropdownLabel);
			System.out
			.println("Successfully Retrieved data from Xls File :-  Username : "
					+ "for " + dropdownLabel);

		}

		catch (Exception e) {

			APPLICATION_LOGS.debug("Error while retrieving data from xls file"
					+ e.getMessage());
			System.out.println("Error while retrieving data from xls file"
					+ "for " + dropdownLabel);
			return "Fail : Error while retrieving data from xls file";

		}

		/*//Click on DropDown
		methodReturnResult = FunctionLibrary.clickAndWait(locatorDropDown, dropdownLabel);
		if (methodReturnResult.contains(failTest)) {
			return methodReturnResult;
		}*/

		// Select value from Dropdown
		String valueToBeSelected = text;
		methodReturnResult = FunctionLibrary.selectValueByVisibleText(locatorDropDown, valueToBeSelected, dropdownLabel);
		if (methodReturnResult.contains(failTest)) {
			return methodReturnResult;
		}

		APPLICATION_LOGS.debug("Successfully selected '" +valueToBeSelected+ "' in to the Field - "
				+ dropdownLabel + "on test site - " + testSiteName);
		System.out.println("Successfully selected '" +valueToBeSelected+ "' in to the Field - "
				+ dropdownLabel + "on test site - " + testSiteName);


		return "Pass : selected in to the field - " + dropdownLabel + "on test site - " + testSiteName;

	}

	public static String switchtoPopUpAndClosePopUp() throws InterruptedException {
		// TODO Auto-generated method stub
		//Verify Switching to PopUp Window 

		APPLICATION_LOGS.debug("Executing switchToPopupWindow and Close It");
		System.out.println("Switching to Pop Window and Close It : ");

		String popUpWindowHandle = null;

		try 
		{

			// Save current window handle for future reference
			defaultWindow = driver.getWindowHandle();

			// Get all the window handles one by one
			for (String windowHandle: driver.getWindowHandles()) 
			{

				// Save new window handle
				if (!windowHandle.equals(defaultWindow))
				{

					popUpWindowHandle = windowHandle;

					// Switches to pop-up window
					driver.switchTo().window(popUpWindowHandle);

					//close the child window
					//Close all the PopUp Windows and return back to Main/Default window
					methodReturnResult = FunctionLibrary.closePopupWindow();
					if (methodReturnResult.contains(failTest)){

						//Log result
						APPLICATION_LOGS.debug("Pop up windows could not be closed on test site - "
								+ testSiteName);
						System.err.println("Pop up windows could not be closed on test site - "
								+ testSiteName);
					}

				}

			}



			// Log result
			System.out.println("Switched to pop-up window and closed the Popup Window");
			APPLICATION_LOGS.debug("Switched to pop-up window and Closed the Popup Window");

			return "Pass : Switched to Parent window";

		}

		catch (Throwable switchToPopupWindowException) 
		{

			// Log error
			System.err.println("Error while Switching to Pop Window : " +switchToPopupWindowException.getMessage());
			APPLICATION_LOGS.debug("Error while Switching to Pop Window : " +switchToPopupWindowException.getMessage());

			return "Fail : Error while Switching to Pop Window : " +switchToPopupWindowException.getMessage();

		}

	}


}
