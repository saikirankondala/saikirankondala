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
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static util.Base.driver;

public class AllocatedUsersSearchwithLoanNo extends Utils {
    String lenderIDInAllocationViewText;
    String EmpIDAllocation;
    String contactno;
    String loanNoAllocation;
    String CPNameAllocation ;
    String lenderNameInAllocationViewText;
    String customerNameInAllocationViewText;
    String contactNoInAllocationViewText;


    By allocatedUserSearchBar = By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/input");
    String rowValue, EmpID, CPName, ContactNO,VehicleNo;
    String Report_LenderName,Report_CPName,Report_ContactNo,Report_LenderID,Reports_LoanNo,Report_CustomerName;
    By LoanNoInAllocationView = By.xpath("//*[@role='dialog']//*[@class='card contact-bx item-content']//tr[2]//td[3]");

    By CPNameInAllocationView = By.xpath("//*[@role='dialog']//*[@class='card contact-bx item-content']//tr[7]//td[3]");
    By CustomerNameInAllocationView=By.xpath("//*[@role='dialog']//*[@class='card contact-bx item-content']//tr[3]//td[3]");
    By ContactNoInAllocationView=By.xpath("//*[@role='dialog']//*[@class='card contact-bx item-content']//tr[19]//td[3]");
    By LenderIDInAllocationView=By.xpath("//*[@role='dialog']//*[@class='card contact-bx item-content']//tr[8]//td[3]");
    By LenderNameInAllocation=By.xpath("//*[@role='dialog']//*[@class='card contact-bx item-content']//tr[9]//td[3]");
    By User_Management_Tab=By.xpath("//*[@id=\"main-wrapper\"]/div[3]/div[1]/div[1]/ul/li[4]/a/span");
    By Click_On_Executive=By.xpath("//*[@id=\"main-wrapper\"]//*[text()=' Executives']");
    By Click_On_Manager=By.xpath("//*[@id=\"main-wrapper\"]/div[3]/div[1]/div[1]/ul/li[4]/ul/li[1]/a/span");
    By Click_On_Executive_SearchBar=By.xpath("//*[@id=\"main-wrapper\"]//input[@placeholder=\"Search By Name/Branch/Mobile/Emp ID\"]");
    By Click_On_Manager_SearchBar=By.xpath("//*[@id=\"main-wrapper\"]//input[@placeholder=\"Search By Name/Branch/Mobile/Emp ID\"]");
    By Click_On_Executive_Result_View=By.xpath("//*[@id=\"main-wrapper\"]//a[@class=\"btn btn-info shadow btn-xs sharp\"]");
    By Executive_EmpID=By.xpath("//*[@id=\"main-wrapper\"]//div[@class='col']/table/tr[2]/td[3]");
    By Executive_Mobile_No=By.xpath("//*[@id=\"main-wrapper\"]//div[@class='col']/table/tr[6]/td[3]");
    By Executive_Reporting_Officer=By.xpath("//*[@id=\"main-wrapper\"]//table/tbody/tr/td[1]/div/span[@class='w-space-no']");
    By Click_On_Manager_Result_View=By.xpath("//*[@id=\"main-wrapper\"]//a[@class=\"btn btn-info shadow btn-xs sharp\"]");
    By Manager_Mobile_No=By.xpath("//*[@id=\"main-wrapper\"]//div[@class='col']/table/tr[6]/td[3]");
    By Manager_Reporting_Officer=By.xpath("//*[@id=\"main-wrapper\"]//table/tbody/tr/td[1]/div/span[@class='w-space-no']");
    By Manager_EmpID=By.xpath("//*[@id=\"main-wrapper\"]//div[@class='col']/table/tr[2]/td[3]");
    String Executive_Mobile_UserManagement,Executive_Reporting_UserManagement,Executive_EmpID_UserManagement;

    public void GetEmployeeDetailsFromUserManagementTab()
    {

        //User Management
//        waitforElementToBeVisible(User_Management_Tab);
//        waitforElementToBePresents(User_Management_Tab);
//        waitforElementToBeClickable(User_Management_Tab);
//        click(User_Management_Tab);

        //Executive
        waitforElementToBeVisible(Click_On_Executive);
        waitforElementToBePresents(Click_On_Executive);
        waitforElementToBeClickable(Click_On_Executive);
        jsClick(Click_On_Executive);

        //Search
        waitforElementToBeVisible(Click_On_Executive_SearchBar);
        waitforElementToBePresents(Click_On_Executive_SearchBar);
        waitforElementToBeClickable(Click_On_Executive_SearchBar);
        wait(2);
        WebElement element = driver.get().findElement(Click_On_Executive_SearchBar);
        wait(2);
        element.sendKeys(EmpID);
        wait(10);
//        By click=By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div[1]/button[2]");
//        jsClick(click);
//        wait(10);
//        jsClick(click);

        //result view
        try {
            waitforElementToBeVisible(Click_On_Executive_Result_View);
            waitforElementToBePresents(Click_On_Executive_Result_View);
            waitforElementToBeClickable(Click_On_Executive_Result_View);
             wait(10);
            click(Click_On_Executive_Result_View);
            System.out.println();
        }
        catch (Exception Io)
        {
            test().log(Status.FAIL,"Emp Id not in the list");
        }

        try {
            //EMP id
            waitforElementToBeVisible(Executive_EmpID);
            waitforElementToBePresents(Executive_EmpID);
            waitforElementToBeClickable(Executive_EmpID);
            WebElement Executive_EmpID_UserManagement2 = driver.get().findElement(Executive_EmpID);
            Executive_EmpID_UserManagement = Executive_EmpID_UserManagement2.getText();
            System.out.println(Executive_EmpID_UserManagement);

            //Mobile
            waitforElementToBeVisible(Executive_Mobile_No);
            waitforElementToBePresents(Executive_Mobile_No);
            waitforElementToBeClickable(Executive_Mobile_No);
            WebElement Executive_Mobile_UserManagement2 = driver.get().findElement(Executive_Mobile_No);
            Executive_Mobile_UserManagement = Executive_Mobile_UserManagement2.getText();
            System.out.println(Executive_Mobile_UserManagement);


            //Reporting Officer
            waitforElementToBeVisible(Manager_Reporting_Officer);
            waitforElementToBePresents(Manager_Reporting_Officer);
            waitforElementToBeClickable(Manager_Reporting_Officer);
            WebElement Executive_ReportingOfficer_UserManagement2 = driver.get().findElement(Manager_Reporting_Officer);
            Executive_Reporting_UserManagement = Executive_ReportingOfficer_UserManagement2.getText();
            System.out.println(Executive_Reporting_UserManagement);

        }
        catch (Exception IO)
        {

        }
    }
    public void SelectLoanNoFromXLSVFile()
    {
        String xlsxFilePath = System.getProperty("user.dir")+"/src/TestData/CollectionAllocationForExecutive/Collection Allocations.xlsx";
        try (FileInputStream fileInputStream = new FileInputStream(xlsxFilePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream))
        {
            // Assuming you are working with the first sheet (index 0)
            Sheet sheet = workbook.getSheetAt(0);
            // Assuming you want to read the first row (header row)
            Row firstRow = sheet.getRow(1);
            if (firstRow != null)
            {
                // Assuming you want to read the first cell (field)
                Cell firstCell = firstRow.getCell(0);
                Cell NinthCell = firstRow.getCell(9);
                Cell sixthCell = firstRow.getCell(5);
                Cell Contact_No = firstRow.getCell(39);
                Cell Vehicle_NO = firstRow.getCell(51);
                if (firstCell != null) {
                    rowValue = firstCell.toString();
                    EmpID = sixthCell.toString();
                    CPName = NinthCell.toString();
                    ContactNO = Contact_No.toString();
                    double scientificValue = Double.parseDouble(ContactNO);
                    // Create a DecimalFormat object
                    DecimalFormat decimalFormat = new DecimalFormat("0");
                    // Format the scientific value as a string
                    contactno = decimalFormat.format(scientificValue);
                    VehicleNo=Vehicle_NO.toString();
                    System.out.println("Value of the first field(LoanNo): " + rowValue);
                    System.out.println("Value of the Sixth field(EMPID): " + EmpID);
                    System.out.println("Value of the Sixth field(CPName): " + CPName);
                    System.out.println("Value of the Sixth field(contactno): " + contactno);
                    System.out.println("Value of the Sixth field(VehicleNo): " + VehicleNo);
                    test().log(Status.PASS,"Data is fetched Successfully from Uploaded File in work allocation: - LoanNo:"+rowValue+" Emp ID:"+EmpID+" CPName:"+CPName+" ContactNo:"+ContactNO);
                }
                else
                {
                    test().log(Status.FAIL,"cells is null in uploaded allocation file.");
                }
            }
            else
            {
                test().log(Status.FAIL,"First row is empty cell  allocation file was uploaded.");
            }

        }
        catch (IOException e)
        {
            // e.printStackTrace();
        }
    }

    public void ClickOnSearchBarAndEnterLoanNo()
    {
        /*
        Enter the Loan No from XlSV File Which was Uploaded from in Collection(workAllocation)
         */

        waitforElementToBePresent(allocatedUserSearchBar);
        waitforElementToBeClickable(allocatedUserSearchBar);
        WebElement element = driver.get().findElement(allocatedUserSearchBar);
        element.sendKeys(rowValue);
        wait(5);
        By listOfCPName = By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[1]/div");
        waitforElementToBePresent(listOfCPName);
        //JustFor search we are clicking 2 time cpname
        waitforElementToBeClickable(listOfCPName);
        jsClick(listOfCPName);
        wait(2);
        jsClick(listOfCPName);

    }

    public void ClickOnAllocatedUserSearchListView()
    {
        /*
        Select the loan no from the resulted search in allocated users
         */
        By AllocatedUserSearchResultView = By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/div/div/div/div/div[3]/div/table/tbody/tr[1]/td[9]/div/a");
        waitforElementToBePresent(AllocatedUserSearchResultView);
        waitforElementToBeClickable(AllocatedUserSearchResultView);
        jsClick(AllocatedUserSearchResultView);
    }


    public void FetchLoanNoandSearchInDrilldownSearch()
    {
        /*
        Searching the LoanNo again in Scheduled CustomerList in Allocated User
         */
        // By searchBarInDrilldownAllocatedUser=By.xpath("/html/body/div[4]/div/div/div[2]/div/div[1]/div[1]/div[1]/div/input");
        By SearchBarInListedCustomerAtAllocatedUSer = By.xpath("//*[@class='modal-body']//input[@placeholder='Search By Name/Mobile/Loan No/Vehicle No']");

        //By CPnameInDrilldown=By.xpath("/html/body/div[4]/div/div/div[2]/div/div[1]/div[2]/div/div/div[1]/div");

        By CPNameInListedCustomerAtAllocatedUser = By.xpath("//*[@id=\"customerCpNameFilter\"]//*[text()='All']");
        waitforElementToBePresent(SearchBarInListedCustomerAtAllocatedUSer);
        waitforElementToBeClickable(SearchBarInListedCustomerAtAllocatedUSer);
        WebElement element = driver.get().findElement(SearchBarInListedCustomerAtAllocatedUSer);
        element.sendKeys(rowValue);
        wait(2);
        jsClick(CPNameInListedCustomerAtAllocatedUser);
        wait(2);
        jsClick(CPNameInListedCustomerAtAllocatedUser);

    }
    By SearchedDrillDownLoanNoResults = By.xpath("//div[@class='react-bootstrap-table']/table/tbody/tr/td[5]/div/span");

    public void CompareLoanNO()
    {
        /*
        Compare the Loan No from the resulted search in listed customer at allocated users
         */

            wait(2);
            waitforElementToBeVisible(SearchedDrillDownLoanNoResults);
            waitforElementToBePresent(SearchedDrillDownLoanNoResults);
            waitforElementToBeClickable(SearchedDrillDownLoanNoResults);
            WebElement element = driver.get().findElement(SearchedDrillDownLoanNoResults);
            // Get the text of the element
            String searchedDrillDownLoanNOResults = element.getText();
            System.out.println(searchedDrillDownLoanNOResults);
        try {
            jsClick(SearchedDrillDownLoanNoResults);
            if (searchedDrillDownLoanNOResults.equalsIgnoreCase(rowValue))
            {
                test().log(Status.PASS, "Searched Loan No   " + rowValue + "  is matched with resulted search list in listed Customer Tab " + searchedDrillDownLoanNOResults);
            }
            else
            {
                test().log(Status.FAIL, "Searched Loan No   " + rowValue + "  is not Matched with resulted search list in listed Customer Tab " + searchedDrillDownLoanNOResults);
            }
            wait(10);
        }
        catch (NoSuchElementException e)
        {
            test().log(Status.FAIL, "Searched Loan No    " + rowValue + "   No data found ");
        }

    }


    public void VerifyLoanNo_EmpID_CPName()
    {
        /*
        Comparing the LoanNO ,EmpID and CPname in allocation details with uploaded xlsv file data
         */

        By EmpIDInAllocationView = By.xpath("/html/body/div[4]/div/div/div[2]/div/div[2]/div[1]/div/table/tbody/tr[1]/td[2]");

        /*
        EMP id in allocation details
         */

        waitforElementToBeVisible(EmpIDInAllocationView);
        waitforElementToBePresent(EmpIDInAllocationView);
        waitforElementToBeClickable(EmpIDInAllocationView);
        WebElement empIDInAllocationView1 = driver.get().findElement(EmpIDInAllocationView);
        EmpIDAllocation= empIDInAllocationView1.getText();
        /*
        LoanNo in allocation details
         */
        waitforElementToBeVisible(LoanNoInAllocationView);
        waitforElementToBePresent(LoanNoInAllocationView);
        waitforElementToBeClickable(LoanNoInAllocationView);
        WebElement loanNoInAllocationView = driver.get().findElement(LoanNoInAllocationView);
        loanNoAllocation = loanNoInAllocationView.getText();
        /*
        CPName in allocation details
         */

        waitforElementToBeVisible(CPNameInAllocationView);
        waitforElementToBePresent(CPNameInAllocationView);
        waitforElementToBeClickable(CPNameInAllocationView);
        WebElement cpNameInAllocationView = driver.get().findElement(CPNameInAllocationView);
         CPNameAllocation = cpNameInAllocationView.getText();
        /*
        Lender id in allocation details
         */

        waitforElementToBeVisible(LenderIDInAllocationView);
        waitforElementToBePresent(LenderIDInAllocationView);
        waitforElementToBeClickable(LenderIDInAllocationView);
        WebElement lenderIDInAllocationView = driver.get().findElement(LenderIDInAllocationView);
        lenderIDInAllocationViewText = lenderIDInAllocationView.getText();
        /*
        Lender Name in allocation details
         */

        waitforElementToBeVisible(LenderNameInAllocation);
        waitforElementToBePresent(LenderNameInAllocation);
        waitforElementToBeClickable(LenderNameInAllocation);
        WebElement lenderNameInAllocationView = driver.get().findElement(LenderNameInAllocation);
        lenderNameInAllocationViewText = lenderNameInAllocationView.getText();

        /*
        Customer Name in allocation details
         */

        waitforElementToBeVisible(CustomerNameInAllocationView);
        waitforElementToBePresent(CustomerNameInAllocationView);
        waitforElementToBeClickable(CustomerNameInAllocationView);
        WebElement customerNameInAllocationView = driver.get().findElement(CustomerNameInAllocationView);
         customerNameInAllocationViewText = customerNameInAllocationView.getText();

        /*
        Contact no in allocation details
         */

        waitforElementToBeVisible(ContactNoInAllocationView);
        waitforElementToBePresent(ContactNoInAllocationView);
        waitforElementToBeClickable(ContactNoInAllocationView);
        WebElement contactNoInAllocationView = driver.get().findElement(ContactNoInAllocationView);
        contactNoInAllocationViewText = contactNoInAllocationView.getText();


        /*
        Loan No verification
         */
        if (loanNoAllocation.equalsIgnoreCase(rowValue))
        {
            test().log(Status.PASS, "Searched Loan No in allocation details  " + rowValue + "  is Validated in allocation Details in Listed Customer tab " + loanNoAllocation);
        }
        else
        {
            test().log(Status.FAIL, "Searched Loan No in allocation details  " + rowValue + "  is Validated in allocation Details in Listed Customer tab " + loanNoAllocation);
        }
        /*
        CP Name Verification
         */
        if (CPNameAllocation.equalsIgnoreCase(CPName))
        {
            test().log(Status.PASS, "Searched Loan No in allocation details  " + CPName + "  is Validated in allocation Details in Listed Customer tab " + CPNameAllocation);
        }
        else
        {
            test().log(Status.FAIL, "Searched Loan No in allocation details  " + CPName + "  is Validated in allocation Details in Listed Customer tab " + CPNameAllocation);
        }
        /*
        EMP ID Verification
         */
        if (EmpIDAllocation.equalsIgnoreCase(EmpID)) {
            test().log(Status.PASS, "Searched Loan No in allocation details  " + EmpID + "  is Validated in allocation Details in Listed Customer tab " + EmpIDAllocation);
        } else {
            test().log(Status.FAIL, "Searched Loan No in allocation details  " + EmpID + "  is Validated in allocation Details in Listed Customer tabt " + EmpIDAllocation);
        }
        By CloseButtonOfAllocationDetails = By.xpath("/html/body/div[7]/div/div/div[1]/button");
        jsClick(CloseButtonOfAllocationDetails);
        wait(2);

    }
    String fileName_Customer_Details;
    public void DownloadResultedXLSVFileFromListedCustomerTab()
    {
        By XLSVDownload = By.xpath("//*[@id=\"userAllocationsDownload\"]");
        waitforElementToBeClickable(XLSVDownload);
        wait(1);
        jsClick(XLSVDownload);
        Date currentDate = new Date();
        wait(5);
//        String downloadFolderPath = "src/file_download";  // Replace with the actual folder path
//        String fileName = "Clu_Customer_Details_Report";  // Replace with the actual file name
//        String downloadDirectory = "C:\\Users\\Saikiran Kondala\\Documents\\Automation\\SIa\\selenium\\src\\file_download\\";
        //Date currentDate = new Date();
        // Define the desired format for the timestamp
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd,yyyy, h_mm_ss a");
        // Format the current date and time using the formatter
        String timestamp = formatter.format(currentDate);
        System.out.println("Timestamp: " + timestamp);
        String downloadFolderPath = "src/file_download";  // Replace with the actual folder path
        fileName_Customer_Details =  System.getProperty("user.dir") +"/src/file_download/Clu_Customer_Details_Report_"+timestamp+".xlsx";  // Replace with the actual file name

        // Verify if the file exists
        File downloadedFile = new File(fileName_Customer_Details);
        boolean isFileDownloaded = downloadedFile.exists();
        // Assertion
        if (isFileDownloaded) {

            test().log(Status.PASS, "File has been downloaded successfully.");
        } else {
            test().log(Status.FAIL, "File download verification failed.");

        }
    }

    public void verifyDownloadedXLSV()
    {
        String xlsxFilePath = fileName_Customer_Details;
            try (FileInputStream fileInputStream = new FileInputStream(xlsxFilePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            // Assuming you are working with the first sheet (index 0)
            Sheet sheet = workbook.getSheetAt(0);
            // Assuming you want to read the first row (header row)
            Row firstRow = sheet.getRow(1);
            if (firstRow != null)
            {
                // Assuming you want to read the first cell (field)
                Cell LenderName_Report = firstRow.getCell(5);
                Cell Customer_Name_Report = firstRow.getCell(1);
                Cell MobileNo_Report = firstRow.getCell(2);
                Cell CPName_Report = firstRow.getCell(3);
                Cell LenderID_Report=firstRow.getCell(4);
                Cell LoanNo=firstRow.getCell(6);
                if (LenderName_Report != null&&Customer_Name_Report!=null&&Customer_Name_Report!=null&&MobileNo_Report!=null&&CPName_Report!=null&&LenderID_Report!=null&&LoanNo!=null)
                {
                    Report_LenderName= LenderName_Report.toString();
                    Report_CustomerName = Customer_Name_Report.toString();
                    Report_ContactNo = MobileNo_Report.toString();
                    Report_CPName = CPName_Report.toString();
                    Report_LenderID = LenderID_Report.toString();
                    Reports_LoanNo = LoanNo.toString();
                    System.out.println("Value of the EMPID "+Report_LenderName);
                    System.out.println("Value of the CustomerName " + Report_CustomerName);
                    System.out.println("Value of the Contactno " + Report_ContactNo);
                    //System.out.println("Value of the CPname: " + Report_CPName);
                    System.out.println("Value of the lenderid " + Report_LenderID);
                    System.out.println("Value of the CPname: " + Report_CPName);
                    System.out.println("value of customer loan no "+Reports_LoanNo);

                    if (Reports_LoanNo.equals(loanNoAllocation))
                    {
                        test().log(Status.PASS,"Web allocation LoanNO :"+Reports_LoanNo+" is  matched with the downloaded file LoanNO"+loanNoAllocation);

                    }
                    else
                    {
                        test().log(Status.FAIL,"Web allocation LoanNO :"+Reports_LoanNo+" is not  matched with the downloaded file LoanNO"+loanNoAllocation);


                    }
                    if (Report_CustomerName.equals(customerNameInAllocationViewText))
                    {
                        test().log(Status.PASS,"Web allocation ContactNo :"+Report_CustomerName+" is  matched with the downloaded file Customer Name "+customerNameInAllocationViewText);

                    }
                    else {
                        test().log(Status.FAIL,"Web allocation ContactNo :"+Report_CustomerName+" is  not matched with the downloaded file Customer Name "+customerNameInAllocationViewText);


                    }
                    if(Report_ContactNo.equals(contactNoInAllocationViewText))
                    {
                        test().log(Status.PASS,"Web allocation ContactNo :"+Report_ContactNo+" is  matched with the downloaded file contactNo "+contactNoInAllocationViewText);

                    }
                    else {
                        test().log(Status.FAIL,"Web allocation ContactNo :"+Report_ContactNo+" is not matched with the downloaded file contactNo "+contactNoInAllocationViewText);

                    }
                    if(Report_CPName.equals(CPNameAllocation))
                    {
                        test().log(Status.PASS,"Web allocation CPName :"+Report_CPName+" is  matched with the downloaded file CP Name "+CPNameAllocation);

                    }
                    else {
                        test().log(Status.FAIL,"Web allocation CPName :"+Report_CPName+" is not matched with the downloaded file CP Name "+CPNameAllocation);
                    }
                    if(Report_LenderID.equals(lenderIDInAllocationViewText))
                    {
                        test().log(Status.PASS,"Web allocation LenderName :"+Report_LenderID+" is  matched with the downloaded file Lender ID "+lenderIDInAllocationViewText);

                    }
                    else {
                        test().log(Status.FAIL,"Web allocation LenderName :"+Report_LenderID+" is not matched with the downloaded file Lender ID "+lenderIDInAllocationViewText);

                    }
                    if(Report_LenderName.equals(lenderNameInAllocationViewText))
                    {
                        test().log(Status.PASS,"Web allocation  LenderName :"+Report_LenderName+" is matched with the downloaded file Lender Name "+lenderNameInAllocationViewText);

                    }
                    else {
                        test().log(Status.FAIL,"Web allocation LenderName :"+Report_LenderName+" is not matched with the downloaded file Lender Name "+lenderNameInAllocationViewText);

                    }


                }
                else
                {
                    test().log(Status.FAIL,"Cell is null in downloaded XLSV file in work allocations. "+LoanNo);
                }
            }
            else
            {
                test().log(Status.FAIL,"First row is null in downloaded XLSV file in work allocations.");
            }

        } catch (IOException e) {
            // e.printStackTrace();
        }

    }

    public void FetchEMPIDandSearchInDrilldownSearch() {
        /*
        Searching the LoanNo again in Scheduled CustomerList in Allocated User
         */
        // By searchBarInDrilldownAllocatedUser=By.xpath("/html/body/div[4]/div/div/div[2]/div/div[1]/div[1]/div[1]/div/input");
        By SearchBarInListedCustomerAtAllocatedUSer = By.xpath("//*[@class='modal-body']//input[@placeholder='Search By Name/Mobile/Loan No/Vehicle No']");

        //By CPnameInDrilldown=By.xpath("/html/body/div[4]/div/div/div[2]/div/div[1]/div[2]/div/div/div[1]/div");

        By CPNameInListedCustomerAtAllocatedUser = By.xpath("//*[@id=\"customerCpNameFilter\"]//*[text()='All']");
        waitforElementToBePresent(SearchBarInListedCustomerAtAllocatedUSer);
        waitforElementToBeClickable(SearchBarInListedCustomerAtAllocatedUSer);
        WebElement element = driver.get().findElement(SearchBarInListedCustomerAtAllocatedUSer);
        element.sendKeys(EmpID);
        wait(2);
        jsClick(CPNameInListedCustomerAtAllocatedUser);
        wait(2);
        jsClick(CPNameInListedCustomerAtAllocatedUser);

    }

    public void CompareEMPIDInAllocatedUserSearchResult()
    {
        By ResultedSearchInAllocateduser=By.xpath("//table[@class='table table-bordered']/tbody/tr/td[3]");
        waitforElementToBeClickable(ResultedSearchInAllocateduser);

        WebElement lenderIDInAllocationView = driver.get().findElement(ResultedSearchInAllocateduser);
        String resultedSearchInAllocateduser = lenderIDInAllocationView.getText();
      try{
          if(EmpID.equals(resultedSearchInAllocateduser))
        {
            test().log(Status.PASS,"EMP ID:-"+EmpID+" search is matched with Resulted search list in allocated users"+resultedSearchInAllocateduser);

        }
        else
        {
            test().log(Status.FAIL,"EMP ID ID:-"+EmpID+" search is  not matched with Resulted search list in allocated users"+resultedSearchInAllocateduser);

        }
      }
      catch (NoSuchElementException e)
      {
          test().log(Status.FAIL,"No Search result found with emp id "+resultedSearchInAllocateduser);

      }


    }

    public void ClickOnSearchBarAndEnterContactNo()
    {
        /*
        Enter the Loan No from XlSV File Which was Uploaded from in Collection(workAllocation)
         */
            waitforElementToBePresent(allocatedUserSearchBar);
            waitforElementToBeClickable(allocatedUserSearchBar);
//          WebElement textBox = driver.get().findElement(allocatedUserSearchBar); // Replace "textboxId" with the actual ID of your text box
//
            WebElement element = driver.get().findElement(allocatedUserSearchBar);
            element.clear();
            element.sendKeys(Executive_Mobile_UserManagement);
            wait(5);
            By listOfCPName = By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[1]/div");
            waitforElementToBePresent(listOfCPName);
            //JustFor search we are clicking 2 time cpname
            waitforElementToBeClickable(listOfCPName);
            jsClick(listOfCPName);
            wait(2);
            jsClick(listOfCPName);


    }

    public void VerifyEMPIDResultInAllocatedUser()
    {
        By EyeViewInAllocatedUsers=By.xpath("//*[@id=\"main-wrapper\"]//a[@class='btn btn-info shadow btn-xs sharp']");
        waitforElementToBePresent(EyeViewInAllocatedUsers);
        waitforElementToBeClickable(EyeViewInAllocatedUsers);
        jsClick(EyeViewInAllocatedUsers);
    }

    public void CompareContactNoAllocatedUserSearchResult()
    {

        waitforElementToBePresent(SearchedDrillDownLoanNoResults);
        waitforElementToBeClickable(SearchedDrillDownLoanNoResults);
        jsClick(SearchedDrillDownLoanNoResults);

        waitforElementToBeVisible(ContactNoInAllocationView);
        waitforElementToBePresent(ContactNoInAllocationView);
        waitforElementToBeClickable(ContactNoInAllocationView);
        WebElement contactNoInAllocationView = driver.get().findElement(ContactNoInAllocationView);
        contactNoInAllocationViewText = contactNoInAllocationView.getText();
        try{
            if(Executive_Mobile_UserManagement.equals(contactNoInAllocationViewText))
            {
                test().log(Status.PASS,"ContactNO:-"+Executive_Mobile_UserManagement+" search is matched with Resulted search list in allocated users"+contactNoInAllocationViewText);

            }
            else
            {
                test().log(Status.FAIL,"Contact NO:-"+Executive_Mobile_UserManagement+" search is  not matched with Resulted search list in allocated users"+contactNoInAllocationViewText);

            }
        }
        catch (NoSuchElementException e)
        {
            test().log(Status.FAIL,"No Search result found with Contact No "+contactNoInAllocationViewText);

        }
    }

    public void ClickOnSearchBarAndEnterEMPID()
    {
        waitforElementToBePresent(allocatedUserSearchBar);
        waitforElementToBeClickable(allocatedUserSearchBar);
        WebElement element = driver.get().findElement(allocatedUserSearchBar);
        element.sendKeys(EmpID);
        wait(5);
        By listOfCPName = By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[1]/div");
        waitforElementToBePresent(listOfCPName);
        //JustFor search we are clicking 2 time cpname
        waitforElementToBeClickable(listOfCPName);
        jsClick(listOfCPName);
        wait(2);
        jsClick(listOfCPName);
    }

    public void ClickOnSearchBarAndEnterContactNoInListedCustomerTab()
    {
        By SearchBarInListedCustomerAtAllocatedUSer = By.xpath("//*[@class='modal-body']//input[@placeholder='Search By Name/Mobile/Loan No/Vehicle No']");

        //By CPnameInDrilldown=By.xpath("/html/body/div[4]/div/div/div[2]/div/div[1]/div[2]/div/div/div[1]/div");

        By CPNameInListedCustomerAtAllocatedUser = By.xpath("//*[@id=\"customerCpNameFilter\"]//*[text()='All']");
        waitforElementToBePresent(SearchBarInListedCustomerAtAllocatedUSer);
        waitforElementToBeClickable(SearchBarInListedCustomerAtAllocatedUSer);
        WebElement element = driver.get().findElement(SearchBarInListedCustomerAtAllocatedUSer);
        element.sendKeys(Executive_Mobile_UserManagement);
        wait(2);
        jsClick(CPNameInListedCustomerAtAllocatedUser);
        wait(2);
        jsClick(CPNameInListedCustomerAtAllocatedUser);

    }
}



