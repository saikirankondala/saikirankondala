package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Utils;

import static util.Base.driver;

public class LoginPage extends Utils {

	By id=By.xpath("//*[@id='sign-in']/form/div[1]/div/input");
	By username = By.xpath("//*[@id='sign-in']/form/div[2]/div/input");
	By password =By.xpath("//*[@id='sign-in']/form/div[3]/div/input");;
	By logInBtn = By.xpath("//*[@id='sign-in']/form/div[5]/button");
	By errMsg = By.xpath("//li[@role='alert']");
	By menuIcon = By.xpath("//span[@class='ui-menuitem-icon ui-icon nms5wi-main-menu-icon']");
	By networkBtn = By.xpath("//span[text()='Network']");
	By NMSDialogBox = By.xpath("//div[@id='j_id_2g_dlg_AboutNMS5WInone']");
	By okButton = By.xpath("//button[@id='aboutOkButton']//span");

	static final String FAIL_CSS_START = "<font color='red'>";
	static final String FAIL_CSS_END = "</font>";

	/**
	 * Enters username on the Login Page
	 * 
	 * @param username String
	 * 
	 */
	public void enterUsername(String userName) {

		waitforPageToFinishLoading();
		driver.get().manage().window().maximize();
		waitforElementToBePresent(username);
		WebElement e = getElement(username);
		enterString(e, userName);
		wait(2);
		test().log(Status.PASS, "=====> Entered Username: " + userName);

	}

	/**
	 * Enters password on the Login Page
	 * 
	 * @param pwd String
	 */

	public void enterPassword(String pwd) {
		waitforElementToBePresent(password);
		WebElement e = getElement(password);
		enterString(e, pwd);
		wait(2);
		test().log(Status.PASS, "=====> Entered Password: "+pwd);
	}

	public void enterId(String i) {
		waitforElementToBePresent(id);
		WebElement e = getElement(id);
		enterString(e, i);
		wait(2);
		test().log(Status.PASS, "=====> Entered Password: "+i);
	}
	/**
	 * Clicks Sign In button on the Login Page
	 * 
	 */

	public void clickLogInButton() {


		waitforElementToBePresent(logInBtn);
		//elementToClick.sendKeys(Keys.ESCAPE);
		wait(5);
		jsClick(logInBtn);
		jsClick(logInBtn);
		wait(2);
		test().log(Status.PASS, "=====> Click Log In button");
	}

	/**
	 * Enters username and password on Login Page
	 * 
	 * @param username String
	 * @param pwd      String
	 */
	public void login(String userName, String pwd,String i) {
		enterId(i);
		enterUsername(userName);
		enterPassword(pwd);
		clickLogInButton();
		wait(5);
		test().log(Status.PASS, "=====> Login Successful!");
	}

	/**
	 * Verifying the error message for invalid credentials.
	 * 
	 * @param username String
	 */

	public void errMsgDisplayed() {
		waitforElementToBeVisible(errMsg);
		verifyElementPresent(errMsg);
		test().log(Status.PASS, " =====> Error Message: '" + getText(errMsg) + "' is displayed");

	}

	/**
	 * Clicking on Menu Icon to navigate to other pages.
	 */

	public void clickMenuIcon() throws Exception {
		waitforElementToBePresent(menuIcon);
		jsClick(menuIcon);
		wait(2);
		test().log(Status.PASS, "=====> Clicked on  Menu Icon ");
	}

	/**
	 * Verifying the Dialog Box on the screen immediately after login.
	 */

	public void verifyDialogBox() throws Exception {
		waitforElementToBePresent(NMSDialogBox);
		verifyElementPresent(NMSDialogBox);
		wait(3);
		test().log(Status.PASS, "=====> NMS Dialog Box appeared on the page ");

	}

	/**
	 * click on OK button after login.
	 */

	public void clickOnOkButton() throws Exception {
		wait(2);
		switchToiframe(okButton);
		waitforElementToBeClickable(okButton);
		jsClick(okButton);
		switchToDefaultContent();
		wait(2);
		test().log(Status.PASS, "=====> Clicked on OK Button on NMS dialog box");
	}
}
