package testcases;

import enums.Helper;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Rerunautomation;
import util.Utils;

import static util.Base.driver;

public class UserManagement_Executive extends Utils {
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();
    final String CluCloud_ID = Helper.getId();

    @Test(retryAnalyzer = Rerunautomation.class,testName = "Verify userManagement_Executive search bar  In CluCloud Application ")
    public void verifyCluUserManagement_Executive() throws Exception, CustomException
    {
        loadUrl(CluCloud_URL);
        Reporter.log("Step 1 & 2: Launch Browser and load Clucloud URL", true);

        Pages.loginPage().login(CluCloud_USERNAME, CluCloud_PASSWORD, CluCloud_ID);
        Reporter.log("Step 3: Login into CluCloud", true);

        Pages.userManagement_executive().ClickOnUserManagement();
        Reporter.log("Step 4: Click UserManagement tab in Clu", true);

        Pages.userManagement_executive().ClickOnManagerTab();
        Reporter.log("Step 5: Click on Executive Tab Management tab in Clu", true);

        Pages.userManagement_executive().FetchEmployeeName();
        Reporter.log("Step 6: Fetch Random Employee Name at Executive Tab in User Management tab in Clu", true);

        Pages.userManagement_executive().ClickOnSearchBar();
        Reporter.log("Step 7: Click on Search Bar at Executive Tab in User Management tab in Clu", true);

        Pages.userManagement_executive().FetchResultedSearch();
        Reporter.log("Step 8: Compare the resulted Emp Name with entered name  at Executive Tab in User Management tab in Clu", true);
        driver.get().navigate().refresh();

        Pages.userManagement_executive().FetchBranchName();
        Reporter.log("Step 9: Fetch Random Branch Name at Executive Tab in User Management tab in Clu", true);

        Pages.userManagement_executive().ClickOnSearchBarForBranchName();
        Reporter.log("Step 10: Click on Search Bar at Executive Tab in User Management tab in Clu", true);

        Pages.userManagement_executive().FetchResultedSearchOfBranchName();
        Reporter.log("Step 11: Compare the resulted branch Name with entered branch name  at Executive Tab in User Management tab in Clu", true);
        driver.get().navigate().refresh();

        Pages.userManagement_executive().FetchEMPIDName();
        Reporter.log("Step 12: Fetch Random EmpID at Executive Tab in User Management tab in Clu", true);

        Pages.userManagement_executive().ClickOnSearchBarForEMPID();
        Reporter.log("Step 13: Click on Search Bar at Executive Tab in User Management tab in Clu", true);

        Pages.userManagement_executive().FetchResultedSearchOfEMPID();
        Reporter.log("Step 14: Compare the resulted empID with entered empId  at Executive Tab in User Management tab in Clu", true);
        driver.get().navigate().refresh();

        Pages.userManagement_executive().FetchMobileNoName();
        Reporter.log("Step 15: Fetch Random Mobile No at Executive Tab in User Management tab in Clu", true);

        Pages.userManagement_executive().ClickOnSearchBarForMobileNo();
        Reporter.log("Step 16: Click on Search Bar at Executive Tab in User Management tab in Clu", true);

        Pages.userManagement_executive().FetchResultedSearchOfMobileNo();
        Reporter.log("Step 17: Compare the resulted MobileNo with entered MobileNo  at Executive Tab in User Management tab in Clu", true);
        driver.get().navigate().refresh();

        Pages.userManagement_executive().ClickOnNextPage();
        Reporter.log("Step 18:Click on NextPage");

        Pages.userManagement_executive().DownloadXlsvFile();
        Reporter.log("Step 19:Download xlsv file");

        Pages.userManagement_executive().VerificationOfXlsvDownloadedFile();
        Reporter.log("Step 20:Verfication of Download xlsv file");


    }
}
