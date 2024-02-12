package testcases;

import enums.Helper;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Utils;

import java.io.IOException;

public class Graphs_BranchWiseCollectionsTrend  extends Utils
{
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();

    final String CluCloud_ID=Helper.getId();

    @Test(testName = "Verify BranchWise Collection Graphs In CluCloud Application ")
    public void verifyCluHomePage_graphs() throws IOException, CustomException
    {

        loadUrl(CluCloud_URL);
        //wait(5);
        Reporter.log("Step 1: Launch Browser and load Clucloud URL", true);

        Pages.loginPage().login(CluCloud_USERNAME, CluCloud_PASSWORD, CluCloud_ID);
        Reporter.log("Step 2: Login into CluCloud", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().Type_BranchWiseCollection();
        Reporter.log("Step 3: Selected BranchWise Collection in trends", true);

        Reporter.log("Step 3: Selected Last 7 Days Filter In branch wise collection Trends", true);
        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 4: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 5: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 6: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 7:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 8:  Succesfully Removed Downloaded File from Root path ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CurrentMonth_Filter();
        Reporter.log("Step 9:  Selected Current Month Filter In branch wise collection Trends ", true);
        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 10: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 11: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 12: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 13:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 14:  Succesfully Removed Downloaded File from Root path ", true);
//---------------------------------Selected Last month Date Range<----------------------------------------//
        Pages.home_graphs_BranchWiseCollectionsTrend().LastMonth_Filter();
        Reporter.log("Step 15:  Selected Last Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 16: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 17: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 18: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 19:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 20:  Succesfully Removed Downloaded File from Root path ", true);



//---------------------------------Selected Last 6 month Date Range<----------------------------------------//

        Pages.home_graphs_BranchWiseCollectionsTrend().Last6Month_Filter();
        Reporter.log("Step 21:  Selected Last 6 Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 22: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 23: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 24: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 25:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 26:  Succesfully Removed Downloaded File from Root path ", true);
//---------------------------------Selected Custom month Date Range<----------------------------------------//
        Pages.home_graphs_BranchWiseCollectionsTrend().CustomMonths_Collection_Trends_Filter();
        Reporter.log("Step 27:  Selected Custom Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 28: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 29: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 30: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 31:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 32:  Succesfully Removed Downloaded File from Root path ", true);


//////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////
// ///////////////////////////////////////////////////////////////////
///////////////////////////


        //---------------------------------STATUS:--PAID(counts)<----------------------------------------//
        Pages.home_graphs_BranchWiseCollectionsTrend().Collection_Status_Paid_SubType_Counts();
        Reporter.log("Step 33:  Selected Paid Status  and sub type Counts Filter In branch wise collection Trends ", true);

        //---------------------------------Selected 7 Days Date Range<----------------------------------------//
        Pages.home_graphs_BranchWiseCollectionsTrend().Collection_7DaysFilter();
        Reporter.log("Step 34: Selected Last 7 Days Filter In branch wise collection Trends", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 35: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 36: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 37: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 38:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 39:  Succesfully Removed Downloaded File from Root path ", true);

//---------------------------------Selected Custom month Date Range<----------------------------------------//
        Pages.home_graphs_BranchWiseCollectionsTrend().CurrentMonth_Filter();
        Reporter.log("Step 40:  Selected Current Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 41: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 42: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 43: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 44:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 45:  Succesfully Removed Downloaded File from Root path ", true);

        //---------------------------------Selected last month Date Range<----------------------------------------//
        Pages.home_graphs_BranchWiseCollectionsTrend().LastMonth_Filter();
        Reporter.log("Step 46:  Selected Last Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 47: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 48: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 49: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 50:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 51:  Succesfully Removed Downloaded File from Root path ", true);

//---------------------------------Selected last 6 month Date Range<----------------------------------------//

        Pages.home_graphs_BranchWiseCollectionsTrend().Last6Month_Filter();
        Reporter.log("Step 52:  Selected Last 6 Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 53: Downloaded SVG file in branch wise collection ", true);
        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 54: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 55: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 56:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 57:  Succesfully Removed Downloaded File from Root path ", true);

        //---------------------------------Selected Custom month Date Range<----------------------------------------//

        Pages.home_graphs_BranchWiseCollectionsTrend().CustomMonths_Collection_Trends_Filter();
        Reporter.log("Step 58:  Selected Custom Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 59: Downloaded SVG file in branch wise collection ", true);
        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 60: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 61: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 62:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 63:  Succesfully Removed Downloaded File from Root path ", true);
        ////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////Collections:Status:-paid---Sub type:-Amount////////////////////////////////////
        //---------------------------------Selected Custom month Date Range<----------------------------------------//
        Pages.home_graphs_BranchWiseCollectionsTrend().Collection_Status_Paid_SubType_Amonut();
        Reporter.log("Step 64:  Selected Paid Status and Sub type Amounts Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().Collection_7DaysFilter();
        Reporter.log("Step 65: Selected Last 7 Days Filter In branch wise collection Trends", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 66: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 67: Downloaded PNG file in collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 68: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 69:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 70:  Succesfully Removed Downloaded File from Root path ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CurrentMonth_Filter();
        Reporter.log("Step 71:  Selected Current Month Filter In branch wise collection Trends ", true);
        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 72: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 73: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 74: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 75:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 76:  Succesfully Removed Downloaded File from Root path ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().LastMonth_Filter();
        Reporter.log("Step 77:  Selected Last Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 78: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 79: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 80: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 81:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 82:  Succesfully Removed Downloaded File from Root path ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().Last6Month_Filter();
        Reporter.log("Step 83:  Selected Last 6 Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 84: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 85: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 86: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 87:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 88:  Succesfully Removed Downloaded File from Root path ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CustomMonths_Collection_Trends_Filter();
        Reporter.log("Step 89:  Selected Custom Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 90: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 91: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 92: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 93:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 94:  Succesfully Removed Downloaded File from Root path ", true);

        //////////////Collection:PTP//////////////////////////
        wait(10);
        Pages.home_graphs_BranchWiseCollectionsTrend().Collection_Status_PTP();
        Reporter.log("Step 95:  Selected PTP Status  Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().Collection_7DaysFilter();
        Reporter.log("Step 96: Selected Last 7 Days Filter In branch wise collection Trends", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 97: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 98: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 99: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 100:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 101:  Succesfully Removed Downloaded File from Root path ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CurrentMonth_Filter();
        Reporter.log("Step 102:  Selected Current Month Filter In branch wise collection Trends ", true);
        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 103: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 104: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 105: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 106:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 107:  Succesfully Removed Downloaded File from Root path ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().LastMonth_Filter();
        Reporter.log("Step 108:  Selected Last Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 109: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 110: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 111: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 112:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 113:  Succesfully Removed Downloaded File from Root path ", true);


        Pages.home_graphs_BranchWiseCollectionsTrend().Last6Month_Filter();
        Reporter.log("Step 114:  Selected Last 6 Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 115: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 116: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 117: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 118:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        Reporter.log("Step 119:  Succesfully Removed Downloaded File from Root path ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CustomMonths_Collection_Trends_Filter();
        Reporter.log("Step 120:  Selected Custom Month Filter In branch wise collection Trends ", true);
/////////////////////////////////////////////////////////////////////////////////////////////////////////
        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 121: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 122: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 123: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 124:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 125:  Succesfully Removed Downloaded File from Root path ", true);


        /////////////////////Collection:Type:----CustomerNot availble
        wait(10);
        Pages.home_graphs_BranchWiseCollectionsTrend().Collection_Status_CustomerNotAvailable();
        Reporter.log("Step 126:  Selected PTP Status  Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().Collection_7DaysFilter();
        Reporter.log("Step 127: Selected Last 7 Days Filter In branch wise collection Trends", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 128: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 129: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 130: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 131:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 132:  Succesfully Removed Downloaded File from Root path ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CurrentMonth_Filter2();
        Reporter.log("Step 133:  Selected Current Month Filter In branch wise collection Trends ", true);
        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 134: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 135: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 136: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 137:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 138:  Succesfully Removed Downloaded File from Root path ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().LastMonth_Filter();
        Reporter.log("Step 139:  Selected Last Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 140: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 141: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 142: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 143:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 144:  Succesfully Removed Downloaded File from Root path ", true);


        Pages.home_graphs_BranchWiseCollectionsTrend().Last6Month_Filter();
        Reporter.log("Step 145:  Selected Last 6 Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 146: Downloaded SVG file in  branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 147: Downloaded PNG file in b branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 148: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 149:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 150:  Succesfully Removed Downloaded File from Root path ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CustomMonths_Collection_Trends_Filter();
        Reporter.log("Step 151:  Selected Custom Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 152: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 153: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 154: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 155:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 156:  Succesfully Removed Downloaded File from Root path ", true);
/////////////////////////////////////////////////
        //////////////////////////////////////
        /////////////////////////////////////////////
        ///////////////////////////////////Status :need attention//////////////////////////////

        Pages.home_graphs_BranchWiseCollectionsTrend().Collection_Status_NeedAttention();
        Reporter.log("Step 157:  Selected Need Attention Status  Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().Collection_7DaysFilter();
        Reporter.log("Step 158: Selected Last 7 Days Filter In branch wise collection Trends", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 159: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 160: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 161: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 162:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 163:  Succesfully Removed Downloaded File from Root path ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CurrentMonth_Filter2();
        Reporter.log("Step 164:  Selected Current Month Filter In branch wise collection Trends ", true);
        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 165: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 166: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 167: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 168:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 169:  Succesfully Removed Downloaded File from Root path ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().LastMonth_Filter();
        Reporter.log("Step 170:  Selected Last Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 171: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 172: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 173: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 174:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 175:  Succesfully Removed Downloaded File from Root path ", true);


        Pages.home_graphs_BranchWiseCollectionsTrend().Last6Month_Filter();
        Reporter.log("Step 176:  Selected Last 6 Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 177: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 178: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 179: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 180:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 181:  Succesfully Removed Downloaded File from Root path ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CustomMonths_Collection_Trends_Filter();
        Reporter.log("Step 182:  Selected Custom Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 183: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 184: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 185: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 186:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 187:  Succesfully Removed Downloaded File from Root path ", true);

        ////////////////////////////////////////////////////
        ///////////////////////////////////////////////////
        //////////////////////////////////////////////////
        //////////Collection:Legal Case
        Pages.home_graphs_BranchWiseCollectionsTrend().Collection_Status_Legal_Case();
        Reporter.log("Step 188:  Selected Legal Case  Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().Collection_7DaysFilter();
        Reporter.log("Step 189: Selected Last 7 Days Filter In branch wise collection Trends", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 190: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 191: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 192: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 193:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 194:  Succesfully Removed Downloaded File from Root path ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CurrentMonth_Filter2();
        Reporter.log("Step 95:  Selected Current Month Filter In Collections Trends ", true);
        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 196: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 197: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 198: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 199:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 200:  Succesfully Removed Downloaded File from Root path ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().LastMonth_Filter();
        Reporter.log("Step 201:  Selected Last Month Filter In Collections Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 202: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 203: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 204: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 205:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 206:  Succesfully Removed Downloaded File from Root path ", true);


        Pages.home_graphs_BranchWiseCollectionsTrend().Last6Month_Filter();
        Reporter.log("Step 207:  Selected Last 6 Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 208: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 209: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 210: Downloaded CSV file in branch wise branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 211:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 212:  Succesfully Removed Downloaded File from Root path ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CustomMonths_Collection_Trends_Filter();
        Reporter.log("Step 213:  Selected Custom Month Filter In branch wise collection Trends ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadSVGButton();
        Reporter.log("Step 214: Downloaded SVG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadPNGButton();
        Reporter.log("Step 215: Downloaded PNG file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().clickDownloadCSVButton();
        Reporter.log("Step 216: Downloaded CSV file in branch wise collection ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().CSVRowCount();
        Reporter.log("Step 217:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_BranchWiseCollectionsTrend().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 218:  Succesfully Removed Downloaded File from Root path ", true);


    }

}
