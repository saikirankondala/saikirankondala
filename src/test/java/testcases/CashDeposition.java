package testcases;

import enums.Helper;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Rerunautomation;
import util.Utils;

public class CashDeposition  extends Utils {
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();
    final String CluCloud_ID = Helper.getId();

    //(
    @Test(retryAnalyzer = Rerunautomation.class,testName = "Verify Cash Deposition Page  In CluCloud Application ")
    public void verifyPaymentHistory() throws Exception, CustomException {
        loadUrl(CluCloud_URL);
        Reporter.log("Step 1 & 2: Launch Browser and load Clucloud URL", true);

        Pages.loginPage().login(CluCloud_USERNAME, CluCloud_PASSWORD, CluCloud_ID);
        Reporter.log("Step 3: Login into CluCloud", true);

        Pages.cashDeposition().ClickOnPaymentHistory();
        Reporter.log("Step 4:Click on Payment History Tab", true);

        Pages.cashDeposition().clickOnCashDeposition();
        Reporter.log("Step 5: Click on Cash Deposition", true);

        Pages.cashDeposition().SearchEmpId();
        Reporter.log("Step 6: Searched EMPId in Cash deposoition", true);

        Pages.cashDeposition().SearchEmpName();
        Reporter.log("Step 7: Searched EmpName in cash deposotion", true);

        Pages.cashDeposition().SearchBankName();
        Reporter.log("Step 8: Search Bank name in cash deposition", true);

//        Pages.cashDeposition().SearchBankCode();

        Pages.cashDeposition().SearchUTRCode();
        Reporter.log("Step 9: Search Bank UTR No", true);

        Pages.cashDeposition().CashDeposition_Status_All();
        Reporter.log("Step 10: Verfied Cash deposition status :All", true);

        Pages.cashDeposition().CashDeposition_Staus_Mapped();
        Reporter.log("Step 11: Verfied Cash depsoiton staus:Mapped", true);

        Pages.cashDeposition().CashDeposition_Status_Deposited();
        Reporter.log("Step 12:Verfied Cash depsotion status:Deposited", true);

        Pages.cashDeposition().CashDeposition_Status_Rejected();
        Reporter.log("Step 13 : Verfied Cash depsoiton status:Rejected", true);


    }



    }
