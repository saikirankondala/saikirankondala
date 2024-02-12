package testcases;

import enums.Helper;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Utils;

import java.io.IOException;

public class Graphs_UPI extends Utils {
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();

    final String CluCloud_ID=Helper.getId();
    @Test(testName = "Verify Collections Graphs In CluCloud Application ")
    public void verifyCluHomePage_graphs() throws IOException, CustomException {

        loadUrl(CluCloud_URL);
        //wait(5);
        Reporter.log("Step 1: Launch Browser and load Clucloud URL", true);

        Pages.loginPage().login(CluCloud_USERNAME, CluCloud_PASSWORD, CluCloud_ID);
        Reporter.log("Step 2: Login into CluCloud", true);
        wait(5);

        Pages.upi_graphs().PaymentType_All();
        Reporter.log("Step 3: Payment type:--All", true);
//
//        Pages.upi_graphs().Collection_7DaysFilter();
        Reporter.log("Step 4: Selected Last 7 Days Filter In FieldInvestigation Trends", true);
        wait(5);
//
        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 5: Downloaded SVG file in collection ", true);
//
        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 6: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 7: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 8:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 9:  Succesfully Removed Downloaded File from Root path ", true);

//---------------------------------Selected Custom month Date Range<----------------------------------------//
        Pages.upi_graphs().CurrentMonth_Filter();
        Reporter.log("Step 10:  Selected Current Month Filter In Collections Trends ", true);

        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 11: Downloaded SVG file in collection ", true);

        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 12: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 13: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 14:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 15:  Succesfully Removed Downloaded File from Root path ", true);

        //---------------------------------Selected last month Date Range<----------------------------------------//
        Pages.upi_graphs().LastMonth_Filter();
        Reporter.log("Step 16:  Selected Last Month Filter In Collections Trends ", true);

        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 17: Downloaded SVG file in collection ", true);

        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 18: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 19: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 20:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 21:  Succesfully Removed Downloaded File from Root path ", true);

//---------------------------------Selected last 6 month Date Range<----------------------------------------//

        Pages.upi_graphs().Last6Month_Filter();
        Reporter.log("Step 22:  Selected Last 6 Month Filter In Collections Trends ", true);

        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 23: Downloaded SVG file in collection ", true);
        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 24: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 25: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 26:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 27:  Succesfully Removed Downloaded File from Root path ", true);

        //---------------------------------Selected Custom month Date Range<----------------------------------------//

        Pages.upi_graphs().CustomMonths_Collection_Trends_Filter();
        Reporter.log("Step 28:  Selected Custom Month Filter In Collections Trends ", true);

        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 29: Downloaded SVG file in collection ", true);
        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 30: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 31: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 32:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 33:  Succesfully Removed Downloaded File from Root path ", true);
//
        Pages.upi_graphs().PaymentType_QRCode();
        Reporter.log("Step 34: Payment type:--QRcode", true);

        Pages.upi_graphs().Collection_7DaysFilter();
        Reporter.log("Step 35: Selected Last 7 Days Filter In FieldInvestigation Trends", true);
        wait(5);
//
        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 36: Downloaded SVG file in collection ", true);
//
        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 37: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 38: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 39:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 40:  Succesfully Removed Downloaded File from Root path ", true);

//---------------------------------Selected Custom month Date Range<----------------------------------------//
        Pages.upi_graphs().CurrentMonth_Filter();
        Reporter.log("Step 41:  Selected Current Month Filter In Collections Trends ", true);

        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 42: Downloaded SVG file in collection ", true);

        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 43: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 44: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 45:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 46:  Succesfully Removed Downloaded File from Root path ", true);

        //---------------------------------Selected last month Date Range<----------------------------------------//
        Pages.upi_graphs().LastMonth_Filter();
        Reporter.log("Step 47:  Selected Last Month Filter In Collections Trends ", true);

        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 48: Downloaded SVG file in collection ", true);

        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 49: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 50: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 51:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 52:  Succesfully Removed Downloaded File from Root path ", true);

//---------------------------------Selected last 6 month Date Range<----------------------------------------//

        Pages.upi_graphs().Last6Month_Filter();
        Reporter.log("Step 53:  Selected Last 6 Month Filter In Collections Trends ", true);

        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 54: Downloaded SVG file in collection ", true);
        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 55: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 56: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 57:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 58:  Succesfully Removed Downloaded File from Root path ", true);

        //---------------------------------Selected Custom month Date Range<----------------------------------------//

        Pages.upi_graphs().CustomMonths_Collection_Trends_Filter();
        Reporter.log("Step 59:  Selected Custom Month Filter In Collections Trends ", true);

        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 60: Downloaded SVG file in collection ", true);
        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 61: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 62: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 63:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 64:  Succesfully Removed Downloaded File from Root path ", true);
//
        Pages.upi_graphs().PaymentType_UPI();
        Reporter.log("Step 65: Payment type:--UPI", true);
 ///////////////////////////////////////////////////////////////////////////////////////////////////
 /////////////////////////////////////////////////////////////////////////////////
        Pages.upi_graphs().Collection_7DaysFilter();
        Reporter.log("Step 66: Selected Last 7 Days Filter In FieldInvestigation Trends", true);
        wait(5);
//
        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 67: Downloaded SVG file in collection ", true);
//
        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 68: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 69: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 70:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 71:  Succesfully Removed Downloaded File from Root path ", true);

//---------------------------------Selected Custom month Date Range<----------------------------------------//
        Pages.upi_graphs().CurrentMonth_Filter();
        Reporter.log("Step 72:  Selected Current Month Filter In Collections Trends ", true);

        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 73: Downloaded SVG file in collection ", true);

        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 74: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 75: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 76:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 77:  Succesfully Removed Downloaded File from Root path ", true);

        //---------------------------------Selected last month Date Range<----------------------------------------//
        Pages.upi_graphs().LastMonth_Filter();
        Reporter.log("Step 78:  Selected Last Month Filter In Collections Trends ", true);

        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 79: Downloaded SVG file in collection ", true);

        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 80: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 81: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 82:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 83:  Succesfully Removed Downloaded File from Root path ", true);

//---------------------------------Selected last 6 month Date Range<----------------------------------------//

        Pages.upi_graphs().Last6Month_Filter();
        Reporter.log("Step 84:  Selected Last 6 Month Filter In Collections Trends ", true);

        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 85: Downloaded SVG file in collection ", true);
        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 86: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 87: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 88:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 89:  Succesfully Removed Downloaded File from Root path ", true);

        //---------------------------------Selected Custom month Date Range<----------------------------------------//

        Pages.upi_graphs().CustomMonths_Collection_Trends_Filter();
        Reporter.log("Step 90:  Selected Custom Month Filter In Collections Trends ", true);

        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 91: Downloaded SVG file in collection ", true);
        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 92: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 93: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 94:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 95:  Succesfully Removed Downloaded File from Root path ", true);
//
        Pages.upi_graphs().PaymentType_BulkTransfer();
        Reporter.log("Step 96: Payment type:--Bulk Transfer", true);

        Pages.upi_graphs().Collection_7DaysFilter();
        Reporter.log("Step 97: Selected Last 7 Days Filter In FieldInvestigation Trends", true);
        wait(5);
//
        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 98: Downloaded SVG file in collection ", true);
//
        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 99: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 100: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 101:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 102:  Succesfully Removed Downloaded File from Root path ", true);

//---------------------------------Selected Custom month Date Range<----------------------------------------//
        Pages.upi_graphs().CurrentMonth_Filter();
        Reporter.log("Step 103:  Selected Current Month Filter In Collections Trends ", true);

        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 104: Downloaded SVG file in collection ", true);

        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 105: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 106: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 107:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 108:  Succesfully Removed Downloaded File from Root path ", true);

        //---------------------------------Selected last month Date Range<----------------------------------------//
        Pages.upi_graphs().LastMonth_Filter();
        Reporter.log("Step 109:  Selected Last Month Filter In Collections Trends ", true);

        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 110: Downloaded SVG file in collection ", true);

        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 111: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 112: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 113:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 114:  Succesfully Removed Downloaded File from Root path ", true);

//---------------------------------Selected last 6 month Date Range<----------------------------------------//

        Pages.upi_graphs().Last6Month_Filter();
        Reporter.log("Step 115:  Selected Last 6 Month Filter In Collections Trends ", true);

        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 116: Downloaded SVG file in collection ", true);
        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 117: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 118: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 119:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 120:  Succesfully Removed Downloaded File from Root path ", true);

        //---------------------------------Selected Custom month Date Range<----------------------------------------//

        Pages.upi_graphs().CustomMonths_Collection_Trends_Filter();
        Reporter.log("Step 121:  Selected Custom Month Filter In Collections Trends ", true);

        Pages.upi_graphs().clickDownloadSVGButton();
        Reporter.log("Step 122: Downloaded SVG file in collection ", true);
        Pages.upi_graphs().clickDownloadPNGButton();
        Reporter.log("Step 123: Downloaded PNG file in collection ", true);

        Pages.upi_graphs().clickDownloadCSVButton();
        Reporter.log("Step 124: Downloaded CSV file in collection ", true);

        Pages.upi_graphs().CSVRowCount();
        Reporter.log("Step 125:  RowCount of CSV and fields in CSV ", true);

        Pages.upi_graphs().removeDownloadedPNGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedSVGFiles();
        wait(2);
        Pages.upi_graphs().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 126:  Succesfully Removed Downloaded File from Root path ", true);
    }
}
