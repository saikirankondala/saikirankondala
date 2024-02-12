package testcases;

import enums.Helper;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Rerunautomation;
import util.Utils;

public class Employee_ledger  extends Utils {
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();
    final String CluCloud_ID = Helper.getId();

    //(
    @Test(retryAnalyzer = Rerunautomation.class,testName = "Verify Cash Deposition Page  In CluCloud Application ")
    public void verifyPaymentHistory() throws Exception, CustomException {
        loadUrl(CluCloud_URL);
        Reporter.log("Step 1 & 2: Launch Browser and load Clucloud URL", true);

        Pages.loginPage().login(CluCloud_USERNAME, CluCloud_PASSWORD, CluCloud_ID);
        Reporter.log("Step 3: Login into CluCloud", true);

        Pages.cashDeposition().ClickOnPaymentHistory();
        Pages.cashDeposition().clickOnCashDeposition();

        Pages.employeeLedger().clickOnCashDepositionEmployeeLedger();

        Pages.employeeLedger().searchEmpName();

        Pages.employeeLedger().searchEmpId();

        Pages.employeeLedger().ListVerfication();


    }
}
