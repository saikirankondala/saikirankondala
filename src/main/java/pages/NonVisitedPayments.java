package pages;

import com.aventstack.extentreports.Status;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import util.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static util.Base.driver;

public class NonVisitedPayments  extends Utils
{
    //    By PaymentHistorySearchBar = By.xpath("//input[@placeholder='Search by Loan No/Customer Name/Mobile No']");
    By PaymentHistorySearchBar = By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[2]/div/div/div[1]/div[2]/div[3]/div/input");
    By AppprovalDropDown_Pending = By.xpath("//*[@id=\"nonVisitedApprovaStatusFilter\"]//*[text()='Pending']");

    By ApprovalDropDown_Approved = By.xpath("//*[@id='ApprovaStatusFilter']//*[text()='Approved']");
    By ApprovalDropDown_Rejected = By.xpath("//*[@id='ApprovaStatusFilter']//*[text()='Rejected']");
    By PaymentMode_UPIPaymentRequest = By.xpath("//*[@id=\"nonVisitedPaymentModes\"]//*[text()='UPI Payment Request']");
    By PaymentMode_UPIMandate = By.xpath("//*[@id=\"nonVisitedPaymentModes\"]//*[text()='UPI Mandates']");
    By PaymentMode_Cash = By.xpath("//*[@id=\"nonVisitedPaymentModes\"]//*[text()='Cash']");
    By PaymentMode_BankTransfer = By.xpath("//*[@id=\"nonVisitedPaymentModes\"]//*[text()='Bank Transfer']");
    By PaymentMode_UPI = By.xpath("//*[@id=\"nonVisitedPaymentModes\"]//*[text()='UPI']");
    By DownloadButton = By.xpath("//*[@id=\"nonVisitedDownlaod\"]");
    By ApprovalDropDown_All = By.xpath("//*[@id=\"nonVisitedApprovaStatusFilter\"]//*[text()='All']");
    By AppprovalDropDown_Rejected = By.xpath("//*[@id=\"nonVisitedApprovaStatusFilter\"]//*[text()='Rejected']");
    By AppprovalDropDown_Approved = By.xpath("//*[@id=\"nonVisitedApprovaStatusFilter\"]//*[text()='Approved']");

    public void ClickOnNonVisitedTab()
    {
        By NonVisitedTab = By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/ul/li[2]/a");
        waitforElementToBePresents(NonVisitedTab);
        waitforElementToBeClickable(NonVisitedTab);
        ;
        click(NonVisitedTab);
        wait(2);
    }

    public void SearchLoanNO()
    {
        waitforElementToBeVisible(PaymentHistorySearchBar);
        waitforElementToBePresent(PaymentHistorySearchBar);
        waitforElementToBeClickable(PaymentHistorySearchBar);
        wait(2);
        jsClick(PaymentHistorySearchBar);
        wait(2);
        ////
        List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div[1]/div/table/tbody/tr/td[3]"));
        int LoanNoCount = rows.size();
        int i = getRandomNumber(1, LoanNoCount);
        String LoanNoInPaymentTab = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div[1]/div/table/tbody/tr[" + i + "]/td[3]";
        By LoanNo = By.xpath(LoanNoInPaymentTab);
        WebElement EmpName = getElement(LoanNo);
        LoanNoInPaymentTab = EmpName.getText();
        WebElement element = driver.get().findElement(PaymentHistorySearchBar);
        element.sendKeys(LoanNoInPaymentTab);
        wait(5);
        ///
        String LoanNoInPaymentTab_Search = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div[1]/div/table/tbody/tr[1]/td[3]";

        By LoanNo_text2 = By.xpath(LoanNoInPaymentTab_Search);
        try
        {
            WebElement LoanNoInPaymentTab_Search_text = getElement(LoanNo_text2);
            String LoanNoInPaymentTab2 = LoanNoInPaymentTab_Search_text.getText();
            if (LoanNoInPaymentTab.equalsIgnoreCase(LoanNoInPaymentTab2)) {
                test().log(Status.PASS, "=====>Searched LoanNo " + LoanNoInPaymentTab + " is matched");
            } else {
                test().log(Status.FAIL, "=====>Searched LoanNo " + LoanNoInPaymentTab + " is not matched");
            }
        }
        catch (NoSuchElementException e)
        {

        }


    }

    public void SearchCustomerName() {
        WebElement textBox = driver.get().findElement(PaymentHistorySearchBar);
        textBox.clear();
        waitforElementToBeVisible(PaymentHistorySearchBar);
        waitforElementToBePresent(PaymentHistorySearchBar);
        waitforElementToBeClickable(PaymentHistorySearchBar);
        jsClick(PaymentHistorySearchBar);
        ////
        List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div[1]/div/table/tbody/tr/td[3]"));
        int LoanNoCount = rows.size();
        int i = getRandomNumber(1, LoanNoCount);
        String LoanNoInPaymentTab = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div[1]/div/table/tbody/tr[" + i + "]/td[1]";
        By LoanNo = By.xpath(LoanNoInPaymentTab);
        WebElement EmpName = getElement(LoanNo);
        LoanNoInPaymentTab = EmpName.getText();
        WebElement element = driver.get().findElement(PaymentHistorySearchBar);
        element.sendKeys(LoanNoInPaymentTab);
        wait(5);
        ///
        String LoanNoInPaymentTab_Search = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div[1]/div/table/tbody/tr[1]/td[1]";

        By LoanNo_text2 = By.xpath(LoanNoInPaymentTab_Search);
        try {
            WebElement LoanNoInPaymentTab_Search_text = getElement(LoanNo_text2);
            String LoanNoInPaymentTab2 = LoanNoInPaymentTab_Search_text.getText();
            if (LoanNoInPaymentTab.equalsIgnoreCase(LoanNoInPaymentTab2)) {
                test().log(Status.PASS, "=====>Searched CustomerName " + LoanNoInPaymentTab + " is matched");
            } else {
                test().log(Status.FAIL, "=====>Searched cusotmerName " + LoanNoInPaymentTab + " is not matched");
            }
        }
        catch (NoSuchElementException e)
        {

        }
    }

    public void SearchMobileNo()
    {
        WebElement textBox = driver.get().findElement(PaymentHistorySearchBar);
        textBox.clear();
        waitforElementToBeVisible(PaymentHistorySearchBar);
        waitforElementToBePresent(PaymentHistorySearchBar);
        waitforElementToBeClickable(PaymentHistorySearchBar);
        jsClick(PaymentHistorySearchBar);
        ////
        List<WebElement> rows = getElementsList(By.xpath("//*[@id='main-wrapper']/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div[1]/div/table/tbody/tr/td[2]"));
        int LoanNoCount = rows.size();
        int i = getRandomNumber(1, LoanNoCount);
        String LoanNoInPaymentTab = "//*[@id='main-wrapper']/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div[1]/div/table/tbody/tr[" + i + "]/td[2]";
        By LoanNo = By.xpath(LoanNoInPaymentTab);
        WebElement EmpName = getElement(LoanNo);
        LoanNoInPaymentTab = EmpName.getText();
        WebElement element = driver.get().findElement(PaymentHistorySearchBar);
        element.sendKeys(LoanNoInPaymentTab);
        wait(5);
        ///
        String LoanNoInPaymentTab_Search = "//*[@id='main-wrapper']/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div[1]/div/table/tbody/tr[1]/td[2]";

        By LoanNo_text2 = By.xpath(LoanNoInPaymentTab_Search);
        try {
            WebElement LoanNoInPaymentTab_Search_text = getElement(LoanNo_text2);
            String LoanNoInPaymentTab2 = LoanNoInPaymentTab_Search_text.getText();
            if (LoanNoInPaymentTab.equalsIgnoreCase(LoanNoInPaymentTab2)) {
                test().log(Status.PASS, "=====>Searched MobileNo " + LoanNoInPaymentTab + " is matched");
            } else {
                test().log(Status.FAIL, "=====>Searched MobileNo " + LoanNoInPaymentTab + " is not matched");
            }
        }
        catch (NoSuchElementException e)
        {

        }
        textBox.clear();

    }
    public void ApprovalStatus_All_UPIPaymentMode()
    {
        int PaymentTransactionCount = 0;
//        driver.get().navigate().refresh();
        for (int i = 1; i < 1000; i++)
        {
            wait(5);
            List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div[1]/div/table/tbody/tr/td[3]"));
            PaymentTransactionCount += rows.size();
            //          wait(2);
            int j = i + 1;
            String NextPage = "/html/body/div[1]/div[1]/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div[2]/nav/ul//*[@id='pagebutton" + j + "']//button[@class='page-link']";
            wait(1);
            try
            {
                By Next_Page = By.xpath(NextPage);
                scrollDown(driver.get());
                waitforElementToBeVisible(Next_Page);
                waitforElementToBePresent(Next_Page);
                waitforElementToBeClickable(Next_Page);
//                wait(3);
                jsClick(Next_Page);
            }
            catch (NoSuchElementException E)
            {
                i = 1000;
            }

        }
        //**************************** download***************************************//
        jsClick(DownloadButton);
        wait(5);
        String Manager_Reports = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory = System.getProperty("user.dir") + "/" + Manager_Reports;
        File dir = new File(downloadDirectory);
        File[] files = dir.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Non_Visited"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Non Visited Payments File of UPI Payments mode has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("UPI Payments mode files found in the directory.");
            test().log(Status.FAIL, "=====>Non Visited payments File of UPI Payments mode download verification failed.");
        }
        System.out.println(PaymentTransactionCount);

        //******************************download verfication******************************//

        int Manager_XLSVRowCount = 0;
        String Manager_Reports2 = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory2 = System.getProperty("user.dir") + "/" + Manager_Reports2;
        File dir2 = new File(downloadDirectory2);
        File[] files2 = dir2.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Non_Visited"))
                {
                    String csvFilePath = file.getAbsolutePath();
                    try (FileInputStream fileInputStream = new FileInputStream(csvFilePath);
                         Workbook workbook = new XSSFWorkbook(fileInputStream))
                    {
                        Sheet sheet = workbook.getSheetAt(0);
                        Manager_XLSVRowCount = sheet.getPhysicalNumberOfRows() - 1;
                        //System.out.println("Number of rows in the XLSX file: " + rowCount);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            if (PaymentTransactionCount == Manager_XLSVRowCount)
            {
                test().log(Status.PASS, "=====>Non Visited Payments Pagenation of UPI Payments mode " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Non Visited  Payments Pagenation  of UPI Payments mode" + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Non Visited  Payments Pagenation  of UPI Payments mode" + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Non Visited Payments Pagenation  of UPI Payments mode" + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Non Visited Payments Downloaded XLSV file of UPI Payments mode");

        }
        //Downloaded File Deleting
        File folder = new File(downloadDirectory);
        if (folder.exists() && folder.isDirectory())
        {
            File[] list=folder.listFiles();
            if(list!=null)
            {
                for (File lists:list)
                {
                    if(lists.isFile())
                    {
                        lists.delete();
                        System.out.println("Deleted file: " + lists.getName());

                    }

                }
            }
            else
            {
                System.out.println("No files found in the folder.");

            }


        }
        else
        {
            System.out.println("Folder does not exist or is not a directory.");
        }
    }

    public void ApprovalStatus_All()
    {
        int PaymentTransactionCount = 0;
//        driver.get().navigate().refresh();
        for (int i = 1; i < 1000; i++)
        {
            wait(2);
            List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div[1]/div/table/tbody/tr/td[3]"));
            PaymentTransactionCount += rows.size();
            //          wait(2);
            int j = i + 1;
            String NextPage = "/html/body/div[1]/div[1]/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div[2]/nav/ul//*[@id='pagebutton" + j + "']//button[@class='page-link']";
            wait(1);
            try
            {
                By Next_Page = By.xpath(NextPage);
                scrollDown(driver.get());
                waitforElementToBeVisible(Next_Page);
                waitforElementToBePresent(Next_Page);
                waitforElementToBeClickable(Next_Page);
//                wait(3);
                jsClick(Next_Page);
            }
            catch (NoSuchElementException E)
            {
                i = 1000;
            }

        }
        //**************************** download***************************************//
        jsClick(DownloadButton);
        wait(5);
        String Manager_Reports = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory = System.getProperty("user.dir") + "/" + Manager_Reports;
        File dir = new File(downloadDirectory);
        File[] files = dir.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Non_Visited"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Non Visited Payments File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>Non Visited payments File download verification failed.");
        }
        System.out.println(PaymentTransactionCount);

        //******************************download verfication******************************//

        int Manager_XLSVRowCount = 0;
        String Manager_Reports2 = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory2 = System.getProperty("user.dir") + "/" + Manager_Reports2;
        File dir2 = new File(downloadDirectory2);
        File[] files2 = dir2.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Non_Visited"))
                {
                    String csvFilePath = file.getAbsolutePath();
                    try (FileInputStream fileInputStream = new FileInputStream(csvFilePath);
                         Workbook workbook = new XSSFWorkbook(fileInputStream))
                    {
                        Sheet sheet = workbook.getSheetAt(0);
                        Manager_XLSVRowCount = sheet.getPhysicalNumberOfRows() - 1;
                        //System.out.println("Number of rows in the XLSX file: " + rowCount);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            if (PaymentTransactionCount == Manager_XLSVRowCount)
            {
                test().log(Status.PASS, "=====>Non Visited Payments Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Non Visited  Payments Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Non Visited  Payments Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Non Visited Payments Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Non Visited Payments Downloaded XLSV file");

        }
        //Downloaded File Deleting
        File folder = new File(downloadDirectory);
        if (folder.exists() && folder.isDirectory())
        {
            File[] list=folder.listFiles();
            if(list!=null)
            {
                for (File lists:list)
                {
                    if(lists.isFile())
                    {
                        lists.delete();
                        System.out.println("Deleted file: " + lists.getName());

                    }

                }
            }
            else
            {
                System.out.println("No files found in the folder.");

            }


        }
        else
        {
            System.out.println("Folder does not exist or is not a directory.");
        }
    }
    public void ApprovalStatus_Pending()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(2);
        try{
        waitforElementToBePresents(ApprovalDropDown_All);
        waitforElementToBeClickable(ApprovalDropDown_All);
        click(ApprovalDropDown_All);
        wait(2);
        waitforElementToBePresent(AppprovalDropDown_Pending);
        waitforElementToBeClickable(AppprovalDropDown_Pending);
        click(AppprovalDropDown_Pending);
        }
        catch (NoSuchElementException e)
        {

        }
        //////////////////////////////////////////
        int PaymentTransactionCount = 0;
//        driver.get().navigate().refresh();
        for (int i = 1; i < 1000; i++)
        {
            wait(2);
            List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div[1]/div/table/tbody/tr/td[3]"));
            PaymentTransactionCount += rows.size();
            //          wait(2);
            int j = i + 1;
            String NextPage = "/html/body/div[1]/div[1]/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div[2]/nav/ul//*[@id='pagebutton" + j + "']//button[@class='page-link']";
            wait(1);
            try
            {
                By Next_Page = By.xpath(NextPage);
                scrollDown(driver.get());
                waitforElementToBeVisible(Next_Page);
                waitforElementToBePresent(Next_Page);
                waitforElementToBeClickable(Next_Page);
//                wait(3);
                jsClick(Next_Page);
            }
            catch (NoSuchElementException E)
            {
                i = 1000;
            }

        }
        //**************************** download***************************************//
        jsClick(DownloadButton);
        wait(5);
        String Manager_Reports = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory = System.getProperty("user.dir") + "/" + Manager_Reports;
        File dir = new File(downloadDirectory);
        File[] files = dir.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Non_Visited"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Non Visited Payments File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>Non Visited payments File download verification failed.");
        }
        System.out.println(PaymentTransactionCount);

        //******************************download verfication******************************//

        int Manager_XLSVRowCount = 0;
        String Manager_Reports2 = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory2 = System.getProperty("user.dir") + "/" + Manager_Reports2;
        File dir2 = new File(downloadDirectory2);
        File[] files2 = dir2.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Non_Visited"))
                {
                    String csvFilePath = file.getAbsolutePath();
                    try (FileInputStream fileInputStream = new FileInputStream(csvFilePath);
                         Workbook workbook = new XSSFWorkbook(fileInputStream))
                    {
                        Sheet sheet = workbook.getSheetAt(0);
                        Manager_XLSVRowCount = sheet.getPhysicalNumberOfRows() - 1;
                        //System.out.println("Number of rows in the XLSX file: " + rowCount);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            if (PaymentTransactionCount == Manager_XLSVRowCount)
            {
                test().log(Status.PASS, "=====>Non Visited Payments Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Non Visited  Payments Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Non Visited  Payments Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Non Visited Payments Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Non Visited Payments Downloaded XLSV file");

        }
        //Downloaded File Deleting
        File folder = new File(downloadDirectory);
        if (folder.exists() && folder.isDirectory())
        {
            File[] list=folder.listFiles();
            if(list!=null)
            {
                for (File lists:list)
                {
                    if(lists.isFile())
                    {
                        lists.delete();
                        System.out.println("Deleted file: " + lists.getName());

                    }

                }
            }
            else
            {
                System.out.println("No files found in the folder.");

            }


        }
        else
        {
            System.out.println("Folder does not exist or is not a directory.");
        }


    }

    public void ApprovalStatus_Approved() {

//
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(2);
//        js.executeScript("window.scrollBy(0,-400)", "");
        try {
            waitforElementToBePresents(ApprovalDropDown_All);
            waitforElementToBeClickable(ApprovalDropDown_All);
            click(ApprovalDropDown_All);
            wait(2);
            waitforElementToBePresent(AppprovalDropDown_Approved);
            waitforElementToBeClickable(AppprovalDropDown_Approved);
            click(AppprovalDropDown_Approved);
        }
        catch (NoSuchElementException e)
        {

        }
        //////////////////////////////////////////
        int PaymentTransactionCount = 0;
//        driver.get().navigate().refresh();
        for (int i = 1; i < 1000; i++)
        {
            wait(5);
            List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div[1]/div/table/tbody/tr/td[3]"));
            PaymentTransactionCount += rows.size();
            //          wait(2);
            int j = i + 1;
            String NextPage = "/html/body/div[1]/div[1]/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div[2]/nav/ul//*[@id='pagebutton" + j + "']//button[@class='page-link']";
            wait(1);
            try
            {
                By Next_Page = By.xpath(NextPage);
                scrollDown(driver.get());
                waitforElementToBeVisible(Next_Page);
                waitforElementToBePresent(Next_Page);
                waitforElementToBeClickable(Next_Page);
//                wait(3);
                jsClick(Next_Page);
            }
            catch (NoSuchElementException E)
            {
                i = 1000;
            }

        }
        //**************************** download***************************************//
        jsClick(DownloadButton);
        wait(5);
        String Manager_Reports = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory = System.getProperty("user.dir") + "/" + Manager_Reports;
        File dir = new File(downloadDirectory);
        File[] files = dir.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Non_Visited"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Non Visited Payments File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>Non Visited payments File download verification failed.");
        }
        System.out.println(PaymentTransactionCount);

        //******************************download verfication******************************//

        int Manager_XLSVRowCount = 0;
        String Manager_Reports2 = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory2 = System.getProperty("user.dir") + "/" + Manager_Reports2;
        File dir2 = new File(downloadDirectory2);
        File[] files2 = dir2.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Non_Visited"))
                {
                    String csvFilePath = file.getAbsolutePath();
                    try (FileInputStream fileInputStream = new FileInputStream(csvFilePath);
                         Workbook workbook = new XSSFWorkbook(fileInputStream))
                    {
                        Sheet sheet = workbook.getSheetAt(0);
                        Manager_XLSVRowCount = sheet.getPhysicalNumberOfRows() - 1;
                        //System.out.println("Number of rows in the XLSX file: " + rowCount);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            if (PaymentTransactionCount == Manager_XLSVRowCount)
            {
                test().log(Status.PASS, "=====>Non Visited Payments Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Non Visited  Payments Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Non Visited  Payments Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Non Visited Payments Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Non Visited Payments Downloaded XLSV file");

        }
        //Downloaded File Deleting
        File folder = new File(downloadDirectory);
        if (folder.exists() && folder.isDirectory())
        {
            File[] list=folder.listFiles();
            if(list!=null)
            {
                for (File lists:list)
                {
                    if(lists.isFile())
                    {
                        lists.delete();
                        System.out.println("Deleted file: " + lists.getName());

                    }

                }
            }
            else
            {
                System.out.println("No files found in the folder.");

            }


        }
        else
        {
            System.out.println("Folder does not exist or is not a directory.");
        }


    }

    public void ApprovalStatus_Rejected() {

        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(2);
        try {
            waitforElementToBePresents(ApprovalDropDown_All);
            waitforElementToBeClickable(ApprovalDropDown_All);
            click(ApprovalDropDown_All);
            wait(2);
            waitforElementToBePresent(AppprovalDropDown_Rejected);
            waitforElementToBeClickable(AppprovalDropDown_Rejected);
            click(AppprovalDropDown_Rejected);
        }catch (NoSuchElementException e)
        {

        }
        ///////////////////////////////////////////////////////////////
        //////////////////////////////////////////
        int PaymentTransactionCount = 0;
//        driver.get().navigate().refresh();
        for (int i = 1; i < 1000; i++)
        {
            wait(2);
            List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div[1]/div/table/tbody/tr/td[3]"));
            PaymentTransactionCount += rows.size();
            //          wait(2);
            int j = i + 1;
            String NextPage = "/html/body/div[1]/div[1]/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div[2]/nav/ul//*[@id='pagebutton" + j + "']//button[@class='page-link']";
            wait(1);
            try
            {
                By Next_Page = By.xpath(NextPage);
                scrollDown(driver.get());
                waitforElementToBeVisible(Next_Page);
                waitforElementToBePresent(Next_Page);
                waitforElementToBeClickable(Next_Page);
//                wait(3);
                jsClick(Next_Page);
            }
            catch (NoSuchElementException E)
            {
                i = 1000;
            }

        }
        //**************************** download***************************************//
        jsClick(DownloadButton);
        wait(5);
        String Manager_Reports = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory = System.getProperty("user.dir") + "/" + Manager_Reports;
        File dir = new File(downloadDirectory);
        File[] files = dir.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Non_Visited"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Non Visited Payments File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>Non Visited payments File download verification failed.");
        }
        System.out.println(PaymentTransactionCount);

        //******************************download verfication******************************//

        int Manager_XLSVRowCount = 0;
        String Manager_Reports2 = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory2 = System.getProperty("user.dir") + "/" + Manager_Reports2;
        File dir2 = new File(downloadDirectory2);
        File[] files2 = dir2.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Non_Visited"))
                {
                    String csvFilePath = file.getAbsolutePath();
                    try (FileInputStream fileInputStream = new FileInputStream(csvFilePath);
                         Workbook workbook = new XSSFWorkbook(fileInputStream))
                    {
                        Sheet sheet = workbook.getSheetAt(0);
                        Manager_XLSVRowCount = sheet.getPhysicalNumberOfRows() - 1;
                        //System.out.println("Number of rows in the XLSX file: " + rowCount);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            if (PaymentTransactionCount == Manager_XLSVRowCount)
            {
                test().log(Status.PASS, "=====>Non Visited Payments Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Non Visited  Payments Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Non Visited  Payments Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Non Visited Payments Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Non Visited Payments Downloaded XLSV file");

        }
        //Downloaded File Deleting
        File folder = new File(downloadDirectory);
        if (folder.exists() && folder.isDirectory())
        {
            File[] list=folder.listFiles();
            if(list!=null)
            {
                for (File lists:list)
                {
                    if(lists.isFile())
                    {
                        lists.delete();
                        System.out.println("Deleted file: " + lists.getName());

                    }

                }
            }
            else
            {
                System.out.println("No files found in the folder.");

            }


        }
        else
        {
            System.out.println("Folder does not exist or is not a directory.");
        }

    }

//    public void PaymentMode_UPIPaymentRequest()
    {
//


    }

    public void PaymentMode_UPImandate()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(2);
        waitforElementToBePresents(PaymentMode_UPIPaymentRequest);
        waitforElementToBeClickable(PaymentMode_UPIPaymentRequest);
        click(PaymentMode_UPIPaymentRequest);
        wait(2);
        waitforElementToBePresent(PaymentMode_UPIMandate);
        waitforElementToBeClickable(PaymentMode_UPIMandate);
        click(PaymentMode_UPIMandate);
    }

    public void PaymentMode_cash()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(2);
        waitforElementToBePresent(PaymentMode_UPIMandate);
        waitforElementToBeClickable(PaymentMode_UPIMandate);
        click(PaymentMode_UPIMandate);
        wait(2);
        waitforElementToBePresents(PaymentMode_Cash);
        waitforElementToBeClickable(PaymentMode_Cash);
        click(PaymentMode_Cash);
    }
    public void PaymentMode_BankTransfer()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(2);
        waitforElementToBePresent(PaymentMode_Cash);
        waitforElementToBeClickable(PaymentMode_Cash);
        click(PaymentMode_Cash);
        wait(2);
        waitforElementToBePresents(PaymentMode_BankTransfer);
        waitforElementToBeClickable(PaymentMode_BankTransfer);
        click(PaymentMode_BankTransfer);
    }
    public void PaymentMode_UPI()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(2);
        waitforElementToBePresents(PaymentMode_BankTransfer);
        waitforElementToBeClickable(PaymentMode_BankTransfer);
        click(PaymentMode_BankTransfer);
        wait(2);
        waitforElementToBePresent(PaymentMode_UPI);
        waitforElementToBeClickable(PaymentMode_UPI);
        click(PaymentMode_UPI);
    }


    public void UPIPaymentMode()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(2);
        waitforElementToBePresents(PaymentMode_UPI);
        waitforElementToBeClickable(PaymentMode_UPI);
        click(PaymentMode_UPI);
        wait(2);
        waitforElementToBePresent(PaymentMode_UPIPaymentRequest);
        waitforElementToBeClickable(PaymentMode_UPIPaymentRequest);
        click(PaymentMode_UPIPaymentRequest);

    }
}