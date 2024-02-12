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

public class PaymentHistory extends Utils {

    By Payments = By.xpath("//*[text()='Payments']");
    By PaymentHistory = By.xpath("//*[@id=\"main-wrapper\"]/div[3]/div[1]/div[1]/ul/li[6]/ul/li[1]/a/span");
    By PaymentHistorySearchBar = By.xpath("//input[@placeholder='Search by Loan No/Customer Name/Mobile No']");
    By LoanNo = By.xpath("");
    By MobileNo = By.xpath("");
    By CustomerName = By.xpath("");

    By DownloadButton = By.xpath("//*[@class=\"fa fa-download\"]");

    By ApprovalDropDown_All = By.xpath("//*[@id='ApprovaStatusFilter']//*[text()='All']");
    By AppprovalDropDown_Pending = By.xpath("//*[@id='ApprovaStatusFilter']//*[text()='Pending']");
    By ApprovalDropDown_Approved = By.xpath("//*[@id='ApprovaStatusFilter']//*[text()='Approved']");
    By ApprovalDropDown_Rejected = By.xpath("//*[@id='ApprovaStatusFilter']//*[text()='Rejected']");
    String Manager_Reports = "/src/file_download/";  // Replace with the actual file name
    String downloadDirectory = System.getProperty("user.dir") + "/"+Manager_Reports;
    By PaymentMode_All=By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div[1]/div");
    By PaymentMode_BankTransfer=By.xpath("//*[text()='Bank Transfer']");
    By PaymentMode_Cash=By.xpath("//*[text()='Cash']");
    By PaymentMode_QRCode=By.xpath("//*[text()='QR Code']");

    By PaymentMode_UPI=By.xpath("//*[text()='UPI']");
    By PaymentMode_UPIPaymentRequest=By.xpath("//*[text()='UPI Payment Request']");
    By PaymentMode_BulkPaymentRequest=By.xpath("//*[text()='Bulk Payment Request']");
    By PaymentMode_Other=By.xpath("//*[text()='Others']");


    public void ClickPaymentHistory()
    {
        waitforElementToBePresent(Payments);
        waitforElementToBeClickable(Payments);
        jsClick(Payments);
        wait(1);
        waitforElementToBePresent(PaymentHistory);
        waitforElementToBeClickable(PaymentHistory);
        jsClick(PaymentHistory);


    }

    public void SearchLoanNoInPaymentHistory()
    {
        waitforElementToBeVisible(PaymentHistorySearchBar);
        waitforElementToBePresent(PaymentHistorySearchBar);
        waitforElementToBeClickable(PaymentHistorySearchBar);
        jsClick(PaymentHistorySearchBar);
        ////
        List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[1]/div[2]/div/div[1]/div/table/tbody/tr/td[4]"));
        int LoanNoCount = rows.size();
        int i = getRandomNumber(1, LoanNoCount);
        String LoanNoInPaymentTab = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[1]/div[2]/div/div[1]/div/table/tbody/tr[" + i + "]/td[4]";
        By LoanNo = By.xpath(LoanNoInPaymentTab);
        WebElement EmpName = getElement(LoanNo);
        LoanNoInPaymentTab = EmpName.getText();
        WebElement element = driver.get().findElement(PaymentHistorySearchBar);
        element.sendKeys(LoanNoInPaymentTab);
        wait(10);
        ///
        String LoanNoInPaymentTab_Search = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[1]/div[2]/div/div[1]/div/table/tbody/tr[1]/td[4]";

        By LoanNo_text2 = By.xpath(LoanNoInPaymentTab_Search);
        WebElement LoanNoInPaymentTab_Search_text = getElement(LoanNo_text2);
        String LoanNoInPaymentTab2 = LoanNoInPaymentTab_Search_text.getText();
        if (LoanNoInPaymentTab.equalsIgnoreCase(LoanNoInPaymentTab2)) {
            test().log(Status.PASS, "=====>Searched LoanNo " + LoanNoInPaymentTab + " is matched");
        } else {
            test().log(Status.FAIL, "=====>Searched LoanNo " + LoanNoInPaymentTab + " is not matched");
        }


    }

    public void SearchCustomerNameInPaymentHistory() {
        WebElement textBox = driver.get().findElement(PaymentHistorySearchBar);
        textBox.clear();
        waitforElementToBeVisible(PaymentHistorySearchBar);
        waitforElementToBePresent(PaymentHistorySearchBar);
        waitforElementToBeClickable(PaymentHistorySearchBar);
        jsClick(PaymentHistorySearchBar);
        ////
        List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[1]/div[2]/div/div[1]/div/table/tbody/tr/td[4]"));
        int LoanNoCount = rows.size();
        int i = getRandomNumber(1, LoanNoCount);
        String LoanNoInPaymentTab = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[1]/div[2]/div/div[1]/div/table/tbody/tr[" + i + "]/td[1]";
        By LoanNo = By.xpath(LoanNoInPaymentTab);
        WebElement EmpName = getElement(LoanNo);
        LoanNoInPaymentTab = EmpName.getText();
        WebElement element = driver.get().findElement(PaymentHistorySearchBar);
        element.sendKeys(LoanNoInPaymentTab);
        wait(10);
        String LoanNoInPaymentTab_Search = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[1]/div[2]/div/div[1]/div/table/tbody/tr[1]/td[1]";

        By LoanNo_text2 = By.xpath(LoanNoInPaymentTab_Search);
        WebElement LoanNoInPaymentTab_Search_text = getElement(LoanNo_text2);
        String LoanNoInPaymentTab2 = LoanNoInPaymentTab_Search_text.getText();
        if (LoanNoInPaymentTab.equalsIgnoreCase(LoanNoInPaymentTab2)) {
            test().log(Status.PASS, "=====>Searched LoanNo " + LoanNoInPaymentTab + " is matched");
        } else {
            test().log(Status.FAIL, "=====>Searched LoanNo " + LoanNoInPaymentTab + " is not matched");
        }
    }

    WebElement textBox;

    public void SearchMobileNoInPaymentHistory() {

        textBox = driver.get().findElement(PaymentHistorySearchBar);
        textBox.clear();
        waitforElementToBeVisible(PaymentHistorySearchBar);
        waitforElementToBePresent(PaymentHistorySearchBar);
        waitforElementToBeClickable(PaymentHistorySearchBar);
        jsClick(PaymentHistorySearchBar);
        ////
        List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[1]/div[2]/div/div[1]/div/table/tbody/tr/td[4]"));
        int LoanNoCount = rows.size();
        int i = getRandomNumber(1, LoanNoCount);
        String LoanNoInPaymentTab = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[1]/div[2]/div/div[1]/div/table/tbody/tr[" + i + "]/td[2]";
        By LoanNo = By.xpath(LoanNoInPaymentTab);
        WebElement EmpName = getElement(LoanNo);
        LoanNoInPaymentTab = EmpName.getText();
        WebElement element = driver.get().findElement(PaymentHistorySearchBar);
        element.sendKeys(LoanNoInPaymentTab);
        wait(10);
        //
        String LoanNoInPaymentTab_Search = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div[1]/div[2]/div/div[1]/div/table/tbody/tr[1]/td[2]";

        By LoanNo_text2 = By.xpath(LoanNoInPaymentTab_Search);
        WebElement LoanNoInPaymentTab_Search_text = getElement(LoanNo_text2);
        String LoanNoInPaymentTab2 = LoanNoInPaymentTab_Search_text.getText();
        if (LoanNoInPaymentTab.equalsIgnoreCase(LoanNoInPaymentTab2)) {
            test().log(Status.PASS, "=====>Searched LoanNo " + LoanNoInPaymentTab + " is matched");
        } else {
            test().log(Status.FAIL, "=====>Searched LoanNo " + LoanNoInPaymentTab + " is not matched");
        }
        textBox = driver.get().findElement(PaymentHistorySearchBar);
        textBox.clear();
    }

    public void ApprovalDropdownInPaymentHistory()
    {
        int PaymentTransactionCount = 0;
        driver.get().navigate().refresh();
        for (int i = 1; i < 1000; i++)
        {
            wait(5);
            List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/div[1]/div/table/tbody/tr"));
            PaymentTransactionCount += rows.size();
            //          wait(2);
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
                if (file.isFile() && file.getName().startsWith("Payments"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Payments File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>payments File download verification failed.");
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
                if (file.isFile() && file.getName().startsWith("Payments"))
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
                test().log(Status.PASS, "=====>Payments Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Payments Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Payments Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Payments Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Payments Downloaded XLSV file");

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

    public void Pending_ApprovalDropdownInPaymentHistory() throws IOException
    {
        int PaymentTransactionCount=0;
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
       js.executeScript("window.scrollBy(0,-400)", "");
        wait(5);
        String ApprovalStatusFieldNameInTable = null,ApprovalstatusName="Pending";
        //Select pending status from Drop Down
        waitforElementToBeVisible(ApprovalDropDown_All);
        waitforElementToBePresent(ApprovalDropDown_All);
        waitforElementToBeClickable(ApprovalDropDown_All);
        click(ApprovalDropDown_All);
        wait(2);
        waitforElementToBeVisible(AppprovalDropDown_Pending);
        waitforElementToBePresent(AppprovalDropDown_Pending);
        waitforElementToBeClickable(AppprovalDropDown_Pending);
        jsClick(AppprovalDropDown_Pending);
        wait(2);
        //Appproval Status  field Verification
        List<WebElement> rows = getElementsList(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[16]/span"));
        int ApprovalStatusFieldCount= rows.size();
        for(int j=1;j<=ApprovalStatusFieldCount;j++)
        {
            String ApprovalStatus="//table[@class='table table-bordered']/tbody/tr["+ j +"]/td[16]/span";
            By ApprovalStatusField=By.xpath(ApprovalStatus);
            WebElement EmpName = getElement(ApprovalStatusField);
            ApprovalStatusFieldNameInTable=EmpName.getText();
            if(ApprovalStatusFieldNameInTable.equalsIgnoreCase(ApprovalstatusName))
            {
                test().log(Status.PASS, "=====> Row "+ j +" Approval Status "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value :"+ApprovalstatusName);
                System.out.println("Row "+j+" Approval Status "+ApprovalStatusFieldNameInTable+"  is  matched with the Table Row Value : "+ApprovalstatusName);

            }
            else
            {
                test().log(Status.FAIL, "=====>Row "+ j +" Approval Status "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value : "+ApprovalstatusName);
                System.out.println("Row "+ j +" Approval Status  "+ApprovalStatusFieldNameInTable+" is  not matched with the Table Row Value : "+ApprovalstatusName);

            }
        }
       //Pagenation count + Clicking on next page
        for (int i = 1; i < 1000; i++)
        {
            wait(5);
            List<WebElement> rows2 = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/div[1]/div/table/tbody/tr"));
            PaymentTransactionCount += rows2.size();
//          wait(2);
            int j = i + 1;
            String NextPage = "//*[@id='pagebutton" + j + "']//button[@class='page-link']";
            try
            {
                By Next_Page = By.xpath(NextPage);
                waitforElementToBeVisible(Next_Page);
                waitforElementToBeClickable(Next_Page);
                scrollDown(driver.get());
                wait(2);
                click(Next_Page);
            }
            catch (NoSuchElementException E)
            {
                i = 1000;
            }

        }

        // download
        jsClick(DownloadButton);
        wait(5);
        String Manager_Reports = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory = System.getProperty("user.dir") + "/"+Manager_Reports;
        File dir = new File(downloadDirectory);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Payments File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>payments File download verification failed.");
        }
        System.out.println(PaymentTransactionCount);
        //********************************************download verfication*************************************//
        int Manager_XLSVRowCount=0;
        String Manager_Reports2 = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory2 = System.getProperty("user.dir") + "/" + Manager_Reports;
        File dir2 = new File(downloadDirectory2);
        File[] files2 = dir2.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
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
            if(PaymentTransactionCount==Manager_XLSVRowCount)
            {
                test().log(Status.PASS, "=====>Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Payments Downloaded XLSV file");

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

    public void Approved_ApprovalDropdownInPaymentHistory() throws IOException
    {
        int PaymentTransactionCount=0;
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(5);
        String ApprovalStatusFieldNameInTable = null,ApprovalstatusName="Approved";
        //Select pending status from Drop Down
        waitforElementToBeVisible(AppprovalDropDown_Pending);
        waitforElementToBePresent(AppprovalDropDown_Pending);
        waitforElementToBeClickable(AppprovalDropDown_Pending);
        click(AppprovalDropDown_Pending);
        wait(2);
        waitforElementToBeVisible(ApprovalDropDown_Approved);
        waitforElementToBePresent(ApprovalDropDown_Approved);
        waitforElementToBeClickable(ApprovalDropDown_Approved);
        jsClick(ApprovalDropDown_Approved);
        wait(2);
        //Appproval Status  field Verification
        List<WebElement> rows = getElementsList(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[16]/span"));
        int ApprovalStatusFieldCount= rows.size();
        for(int j=1;j<=ApprovalStatusFieldCount;j++)
        {
            String ApprovalStatus="//table[@class='table table-bordered']/tbody/tr["+ j +"]/td[16]/span";
            By ApprovalStatusField=By.xpath(ApprovalStatus);
            WebElement EmpName = getElement(ApprovalStatusField);
            ApprovalStatusFieldNameInTable=EmpName.getText();
            if(ApprovalStatusFieldNameInTable.equalsIgnoreCase(ApprovalstatusName))
            {
                test().log(Status.PASS, "=====> Row "+ j +" Approval Status "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value :"+ApprovalstatusName);
                System.out.println("Row "+j+" Approval Status "+ApprovalStatusFieldNameInTable+"  is  matched with the Table Row Value : "+ApprovalstatusName);

            }
            else
            {
                test().log(Status.FAIL, "=====>Row "+ j +" Approval Status "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value : "+ApprovalstatusName);
                System.out.println("Row "+ j +" Approval Status  "+ApprovalStatusFieldNameInTable+" is  not matched with the Table Row Value : "+ApprovalstatusName);

            }
        }
        //Pagenation count + Clicking on next page
        for (int i = 1; i < 1000; i++)
        {
            wait(2);
            List<WebElement> rows2 = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/div[1]/div/table/tbody/tr"));
            PaymentTransactionCount += rows2.size();
//          wait(2);
            int j = i + 1;
            String NextPage = "//*[@id='pagebutton" + j + "']//button[@class='page-link']";
            try
            {
                By Next_Page = By.xpath(NextPage);
                waitforElementToBeVisible(Next_Page);
                waitforElementToBeClickable(Next_Page);
                scrollDown(driver.get());
                wait(2);
                click(Next_Page);
            }
            catch (NoSuchElementException E)
            {
                i = 1000;
            }

        }

        // download
        jsClick(DownloadButton);
        wait(5);
        String Manager_Reports = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory = System.getProperty("user.dir") + "/"+Manager_Reports;
        File dir = new File(downloadDirectory);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Payments File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>payments File download verification failed.");
        }
        System.out.println(PaymentTransactionCount);
        //********************************************download verfication*************************************//
        int Manager_XLSVRowCount=0;
        String Manager_Reports2 = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory2 = System.getProperty("user.dir") + "/" + Manager_Reports;
        File dir2 = new File(downloadDirectory2);
        File[] files2 = dir2.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
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
            if(PaymentTransactionCount==Manager_XLSVRowCount)
            {
                test().log(Status.PASS, "=====>Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Payments Downloaded XLSV file");

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

    public void Rejected_ApprovalDropdownInPaymentHistory() throws IOException {
        int PaymentTransactionCount=0;
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(2);
        String ApprovalStatusFieldNameInTable = null,ApprovalstatusName="Rejected";
        //Select pending status from Drop Down
        waitforElementToBeVisible(ApprovalDropDown_Approved);
        waitforElementToBePresent(ApprovalDropDown_Approved);
        waitforElementToBeClickable(ApprovalDropDown_Approved);
        click(ApprovalDropDown_Approved);
        wait(2);
        waitforElementToBeVisible(ApprovalDropDown_Rejected);
        waitforElementToBePresent(ApprovalDropDown_Rejected);
        waitforElementToBeClickable(ApprovalDropDown_Rejected);
        jsClick(ApprovalDropDown_Rejected);
        wait(2);
        //Appproval Status  field Verification
        List<WebElement> rows = getElementsList(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[16]/span"));
        int ApprovalStatusFieldCount= rows.size();
        for(int j=1;j<=ApprovalStatusFieldCount;j++)
        {
            String ApprovalStatus="//table[@class='table table-bordered']/tbody/tr["+ j +"]/td[16]/span";
            By ApprovalStatusField=By.xpath(ApprovalStatus);
            WebElement EmpName = getElement(ApprovalStatusField);
            ApprovalStatusFieldNameInTable=EmpName.getText();
            if(ApprovalStatusFieldNameInTable.equalsIgnoreCase(ApprovalstatusName))
            {
                test().log(Status.PASS, "=====> Row "+ j +" Approval Status "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value :"+ApprovalstatusName);
                System.out.println("Row "+j+" Approval Status "+ApprovalStatusFieldNameInTable+"  is  matched with the Table Row Value : "+ApprovalstatusName);

            }
            else
            {
                test().log(Status.FAIL, "=====>Row "+ j +" Approval Status "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value : "+ApprovalstatusName);
                System.out.println("Row "+ j +" Approval Status  "+ApprovalStatusFieldNameInTable+" is  not matched with the Table Row Value : "+ApprovalstatusName);

            }
        }
        //Pagenation count + Clicking on next page
        for (int i = 1; i < 1000; i++)
        {
            wait(5);
            List<WebElement> rows2 = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/div[1]/div/table/tbody/tr"));
            PaymentTransactionCount += rows2.size();
//          wait(2);
            int j = i + 1;
            String NextPage = "//*[@id='pagebutton" + j + "']//button[@class='page-link']";
            try
            {
                By Next_Page = By.xpath(NextPage);
                waitforElementToBeVisible(Next_Page);
                waitforElementToBeClickable(Next_Page);
                scrollDown(driver.get());
                wait(2);
                click(Next_Page);
            }
            catch (NoSuchElementException E)
            {
                i = 1000;
            }

        }

        // download
        jsClick(DownloadButton);
        wait(5);
        String Manager_Reports = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory = System.getProperty("user.dir") + "/"+Manager_Reports;
        File dir = new File(downloadDirectory);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Payments File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>payments File download verification failed.");
        }
        System.out.println(PaymentTransactionCount);
        //********************************************download verfication*************************************//
        int Manager_XLSVRowCount=0;
        String Manager_Reports2 = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory2 = System.getProperty("user.dir") + "/" + Manager_Reports;
        File dir2 = new File(downloadDirectory2);
        File[] files2 = dir2.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
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
            if(PaymentTransactionCount==Manager_XLSVRowCount)
            {
                test().log(Status.PASS, "=====>Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Payments Downloaded XLSV file");

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
        driver.get().navigate().refresh();

    }

    public void CPnameDropdownInPaymentHistory()
    {

    }

    public void PaymentModeDropdownInPaymentHistory()
    {



    }

    public void BankTransfer_PaymentModeDropdownInPaymentHistory()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(1);
        driver.get().navigate().refresh();
        wait(3);
        waitforElementToBeVisible(PaymentMode_All);
        waitforElementToBePresent(PaymentMode_All);
        waitforElementToBeClickable(PaymentMode_All);
        click(PaymentMode_All);
        wait(3);
        waitforElementToBePresent(PaymentMode_BankTransfer);
        waitforElementToBeClickable(PaymentMode_BankTransfer);
        click(PaymentMode_BankTransfer);
        wait(3);
        int PaymentTransactionCount=0;
        wait(5);
        String ApprovalStatusFieldNameInTable = null,ApprovalstatusName="Bank Transfer";
        //Appproval Status  field Verification
        List<WebElement> rows = getElementsList(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[13]"));
        int ApprovalStatusFieldCount= rows.size();
        for(int j=1;j<=ApprovalStatusFieldCount;j++)
        {
            String ApprovalStatus="//table[@class='table table-bordered']/tbody/tr["+ j +"]/td[13]";
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver.get();
            String script = "window.scrollBy(500, 0);";
            // Execute the JavaScript code to scroll right
            jsExecutor.executeScript(script);
            By ApprovalStatusField=By.xpath(ApprovalStatus);
            WebElement EmpName = getElement(ApprovalStatusField);
            ApprovalStatusFieldNameInTable=EmpName.getText();
            if(ApprovalStatusFieldNameInTable.equalsIgnoreCase(ApprovalstatusName))
            {
                test().log(Status.PASS, "=====> Row "+ j +" PaymentMode "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value :"+ApprovalstatusName);
                System.out.println("Row "+j+"  PaymentMode "+ApprovalStatusFieldNameInTable+"  is  matched with the Table Row Value : "+ApprovalstatusName);

            }
            else
            {
                test().log(Status.FAIL, "=====>Row "+ j +" PaymentMode "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value : "+ApprovalstatusName);
                System.out.println("Row "+ j +" PaymentMode  "+ApprovalStatusFieldNameInTable+" is  not matched with the Table Row Value : "+ApprovalstatusName);

            }
        }
        //Pagenation count + Clicking on next page
        for (int i = 1; i < 1000; i++)
        {
            wait(5);
            List<WebElement> rows2 = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/div[1]/div/table/tbody/tr"));
            PaymentTransactionCount += rows2.size();
//          wait(2);
            int j = i + 1;
            String NextPage = "//*[@id='pagebutton" + j + "']//button[@class='page-link']";
            try
            {
                By Next_Page = By.xpath(NextPage);
                waitforElementToBeVisible(Next_Page);
                waitforElementToBeClickable(Next_Page);
                scrollDown(driver.get());
                wait(2);
                click(Next_Page);
            }
            catch (NoSuchElementException E)
            {
                i = 1000;
            }

        }

        // download
        jsClick(DownloadButton);
        wait(5);
        String Manager_Reports = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory = System.getProperty("user.dir") + "/"+Manager_Reports;
        File dir = new File(downloadDirectory);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Payments File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>payments File download verification failed.");
        }
        System.out.println(PaymentTransactionCount);
        //********************************************download verfication*************************************//
        int Manager_XLSVRowCount=0;
        String Manager_Reports2 = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory2 = System.getProperty("user.dir") + "/" + Manager_Reports;
        File dir2 = new File(downloadDirectory2);
        File[] files2 = dir2.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
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
            if(PaymentTransactionCount==Manager_XLSVRowCount)
            {
                test().log(Status.PASS, "=====>Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Payments Downloaded XLSV file");

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

    public void Cash_PaymentModeDropdownInPaymentHistory()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(1);
        waitforElementToBeVisible(PaymentMode_BankTransfer);
        waitforElementToBePresent(PaymentMode_BankTransfer);
        waitforElementToBeClickable(PaymentMode_BankTransfer);
        click(PaymentMode_BankTransfer);
        wait(3);
        waitforElementToBeVisible(PaymentMode_Cash);
        waitforElementToBePresent(PaymentMode_Cash);
        waitforElementToBeClickable(PaymentMode_Cash);
        click(PaymentMode_Cash);
        wait(3);
        int PaymentTransactionCount=0;
        wait(5);
        String ApprovalStatusFieldNameInTable = null,ApprovalstatusName="Cash";
        //Appproval Status  field Verification
        List<WebElement> rows = getElementsList(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[13]"));
        int ApprovalStatusFieldCount= rows.size();
        for(int j=1;j<=ApprovalStatusFieldCount;j++)
        {
            String ApprovalStatus="//table[@class='table table-bordered']/tbody/tr["+ j +"]/td[13]";
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver.get();
            String script = "window.scrollBy(500, 0);";
            // Execute the JavaScript code to scroll right
            jsExecutor.executeScript(script);
            By ApprovalStatusField=By.xpath(ApprovalStatus);
            WebElement EmpName = getElement(ApprovalStatusField);
            ApprovalStatusFieldNameInTable=EmpName.getText();
            if(ApprovalStatusFieldNameInTable.equalsIgnoreCase(ApprovalstatusName))
            {
                test().log(Status.PASS, "=====> Row "+ j +" PaymentMode "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value :"+ApprovalstatusName);
                System.out.println("Row "+j+"  PaymentMode "+ApprovalStatusFieldNameInTable+"  is  matched with the Table Row Value : "+ApprovalstatusName);

            }
            else
            {
                test().log(Status.FAIL, "=====>Row "+ j +" PaymentMode "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value : "+ApprovalstatusName);
                System.out.println("Row "+ j +" PaymentMode  "+ApprovalStatusFieldNameInTable+" is  not matched with the Table Row Value : "+ApprovalstatusName);

            }
        }
        //Pagenation count + Clicking on next page
        for (int i = 1; i < 1000; i++)
        {
            wait(5);
            List<WebElement> rows2 = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/div[1]/div/table/tbody/tr"));
            PaymentTransactionCount += rows2.size();
//          wait(2);
            int j = i + 1;
            String NextPage = "//*[@id='pagebutton" + j + "']//button[@class='page-link']";
            try
            {
                By Next_Page = By.xpath(NextPage);
                waitforElementToBeVisible(Next_Page);
                waitforElementToBeClickable(Next_Page);
                scrollDown(driver.get());
                wait(2);
                click(Next_Page);
            }
            catch (NoSuchElementException E)
            {
                i = 1000;
            }

        }
        // download
        jsClick(DownloadButton);
        wait(5);
        String Manager_Reports = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory = System.getProperty("user.dir") + "/"+Manager_Reports;
        File dir = new File(downloadDirectory);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Payments File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>payments File download verification failed.");
        }
        System.out.println(PaymentTransactionCount);
        //********************************************download verfication*************************************//
        int Manager_XLSVRowCount=0;
        String Manager_Reports2 = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory2 = System.getProperty("user.dir") + "/" + Manager_Reports;
        File dir2 = new File(downloadDirectory2);
        File[] files2 = dir2.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
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
            if(PaymentTransactionCount==Manager_XLSVRowCount)
            {
                test().log(Status.PASS, "=====>Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Payments Downloaded XLSV file");

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

    public void QRCode_PaymentModeDropdownInPaymentHistory()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(2);
        waitforElementToBeVisible(PaymentMode_Cash);
        waitforElementToBePresent(PaymentMode_Cash);
        waitforElementToBeClickable(PaymentMode_Cash);
        click(PaymentMode_Cash);
        wait(2);
        waitforElementToBeVisible(PaymentMode_QRCode);
        waitforElementToBePresent(PaymentMode_QRCode);
        waitforElementToBeClickable(PaymentMode_QRCode);
        click(PaymentMode_QRCode);
        wait(2);
        int PaymentTransactionCount=0;
//       driver.get().navigate().refresh();
        wait(5);
        String ApprovalStatusFieldNameInTable = null,ApprovalstatusName="QR Code";
        //Appproval Status  field Verification
        List<WebElement> rows = getElementsList(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[13]"));
        int ApprovalStatusFieldCount= rows.size();
        for(int j=1;j<=ApprovalStatusFieldCount;j++)
        {
            String ApprovalStatus="//table[@class='table table-bordered']/tbody/tr["+ j +"]/td[13]";
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver.get();
            String script = "window.scrollBy(500, 0);";
            // Execute the JavaScript code to scroll right
            jsExecutor.executeScript(script);
            By ApprovalStatusField=By.xpath(ApprovalStatus);
            WebElement EmpName = getElement(ApprovalStatusField);
            ApprovalStatusFieldNameInTable=EmpName.getText();
            if(ApprovalStatusFieldNameInTable.equalsIgnoreCase(ApprovalstatusName))
            {
                test().log(Status.PASS, "=====> Row "+ j +" PaymentMode "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value :"+ApprovalstatusName);
                System.out.println("Row "+j+"  PaymentMode "+ApprovalStatusFieldNameInTable+"  is  matched with the Table Row Value : "+ApprovalstatusName);

            }
            else
            {
                test().log(Status.FAIL, "=====>Row "+ j +" PaymentMode "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value : "+ApprovalstatusName);
                System.out.println("Row "+ j +" PaymentMode  "+ApprovalStatusFieldNameInTable+" is  not matched with the Table Row Value : "+ApprovalstatusName);

            }
        }
        //Pagenation count + Clicking on next page
        for (int i = 1; i < 1000; i++)
        {
            wait(5);
            List<WebElement> rows2 = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/div[1]/div/table/tbody/tr"));
            PaymentTransactionCount += rows2.size();
//          wait(2);
            int j = i + 1;
            String NextPage = "//*[@id='pagebutton" + j + "']//button[@class='page-link']";
            try
            {
                By Next_Page = By.xpath(NextPage);
                waitforElementToBeVisible(Next_Page);
                waitforElementToBeClickable(Next_Page);
                scrollDown(driver.get());
                wait(2);
                click(Next_Page);
            }
            catch (NoSuchElementException E)
            {
                i = 1000;
            }

        }

        // download
        jsClick(DownloadButton);
        wait(5);
        String Manager_Reports = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory = System.getProperty("user.dir") + "/"+Manager_Reports;
        File dir = new File(downloadDirectory);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Payments File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>payments File download verification failed.");
        }
        System.out.println(PaymentTransactionCount);
        //********************************************download verfication*************************************//
        int Manager_XLSVRowCount=0;
        String Manager_Reports2 = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory2 = System.getProperty("user.dir") + "/" + Manager_Reports;
        File dir2 = new File(downloadDirectory2);
        File[] files2 = dir2.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
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
            if(PaymentTransactionCount==Manager_XLSVRowCount)
            {
                test().log(Status.PASS, "=====>Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Payments Downloaded XLSV file");

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

    public void UPI_PaymentModeDropdownInPaymentHistory()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(2);
        waitforElementToBeVisible(PaymentMode_QRCode);
        waitforElementToBePresent(PaymentMode_QRCode);
        waitforElementToBeClickable(PaymentMode_QRCode);
        click(PaymentMode_QRCode);
        wait(2);
        waitforElementToBeVisible(PaymentMode_UPI);
        waitforElementToBePresent(PaymentMode_UPI);
        waitforElementToBeClickable(PaymentMode_UPI);
        click(PaymentMode_UPI);

        wait(2);
        int PaymentTransactionCount=0;

//       driver.get().navigate().refresh();
        wait(5);
        String ApprovalStatusFieldNameInTable = null,ApprovalstatusName="UPI";
        //Appproval Status  field Verification
        List<WebElement> rows = getElementsList(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[13]"));
        int ApprovalStatusFieldCount= rows.size();
        for(int j=1;j<=ApprovalStatusFieldCount;j++)
        {
            String ApprovalStatus="//table[@class='table table-bordered']/tbody/tr["+ j +"]/td[13]";
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver.get();
            String script = "window.scrollBy(500, 0);";
            // Execute the JavaScript code to scroll right
            jsExecutor.executeScript(script);
            By ApprovalStatusField=By.xpath(ApprovalStatus);
            WebElement EmpName = getElement(ApprovalStatusField);
            ApprovalStatusFieldNameInTable=EmpName.getText();
            if(ApprovalStatusFieldNameInTable.equalsIgnoreCase(ApprovalstatusName))
            {
                test().log(Status.PASS, "=====> Row "+ j +" PaymentMode "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value :"+ApprovalstatusName);
                System.out.println("Row "+j+"  PaymentMode "+ApprovalStatusFieldNameInTable+"  is  matched with the Table Row Value : "+ApprovalstatusName);

            }
            else
            {
                test().log(Status.FAIL, "=====>Row "+ j +" PaymentMode "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value : "+ApprovalstatusName);
                System.out.println("Row "+ j +" PaymentMode  "+ApprovalStatusFieldNameInTable+" is  not matched with the Table Row Value : "+ApprovalstatusName);

            }
        }
        //Pagenation count + Clicking on next page
        for (int i = 1; i < 1000; i++)
        {
            wait(5);
            List<WebElement> rows2 = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/div[1]/div/table/tbody/tr"));
            PaymentTransactionCount += rows2.size();
//          wait(2);
            int j = i + 1;
            String NextPage = "//*[@id='pagebutton" + j + "']//button[@class='page-link']";
            try
            {
                By Next_Page = By.xpath(NextPage);
                waitforElementToBeVisible(Next_Page);
                waitforElementToBeClickable(Next_Page);
                scrollDown(driver.get());
                wait(2);
                click(Next_Page);
            }
            catch (NoSuchElementException E)
            {
                i = 1000;
            }

        }

        // download
        jsClick(DownloadButton);
        wait(5);
        String Manager_Reports = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory = System.getProperty("user.dir") + "/"+Manager_Reports;
        File dir = new File(downloadDirectory);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Payments File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>payments File download verification failed.");
        }
        System.out.println(PaymentTransactionCount);
        //********************************************download verfication*************************************//
        int Manager_XLSVRowCount=0;
        String Manager_Reports2 = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory2 = System.getProperty("user.dir") + "/" + Manager_Reports;
        File dir2 = new File(downloadDirectory2);
        File[] files2 = dir2.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
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
            if(PaymentTransactionCount==Manager_XLSVRowCount)
            {
                test().log(Status.PASS, "=====>Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Payments Downloaded XLSV file");

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

    public void UPI_Payment_request_PaymentModeDropdownInPaymentHistory()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(2);
        waitforElementToBeVisible(PaymentMode_UPI);
        waitforElementToBePresent(PaymentMode_UPI);
        waitforElementToBeClickable(PaymentMode_UPI);
        click(PaymentMode_UPI);
        wait(3);
        waitforElementToBeVisible(PaymentMode_UPIPaymentRequest);
        waitforElementToBePresent(PaymentMode_UPIPaymentRequest);
        waitforElementToBeClickable(PaymentMode_UPIPaymentRequest);
        click(PaymentMode_UPIPaymentRequest);
        wait(3);
        int PaymentTransactionCount=0;

//       driver.get().navigate().refresh();
        wait(5);
        String ApprovalStatusFieldNameInTable = null,ApprovalstatusName="UPI Payment Request";
        //Appproval Status  field Verification
        List<WebElement> rows = getElementsList(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[13]"));
        int ApprovalStatusFieldCount= rows.size();
        for(int j=1;j<=ApprovalStatusFieldCount;j++)
        {
            String ApprovalStatus="//table[@class='table table-bordered']/tbody/tr["+ j +"]/td[13]";
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver.get();
            String script = "window.scrollBy(500, 0);";
            // Execute the JavaScript code to scroll right
            jsExecutor.executeScript(script);
            By ApprovalStatusField=By.xpath(ApprovalStatus);
            WebElement EmpName = getElement(ApprovalStatusField);
            ApprovalStatusFieldNameInTable=EmpName.getText();
            if(ApprovalStatusFieldNameInTable.equalsIgnoreCase(ApprovalstatusName))
            {
                test().log(Status.PASS, "=====> Row "+ j +" PaymentMode "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value :"+ApprovalstatusName);
                System.out.println("Row "+j+"  PaymentMode "+ApprovalStatusFieldNameInTable+"  is  matched with the Table Row Value : "+ApprovalstatusName);

            }
            else
            {
                test().log(Status.FAIL, "=====>Row "+ j +" PaymentMode "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value : "+ApprovalstatusName);
                System.out.println("Row "+ j +" PaymentMode  "+ApprovalStatusFieldNameInTable+" is  not matched with the Table Row Value : "+ApprovalstatusName);

            }
        }
        //Pagenation count + Clicking on next page
        for (int i = 1; i < 1000; i++)
        {
            wait(5);
            List<WebElement> rows2 = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/div[1]/div/table/tbody/tr"));
            PaymentTransactionCount += rows2.size();
//          wait(2);
            int j = i + 1;
            String NextPage = "//*[@id='pagebutton" + j + "']//button[@class='page-link']";
            try
            {
                By Next_Page = By.xpath(NextPage);
                waitforElementToBeVisible(Next_Page);
                waitforElementToBeClickable(Next_Page);
                scrollDown(driver.get());
                wait(2);
                click(Next_Page);
            }
            catch (NoSuchElementException E)
            {
                i = 1000;
            }

        }

        // download
        jsClick(DownloadButton);
        wait(5);
        String Manager_Reports = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory = System.getProperty("user.dir") + "/"+Manager_Reports;
        File dir = new File(downloadDirectory);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Payments File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>payments File download verification failed.");
        }
        System.out.println(PaymentTransactionCount);
        //********************************************download verfication*************************************//
        int Manager_XLSVRowCount=0;
        String Manager_Reports2 = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory2 = System.getProperty("user.dir") + "/" + Manager_Reports;
        File dir2 = new File(downloadDirectory2);
        File[] files2 = dir2.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
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
            if(PaymentTransactionCount==Manager_XLSVRowCount)
            {
                test().log(Status.PASS, "=====>Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Payments Downloaded XLSV file");

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

    public void BulkPayment_PaymentModeDropdownInPaymentHistory()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(2);
        waitforElementToBeVisible(PaymentMode_UPIPaymentRequest);
        waitforElementToBePresent(PaymentMode_UPIPaymentRequest);
        waitforElementToBeClickable(PaymentMode_UPIPaymentRequest);
        click(PaymentMode_UPIPaymentRequest);
        wait(3);
        waitforElementToBeVisible(PaymentMode_BulkPaymentRequest);
        waitforElementToBePresent(PaymentMode_BulkPaymentRequest);
        waitforElementToBeClickable(PaymentMode_BulkPaymentRequest);
        click(PaymentMode_BulkPaymentRequest);
        wait(3);
        int PaymentTransactionCount=0;
        wait(5);
        String ApprovalStatusFieldNameInTable = null,ApprovalstatusName="Bulk Payment Request";
        //Appproval Status  field Verification
        List<WebElement> rows = getElementsList(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[13]"));
        int ApprovalStatusFieldCount= rows.size();
        for(int j=1;j<=ApprovalStatusFieldCount;j++)
        {
            String ApprovalStatus="//table[@class='table table-bordered']/tbody/tr["+ j +"]/td[13]";
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver.get();
            String script = "window.scrollBy(500, 0);";
            // Execute the JavaScript code to scroll right
            jsExecutor.executeScript(script);
            By ApprovalStatusField=By.xpath(ApprovalStatus);
            WebElement EmpName = getElement(ApprovalStatusField);
            ApprovalStatusFieldNameInTable=EmpName.getText();
            if(ApprovalStatusFieldNameInTable.equalsIgnoreCase(ApprovalstatusName))
            {
                test().log(Status.PASS, "=====> Row "+ j +" PaymentMode "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value :"+ApprovalstatusName);
                System.out.println("Row "+j+"  PaymentMode "+ApprovalStatusFieldNameInTable+"  is  matched with the Table Row Value : "+ApprovalstatusName);

            }
            else
            {
                test().log(Status.FAIL, "=====>Row "+ j +" PaymentMode "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value : "+ApprovalstatusName);
                System.out.println("Row "+ j +" PaymentMode  "+ApprovalStatusFieldNameInTable+" is  not matched with the Table Row Value : "+ApprovalstatusName);

            }
        }
        //Pagenation count + Clicking on next page
        for (int i = 1; i < 1000; i++)
        {
            wait(5);
            List<WebElement> rows2 = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/div[1]/div/table/tbody/tr"));
            PaymentTransactionCount += rows2.size();
//          wait(2);
            int j = i + 1;
            String NextPage = "//*[@id='pagebutton" + j + "']//button[@class='page-link']";
            try
            {
                By Next_Page = By.xpath(NextPage);
                waitforElementToBeVisible(Next_Page);
                waitforElementToBeClickable(Next_Page);
                scrollDown(driver.get());
                wait(2);
                click(Next_Page);
            }
            catch (NoSuchElementException E)
            {
                i = 1000;
            }

        }
        // download
        jsClick(DownloadButton);
        wait(5);
        String Manager_Reports = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory = System.getProperty("user.dir") + "/"+Manager_Reports;
        File dir = new File(downloadDirectory);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Payments File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>payments File download verification failed.");
        }
        System.out.println(PaymentTransactionCount);
        //********************************************download verfication*************************************//
        int Manager_XLSVRowCount=0;
        String Manager_Reports2 = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory2 = System.getProperty("user.dir") + "/" + Manager_Reports;
        File dir2 = new File(downloadDirectory2);
        File[] files2 = dir2.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
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
            if(PaymentTransactionCount==Manager_XLSVRowCount)
            {
                test().log(Status.PASS, "=====>Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Payments Downloaded XLSV file");

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

    public void Others_PaymentModeDropdownInPaymentHistory()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("window.scrollBy(0,-400)", "");
        wait(2);
        waitforElementToBeVisible(PaymentMode_BulkPaymentRequest);
        waitforElementToBePresent(PaymentMode_BulkPaymentRequest);
        waitforElementToBeClickable(PaymentMode_BulkPaymentRequest);
        click(PaymentMode_BulkPaymentRequest);
        wait(3);
        waitforElementToBeVisible(PaymentMode_Other);
        waitforElementToBePresent(PaymentMode_Other);
        waitforElementToBeClickable(PaymentMode_Other);
        click(PaymentMode_Other);
        wait(2);
        int PaymentTransactionCount=0;
        wait(5);
        String ApprovalStatusFieldNameInTable = null,ApprovalstatusName="Others";
        //Appproval Status  field Verification
        List<WebElement> rows = getElementsList(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[13]"));
        int ApprovalStatusFieldCount= rows.size();
        for(int j=1;j<=ApprovalStatusFieldCount;j++)
        {
            String ApprovalStatus="//table[@class='table table-bordered']/tbody/tr["+ j +"]/td[13]";
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver.get();
            String script = "window.scrollBy(500, 0);";
            // Execute the JavaScript code to scroll right
            jsExecutor.executeScript(script);
            By ApprovalStatusField=By.xpath(ApprovalStatus);
            WebElement EmpName = getElement(ApprovalStatusField);
            ApprovalStatusFieldNameInTable=EmpName.getText();
            if(ApprovalStatusFieldNameInTable.equalsIgnoreCase(ApprovalstatusName))
            {
                test().log(Status.PASS, "=====> Row "+ j +" PaymentMode "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value :"+ApprovalstatusName);
                System.out.println("Row "+j+"  PaymentMode "+ApprovalStatusFieldNameInTable+"  is  matched with the Table Row Value : "+ApprovalstatusName);

            }
            else
            {
                test().log(Status.FAIL, "=====>Row "+ j +" PaymentMode "+ApprovalStatusFieldNameInTable+"  is matched with the Table Row Value : "+ApprovalstatusName);
                System.out.println("Row "+ j +" PaymentMode  "+ApprovalStatusFieldNameInTable+" is  not matched with the Table Row Value : "+ApprovalstatusName);

            }
        }
        //Pagenation count + Clicking on next page
        for (int i = 1; i < 1000; i++)
        {
            wait(5);
            List<WebElement> rows2 = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div[2]/div/div[1]/div/table/tbody/tr"));
            PaymentTransactionCount += rows2.size();
//          wait(2);
            int j = i + 1;
            String NextPage = "//*[@id='pagebutton" + j + "']//button[@class='page-link']";
            try
            {
                By Next_Page = By.xpath(NextPage);
                waitforElementToBeVisible(Next_Page);
                waitforElementToBeClickable(Next_Page);
                scrollDown(driver.get());
                wait(2);
                click(Next_Page);
            }
            catch (NoSuchElementException E)
            {
                i = 1000;
            }

        }
        // download
        jsClick(DownloadButton);
        wait(5);
        String Manager_Reports = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory = System.getProperty("user.dir") + "/"+Manager_Reports;
        File dir = new File(downloadDirectory);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Payments File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>payments File download verification failed.");
        }
        System.out.println(PaymentTransactionCount);
        //********************************************download verfication*************************************//
        int Manager_XLSVRowCount=0;
        String Manager_Reports2 = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory2 = System.getProperty("user.dir") + "/" + Manager_Reports;
        File dir2 = new File(downloadDirectory2);
        File[] files2 = dir2.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Payments"))
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
            if(PaymentTransactionCount==Manager_XLSVRowCount)
            {
                test().log(Status.PASS, "=====>Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Payments Pagenation "+PaymentTransactionCount+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Payments Downloaded XLSV file");

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
