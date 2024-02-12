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

public class CashDeposition extends Utils
{

By CashDepositionSearchBar=By.xpath("//*[@placeholder=\"Search by Emp Id/Emp Name/Bank Name/Bank Code/UTR No\"]");
By Payments = By.xpath("//*[text()='Payments']");
By CashDepositionPage=By.xpath("//*[@id=\"main-wrapper\"]/div[3]/div[1]/div[1]/ul/li[6]/ul/li[2]/a/span");

By CashDepositionStatus_All=By.xpath("//*[@id=\"cashDepositStatusFilter\"]//*[text()='All']");
    By CashDepositionStatus_Mapped=By.xpath("//*[@id=\"cashDepositStatusFilter\"]//*[text()='Mapped']");

    By CashDepositionStatus_Deposited=By.xpath("//*[@id=\"cashDepositStatusFilter\"]//*[text()='Deposited']");

    By CashDepositionStatus_Rejected=By.xpath("//*[@id=\"cashDepositStatusFilter\"]//*[text()='Rejected']");

    public void ClickOnPaymentHistory()
    {
            waitforElementToBePresent(Payments);
            waitforElementToBeClickable(Payments);
            jsClick(Payments);
            wait(1);
    }

    public void clickOnCashDeposition()
    {
        waitforElementToBeVisible(CashDepositionPage);
        waitforElementToBePresent(CashDepositionPage);
        waitforElementToBeClickable(CashDepositionPage);
        wait(2);
        jsClick(CashDepositionPage);
    }

    public void SearchEmpId()
    {
        wait(10);
        waitforElementToBeVisible(CashDepositionSearchBar);
        waitforElementToBePresent(CashDepositionSearchBar);
        waitforElementToBeClickable(CashDepositionSearchBar);
        wait(2);
        jsClick(CashDepositionSearchBar);
        wait(2);
        ////
        try {
            List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/table/tbody/tr/td[1]"));
            int LoanNoCount = rows.size();
            int i = getRandomNumber(1, LoanNoCount);
            String LoanNoInPaymentTab = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/table/tbody/tr[" + i + "]/td[1]";
            By LoanNo = By.xpath(LoanNoInPaymentTab);
            WebElement EmpName = getElement(LoanNo);
            LoanNoInPaymentTab = EmpName.getText();
            WebElement element = driver.get().findElement(CashDepositionSearchBar);
            element.sendKeys(LoanNoInPaymentTab);
            wait(5);
            String LoanNoInPaymentTab_Search = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/table/tbody/tr[1]/td[1]";
            By LoanNo_text2 = By.xpath(LoanNoInPaymentTab_Search);
            try {
                WebElement LoanNoInPaymentTab_Search_text = getElement(LoanNo_text2);
                String LoanNoInPaymentTab2 = LoanNoInPaymentTab_Search_text.getText();
                if (LoanNoInPaymentTab.equalsIgnoreCase(LoanNoInPaymentTab2)) {
                    test().log(Status.PASS, "=====>Searched EMP ID " + LoanNoInPaymentTab + " is matched");
                } else {
                    test().log(Status.FAIL, "=====>Searched EMP ID " + LoanNoInPaymentTab + " is not matched");
                }
            } catch (NoSuchElementException e) {

            }
            WebElement textBox = driver.get().findElement(CashDepositionSearchBar);
            textBox.clear();
        }
        catch (NoSuchElementException e)
        {
            test().log(Status.PASS, "No item to search in cash Depositions");

        }
    }

    public void SearchEmpName()
    {
        waitforElementToBeVisible(CashDepositionSearchBar);
        waitforElementToBePresent(CashDepositionSearchBar);
        waitforElementToBeClickable(CashDepositionSearchBar);
        wait(2);
        jsClick(CashDepositionSearchBar);
        wait(2);
        ////
        try {
            List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/table/tbody/tr/td[1]"));
            int LoanNoCount = rows.size();
            int i = getRandomNumber(1, LoanNoCount);
            String LoanNoInPaymentTab = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/table/tbody/tr[" + i + "]/td[2]";
            By LoanNo = By.xpath(LoanNoInPaymentTab);
            WebElement EmpName = getElement(LoanNo);
            LoanNoInPaymentTab = EmpName.getText();
            WebElement element = driver.get().findElement(CashDepositionSearchBar);
            element.sendKeys(LoanNoInPaymentTab);
            wait(5);
            String LoanNoInPaymentTab_Search = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/table/tbody/tr[1]/td[2]";
            By LoanNo_text2 = By.xpath(LoanNoInPaymentTab_Search);
            try {
                WebElement LoanNoInPaymentTab_Search_text = getElement(LoanNo_text2);
                String LoanNoInPaymentTab2 = LoanNoInPaymentTab_Search_text.getText();
                if (LoanNoInPaymentTab.equalsIgnoreCase(LoanNoInPaymentTab2)) {
                    test().log(Status.PASS, "=====>Searched EMP Name " + LoanNoInPaymentTab + " is matched");
                } else {
                    test().log(Status.FAIL, "=====>Searched EMP Name " + LoanNoInPaymentTab + " is not matched");
                }
            } catch (NoSuchElementException e) {

            }
            WebElement textBox = driver.get().findElement(CashDepositionSearchBar);
            textBox.clear();
        }
        catch (NoSuchElementException e)
        {
            test().log(Status.PASS, "No item to search in cash Depositions");
        }
    }

    public void SearchBankName()
    {
        waitforElementToBeVisible(CashDepositionSearchBar);
        waitforElementToBePresent(CashDepositionSearchBar);
        waitforElementToBeClickable(CashDepositionSearchBar);
        wait(2);
        jsClick(CashDepositionSearchBar);
        wait(2);
        try {
            List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/table/tbody/tr/td[1]"));
            int LoanNoCount = rows.size();
            int i = getRandomNumber(1, LoanNoCount);
            String LoanNoInPaymentTab = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/table/tbody/tr[" + i + "]/td[3]";
            By LoanNo = By.xpath(LoanNoInPaymentTab);
            WebElement EmpName = getElement(LoanNo);
            LoanNoInPaymentTab = EmpName.getText();
            WebElement element = driver.get().findElement(CashDepositionSearchBar);
            element.sendKeys(LoanNoInPaymentTab);
            wait(5);
            String LoanNoInPaymentTab_Search = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/table/tbody/tr[1]/td[3]";
            By LoanNo_text2 = By.xpath(LoanNoInPaymentTab_Search);
            try {
                WebElement LoanNoInPaymentTab_Search_text = getElement(LoanNo_text2);
                String LoanNoInPaymentTab2 = LoanNoInPaymentTab_Search_text.getText();
                if (LoanNoInPaymentTab.equalsIgnoreCase(LoanNoInPaymentTab2)) {
                    test().log(Status.PASS, "=====>Searched Bank Name " + LoanNoInPaymentTab + " is matched");
                } else {
                    test().log(Status.FAIL, "=====>Searched Bank Name " + LoanNoInPaymentTab + " is not matched");
                }
            } catch (NoSuchElementException e) {

            }
            WebElement textBox = driver.get().findElement(CashDepositionSearchBar);
            textBox.clear();
        }catch (NoSuchElementException e)
        {
            test().log(Status.PASS, "No item to search in cash Depositions");
        }
    }

    public void SearchBankCode()
    {
        waitforElementToBeVisible(CashDepositionSearchBar);
        waitforElementToBePresent(CashDepositionSearchBar);
        waitforElementToBeClickable(CashDepositionSearchBar);
        wait(2);
        jsClick(CashDepositionSearchBar);
        wait(2);
        try {
            List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/table/tbody/tr/td[1]"));
            int LoanNoCount = rows.size();
            int i = getRandomNumber(1, LoanNoCount);
            String LoanNoInPaymentTab = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/table/tbody/tr[" + i + "]/td[4]";
            By LoanNo = By.xpath(LoanNoInPaymentTab);
            WebElement EmpName = getElement(LoanNo);
            LoanNoInPaymentTab = EmpName.getText();
            WebElement element = driver.get().findElement(CashDepositionSearchBar);
            element.sendKeys(LoanNoInPaymentTab);
            wait(5);
            String LoanNoInPaymentTab_Search = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/table/tbody/tr[1]/td[4]";
            By LoanNo_text2 = By.xpath(LoanNoInPaymentTab_Search);
            try {
                WebElement LoanNoInPaymentTab_Search_text = getElement(LoanNo_text2);
                String LoanNoInPaymentTab2 = LoanNoInPaymentTab_Search_text.getText();
                if (LoanNoInPaymentTab.equalsIgnoreCase(LoanNoInPaymentTab2)) {
                    test().log(Status.PASS, "=====>Searched Bank code " + LoanNoInPaymentTab + " is matched");
                } else {
                    test().log(Status.FAIL, "=====>Searched Bank Code " + LoanNoInPaymentTab + " is not matched");
                }
            } catch (NoSuchElementException e) {

            }
            WebElement textBox = driver.get().findElement(CashDepositionSearchBar);
            textBox.clear();
        }
        catch (NoSuchElementException e)
        {
            test().log(Status.PASS, "No item to search in cash Depositions");
        }
    }

    public void SearchUTRCode()
    {
        waitforElementToBeVisible(CashDepositionSearchBar);
        waitforElementToBePresent(CashDepositionSearchBar);
        waitforElementToBeClickable(CashDepositionSearchBar);
        wait(2);
        jsClick(CashDepositionSearchBar);
        wait(2);
        try
        {
            List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/table/tbody/tr/td[1]"));
            int LoanNoCount = rows.size();
            int i = getRandomNumber(1, LoanNoCount);
            String LoanNoInPaymentTab = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/table/tbody/tr[" + i + "]/td[5]";
            By LoanNo = By.xpath(LoanNoInPaymentTab);
            WebElement EmpName = getElement(LoanNo);
            LoanNoInPaymentTab = EmpName.getText();
            WebElement element = driver.get().findElement(CashDepositionSearchBar);
            element.sendKeys(LoanNoInPaymentTab);
            wait(5);
            String LoanNoInPaymentTab_Search = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/table/tbody/tr[1]/td[5]";
            By LoanNo_text2 = By.xpath(LoanNoInPaymentTab_Search);
            try
            {
                WebElement LoanNoInPaymentTab_Search_text = getElement(LoanNo_text2);
                String LoanNoInPaymentTab2 = LoanNoInPaymentTab_Search_text.getText();
                if (LoanNoInPaymentTab.equalsIgnoreCase(LoanNoInPaymentTab2))
                {
                    test().log(Status.PASS, "=====>Searched UTR no " + LoanNoInPaymentTab + " is matched");
                }
                else
                {
                    test().log(Status.FAIL, "=====>Searched UTR no " + LoanNoInPaymentTab + " is not matched");
                }
            }
            catch (NoSuchElementException e)
            {

            }
            WebElement textBox = driver.get().findElement(CashDepositionSearchBar);
            textBox.clear();
        }
        catch (NoSuchElementException e)
        {
            test().log(Status.PASS, "No item to search in cash Depositions");
        }
        driver.get().navigate().refresh();
    }
By DownloadButton=By.xpath("//button[@type='button']");
    public void CashDeposition_Status_All()
    {
        int PaymentTransactionCount = 0;
//        driver.get().navigate().refresh();
        for (int i = 1; i < 1000; i++)
        {
            wait(5);
            List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div/div/div/div[3]/div/div/table/tbody/tr/td[3]"));
            PaymentTransactionCount += rows.size();
            int j = i + 1;
            String NextPage = "//*[@id='pagebutton" + j + "']//button[@class='page-link']";
            try
            {
                By Next_Page = By.xpath(NextPage);
                waitforElementToBeVisible(Next_Page);
                waitforElementToBeClickable(Next_Page);
                scrollDown(driver.get());
                wait(2);
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
                if (file.isFile() && file.getName().startsWith("Cash"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Cash Deposition File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>Cash Deposition File download verification failed.");
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
                if (file.isFile() && file.getName().startsWith("Cash"))
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
                test().log(Status.PASS, "=====> Cash Depositions Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Cash Deposition Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Cash Depositons Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Cash Deposition Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Cash Deposition Downloaded XLSV file");

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

    public void CashDeposition_Staus_Mapped()
    {
        int PaymentTransactionCount=0;
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(5);
        String ApprovalStatusFieldNameInTable = null,ApprovalstatusName="Mapped";
        //Select pending status from Drop Down
        waitforElementToBeVisible(CashDepositionStatus_All);
        waitforElementToBePresent(CashDepositionStatus_All);
        waitforElementToBeClickable(CashDepositionStatus_All);
        wait(1);
        click(CashDepositionStatus_All);
        wait(5);
        waitforElementToBeVisible(CashDepositionStatus_Mapped);
        waitforElementToBePresent(CashDepositionStatus_Mapped);
        waitforElementToBeClickable(CashDepositionStatus_Mapped);
        wait(1);
        jsClick(CashDepositionStatus_Mapped);
        wait(5);
        for (int i = 1; i < 1000; i++)
        {
            wait(5);
            List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div/div/div/div[3]/div/div/table/tbody/tr/td[3]"));
            PaymentTransactionCount += rows.size();
            int j = i + 1;
            String NextPage = "//*[@id='pagebutton" + j + "']//button[@class='page-link']";
            try
            {
                By Next_Page = By.xpath(NextPage);
                waitforElementToBeVisible(Next_Page);
                waitforElementToBeClickable(Next_Page);
                scrollDown(driver.get());
                wait(2);
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
                if (file.isFile() && file.getName().startsWith("Cash"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Cash Deposition  Mapped File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>Cash Deposition Mapped File download verification failed.");
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
                if (file.isFile() && file.getName().startsWith("Cash"))
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
                test().log(Status.PASS, "=====> Cash Depositions  Mapped Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Cash Deposition Mapped Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Cash Depositons Mapped Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Cash Deposition Mapped Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Cash Deposition Downloaded XLSV file");

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

    public void CashDeposition_Status_Deposited()
    {
        int PaymentTransactionCount=0;
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(5);
        String ApprovalStatusFieldNameInTable = null,ApprovalstatusName="Deposited";
        //Select pending status from Drop Down
        waitforElementToBeVisible(CashDepositionStatus_Mapped);
        waitforElementToBePresent(CashDepositionStatus_Mapped);
        waitforElementToBeClickable(CashDepositionStatus_Mapped);
        wait(1);
        click(CashDepositionStatus_Mapped);
        wait(5);
        waitforElementToBeVisible(CashDepositionStatus_Deposited);
        waitforElementToBePresent(CashDepositionStatus_Deposited);
        waitforElementToBeClickable(CashDepositionStatus_Deposited);
        wait(1);
        jsClick(CashDepositionStatus_Deposited);
        wait(5);
        for (int i = 1; i < 1000; i++)
        {
            wait(5);
            List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div/div/div/div[3]/div/div/table/tbody/tr/td[3]"));
            PaymentTransactionCount += rows.size();
            int j = i + 1;
            String NextPage = "//*[@id='pagebutton" + j + "']//button[@class='page-link']";
            try
            {
                By Next_Page = By.xpath(NextPage);
                waitforElementToBeVisible(Next_Page);
                waitforElementToBeClickable(Next_Page);
                scrollDown(driver.get());
                wait(2);
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
                if (file.isFile() && file.getName().startsWith("Cash"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Cash Deposition  Deposited status File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>Cash Deposition Deposited status File download verification failed.");
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
                if (file.isFile() && file.getName().startsWith("Cash"))
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
                test().log(Status.PASS, "=====> Cash Depositions  Deposited status Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Cash Deposition Deposited status Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Cash Depositons Deposited status Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Cash Deposition Deposited status Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Cash Deposition Deposited status Downloaded XLSV file");

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

    public void CashDeposition_Status_Rejected()
    {
        int PaymentTransactionCount=0;
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(5);
        String ApprovalStatusFieldNameInTable = null,ApprovalstatusName="Rejected";
        //Select pending status from Drop Down
        waitforElementToBeVisible(CashDepositionStatus_Deposited);
        waitforElementToBePresent(CashDepositionStatus_Deposited);
        waitforElementToBeClickable(CashDepositionStatus_Deposited);
        wait(1);
        click(CashDepositionStatus_Deposited);
        wait(5);
        waitforElementToBeVisible(CashDepositionStatus_Rejected);
        waitforElementToBePresent(CashDepositionStatus_Rejected);
        waitforElementToBeClickable(CashDepositionStatus_Rejected);
        wait(1);
        jsClick(CashDepositionStatus_Rejected);
        wait(5);
        for (int i = 1; i < 1000; i++)
        {
            wait(5);
            List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div/div/div/div[3]/div/div/table/tbody/tr/td[3]"));
            PaymentTransactionCount += rows.size();
            int j = i + 1;
            String NextPage = "//*[@id='pagebutton" + j + "']//button[@class='page-link']";
            try
            {
                By Next_Page = By.xpath(NextPage);
                waitforElementToBeVisible(Next_Page);
                waitforElementToBeClickable(Next_Page);
                scrollDown(driver.get());
                wait(2);
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
                if (file.isFile() && file.getName().startsWith("Cash"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Cash Deposition  Rejected status File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>Cash Deposition Rejected status File download verification failed.");
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
                if (file.isFile() && file.getName().startsWith("Cash"))
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
                test().log(Status.PASS, "=====> Cash Depositions  Rejected status Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Cash Deposition Rejected status Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Cash Depositons Rejected status Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Cash Deposition Rejected status Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Cash Deposition Rejected status Downloaded XLSV file");

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
}


