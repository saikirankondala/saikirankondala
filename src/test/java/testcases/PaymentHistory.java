package testcases;

import enums.Helper;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Rerunautomation;
import util.Utils;

public class PaymentHistory extends Utils {
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();
    final String CluCloud_ID = Helper.getId();
//(retryAnalyzer = Rerunautomation.class
    @Test(retryAnalyzer = Rerunautomation.class,testName = "Verify Payment History  In CluCloud Application ")
    public void verifyPaymentHistory() throws Exception, CustomException
    {
        loadUrl(CluCloud_URL);
        Reporter.log("Step 1 & 2: Launch Browser and load Clucloud URL", true);

        Pages.loginPage().login(CluCloud_USERNAME, CluCloud_PASSWORD, CluCloud_ID);
        Reporter.log("Step 3: Login into CluCloud", true);

        Pages.paymentHistory().ClickPaymentHistory();
        Reporter.log("Step 4: Click Payment History Management tab in Clu", true);

        Pages.paymentHistory().SearchLoanNoInPaymentHistory();
        Reporter.log("Step 5: Search LoanNo Payment History Management tab in Clu", true);

        Pages.paymentHistory().SearchCustomerNameInPaymentHistory();
        Reporter.log("Step 6: Search CustomerName Payment History Management tab in Clu", true);

        Pages.paymentHistory().SearchMobileNoInPaymentHistory();
        Reporter.log("Step 7: Search MobileNo Payment History Management tab in Clu", true);

//**************************************  Approval Drop Down   *************************************************///////////////////

        Pages.paymentHistory().ApprovalDropdownInPaymentHistory();
        Reporter.log("Step 8: Verify Approval dropdown in Payment History Management tab in Clu", true);

        Pages.paymentHistory().Pending_ApprovalDropdownInPaymentHistory();
        Reporter.log("Step 9: Verify Approval dropdown in Payment History Management tab in Clu", true);

        Pages.paymentHistory().Approved_ApprovalDropdownInPaymentHistory();
        Reporter.log("Step 10: Verify Approval dropdown in Payment History Management tab in Clu", true);
//
        Pages.paymentHistory().Rejected_ApprovalDropdownInPaymentHistory();
        Reporter.log("Step 11: Verify Approval dropdown in Payment History Management tab in Clu", true);

//        Pages.paymentHistory().CPnameDropdownInPaymentHistory();
//        Reporter.log("Step 12: verify CPName Payment History Management tab in Clu", true);

////        *****************************    Payment Mode ***********************************************************************//
//
//        Pages.paymentHistory().PaymentModeDropdownInPaymentHistory();
//        Reporter.log("Step 13: Verify All Payment mode in  Payment History Management tab in Clu", true);
////
        Pages.paymentHistory().BankTransfer_PaymentModeDropdownInPaymentHistory();
        Reporter.log("Step 12: Verify  Bank transfer Payment mode in  Payment History Management tab in Clu", true);

        Pages.paymentHistory().Cash_PaymentModeDropdownInPaymentHistory();
        Reporter.log("Step 13: Verify cash Payment mode in  Payment History Management tab in Clu", true);

        Pages.paymentHistory().QRCode_PaymentModeDropdownInPaymentHistory();
        Reporter.log("Step 14: Verify  QR code Payment mode in  Payment History Management tab in Clu", true);

        Pages.paymentHistory().UPI_PaymentModeDropdownInPaymentHistory();
        Reporter.log("Step 15: Verify UPI payment  mode in  Payment History Management tab in Clu", true);

        Pages.paymentHistory().UPI_Payment_request_PaymentModeDropdownInPaymentHistory();
        Reporter.log("Step 16: Verify  UPI payment request  mode in  Payment History Management tab in Clu", true);
//
        Pages.paymentHistory().BulkPayment_PaymentModeDropdownInPaymentHistory();
        Reporter.log("Step 17: Verify  Bulk Payment mode in  Payment History Management tab in Clu", true);
//
        Pages.paymentHistory().Others_PaymentModeDropdownInPaymentHistory();
        Reporter.log("Step 18: Verify  others Payment mode in  Payment History Management tab in Clu", true);

    }
}

