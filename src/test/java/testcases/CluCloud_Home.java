package testcases;

import enums.Helper;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Rerunautomation;
import util.Utils;

public class CluCloud_Home extends Utils {
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();

    final String CluCloud_ID=Helper.getId();
//retryAnalyzer = Rerunautomation.class
    @Test(retryAnalyzer = Rerunautomation.class,testName = "Verify Home Tab Counts of Sales,Collections and FI  In CluCloud Application ")
    public void verifyCluHomePage() throws Exception, CustomException
    {

        loadUrl(CluCloud_URL);

        Reporter.log("Step 1 & 2: Launch Browser and load Clucloud URL", true);

        Pages.loginPage().login(CluCloud_USERNAME, CluCloud_PASSWORD,CluCloud_ID);
        Reporter.log("Step 3: Login into CluCloud", true);

        //////////////////Today////////////////////////////////////


        Pages.home().salesDashboard();
        Reporter.log("Step 4: Verified Sales  visit counts in Home Page Dashboard ", true);

        Pages.home().collectionsDashboard();
        Reporter.log("Step 5: Verified Collection  visit counts in Home Page Dashboard ", true);
//
        Pages.home().FieldInvestigationDashboard();
        Reporter.log("Step 6: Verified Field Investigation  visit counts in Home Page Dashboard ", true);
//
//        ////////////////////////30 days/////////////////////////////////
//
        Pages.home().Last7DaysDashboard();
        wait(2);
        Reporter.log("Step 7: Selected 7 Days custom date ", true);

        Pages.home().salesDashboard();
        Reporter.log("Step :8 Verified Sales  visit counts in Home Page Dashboard ", true);
//
        Pages.home().collectionsDashboard();
        Reporter.log("Step 9: Verified Collection  visit counts in Home Page Dashboard ", true);

        Pages.home().FieldInvestigationDashboard();
        Reporter.log("Step 10: Verified Field Investigation  visit counts in Home Page Dashboard ", true);

        //////////////30 days//////////////////////////////////////////

        Pages.home().Last30DaysDashboard();
        wait(2);
        Reporter.log("Step 11: Selected 30 days filter", true);

        Pages.home().salesDashboard();
        Reporter.log("Step 12: Verified Sales  visit counts in Home Page Dashboard ", true);
//
        Pages.home().collectionsDashboard();
        Reporter.log("Step 13: Verified Collection  visit counts in Home Page Dashboard ", true);
        wait(10);

        Pages.home().FieldInvestigationDashboard();
        Reporter.log("Step 14: Verified Field Investigation  visit counts in Home Page Dashboard ", true);

        Pages.home().CustomFilterInCollectionCountDashboard();
        Pages.home().CustomDatePicker();
        wait(2);
        Reporter.log("Step 15: Selected customs days filter", true);


        Pages.home().salesDashboard();
        Reporter.log("Step 16: Verified Sales  visit counts in Home Page Dashboard ", true);

        Pages.home().collectionsDashboard();
        Reporter.log("Step 17: Verified Collection  visit counts in Home Page Dashboard ", true);
        wait(10);

        Pages.home().FieldInvestigationDashboard();
        Reporter.log("Step 18: Verified Field Investigation  visit counts in Home Page Dashboard ", true);






    }
}
