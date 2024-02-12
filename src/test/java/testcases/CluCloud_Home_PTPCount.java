package testcases;

import enums.Helper;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Utils;

public class CluCloud_Home_PTPCount extends Utils {
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();

    final String CluCloud_ID = Helper.getId();
    //retryAnalyzer = Rerunautomation.class
    @Test(testName = "Verify Home Tab PTP Counts  In CluCloud Application ")
    public void verifyCluHomePage() throws Exception, CustomException {

        loadUrl(CluCloud_URL);
        //wait(5);
        Reporter.log("Step 1 & 2: Launch Browser and load Clucloud URL", true);

        Pages.loginPage().login(CluCloud_USERNAME, CluCloud_PASSWORD, CluCloud_ID);
        Reporter.log("Step 3: Login into CluCloud", true);

        ////////////////////Today////////////////////////////////////

        Pages.home().TodayPTPCounts();
        Reporter.log("Step 4:Selected Today Date range in  PTP Home Page Dashboard ", true);
        Pages.home().PTPCountsMethod();
        Reporter.log("Step 5: Verified Today PTP  visit counts in Home Page Dashboard ", true);

        Pages.home().TommorrowPTPCounts();
        Reporter.log("Step 6:Selected Tomorrow Date range in  PTP Home Page Dashboard ", true);
        Pages.home().PTPCountsMethod();
        Reporter.log("Step 7: Verified Tomorrow PTP  visit counts in Home Page Dashboard ", true);

        Pages.home().Next7DaysPTPCounts();
        Reporter.log("Step 8:Selected Next 7 Days Date range in  PTP Home Page Dashboard ", true);
        Pages.home().PTPCountsMethod();
        Reporter.log("Step 9: Verified Collection  PTP Visits counts in Home Page Dashboard ", true);


    }
}
