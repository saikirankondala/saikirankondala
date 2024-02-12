package testcases;

import enums.Helper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Utils;

public class AllocationUploadTest extends Utils
{
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();
    final String CluCloud_ID=Helper.getId();
    @Test(testName = "Verify allocation upload  In CluCloud Application ")
    public void verifyCluHomePage() throws Exception, CustomException
    {

        loadUrl(CluCloud_URL);
        //wait(5);
        Reporter.log("Step 1 : Launch Browser and load Clucloud URL", true);

        Pages.loginPage().login(CluCloud_USERNAME, CluCloud_PASSWORD, CluCloud_ID);
        Reporter.log("Step 2: Login into CluCloud", true);
//
        Pages.collectionAllocationUpload().ChangeLoanNo();
        Reporter.log("Step 3: Change the loan NO in xlsv file in Clu", true);


        Pages.collectionAllocationUpload().ClickOnWorkAllocation();
        Reporter.log("Step 4: Click on work allocation tab in Clu", true);

        Pages.collectionAllocationUpload().ClickOnCollectionUnderWorkAllocation();
        Reporter.log("Step 5: Click on Collections under work allocation tab in Clu", true);

        Pages.collectionAllocationUpload().ClickOnSummaryReportTab();
        Reporter.log("Step 6: Click on Summary report under work allocation tab in Clu", true);

        Pages.allocationSummary().SelectEmpIDXLSVFile();
        Reporter.log("Step 7: Click on Collections under work allocation tab in Clu", true);

        Pages.allocationSummary().StoreWorkallocationsummaryreports();
        Reporter.log("Step 8: Click on Collections under work allocation tab in Clu", true);
////
   By homepage= By.xpath("//*[@id=\"main-wrapper\"]/div[1]/a/div[1]/img");
        jsClick(homepage);

        Pages.collectionAllocationUpload().ClickOnWorkAllocation();
        Reporter.log("Step 9: Click on work allocation tab in Clu", true);

        Pages.collectionAllocationUpload().ClickOnCollectionUnderWorkAllocation();
        Reporter.log("Step 10: Click on Collections under work allocation tab in Clu", true);

        Pages.collectionAllocationUpload().ClickOnUploadExecutiveSchedule();
        Reporter.log("Step 11: Click on Upload Executive Schedule in collection allocation tab in Clu", true);

        Pages.collectionAllocationUpload().ClickOnUploadExcelfile();
        Reporter.log("Step 12: Click on Upload Excel file in collections upload in Clu", true);

        Pages.collectionAllocationUpload().ClickOnExcelFileName();
        Reporter.log("Step 13: Click on Excel file name and enter file name in Collections under work allocation tab in Clu", true);

        Pages.collectionAllocationUpload().ClickOnExcelFileSubmit();
        Reporter.log("Step 14: Click on Excel Submit Button in Clu", true);

        Pages.collectionAllocationUpload().ClickOnHomeTab();
        Reporter.log("Step 15: Click on Home Tab");

        Pages.collectionAllocationUpload().ClickOnWorkAllocation();
        Reporter.log("Step 16: Click on work allocation tab in Clu", true);
        wait(190);

        Pages.collectionAllocationUpload().ClickOnCollectionUnderWorkAllocation();
        Reporter.log("Step 17: Click on Collections under work allocation tab in Clu", true);

        Pages.collectionAllocationUpload().ClickOnUploadedSummary();
        Reporter.log("Step 18: Click on UploadedSummary tab", true);

        Pages.collectionAllocationUpload().ClickOnUploadedSummaryReport();
        Reporter.log("Step 19: Click on UploadedSummary report tab", true);

//        Pages.collectionAllocationUpload().VerifyAllocationFileName();
//        Reporter.log("Step 20: Verfied File allocation Name", true);

        Pages.collectionAllocationUpload().VerifyNoOfRecordsProcessedInAllocations();
        Reporter.log("Step 21:Verified No of records Processed In uploaded collections allocation File",true);

                //By homepage= By.xpath("//*[@id=\"main-wrapper\"]/div[1]/a/div[1]/img");
        jsClick(homepage);

        Pages.collectionAllocationUpload().ClickOnWorkAllocation();
        Reporter.log("Step 22: Click on work allocation tab in Clu", true);

        Pages.collectionAllocationUpload().ClickOnCollectionUnderWorkAllocation();
        Reporter.log("Step 23: Click on Collections under work allocation tab in Clu", true);

        Pages.collectionAllocationUpload().ClickOnSummaryReportTab();
        Reporter.log("Step 24: Click on Collections under work allocation tab in Clu", true);

//
        Pages.allocationSummary().StoreWorkallocationsummaryreports2();
        Reporter.log("Step 27: Click on Collections under work allocation tab in Clu", true);

        Pages.allocationSummary().compareList();
        Reporter.log("Step 8: Click on Collections under work allocation tab in Clu", true);

    }
}
