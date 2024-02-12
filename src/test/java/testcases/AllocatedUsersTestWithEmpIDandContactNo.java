package testcases;

import enums.Helper;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Utils;

public class AllocatedUsersTestWithEmpIDandContactNo extends Utils {
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();
    final String CluCloud_ID = Helper.getId();

    @Test(testName = "Verify EMP ID  and Contact No in allocated search bar  In CluCloud Application ")
    public void verifyCluHomePage() throws Exception, CustomException
    {
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
        Reporter.log("Step 6:Fetched the EMPID from XLSV file");

        Pages.allocatedUsersSearchwithLoanNo().ClickOnSearchBarAndEnterEMPID();
        Reporter.log("Step 7:Entered EMPID in search bar");

        Pages.allocatedUsersSearchwithLoanNo().CompareEMPIDInAllocatedUserSearchResult();
        Reporter.log("Step 8:Verify EMPID In resulted search list in allocated user");

        Pages.allocatedUsersSearchwithLoanNo().GetEmployeeDetailsFromUserManagementTab();
        Reporter.log("Step 10:Fetch the Employee details by using EmpID in User Management Tab");

        Pages.collectionAllocationUpload().ClickOnWorkAllocation();
        Reporter.log("Step 11: Click on work allocation tab in Clu", true);

        Pages.collectionAllocationUpload().ClickOnCollectionUnderWorkAllocation();
        Reporter.log("Step 12: Click on Collections under work allocation tab in Clu", true);

        Pages.allocatedUsersSearchwithLoanNo().ClickOnSearchBarAndEnterContactNo();
        Reporter.log("Step 13:Entered EMPID in search bar");

        Pages.allocatedUsersSearchwithLoanNo().VerifyEMPIDResultInAllocatedUser();
        Reporter.log("Step 14:Select Resulted list in allocated user");

        Pages.allocatedUsersSearchwithLoanNo().ClickOnSearchBarAndEnterContactNoInListedCustomerTab();
        Reporter.log("Step 15:Entered EMPID in search bar at Listed customer tab ");

        Pages.allocatedUsersSearchwithLoanNo().CompareContactNoAllocatedUserSearchResult();
        Reporter.log("Step 16:Verify EMPID In resulted search list in allocated user");

    }
}

