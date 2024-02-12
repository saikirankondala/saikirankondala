package pages;

import com.aventstack.extentreports.Status;
import com.opencsv.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import util.Reporter.Reporter;
import util.Utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Graphs_CollectionTrends extends Utils
{

    By Collection_menu = By.xpath("/html/body/div/div[1]/div[4]/div/div/div[3]/div/div[2]/div/div/div/div/div[3]/div[1]");
    By Download_SVG = By.xpath("/html/body/div/div[1]/div[4]/div/div/div[3]/div/div[2]/div/div/div/div/div[3]/div[2]/div[1]");
    By Download_PNG = By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div[3]/div/div[2]/div/div/div/div/div[3]/div[2]/div[2]");
    By Download_CSV = By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div[3]/div/div[2]/div/div/div/div/div[3]/div[2]/div[3]");
    By Collection_7Days_Trends = By.xpath("//*[@id=\"collectionsDateRange\"]//*[text()='Last 7 Days']");
    By Collections_Current_Month_Trends = By.xpath("//*[@id=\"collectionsDateRange\"]//*[text()='Current Month']");
    By Collectionss_Last_Month_Trends = By.xpath("//*[@id=\"collectionsDateRange\"]//*[text()='Last Month']");
    By Collections_Last_6Months_Trends = By.xpath("//*[@id=\"collectionsDateRange\"]//*[text()='Last 6 Months']");
    By COllections_Custom_Months = By.xpath("//*[@id=\"collectionsDateRange\"]//*[text()='Custom Month']");
    By Select_Custom_month = By.xpath("/html/body/div[2]/div[2]/div/div/span[4]");
    By custom_month_CollectionTrend = By.xpath("//*[@id=\"collectionsDateRange\"]//*[text()='Custom Month']");
    By Collection_custom_month_calender_textbox=By.xpath("//*[@id=\"collectionsCustomOption\"]/input");

    By Type_Collections = By.xpath("//*[@id=\"graphTypeOptions\"]//*[text()='Collections']");
    By Collection_StatusType_All = By.xpath("//*[@id=\"statusOptions\"]//*[text()='All']");
    ///////Status
    By Collection_StatusType_Paid = By.xpath("//*[@id=\"statusOptions\"]//*[text()='Paid']");
    By Collection_StatusType_Paid_SubType_Counts = By.xpath("//*[@id=\"status2Options\"]//*[text()='Counts']");
    By Collection_Type_PTP=By.xpath("//*[@id=\"statusOptions\"]//*[text()='PTP']");
    By Collection_StatusType_Paid_SubType_Amounts = By.xpath("//*[@id=\"status2Options\"]//*[text()='Amounts']");
    By Collection_Type_CustomerNotAvailable=By.xpath("//*[@id=\"statusOptions\"]//*[text()='Customer Not Available']");
    By Collection_Type_NeedsAttention=By.xpath("//*[@id=\"statusOptions\"]//*[text()='Needs Attention']");
    By Collection_Type_LegalCase_Trends = By.xpath("//*[@id=\"statusOptions\"]//*[text()='Legal Case']");
    static final String FAIL_CSS_START = "<font color='red'>";
    static final String FAIL_CSS_END = "</font>";

    public void clickDownloadSVGButton() throws IOException, CustomException {
        //Download SVG
        try {
        waitforElementToBePresent(Collection_menu);
        waitforElementToBeClickable(Collection_menu);
        click(Collection_menu);
        wait(5);
        waitforElementToBePresent(Download_SVG);
        waitforElementToBeClickable(Download_SVG);
        click(Download_SVG);
        }
        catch (NoSuchElementException m)
        {
            test().log(Status.PASS, "No graph to download.");
            return;
        }
        wait(5);

        String downloadFolderPath = "src/file_download";  // Replace with the actual folder path
        String fileName = "Preview Graph.svg";  // Replace with the actual file name

        // Verify if the file exists
        File downloadedFile = new File(downloadFolderPath, fileName);
        boolean isFileDownloaded = downloadedFile.exists();
        // Assertion
        if (isFileDownloaded) {

            test().log(Status.PASS, "File has been downloaded successfully.");
        } else {
            test().log(Status.FAIL, "File download verification failed.");

        }
    }

    public void clickDownloadPNGButton() throws IOException, CustomException {
        try
        {
        waitforElementToBePresent(Collection_menu);
        verifyElementPresent(Collection_menu);
        waitforElementToBeClickable(Collection_menu);
        click(Collection_menu);
        //Download SVG
        waitforElementToBePresent(Download_PNG);
        verifyElementPresent(Download_PNG);
        waitforElementToBeClickable(Download_PNG);
            click(Download_PNG);
        } catch (NoSuchElementException m) {
            test().log(Status.PASS, "No graph to download.");
            return;
        }
        wait(5);
        String downloadFolderPath = "src/file_download";  // Replace with the actual folder path
        String fileName = "Preview Graph.png";  // Replace with the actual file name

        // Verify if the file exists
        File downloadedFile = new File(downloadFolderPath, fileName);
        boolean isFileDownloaded = downloadedFile.exists();
        // Assertion
        if (isFileDownloaded) {

            test().log(Status.PASS, "File has been downloaded successfully.");
        } else {
            test().log(Status.FAIL, "File download verification failed.");

        }
    }

    public void clickDownloadCSVButton() throws IOException, CustomException {
        try
        {
        waitforElementToBePresent(Collection_menu);
        verifyElementPresent(Collection_menu);
        waitforElementToBeClickable(Collection_menu);
        click(Collection_menu);
        //Download SVG
        waitforElementToBePresent(Download_CSV);
        verifyElementPresent(Download_CSV);
        waitforElementToBeClickable(Download_CSV);
            click(Download_CSV);
        } catch (NoSuchElementException m) {
            test().log(Status.PASS, "No graph to download.");
            return;
        }
        wait(5);
        String downloadFolderPath = "src/file_download";  // Replace with the actual folder path
        String fileName = "Collections Trend.csv";  // Replace with the actual file name

        // Verify if the file exists
        File downloadedFile = new File(downloadFolderPath, fileName);
        boolean isFileDownloaded = downloadedFile.exists();
        // Assertion
        if (isFileDownloaded) {

            test().log(Status.PASS, "File has been downloaded successfully.");
        } else {
            test().log(Status.FAIL, "File download verification failed.");

        }
    }

    public void CSVRowCount() {

        String csvFilePath = "src/file_download/Collections Trend.csv";
        File file=new File(csvFilePath);
        int rowCount = 0;
        String[] fieldNames = null;
        if(file.exists()) {

            try (CSVReader reader = new CSVReader(new FileReader(csvFilePath)))
            {
                // Read field names from the first row
                fieldNames = reader.readNext();

                // Count rows
                while (reader.readNext() != null)
                {
                    rowCount++;
                }

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            if(fieldNames.length == 0&& rowCount==0)
            {
                test().log(Status.FAIL, "No data avaible in the CSV file");

            }
            Reporter.log("Number of rows in the CSV file: " + rowCount);
            Reporter.log("Field names: " + String.join(", ", fieldNames));
        }
        else
        {
            Reporter.log("no file found");
        }

    }

    public void CurrentMonth_Filter2() {


        waitforElementToBeClickable(Collection_7Days_Trends);
        click(Collection_7Days_Trends);
        waitforElementToBeClickable(Collections_Current_Month_Trends);
        click(Collections_Current_Month_Trends);
    }
    public void CurrentMonth_Filter()
    {
        waitforElementToBeClickable(Collection_7Days_Trends);
        click(Collection_7Days_Trends);
        waitforElementToBeClickable(Collections_Current_Month_Trends);
        click(Collections_Current_Month_Trends);
    }

    public void LastMonth_Filter() {

        waitforElementToBeClickable(Collections_Current_Month_Trends);
        click(Collections_Current_Month_Trends);
        waitforElementToBeClickable(Collectionss_Last_Month_Trends);
        click(Collectionss_Last_Month_Trends);
    }

    public void Last6Month_Filter() {

        waitforElementToBeClickable(Collectionss_Last_Month_Trends);
        click(Collectionss_Last_Month_Trends);
        waitforElementToBeClickable(Collections_Last_6Months_Trends);
        click(Collections_Last_6Months_Trends);
    }

    public void CustomMonths_Collection_Trends_Filter() {

        waitforElementToBeClickable(Collections_Last_6Months_Trends);
        click(Collections_Last_6Months_Trends);
        //Select Custom Month
        waitforElementToBeClickable(COllections_Custom_Months);
        click(COllections_Custom_Months);
        //Select custom month in calendar button
        waitforElementToBeClickable(Collection_custom_month_calender_textbox);
        click(Collection_custom_month_calender_textbox);
        //select Custom month in calendar
        waitforElementToBeClickable(Select_Custom_month);
        click(Select_Custom_month);
    }


    public void removeDownloadedPNGFiles() {
        String fileToDelete = "Preview Graph.png";
        String path = "src/file_download";
        String filePath = path + File.separator + fileToDelete;
        File file = new File(filePath);
        try {
            if (file.exists()) {
                if (file.delete()) {
                    test().log(Status.PASS,"File '" + fileToDelete + "' deleted successfully.");
                } else {
                    test().log(Status.FAIL,"Unable to delete '" + fileToDelete + "'.");
                }
            }
        } catch (NoSuchElementException m) {
            //test().log(Status.PASS,"No file to delete");
            Reporter.log("**********************No file to delete ***********************************");
            return;
        }

    }

    public void removeDownloadedSVGFiles() {
        String fileToDelete = "Preview Graph.svg";
        String path = "src/file_download";
        String filePath = path + File.separator + fileToDelete;
        File file = new File(filePath);
        try {
            if (file.exists()) {
                if (file.delete()) {
                    test().log(Status.PASS,"File '" + fileToDelete + "' deleted successfully.");
                } else {
                    test().log(Status.FAIL,"Unable to delete '" + fileToDelete + "'.");
                }
            }
        } catch (NoSuchElementException m) {
            //test().log(Status.PASS,"No file to delete");
            Reporter.log("**********************No file to delete ***********************************");
            return;
        }

    }

    public void removeDownloadedCSVFiles() {
        String fileToDelete = "Collections Trend.csv";
        String path = "src/file_download";
        String filePath = path + File.separator + fileToDelete;
        File file = new File(filePath);
        try {
            if (file.exists()) {
                if (file.delete())
                {
                    test().log(Status.PASS,"File '" + fileToDelete + "' deleted successfully.");
                } else {
                    test().log(Status.FAIL,"Unable to delete '" + fileToDelete + "'.");
                }
            }
        } catch (NoSuchElementException m) {
            //test().log(Status.PASS,"No file to delete");
            Reporter.log("**********************No file to delete ***********************************");
            return;
        }

    }

    public void Collection_Status_Paid_SubType_Counts()
    {
        waitforElementToBeClickable(Collection_StatusType_All);
        click(Collection_StatusType_All);
        waitforElementToBeClickable(Collection_StatusType_Paid);
        click(Collection_StatusType_Paid);
    }

    public void Collection_Status_Paid_SubType_Amonut()
    {
        waitforElementToBeClickable(Collection_StatusType_Paid_SubType_Counts);
        click(Collection_StatusType_Paid_SubType_Counts);
        waitforElementToBeClickable(Collection_StatusType_Paid_SubType_Amounts);
        click(Collection_StatusType_Paid_SubType_Amounts);

    }
    public void Collection_7DaysFilter()
    {
        waitforElementToBeClickable(custom_month_CollectionTrend);
        click(custom_month_CollectionTrend);
        waitforElementToBeClickable(Collection_7Days_Trends);
        click(Collection_7Days_Trends);
    }

    public void Collection_Status_PTP()
    {
        waitforElementToBeClickable(Collection_StatusType_Paid);
        click(Collection_StatusType_Paid);
        waitforElementToBeClickable(Collection_Type_PTP);
        click(Collection_Type_PTP);
    }
    public void Collection_Status_CustomerNotAvailable()
    {
        waitforElementToBeClickable(Collection_Type_PTP);
        click(Collection_Type_PTP);
        waitforElementToBeClickable(Collection_Type_CustomerNotAvailable);
        click(Collection_Type_CustomerNotAvailable);
    }
    public void Collection_Status_NeedAttention()
    {
        waitforElementToBeClickable(Collection_Type_CustomerNotAvailable);
        click(Collection_Type_CustomerNotAvailable);
        waitforElementToBeClickable(Collection_Type_NeedsAttention);
        click(Collection_Type_NeedsAttention);
    }
    public void Collection_Status_Legal_Case()
    {

        waitforElementToBeClickable(Collection_Type_NeedsAttention);
        click(Collection_Type_NeedsAttention);
        waitforElementToBeClickable(Collection_Type_LegalCase_Trends);
        click(Collection_Type_LegalCase_Trends);
    }
}