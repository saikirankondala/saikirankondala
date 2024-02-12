package pages;

import com.aventstack.extentreports.Status;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import util.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static util.Base.driver;

public class Employee_ledger extends Utils {
    By Payments_cashDepositions=By.xpath("//*[text()=' Employee Ledger ']");
    By CashDeposition_Search=By.xpath("//*[@placeholder='Search by Emp Id/Emp Name']");
    By CashDepsotion_download=By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[2]/div/div/div/div[2]/button");
    public void clickOnCashDepositionEmployeeLedger()
    {
        waitforElementToBePresent(Payments_cashDepositions);
        waitforElementToBeClickable(Payments_cashDepositions);
        jsClick(Payments_cashDepositions);
        wait(1);
    }

    public void searchEmpName()
    {
        WebElement textBox = driver.get().findElement(CashDeposition_Search);
        textBox.clear();
        waitforElementToBeVisible(CashDeposition_Search);
        waitforElementToBePresent(CashDeposition_Search);
        waitforElementToBeClickable(CashDeposition_Search);
        jsClick(CashDeposition_Search);
        ////
        List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[2]/div/div/div/div[3]/div/div/table/tbody/tr/td[1]"));
        int LoanNoCount = rows.size();
        int i = getRandomNumber(1, LoanNoCount);
        String LoanNoInPaymentTab = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[2]/div/div/div/div[3]/div/div/table/tbody/tr["+ i +"]/td[1]";
        By LoanNo = By.xpath(LoanNoInPaymentTab);
        WebElement EmpName = getElement(LoanNo);
        LoanNoInPaymentTab = EmpName.getText();
        WebElement element = driver.get().findElement(CashDeposition_Search);
        element.sendKeys(LoanNoInPaymentTab);
        wait(10);
        String LoanNoInPaymentTab_Search = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[2]/div/div/div/div[3]/div/div/table/tbody/tr[1]/td[1]";

        By LoanNo_text2 = By.xpath(LoanNoInPaymentTab_Search);
        WebElement LoanNoInPaymentTab_Search_text = getElement(LoanNo_text2);
        String LoanNoInPaymentTab2 = LoanNoInPaymentTab_Search_text.getText();
        if (LoanNoInPaymentTab.equalsIgnoreCase(LoanNoInPaymentTab2)) {
            test().log(Status.PASS, "=====>Searched EmpID " + LoanNoInPaymentTab + " is matched");
        } else {
            test().log(Status.FAIL, "=====>Searched EmpID " + LoanNoInPaymentTab + " is not matched");
        }
    }

    public void searchEmpId() {
        WebElement textBox = driver.get().findElement(CashDeposition_Search);
        textBox.clear();
        waitforElementToBeVisible(CashDeposition_Search);
        waitforElementToBePresent(CashDeposition_Search);
        waitforElementToBeClickable(CashDeposition_Search);
        jsClick(CashDeposition_Search);
        ////
        List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[2]/div/div/div/div[3]/div/div/table/tbody/tr/td[1]"));
        int LoanNoCount = rows.size();
        int i = getRandomNumber(1, LoanNoCount);
        String LoanNoInPaymentTab = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[2]/div/div/div/div[3]/div/div/table/tbody/tr[" + i + "]/td[2]";
        By LoanNo = By.xpath(LoanNoInPaymentTab);
        WebElement EmpName = getElement(LoanNo);
        LoanNoInPaymentTab = EmpName.getText();
        WebElement element = driver.get().findElement(CashDeposition_Search);
        element.sendKeys(LoanNoInPaymentTab);
        wait(10);
        String LoanNoInPaymentTab_Search = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[2]/div/div/div/div[3]/div/div/table/tbody/tr[1]/td[2]";

        By LoanNo_text2 = By.xpath(LoanNoInPaymentTab_Search);
        WebElement LoanNoInPaymentTab_Search_text = getElement(LoanNo_text2);
        String LoanNoInPaymentTab2 = LoanNoInPaymentTab_Search_text.getText();
        if (LoanNoInPaymentTab.equalsIgnoreCase(LoanNoInPaymentTab2)) {
            test().log(Status.PASS, "=====>Searched EmpName " + LoanNoInPaymentTab + " is matched");
        } else {
            test().log(Status.FAIL, "=====>Searched EmpName " + LoanNoInPaymentTab + " is not matched");
        }
    }

    public void ListVerfication()
    {
        int PaymentTransactionCount = 0;
        for (int i = 1; i < 1000; i++)
        {
            wait(2);
            List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div/div/div/div[2]/div/div/div/div[3]/div/div/table/tbody/tr/td[1]"));
            PaymentTransactionCount += rows.size();
            //          wait(2);
            int j = i + 1;
            String NextPage = "//*[@id='pagebutton" + j + "']//button[@class='page-link']";
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
        jsClick(CashDepsotion_download);
        wait(5);
        String Manager_Reports = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory = System.getProperty("user.dir") + "/" + Manager_Reports;
        File dir = new File(downloadDirectory);
        File[] files = dir.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Ledger"))
                {
                    System.out.println("Found file: " + file.getAbsolutePath());
                    test().log(Status.PASS, "=====>Ledger File has been downloaded successfully.");
                }
            }
        }
        else
        {
            System.out.println("No files found in the directory.");
            test().log(Status.FAIL, "=====>Ledger File download verification failed.");
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
                if (file.isFile() && file.getName().startsWith("Ledger"))
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
                test().log(Status.PASS, "=====>Ledger Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("ledger Pagenation " + PaymentTransactionCount + " count is matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Ledger Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);
                System.out.println("Ledger Pagenation " + PaymentTransactionCount + " count is not matched with the XLS File downloaded File Row count " + Manager_XLSVRowCount);

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
}

