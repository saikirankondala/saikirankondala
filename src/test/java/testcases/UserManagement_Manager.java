package testcases;

import enums.Helper;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Rerunautomation;
import util.Utils;

import static util.Base.driver;

public class UserManagement_Manager extends Utils {
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();
    final String CluCloud_ID = Helper.getId();

    @Test(retryAnalyzer = Rerunautomation.class,testName = "Verify userManagement_manager search bar  In CluCloud Application ")
    public void verifyCluuserManagement_managerPage_Managers() throws Exception, CustomException
    {
        loadUrl(CluCloud_URL);
        Reporter.log("Step 1 & 2: Launch Browser and load Clucloud URL", true);

        Pages.loginPage().login(CluCloud_USERNAME, CluCloud_PASSWORD, CluCloud_ID);
        Reporter.log("Step 3: Login into CluCloud", true);

        Pages.userManagement_manager().ClickOnUserManagement();
        Reporter.log("Step 4: Click gement tab in Clu", true);

        Pages.userManagement_manager().ClickOnManagerTab();
        Reporter.log("Step 5: Click on Manager Tab Management tab in Clu", true);

        Pages.userManagement_manager().FetchEmployeeName();
        Reporter.log("Step 6: Fetch Random Employee Name at Manager Tab in User Management tab in Clu", true);

        Pages.userManagement_manager().ClickOnSearchBar();
        Reporter.log("Step 7: Click on Search Bar at Manager Tab in User Management tab in Clu", true);

        Pages.userManagement_manager().FetchResultedSearch();
        Reporter.log("Step 8: Compare the resulted Emp Name with entered name  at Manager Tab in User Management tab in Clu", true);
        driver.get().navigate().refresh();

        Pages.userManagement_manager().FetchBranchName();
        Reporter.log("Step 9: Fetch Random Branch Name at Manager Tab in User Management tab in Clu", true);

        Pages.userManagement_manager().ClickOnSearchBarForBranchName();
        Reporter.log("Step 10: Click on Search Bar at Manager Tab in User Management tab in Clu", true);

        Pages.userManagement_manager().FetchResultedSearchOfBranchName();
        Reporter.log("Step 11: Compare the resulted branch Name with entered branch name  at Manager Tab in User Management tab in Clu", true);
        driver.get().navigate().refresh();

        Pages.userManagement_manager().FetchEMPIDName();
        Reporter.log("Step 12: Fetch Random EmpID at Manager Tab in User Management tab in Clu", true);

        Pages.userManagement_manager().ClickOnSearchBarForEMPID();
        Reporter.log("Step 13: Click on Search Bar at Manager Tab in User Management tab in Clu", true);

        Pages.userManagement_manager().FetchResultedSearchOfEMPID();
        Reporter.log("Step 14: Compare the resulted empID with entered empId  at Manager Tab in User Management tab in Clu", true);
        driver.get().navigate().refresh();

        Pages.userManagement_manager().FetchMobileNoName();
        Reporter.log("Step 15: Fetch Random Mobile No at Manager Tab in User Management tab in Clu", true);

        Pages.userManagement_manager().ClickOnSearchBarForMobileNo();
        Reporter.log("Step 16: Click on Search Bar at Manager Tab in User Management tab in Clu", true);

        Pages.userManagement_manager().FetchResultedSearchOfMobileNo();
        Reporter.log("Step 17: Compare the resulted MobileNo with entered MobileNo  at Manager Tab in User Management tab in Clu", true);
        driver.get().navigate().refresh();

        Pages.userManagement_manager().ClickOnNextPage();
        Reporter.log("Step 18:Click on NextPage");

        Pages.userManagement_manager().DownloadXlsvFile();
        Reporter.log("Step 19:Download xlsv file");

        Pages.userManagement_manager().VerificationOfXlsvDownloadedFile();
        Reporter.log("Step 20:Verfication of Download xlsv file");


    }
}
