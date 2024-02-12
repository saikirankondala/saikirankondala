package testcases;

import enums.Helper;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Utils;

public class Telecaller  extends Utils {
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();
    final String CluCloud_ID = Helper.getId();

    @Test(testName = "Verify loan No in work allocation search bar  In CluCloud Application ")
    public void verifyCluHomePage() throws Exception, CustomException
    {
        loadUrl(CluCloud_URL);
        //wait(5);
        Reporter.log("Step 1 & 2: Launch Browser and load Clucloud URL", true);

        Pages.loginPage().login(CluCloud_USERNAME, CluCloud_PASSWORD, CluCloud_ID);
        Reporter.log("Step 3: Login into CluCloud", true);

        Pages.collectionAllocationUpload().ClickOnWorkAllocation();
        Reporter.log("Step 4: Click on work allocation tab in Clu", true);

        Pages.caller().SelectMyAllocation();
        Reporter.log("Step 5: Click on My allocation allocation tab in Clu", true);

        Pages.caller().ClickOnDail();
        Reporter.log("Step 6: Click on Dailer", true);


    }
}
