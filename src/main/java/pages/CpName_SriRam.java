package pages;

import com.aventstack.extentreports.Status;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import util.Utils;
import java.io.File;
import java.io.FilenameFilter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.Base.driver;

public class CpName_SriRam extends Utils
{
    By XLSVDownload = By.xpath("//*[@id=\"userAllocationsDownload\"]");
    By CPName_TextBox = By.xpath("//*[@id=\"cpNames\"]//*[text()='All']");
    By IndifyCPname = By.xpath("//*[@id=\"cpNames\"]//*[text()='INDIFY']");
    By SRI_RAM_FINANCE_CPname = By.xpath("//*[@id=\"cpNames\"]//*[text()='SRI RAM FINANCE']");
    By AUBank_CPname = By.xpath("//*[@id=\"cpNames\"]//*[text()='AU BANK']");
    By BAJAJ_FINANACE_CPname = By.xpath("//*[@id=\"cpNames\"]//*[text()='BAJAJ FINANCE']");

    By Eye_Symbol = By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/div/div/div/div/div[3]/div/table/tbody/tr[1]/td[9]/div/a/i");
    By CloseButton = By.xpath("/html/body/div[7]/div/div/div[1]/button");
    By NextPage = By.xpath("/html/body/div[4]/div/div/div[2]/div/div[2]/div[2]/nav/ul/li[8]/button");
    By CPname = By.xpath("//*[@role='dialog']//*[@class='card contact-bx item-content']//tr[7]//td[3]");
    By LoanNo=By.xpath("//*[@role='dialog']//*[@class='card contact-bx item-content']//tr[2]//td[3]");
    String Report_CPName,Reports_LoanNo;
    int rowsintable=1;
    List<String> loanNoList = new ArrayList<>();
    List<WebElement> rows;
    String fileName_Customer_Details,fileName;


    public void SelectCPNameAllocationFromList(String CPnameSelected) throws InterruptedException
    {
        int rowSize=1;
        int i = 1; // Initialize i to 1
        wait(2);
        while (i <= rowSize)
        { // Use a while loop

            rows = getElementsList(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[5]/div/span"));
            rowSize= rows.size();

            String xpathOfLoanNo = "//table[@class='table table-bordered']/tbody/tr[" + i + "]/td[5]/div/span";

            By LoanNoList = By.xpath(xpathOfLoanNo);
            waitforElementToBeVisible(LoanNoList);
            waitforElementToBePresent(LoanNoList);
            waitforElementToBeClickable(LoanNoList);
            jsClick(LoanNoList);


            waitforElementToBeVisible(LoanNo);
            waitforElementToBePresent(LoanNo);
            waitforElementToBeClickable(LoanNo);
            WebElement LoanNoAllocationView1 = driver.get().findElement(LoanNo);


            waitforElementToBeVisible(CPname);
            waitforElementToBePresent(CPname);
            waitforElementToBeClickable(CPname);
            WebElement CPnameAllocationView1 = driver.get().findElement(CPname);

            String loanNoAllocationView1=LoanNoAllocationView1.getText();
            String cpnameAllocationView1 = CPnameAllocationView1.getText();
            String[] values = {loanNoAllocationView1,cpnameAllocationView1};
            loanNoList.add(Arrays.toString(values));

            rowsintable++;
            // CPnameSelected = "INDIFY/bajaj/sriram/aubank";
            if (CPnameSelected.equalsIgnoreCase(cpnameAllocationView1))
            {
                test().log(Status.PASS, "Selected CPName filter : "+CPnameSelected+ " is matched with this Loan No: "+loanNoAllocationView1+" CPName : "+ cpnameAllocationView1);
            }
            else
            {
                test().log(Status.FAIL," Selected CPName filter : "+CPnameSelected+ " is not matched with this Loan No: "+loanNoAllocationView1+" CPName : "+ cpnameAllocationView1);
            }
            try
            {
                click(CloseButton);
            }
            catch (NoSuchElementException ignored)
            {
                // Handle NoSuchElementException
            }
            if (i == 10)
            {
                // Reset i to 1

                try
                {
                    waitforElementToBeVisible(NextPage);
                    waitforElementToBePresent(NextPage);
                    waitforElementToBeClickable(NextPage);
                    wait(3);
                    jsClick(NextPage);
                    wait(2);
                }
                catch (NoSuchElementException e)
                {
                    System.out.println("Next page is not available");
                    break;
                }
                rows = getElementsList(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[5]/div/span"));
                rowSize = rows.size();
                wait(2);
                i = 1;
            }
            else
            {
                i++;
            }
        }
        System.out.println("rowsize value is "+(rowsintable-1));
        System.out.println(loanNoList);
        //wait(10);
    }

    public void DownloadResultedXLSVFileFromListedCustomerTab()
    {

        waitforElementToBeClickable(XLSVDownload);
        wait(1);
        jsClick(XLSVDownload);

        File downloadDirectory = new File("src/file_download");
        wait(20);

        File[] files = downloadDirectory.listFiles(new FilenameFilter()
        {
            public boolean accept(File dir, String name)
            {
                return name.endsWith(".xlsx"); // Replace with the file extension you expect
            }
        });
        // Check if any files matching the criteria were found
        if (files != null && files.length > 0)
        {
            fileName = files[0].getName(); // Get the first file (change the index if needed)
            System.out.println("Downloaded file name: " + fileName);
        }
        else
        {
            System.out.println("No matching files found in the download directory");
        }
        fileName_Customer_Details = "C:\\Users\\Saikiran Kondala\\Documents\\Automation\\SIa\\selenium\\src\\file_download\\"+fileName;
        File downloadedFile = new File(fileName_Customer_Details);
        boolean isFileDownloaded = downloadedFile.exists();
        // Assertion
        if (isFileDownloaded)
        {
            test().log(Status.PASS, "XlSV File has been downloaded successfully.");
        }
        else
        {
            test().log(Status.FAIL, "XSLV File download & verification failed.");
        }

    }

    public void verifyDownloadedXLSV()
    {
        int i = 1;
        while (i <= loanNoList.size())
        {
            String xlsxFilePath = fileName_Customer_Details;
            try (FileInputStream fileInputStream = new FileInputStream(xlsxFilePath);
                 Workbook workbook = new XSSFWorkbook(fileInputStream)) {
                // Assuming you are working with the first sheet (index 0)
                Sheet sheet = workbook.getSheetAt(0);
                // Assuming you want to read the first row (header row)
                Row firstRow = sheet.getRow(i);
                if (firstRow != null)
                {
                    // Assuming you want to read the first cell (field)
                    Cell CPName_Report = firstRow.getCell(3);
                    Cell LoanNo = firstRow.getCell(6);
                    if (CPName_Report != null && LoanNo != null)
                    {
                        Report_CPName = CPName_Report.toString();
                        Reports_LoanNo = LoanNo.toString();
                        int j=0;
                        while(j<loanNoList.size())
                        {
                            if(Reports_LoanNo.contains(loanNoList.get(j)))
                            {

                                if (Report_CPName.contains(loanNoList.get(j)))
                                {
                                    test().log(Status.PASS, "LoanNo :- " + Reports_LoanNo + " CPName: " + Report_CPName + " is matched with XLSV LoanNo and CPName: "+loanNoList.get(j));

                                }
                                else
                                {
                                    test().log(Status.FAIL, "LoanNo :- " + Reports_LoanNo + "CPName: " + Report_CPName + " is  not matched with XLSV LoanNo and CPName: "+loanNoList.get(j) );

                                }
                            }
                            j++;

                        }

                    }
                    else
                    {
                        test().log(Status.FAIL, "Cell is null in downloaded XLSV file in work allocations. ");
                    }
                }
                else
                {
                    test().log(Status.FAIL, i+ " row is null in downloaded XLSV file in work allocations.");
                }
            }
            catch (IOException e)
            {
                // e.printStackTrace();
            }
            i++;
        }
    }

    public void SelectCPNameFromDropDown()
    {
        wait(2);
        waitforElementToBePresent(CPName_TextBox);
        waitforElementToBeClickable(CPName_TextBox);
        click(CPName_TextBox);
        wait(2);
        waitforElementToBeVisible(IndifyCPname);
        waitforElementToBePresent(IndifyCPname);
        waitforElementToBeClickable(IndifyCPname);
        jsClick(IndifyCPname);
        wait(10);
        waitforElementToBeVisible(Eye_Symbol);
        waitforElementToBePresent(Eye_Symbol);
        waitforElementToBeClickable(Eye_Symbol);
        jsClick(Eye_Symbol);
    }
    public void Select_AUBank_CPNameFromDropDown()
    {
        wait(2);
        waitforElementToBePresent(CPName_TextBox);
        waitforElementToBeClickable(CPName_TextBox);
        click(CPName_TextBox);
        wait(2);
        waitforElementToBeVisible(AUBank_CPname);
        waitforElementToBePresent(AUBank_CPname);
        waitforElementToBeClickable(AUBank_CPname);
        jsClick(AUBank_CPname);
        wait(10);
        waitforElementToBeVisible(Eye_Symbol);
        waitforElementToBePresent(Eye_Symbol);
        waitforElementToBeClickable(Eye_Symbol);
        jsClick(Eye_Symbol);
    }
    public void Select_SRIRAMFINANCE_CPNameFromDropDown()
    {
        wait(2);
        waitforElementToBePresent(CPName_TextBox);
        waitforElementToBeClickable(CPName_TextBox);
        click(CPName_TextBox);
        wait(2);
        waitforElementToBeVisible(SRI_RAM_FINANCE_CPname);
        waitforElementToBePresent(SRI_RAM_FINANCE_CPname);
        waitforElementToBeClickable(SRI_RAM_FINANCE_CPname);
        jsClick(SRI_RAM_FINANCE_CPname);
        wait(10);
        waitforElementToBeVisible(Eye_Symbol);
        waitforElementToBePresent(Eye_Symbol);
        waitforElementToBeClickable(Eye_Symbol);
        jsClick(Eye_Symbol);
    }
    public void Select_BAJAJFINANCE_CPNameFromDropDown()
    {
        wait(2);
        waitforElementToBePresent(CPName_TextBox);
        waitforElementToBeClickable(CPName_TextBox);
        click(CPName_TextBox);
        wait(2);
        waitforElementToBeVisible(BAJAJ_FINANACE_CPname);
        waitforElementToBePresent(BAJAJ_FINANACE_CPname);
        waitforElementToBeClickable(BAJAJ_FINANACE_CPname);
        jsClick(BAJAJ_FINANACE_CPname);
        wait(10);
        waitforElementToBeVisible(Eye_Symbol);
        waitforElementToBePresent(Eye_Symbol);
        waitforElementToBeClickable(Eye_Symbol);
        jsClick(Eye_Symbol);
    }

    public void verifyDownloadedXLSVRowCounts() {

        String filePath = fileName_Customer_Details; // Replace with the path to your Excel file

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            // Assuming you want to read the first sheet. You can change this if needed.
            Sheet sheet = workbook.getSheetAt(0);

            // Get the total number of rows in the sheet
            int rowCount = sheet.getLastRowNum() + 1;

            if(loanNoList.size()==rowCount-1)
            {
                test().log(Status.PASS, "Row count of XLSV "+rowCount+" is matched with pagenationcount in allocated user"+loanNoList.size());

            }
            else
            {
                test().log(Status.FAIL, "Row count of XLSV "+rowCount+" is  not matched with pagenationcount in allocated user"+loanNoList.size());

            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
