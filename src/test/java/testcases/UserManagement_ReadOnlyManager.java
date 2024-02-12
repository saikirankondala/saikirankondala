package testcases;

import enums.Helper;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Rerunautomation;
import util.Utils;

import static util.Base.driver;

public class UserManagement_ReadOnlyManager extends Utils {
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();
    final String CluCloud_ID = Helper.getId();

    @Test(retryAnalyzer = Rerunautomation.class,testName = "Verify userManagement_ReadOnlyManager search bar  In CluCloud Application ")
    public void verifyCluuserManagement_ReadOnlyManagers() throws Exception, CustomException
    {
        loadUrl(CluCloud_URL);
        Reporter.log("Step 1 & 2: Launch Browser and load Clucloud URL", true);

        Pages.loginPage().login(CluCloud_USERNAME, CluCloud_PASSWORD, CluCloud_ID);
        Reporter.log("Step 3: Login into CluCloud", true);

        Pages.userManagementRaManager().ClickOnUserManagement();
        Reporter.log("Step 4: Click User Management tab in Clu", true);

        Pages.userManagementRaManager().ClickOnManagerTab();
        Reporter.log("Step 5: Click on Manager Tab Management tab in Clu", true);

        Pages.userManagementRaManager().FetchEmployeeName();
        Reporter.log("Step 6: Fetch Random Employee Name at RA Manager Tab in User Management tab in Clu", true);

        Pages.userManagementRaManager().ClickOnSearchBar();
        Reporter.log("Step 7: Click on Search Bar at RA Manager Tab in User Management tab in Clu", true);

        Pages.userManagementRaManager().FetchResultedSearch();
        Reporter.log("Step 8: Compare the resulted Emp Name with entered name  at RA Manager Tab in User Management tab in Clu", true);
        driver.get().navigate().refresh();

        Pages.userManagementRaManager().FetchBranchName();
        Reporter.log("Step 9: Fetch Random Branch Name at RA Manager Tab in User Management tab in Clu", true);

        Pages.userManagementRaManager().ClickOnSearchBarForBranchName();
        Reporter.log("Step 10: Click on Search Bar at RA Manager Tab in User Management tab in Clu", true);

        Pages.userManagementRaManager().FetchResultedSearchOfBranchName();
        Reporter.log("Step 11: Compare the resulted branch Name with entered branch name  at RA Manager Tab in User Management tab in Clu", true);
        driver.get().navigate().refresh();

        Pages.userManagementRaManager().FetchEMPIDName();
        Reporter.log("Step 12: Fetch Random EmpID at RA Manager Tab in User Management tab in Clu", true);

        Pages.userManagementRaManager().ClickOnSearchBarForEMPID();
        Reporter.log("Step 13: Click on Search Bar at RA Manager Tab in User Management tab in Clu", true);

        Pages.userManagementRaManager().FetchResultedSearchOfEMPID();
        Reporter.log("Step 14: Compare the resulted empID with entered empId  at RA Manager Tab in User Management tab in Clu", true);
        driver.get().navigate().refresh();

        Pages.userManagementRaManager().FetchMobileNoName();
        Reporter.log("Step 15: Fetch Random Mobile No at RA Manager Tab in User Management tab in Clu", true);

        Pages.userManagementRaManager().ClickOnSearchBarForMobileNo();
        Reporter.log("Step 16: Click on Search Bar at RA Manager Tab in User Management tab in Clu", true);

        Pages.userManagementRaManager().FetchResultedSearchOfMobileNo();
        Reporter.log("Step 17: Compare the resulted MobileNo with entered MobileNo  at RA Manager Tab in User Management tab in Clu", true);
        driver.get().navigate().refresh();

        Pages.userManagementRaManager().ClickOnNextPage();
        Reporter.log("Step 18:Click on NextPage");

        Pages.userManagementRaManager().DownloadXlsvFile();
        Reporter.log("Step 19:Download xlsv file");

        Pages.userManagementRaManager().VerificationOfXlsvDownloadedFile();
        Reporter.log("Step 20:Verfication of Download xlsv file");
    }
}
