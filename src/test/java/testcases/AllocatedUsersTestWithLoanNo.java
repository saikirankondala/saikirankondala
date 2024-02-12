package testcases;

import enums.Helper;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Utils;

public class AllocatedUsersTestWithLoanNo extends Utils {
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();
    final String CluCloud_ID = Helper.getId();

    @Test(testName = "Verify loan No in work allocation search bar  In CluCloud Application ")
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

        Pages.allocatedUsersSearchwithLoanNo().SelectLoanNoFromXLSVFile();
        Reporter.log("Step 6:Fetched the loan no from XLSV file");

        Pages.allocatedUsersSearchwithLoanNo().ClickOnSearchBarAndEnterLoanNo();
        Reporter.log("Step 7:Entered Loan No in search bar");

        Pages.allocatedUsersSearchwithLoanNo().ClickOnAllocatedUserSearchListView();
        Reporter.log("Step 8:Clicked on allocated user search list view");


        Pages.allocatedUsersSearchwithLoanNo().FetchLoanNoandSearchInDrilldownSearch();
        Reporter.log("Step 10:Search the loan no in drilldown search loan no");

        Pages.allocatedUsersSearchwithLoanNo().CompareLoanNO();
        Reporter.log("Step 11:Compare the Loan no in drill down search bar result");

        Pages.allocatedUsersSearchwithLoanNo().VerifyLoanNo_EmpID_CPName();
        Reporter.log("Step 12:Compare the Loan no,CPm in drill down search bar result");

        Pages.allocatedUsersSearchwithLoanNo().DownloadResultedXLSVFileFromListedCustomerTab();
        Reporter.log("Step 12:XLSV file is downloaded from the Listed Customer tab ");


        Pages.allocatedUsersSearchwithLoanNo().verifyDownloadedXLSV();
        Reporter.log("Step 12: verify XLSV file is downloaded from the Listed Customer tab ");



    }
}
