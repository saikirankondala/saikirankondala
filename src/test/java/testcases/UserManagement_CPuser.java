package testcases;

import enums.Helper;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Rerunautomation;
import util.Utils;

import static util.Base.driver;

public class UserManagement_CPuser extends Utils {
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();
    final String CluCloud_ID = Helper.getId();

  //  @Test(testName = "Verify userManagement_CPUser search bar  In CluCloud Application ")
    @Test(retryAnalyzer = Rerunautomation.class,testName ="Verify userManagement_CPUser search bar  In CluCloud Application " )
    public void verifyCluuserManagement_cPuser() throws Exception, CustomException
    {
        loadUrl(CluCloud_URL);
        Reporter.log("Step 1 & 2: Launch Browser and load Clucloud URL", true);

        Pages.loginPage().login(CluCloud_USERNAME, CluCloud_PASSWORD, CluCloud_ID);
        Reporter.log("Step 3: Login into CluCloud", true);

        Pages.userManagement_cPuser().ClickOnUserManagement();
        Reporter.log("Step 4: Click UserManagement tab in Clu", true);

        Pages.userManagement_cPuser().ClickOnManagerTab();
        Reporter.log("Step 5: Click on CPUser Tab Management tab in Clu", true);

        Pages.userManagement_cPuser().FetchEmployeeName();
        Reporter.log("Step 6: Fetch Random Employee Name at CPUser Tab in User Management tab in Clu", true);

        Pages.userManagement_cPuser().ClickOnSearchBar();
        Reporter.log("Step 7: Click on Search Bar at CPUser Tab in User Management tab in Clu", true);

        Pages.userManagement_cPuser().FetchResultedSearch();
        Reporter.log("Step 8: Compare the resulted Emp Name with entered name  at CPUser Tab in User Management tab in Clu", true);
        driver.get().navigate().refresh();

        Pages.userManagement_cPuser().FetchBranchName();
        Reporter.log("Step 9: Fetch Random Branch Name at CPUser Tab in User Management tab in Clu", true);

        Pages.userManagement_cPuser().ClickOnSearchBarForBranchName();
        Reporter.log("Step 10: Click on Search Bar at CPUser Tab in User Management tab in Clu", true);

        Pages.userManagement_cPuser().FetchResultedSearchOfBranchName();
        Reporter.log("Step 11: Compare the resulted branch Name with entered branch name  at CPUser Tab in User Management tab in Clu", true);
        driver.get().navigate().refresh();

        Pages.userManagement_cPuser().FetchEMPIDName();
        Reporter.log("Step 12: Fetch Random EmpID at CPUser Tab in User Management tab in Clu", true);

        Pages.userManagement_cPuser().ClickOnSearchBarForEMPID();
        Reporter.log("Step 13: Click on Search Bar at CPUser Tab in User Management tab in Clu", true);

        Pages.userManagement_cPuser().FetchResultedSearchOfEMPID();
        Reporter.log("Step 14: Compare the resulted empID with entered empId  at CPUser Tab in User Management tab in Clu", true);
        driver.get().navigate().refresh();

        Pages.userManagement_cPuser().FetchMobileNoName();
        Reporter.log("Step 15: Fetch Random Mobile No at CPUser Tab in User Management tab in Clu", true);

        Pages.userManagement_cPuser().ClickOnSearchBarForMobileNo();
        Reporter.log("Step 16: Click on Search Bar at CPUser Tab in User Management tab in Clu", true);

        Pages.userManagement_cPuser().FetchResultedSearchOfMobileNo();
        Reporter.log("Step 17: Compare the resulted MobileNo with entered MobileNo  at CPUser Tab in User Management tab in Clu", true);
        driver.get().navigate().refresh();

        Pages.userManagement_cPuser().ClickOnNextPage();
        Reporter.log("Step 18:Click on NextPage");

//        Pages.userManagement_cPuser().DownloadXlsvFile();
//        Reporter.log("Step 19:Download xlsv file");
//
//        Pages.userManagement_cPuser().VerificationOfXlsvDownloadedFile();
//        Reporter.log("Step 20:Verfication of Download xlsv file");

    }
}
