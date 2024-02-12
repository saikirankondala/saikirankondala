package testcases;

import enums.Helper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Utils;

public class AllocatedUsersSearchBar_CPName_Indify extends Utils {
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();
    final String CluCloud_ID = Helper.getId();

    @Test(testName = "Verify Indify CP name in work allocation In CluCloud Application ")
    public void verifyCluHomePage() throws Exception, CustomException {

        loadUrl(CluCloud_URL);
        //wait(5);
        Reporter.log("Step 1 & 2: Launch Browser and load Clucloud URL", true);

        Pages.loginPage().login(CluCloud_USERNAME, CluCloud_PASSWORD, CluCloud_ID);
        Reporter.log("Step 3: Login into CluCloud", true);

        Pages.collectionAllocationUpload().ClickOnWorkAllocation();
        Reporter.log("Step 4: Click on work allocation tab in Clu", true);

        Pages.collectionAllocationUpload().ClickOnCollectionUnderWorkAllocation();
        Reporter.log("Step 5: Click on Collections under work allocation tab in Clu", true);

        Pages.cpName_Indify().SelectCPNameFromDropDown();
        Reporter.log("Step 6: Click on CPname under work allocation tab in Clu", true);

        Pages.cpName_Indify().SelectCPNameAllocationFromList("INDIFY");
        Reporter.log("Step 7: Click on CPname under work allocation tab in Clu", true);

        Pages.cpName_Indify().DownloadResultedXLSVFileFromListedCustomerTab();
        Reporter.log("Step 8: Click on Download xlsv file in Listed Customer details", true);

        Pages.cpName_Indify().verifyDownloadedXLSV();
        Reporter.log("Step 9: Verify Download xlsv file in Listed Customer details", true);

        Pages.cpName_Indify().verifyDownloadedXLSV();
        Reporter.log("Step 9: Verify Download xlsv file in Listed Customer details", true);

        Pages.cpName_Indify().verifyDownloadedXLSVRowCounts();
        Reporter.log("Step 9: Verify Download xlsv file  row count in Listed Customer details", true);
        By WindowCloseButton= By.xpath("//button[@type='button'][@class='btn-close btn']");


    }
}
