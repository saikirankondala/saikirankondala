package testcases;

import enums.Helper;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Utils;

public class AllocatedUsersTestWithVehicleNo extends Utils {
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();
    final String CluCloud_ID = Helper.getId();

    @Test(testName = "Verify Vehicle No in allocated user search  In CluCloud Application ")
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

        Pages.allocatedUserSearchBasedOnVehicleNo().SelectVehicleNoFromXLSVFile();
        Reporter.log("Step 6: Fetch the Loan No from the XLSV file", true);

        Pages.allocatedUserSearchBasedOnVehicleNo().ClickOnSearchBarAndEnterVehicleNo();
        Reporter.log("Step 7: Click on Search Bar and enter VehicleNo", true);

        Pages.allocatedUserSearchBasedOnVehicleNo().ClickOnAllocatedUserSearchListView();
        Reporter.log("Step 8: Click on View Button ", true);

        Pages.allocatedUserSearchBasedOnVehicleNo().FetchVehicleNoandSearchInDrilldownSearch();
        Reporter.log("Step 9: Click On Second Search bar in Listed customer tab in allocated user");

        Pages.allocatedUserSearchBasedOnVehicleNo().SelectResultList();
        Reporter.log("Step 10:Selected the allocation details from the resulted list to validate the vehicle No");

        Pages.allocatedUserSearchBasedOnVehicleNo().VerifyVehicleNoInAllocationDetails();
        Reporter.log("Step 11: Verified the Vehicle No in Allocation details");


    }
}
