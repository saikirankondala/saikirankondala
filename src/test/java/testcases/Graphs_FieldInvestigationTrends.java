package testcases;

import enums.Helper;
import org.testng.annotations.Test;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;
import util.Utils;

import java.io.IOException;

public class Graphs_FieldInvestigationTrends extends Utils
{
    final String CluCloud_URL = Helper.getURL();
    final String CluCloud_USERNAME = Helper.getUser();
    final String CluCloud_PASSWORD = Helper.getPassword();

    final String CluCloud_ID=Helper.getId();

    @Test(testName = "Verify  Field Investigsation Graphs  In CluCloud Application ")
    public void verifyCluHomePage_graphs() throws IOException, CustomException {

        loadUrl(CluCloud_URL);
        //wait(5);
        Reporter.log("Step 1: Launch Browser and load Clucloud URL", true);

        Pages.loginPage().login(CluCloud_USERNAME, CluCloud_PASSWORD, CluCloud_ID);
        Reporter.log("Step 2: Login into CluCloud", true);
        wait(10);

        Pages.home_graphs_FieldInvestigationTrends().Type_FieldInvestigation();
        Reporter.log("Step 3: Selected FieldInvestigation in trends", true);

        Pages.home_graphs_FieldInvestigationTrends().Collection_7DaysFilter();
        Reporter.log("Step 4: Selected Last 7 Days Filter In FieldInvestigation Trends", true);

        Pages.home_graphs_FieldInvestigationTrends().clickDownloadSVGButton();
        Reporter.log("Step 5: Downloaded SVG file in collection ", true);

        Pages.home_graphs_FieldInvestigationTrends().clickDownloadPNGButton();
        Reporter.log("Step 6: Downloaded PNG file in collection ", true);

        Pages.home_graphs_FieldInvestigationTrends().clickDownloadCSVButton();
        Reporter.log("Step 7: Downloaded CSV file in collection ", true);

        Pages.home_graphs_FieldInvestigationTrends().CSVRowCount();
        Reporter.log("Step 8:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_FieldInvestigationTrends().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_FieldInvestigationTrends().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_FieldInvestigationTrends().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 9:  Succesfully Removed Downloaded File from Root path ", true);

//---------------------------------Selected Custom month Date Range<----------------------------------------//
        Pages.home_graphs_FieldInvestigationTrends().CurrentMonth_Filter();
        Reporter.log("Step 10:  Selected Current Month Filter In Collections Trends ", true);

        Pages.home_graphs_FieldInvestigationTrends().clickDownloadSVGButton();
        Reporter.log("Step 11: Downloaded SVG file in collection ", true);

        Pages.home_graphs_FieldInvestigationTrends().clickDownloadPNGButton();
        Reporter.log("Step 12: Downloaded PNG file in collection ", true);

        Pages.home_graphs_FieldInvestigationTrends().clickDownloadCSVButton();
        Reporter.log("Step 13: Downloaded CSV file in collection ", true);

        Pages.home_graphs_FieldInvestigationTrends().CSVRowCount();
        Reporter.log("Step 14:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_FieldInvestigationTrends().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_FieldInvestigationTrends().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_FieldInvestigationTrends().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 15:  Succesfully Removed Downloaded File from Root path ", true);

        //---------------------------------Selected last month Date Range<----------------------------------------//
        Pages.home_graphs_FieldInvestigationTrends().LastMonth_Filter();
        Reporter.log("Step 16:  Selected Last Month Filter In Collections Trends ", true);

        Pages.home_graphs_FieldInvestigationTrends().clickDownloadSVGButton();
        Reporter.log("Step 17: Downloaded SVG file in collection ", true);

        Pages.home_graphs_FieldInvestigationTrends().clickDownloadPNGButton();
        Reporter.log("Step 18: Downloaded PNG file in collection ", true);

        Pages.home_graphs_FieldInvestigationTrends().clickDownloadCSVButton();
        Reporter.log("Step 19: Downloaded CSV file in collection ", true);

        Pages.home_graphs_FieldInvestigationTrends().CSVRowCount();
        Reporter.log("Step 20:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_FieldInvestigationTrends().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_FieldInvestigationTrends().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_FieldInvestigationTrends().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 21:  Succesfully Removed Downloaded File from Root path ", true);

//---------------------------------Selected last 6 month Date Range<----------------------------------------//

        Pages.home_graphs_FieldInvestigationTrends().Last6Month_Filter();
        Reporter.log("Step 22:  Selected Last 6 Month Filter In Collections Trends ", true);

        Pages.home_graphs_FieldInvestigationTrends().clickDownloadSVGButton();
        Reporter.log("Step 23: Downloaded SVG file in collection ", true);
        Pages.home_graphs_FieldInvestigationTrends().clickDownloadPNGButton();
        Reporter.log("Step 24: Downloaded PNG file in collection ", true);

        Pages.home_graphs_FieldInvestigationTrends().clickDownloadCSVButton();
        Reporter.log("Step 25: Downloaded CSV file in collection ", true);

        Pages.home_graphs_FieldInvestigationTrends().CSVRowCount();
        Reporter.log("Step 26:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_FieldInvestigationTrends().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_FieldInvestigationTrends().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_FieldInvestigationTrends().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 27:  Succesfully Removed Downloaded File from Root path ", true);

        //---------------------------------Selected Custom month Date Range<----------------------------------------//

        Pages.home_graphs_FieldInvestigationTrends().CustomMonths_Collection_Trends_Filter();
        Reporter.log("Step 28:  Selected Custom Month Filter In Collections Trends ", true);

        Pages.home_graphs_FieldInvestigationTrends().clickDownloadSVGButton();
        Reporter.log("Step 29: Downloaded SVG file in collection ", true);
        Pages.home_graphs_FieldInvestigationTrends().clickDownloadPNGButton();
        Reporter.log("Step 30: Downloaded PNG file in collection ", true);

        Pages.home_graphs_FieldInvestigationTrends().clickDownloadCSVButton();
        Reporter.log("Step 31: Downloaded CSV file in collection ", true);

        Pages.home_graphs_FieldInvestigationTrends().CSVRowCount();
        Reporter.log("Step 32:  RowCount of CSV and fields in CSV ", true);

        Pages.home_graphs_FieldInvestigationTrends().removeDownloadedPNGFiles();
        wait(2);
        Pages.home_graphs_FieldInvestigationTrends().removeDownloadedSVGFiles();
        wait(2);
        Pages.home_graphs_FieldInvestigationTrends().removeDownloadedCSVFiles();
        wait(2);
        Reporter.log("Step 33:  Succesfully Removed Downloaded File from Root path ", true);
    }
}
