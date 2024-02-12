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

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static util.Base.driver;

public class CollectionAllocationUpload extends Utils
{
    By workAllocation=By.xpath("//*[@id=\"main-wrapper\"]//*[text()='Work Allocations']");
    By collectionAllocation=By.xpath("//*[@id=\"main-wrapper\"]//*[text()='Collections']");
    By uploadExecutiveSchedule=By.xpath("//*[@id=\"uploadExecutiveSchedule\"]");//need to change once rakesh give id to tags
    By uploadExcelFile=By.xpath("//*[@class='form-control' and @type='file']");
    By nameForUploadExcelFile=By.xpath("//*[@id=\"fileNameInput\"]");
    By submitForUploadedExcelFile=By.xpath("//*[@id=\"uploadScheduleSubmitButton\"]");
    By SummaryReportTab=By.xpath("//*[@id=\"main-wrapper\"]//ul[@class='nav-tabs-custom nav-justified nav']//*[text()=' Summary ']");

    By UploadedSummary=By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/ul/li[4]");
    By UploadedSummaryReportStatus=By.xpath("//*[@id=\"main-wrapper\"]//*[@class='table table-bordered']//tr//td[4]");

    By UploadedSummaryReportName=By.xpath("//*[@id=\"main-wrapper\"]//*[@class='table table-bordered']//tr//td[1]");

    By UploadedSummaryReportNoOfRecordsProcessed=By.xpath("//*[@id=\"main-wrapper\"]//*[@class='table table-bordered']//tr//td[4]");
    By submitOK=By.xpath("//*[@class='swal-button swal-button--confirm'][text()='OK']");

    By homeTab=By.xpath("//*[@id=\"main-wrapper\"]/div[1]/a/div[1]/img");

    By TemplateName=By.xpath("//*[@class=\" css-1wa3eu0-placeholder\"][text()='Select...']");
    By TemplateDropDown_NormalAllocation=By.xpath("//*[text()='Upload Collection Allocations']");
    String allocationFileName;
    int iii;
    public void ClickOnWorkAllocation()
    {
        waitforElementToBePresent(workAllocation);
        waitforElementToBeClickable(workAllocation);
        click(workAllocation);
        wait(2);
    }

    public void ClickOnCollectionUnderWorkAllocation() {
        waitforElementToBePresent(collectionAllocation);
        waitforElementToBeClickable(collectionAllocation);
        jsClick(collectionAllocation);
        wait(2);
    }

    public void ClickOnUploadExecutiveSchedule() {
        waitforElementToBePresent(uploadExecutiveSchedule);
        waitforElementToBeClickable(uploadExecutiveSchedule);
        click(uploadExecutiveSchedule);
        wait(2);
    }

    public void ClickOnUploadExcelfile() throws AWTException {

        waitforElementToBePresent(TemplateName);
        waitforElementToBeClickable(TemplateName);
        click(TemplateName);

        waitforElementToBePresent(TemplateDropDown_NormalAllocation);
        waitforElementToBeClickable(TemplateDropDown_NormalAllocation);
        click(TemplateDropDown_NormalAllocation);

        waitforElementToBePresent(uploadExcelFile);
        waitforElementToBeClickable(uploadExcelFile);
        //WebElement fileInput = driver.get().findElement(uploadExcelFile);
        jsClick(uploadExcelFile);
        wait(2);
        Robot rb = new Robot();

        // copying File path to Clipboard
        StringSelection str = new StringSelection("C:\\Users\\Saikiran Kondala\\Documents\\Automation\\SIa\\selenium\\src\\TestData\\CollectionAllocationForExecutive\\Collection Allocations.xlsx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

    }

    public void ClickOnExcelFileName()
    {


        waitforElementToBePresent(nameForUploadExcelFile);
        waitforElementToBeClickable(nameForUploadExcelFile);
        allocationFileName="Allocation_"+randomAlphabeticString()+getRandomNumber(0,9);
        WebElement fileInput = driver.get().findElement(nameForUploadExcelFile);
        fileInput.sendKeys(allocationFileName);
        wait(2);
    }

    public void ClickOnExcelFileSubmit() {
        waitforElementToBePresent(submitForUploadedExcelFile);
        waitforElementToBeClickable(submitForUploadedExcelFile);
        jsClick(submitForUploadedExcelFile);
        wait(60);
        try
        {
            waitforElementToBeVisible(submitOK);
            waitforElementToBePresent(submitOK);
            waitforElementToBeClickable(submitOK);
            jsClick(submitOK);
            test().log(Status.PASS, "uploaded collection allocation");

        }
        catch (NoSuchElementException m) {
            test().log(Status.FAIL, "Issue in uploaded collection allocation");
        }
    }

    public void ClickOnUploadedSummary()
    {
        waitforElementToBePresent(UploadedSummary);
        waitforElementToBeClickable(UploadedSummary);
        click(UploadedSummary);
    }
    public void ClickOnUploadedSummaryReport()
    {
        wait(5);
        int i = 1,rowSize = 1;WebElement e1;
        try {
            while (i <= rowSize)
            {
                wait(1);
                String totalrowsintable = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div/table/tbody/tr";
                List<WebElement> rows = getElementsList(By.xpath(totalrowsintable));
                rowSize = rows.size();
                String Allocation_File_Name = "//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr[" + i + "]/td[1]";
                By AllocationFileName = By.xpath(Allocation_File_Name);
                waitforElementToBeVisible(AllocationFileName);
                waitforElementToBePresents(AllocationFileName);
                waitforElementToBeClickable(AllocationFileName);
                e1 = getElement(AllocationFileName);
                wait(1);
                String Allocation_FileName = e1.getText();
                if (Allocation_FileName.equalsIgnoreCase(allocationFileName))
                {
                    test().log(Status.PASS, "Collection allocation file Name  is Matched");
                    String UploadStatus = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div/table/tbody/tr[" + i + "]/td[5]";
                    By Uploadstatus = By.xpath(UploadStatus);
                    waitforElementToBeVisible(Uploadstatus);
                    waitforElementToBePresents(Uploadstatus);
                    waitforElementToBeClickable(Uploadstatus);
                    e1 = getElement(Uploadstatus);
                    wait(1);
                    String UploadStatusInUploadedFile = e1.getText();
                    i = rowSize + 1;
                    //////////To fetch the row count from XLSV file
                    int rowCount = 0;
                    String csvFilePath = "C:\\Users\\Saikiran Kondala\\Documents\\Automation\\SIa\\selenium\\src\\TestData\\CollectionAllocationForExecutive\\Collection Allocations.xlsx";
                    try (FileInputStream fileInputStream = new FileInputStream(csvFilePath);
                         Workbook workbook = new XSSFWorkbook(fileInputStream))
                    {
                        Sheet sheet = workbook.getSheetAt(0);
                        rowCount = sheet.getPhysicalNumberOfRows() - 1;
                        //System.out.println("Number of rows in the XLSX file: " + rowCount);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    wait(5);
                    String EmpID = "//*[@id=\"main-wrapper\"]//*[@class=\"table table-bordered\"]/tbody/tr[" + i + "]/td[4]";
                    By UploadedSummaryReportNoOfRecordsProcessed1 = By.xpath(EmpID);
                    waitforElementToBePresent(UploadedSummaryReportNoOfRecordsProcessed1);
                    waitforElementToBeClickable(UploadedSummaryReportNoOfRecordsProcessed1);
                    WebElement element = driver.get().findElement(UploadedSummaryReportNoOfRecordsProcessed1);
                    String uploadedSummaryReportNoOfRecordsProcessed = element.getText();
                    System.out.println(uploadedSummaryReportNoOfRecordsProcessed);
                    if (uploadedSummaryReportNoOfRecordsProcessed.equalsIgnoreCase(String.valueOf(rowCount)))
                    {
                        test().log(Status.PASS, "Collection allocation  row count  " + uploadedSummaryReportNoOfRecordsProcessed + "  is matched with " + rowCount + "Uploaded File");

                    }
                    else
                    {
                        test().log(Status.FAIL, "Collection allocation row count  " + uploadedSummaryReportNoOfRecordsProcessed + "  is not matched with " + rowCount + "Uploaded File");
                    }
                    if (UploadStatusInUploadedFile.equalsIgnoreCase("Uploaded"))
                    {
                        test().log(Status.PASS, "Collection allocation is Uploaded Successfully:--" + UploadStatusInUploadedFile);
                    }
                    else
                    {
                        test().log(Status.FAIL, "Collection allocation is not Uploaded Successfully:----" + UploadStatusInUploadedFile);
                    }
                }
                else
                {
                    //test().log(Status.FAIL, "Collection allocation File is not matched");
                    i++;
                }
            }
        }
        catch (NoSuchElementException elementException1)
        {
            //break;
        }
    }


    public void VerifyNoOfRecordsProcessedInAllocations()
    {
//        int rowCount = 0;
//        String csvFilePath = "C:\\Users\\Saikiran Kondala\\Documents\\Automation\\SIa\\selenium\\src\\TestData\\CollectionAllocationForExecutive\\Collection Allocations.xlsx";
//        try (FileInputStream fileInputStream = new FileInputStream(csvFilePath);
//             Workbook workbook = new XSSFWorkbook(fileInputStream))
//        {
//            Sheet sheet = workbook.getSheetAt(0);
//             rowCount = sheet.getPhysicalNumberOfRows()-1;
//            //System.out.println("Number of rows in the XLSX file: " + rowCount);
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
        wait(5);

//        WebElement e11;
//            String Allocation_File_Name = "//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr[" + iii + "]/td[1]";
//            By AllocationFileName=By.xpath(Allocation_File_Name);
//            waitforElementToBeVisible(AllocationFileName);
//            waitforElementToBePresents(AllocationFileName);
//            waitforElementToBeClickable(AllocationFileName);
//            e11 = getElement(AllocationFileName);
//            wait(1);
//            String Allocation_FileName = e11.getText();
//            if(Allocation_FileName.equalsIgnoreCase(allocationFileName))
//            {
//                wait(5);
//                String EmpID = "//*[@id=\"main-wrapper\"]//*[@class=\"table table-bordered\"]/tbody/tr["+ i+"]/td[4]";
//                By UploadedSummaryReportNoOfRecordsProcessed1 = By.xpath(EmpID);
//                waitforElementToBePresent(UploadedSummaryReportNoOfRecordsProcessed1);
//                waitforElementToBeClickable(UploadedSummaryReportNoOfRecordsProcessed1);
//                WebElement element = driver.get().findElement(UploadedSummaryReportNoOfRecordsProcessed1);
//                String uploadedSummaryReportNoOfRecordsProcessed = element.getText();
//                System.out.println(uploadedSummaryReportNoOfRecordsProcessed);
//                if (uploadedSummaryReportNoOfRecordsProcessed.equalsIgnoreCase(String.valueOf(rowCount)))
//                {
//                    test().log(Status.PASS, "Collection allocation  row count  " + uploadedSummaryReportNoOfRecordsProcessed + "  is matched with " + rowCount+"Uploaded File");
//
//                }
//                else
//                {
//                    test().log(Status.FAIL, "Collection allocation row count  " + uploadedSummaryReportNoOfRecordsProcessed + "  is not matched with " + rowCount+"Uploaded File");
//                }
//            }

    }
    public void ClickOnHomeTab()
    {
        waitforElementToBePresent(homeTab);
        waitforElementToBeClickable(homeTab);
        jsClick(homeTab);
    }


    public void ClickOnSummaryReportTab()
    {
        waitforElementToBeVisible(SummaryReportTab);
        waitforElementToBePresent(SummaryReportTab);
        waitforElementToBeClickable(SummaryReportTab);
        jsClick(SummaryReportTab);

    }

    public void ChangeLoanNo()
    {
                try {
                    // Load the Excel file
                    FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Saikiran Kondala\\Documents\\Automation\\SIa\\selenium\\src\\TestData\\CollectionAllocationForExecutive\\Collection Allocations.xlsx");
                    Workbook workbook = new XSSFWorkbook(fileInputStream);

                    // Access the sheet (Assuming it's the first sheet)
                    Sheet sheet = workbook.getSheetAt(0);

                    // Access the row and cell where you want to change the value
                    int rowIndex = 1; // Row index (0-based)
                    int columnIndex = 0; // Column index (0-based)
                    Row row = sheet.getRow(rowIndex);
                    Cell cell = row.getCell(columnIndex);
                    String loanNovalue= "automation"+String.valueOf(getRandomNumber(1,99999999));
                    // Set the new value for the cell
                    cell.setCellValue(loanNovalue);

                    // Save the changes to the file
                    FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Saikiran Kondala\\Documents\\Automation\\SIa\\selenium\\src\\TestData\\CollectionAllocationForExecutive\\Collection Allocations.xlsx");
                    workbook.write(fileOutputStream);
                    fileOutputStream.close();

                    // Close the input stream
                    fileInputStream.close();

                    System.out.println("loan NO Value updated successfully.");
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }



}



