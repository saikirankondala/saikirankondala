package testcases;

import enums.Helper;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Rerunautomation;
import util.Utils;

public class NonVisitedPaymentHistory extends Utils {
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();
    final String CluCloud_ID = Helper.getId();

    //(retryAnalyzer = Rerunautomation.class
    @Test(retryAnalyzer = Rerunautomation.class,testName = "Verify Non-Visited Payment History  In CluCloud Application ")
    public void verifyPaymentHistory() throws Exception, CustomException
    {
        loadUrl(CluCloud_URL);
        Reporter.log("Step 1 & 2: Launch Browser and load Clucloud URL", true);

        Pages.loginPage().login(CluCloud_USERNAME, CluCloud_PASSWORD, CluCloud_ID);
        Reporter.log("Step 3: Login into CluCloud", true);

        Pages.paymentHistory().ClickPaymentHistory();
        Reporter.log("Step 4: Click Payment History Management tab in Clu", true);

        Pages.nonVisitedPayments().ClickOnNonVisitedTab();
        Reporter.log("Step 5: Clicked on Non Visited Payment History Management tab in Clu", true);
        wait(10);
        Pages.nonVisitedPayments().SearchLoanNO();
        Reporter.log("Step 6: Searched loan No in Non Visited Payment History Management tab in Clu", true);

        Pages.nonVisitedPayments().SearchCustomerName();
        Reporter.log("Step 7: Searched Customer No in Non Visited Payment History Management tab in Clu", true);

        Pages.nonVisitedPayments().SearchMobileNo();
        Reporter.log("Step 8: Searched Mobile No in Non Visited Payment History Management tab in Clu", true);
        /*
        Default UPI payment Drop is selected in non visited payment pages
        */
        Pages.nonVisitedPayments().ApprovalStatus_All();
        Reporter.log("Step 9: Selected Approval Status:All &Payment mode:UPI Payment request Payment Mode in Non Visited Payment History Management tab in Clu", true);

        Pages.nonVisitedPayments().PaymentMode_UPImandate();
        Pages.nonVisitedPayments().ApprovalStatus_All();
        Reporter.log("Step 10: Selected Approval Status:All &Payment mode:UPI Mandate Mode in Non Visited Payment History Management tab in Clu", true);

        Pages.nonVisitedPayments().PaymentMode_cash();
        Pages.nonVisitedPayments().ApprovalStatus_All();
        Reporter.log("Step 11: Selected Approval Status:All &Payment mode:Cash Payment Mode in Non Visited Payment History Management tab in Clu", true);

        Pages.nonVisitedPayments().PaymentMode_BankTransfer();
        Pages.nonVisitedPayments().ApprovalStatus_All();
        Reporter.log("Step 12: Selected Approval Status:All &Payment mode:Bank Transfer Mode in Non Visited Payment History Management tab in Clu", true);

        Pages.nonVisitedPayments().PaymentMode_UPI();
        Pages.nonVisitedPayments().ApprovalStatus_All();
        Reporter.log("Step 13: Selected Approval Status:All &Payment mode:UPI  Mode in Non Visited Payment History Management tab in Clu", true);

//**************************************************************************************************************************************************************************************//
        /*
        Default UPI payment Drop is selected in non visited payment pages
        */
        Pages.nonVisitedPayments().UPIPaymentMode();
         Pages.nonVisitedPayments().ApprovalStatus_Pending();
        Reporter.log("Step 14: Selected Approval Status:Pending &Payment mode:UPI Payment request Payment Mode in Non Visited Payment History Management tab in Clu", true);

        Pages.nonVisitedPayments().PaymentMode_UPImandate();
        Pages.nonVisitedPayments().ApprovalStatus_Pending();
        Reporter.log("Step 15: Selected Approval Status:Pending &Payment mode:UPI Mandate Payment Mode in Non Visited Payment History Management tab in Clu", true);


        Pages.nonVisitedPayments().PaymentMode_cash();
        Pages.nonVisitedPayments().ApprovalStatus_Pending();
        Reporter.log("Step 16: Selected Approval Status:Pending &Payment mode:Cash Mode in Non Visited Payment History Management tab in Clu", true);


        Pages.nonVisitedPayments().PaymentMode_BankTransfer();
        Pages.nonVisitedPayments().ApprovalStatus_Pending();
        Reporter.log("Step 17: Selected Approval Status:Pending & Payment mode:Bank transfer Payment Mode in Non Visited Payment History Management tab in Clu", true);


        Pages.nonVisitedPayments().PaymentMode_UPI();
        Pages.nonVisitedPayments().ApprovalStatus_Pending();
        Reporter.log("Step 18: Selected Approval Status:Pending &Payment mode:UPI Payment Mode in Non Visited Payment History Management tab in Clu", true);


        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         /*
        Default UPI payment Drop is selected in non visited payment pages
        */
        Pages.nonVisitedPayments().UPIPaymentMode();
        Pages.nonVisitedPayments().ApprovalStatus_Approved();
        Reporter.log("Step 19: Selected Approval Status:Approved &Payment mode:UPI payment request Payment Mode in Non Visited Payment History Management tab in Clu", true);


        Pages.nonVisitedPayments().PaymentMode_UPImandate();
        Pages.nonVisitedPayments().ApprovalStatus_Approved();
        Reporter.log("Step 20: Selected Approval Status:Approved &Payment mode:UPI mandate Payment Mode in Non Visited Payment History Management tab in Clu", true);


        Pages.nonVisitedPayments().PaymentMode_cash();
        Pages.nonVisitedPayments().ApprovalStatus_Approved();
        Reporter.log("Step 21: Selected Approval Status:Approved &Payment mode:Cash Payment Mode in Non Visited Payment History Management tab in Clu", true);


        Pages.nonVisitedPayments().PaymentMode_BankTransfer();
        Pages.nonVisitedPayments().ApprovalStatus_Approved();
        Reporter.log("Step 22: Selected Approval Status:Approved &Payment mode:Bank transfer Payment Mode in Non Visited Payment History Management tab in Clu", true);


        Pages.nonVisitedPayments().PaymentMode_UPI();
        Pages.nonVisitedPayments().ApprovalStatus_Approved();
        Reporter.log("Step 23: Selected Approval Status:Approved &Payment mode:UPI Payment Mode in Non Visited Payment History Management tab in Clu", true);

//        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//          /*
//        Default UPI payment Drop is selected in non visited payment pages
//        */
        Pages.nonVisitedPayments().UPIPaymentMode();
        Pages.nonVisitedPayments().ApprovalStatus_Rejected();
        Reporter.log("Step 24: Selected Approval Status:Rejected &Payment mode:UPI Payment  Request Payment Mode in Non Visited Payment History Management tab in Clu", true);


        Pages.nonVisitedPayments().PaymentMode_UPImandate();
        Pages.nonVisitedPayments().ApprovalStatus_Rejected();
        Reporter.log("Step 25: Selected Approval Status:Rejected &Payment mode:UPI Mandate Payment Mode in Non Visited Payment History Management tab in Clu", true);


        Pages.nonVisitedPayments().PaymentMode_cash();
        Pages.nonVisitedPayments().ApprovalStatus_Rejected();
        Reporter.log("Step 26: Selected Approval Status:Rejected &Payment mode:Cash Payment Mode in Non Visited Payment History Management tab in Clu", true);


        Pages.nonVisitedPayments().PaymentMode_BankTransfer();
        Pages.nonVisitedPayments().ApprovalStatus_Rejected();
        Reporter.log("Step 27: Selected Approval Status:Rejeceted &Payment mode:Bank transfer Payment Mode in Non Visited Payment History Management tab in Clu", true);


        Pages.nonVisitedPayments().PaymentMode_UPI();
        Pages.nonVisitedPayments().ApprovalStatus_Rejected();
        Reporter.log("Step 28: Selected Approval Status:Rejected &Payment mode:UPI Payment Mode in Non Visited Payment History Management tab in Clu", true);



    }

}