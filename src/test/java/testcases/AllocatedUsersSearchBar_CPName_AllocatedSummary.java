package testcases;

import enums.Helper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Utils;

public class AllocatedUsersSearchBar_CPName_AllocatedSummary extends Utils {
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();
    final String CluCloud_ID = Helper.getId();

    @Test(testName = "Verify Au bank CP name in work allocation   In CluCloud Application ")
    public void verifyCluHomePage() throws Exception, CustomException
    {

        loadUrl(CluCloud_URL);
        //wait(5);
        Reporter.log("Step 1 & 2: Launch Browser and load Clucloud URL", true);

        Pages.loginPage().login(CluCloud_USERNAME, CluCloud_PASSWORD, CluCloud_ID);
        Reporter.log("Step 3: Login into CluCloud", true);
        wait(5);

        By homepage= By.xpath("//*[@id=\"main-wrapper\"]/div[1]/a/div[1]/img");
        jsClick(homepage);

        Pages.collectionAllocationUpload().ClickOnWorkAllocation();
        Reporter.log("Step 4: Click on work allocation tab in Clu", true);

        Pages.collectionAllocationUpload().ClickOnCollectionUnderWorkAllocation();
        Reporter.log("Step 5: Click on Collections under work allocation tab in Clu", true);

        Pages.collectionAllocationUpload().ClickOnSummaryReportTab();
        Reporter.log("Step 6: Click on Collections under work allocation tab in Clu", true);

        Pages.allocationSummary().SelectEmpIDXLSVFile();
        Reporter.log("Step 6: Click on Collections under work allocation tab in Clu", true);

        Pages.allocationSummary().StoreWorkallocationsummaryreports();
        Reporter.log("Step 8: Click on Collections under work allocation tab in Clu", true);
//
        Pages.allocationSummary().StoreWorkallocationsummaryreports2();
        Reporter.log("Step 8: Click on Collections under work allocation tab in Clu", true);
//

//
//        Pages.collectionAllocationUpload().ClickOnWorkAllocation();
//        Reporter.log("Step 4: Click on work allocation tab in Clu", true);
//
//        Pages.collectionAllocationUpload().ClickOnCollectionUnderWorkAllocation();
//        Reporter.log("Step 5: Click on Collections under work allocation tab in Clu", true);
//
//        Pages.collectionAllocationUpload().ClickOnSummaryReportTab();
//        Reporter.log("Step 6: Click on Collections under work allocation tab in Clu", true);
//
//        Pages.allocationSummary().StoreWorkallocationsummaryreports2();
//        Reporter.log("Step 7: Click on Collections under work allocation tab in Clu", true);
//
        Pages.allocationSummary().compareList();
        Reporter.log("Step 8: Click on Collections under work allocation tab in Clu", true);






    }
}
