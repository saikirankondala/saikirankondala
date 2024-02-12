package pages;

import com.aventstack.extentreports.Status;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Utils;

import java.io.FileInputStream;
import java.io.IOException;

import static util.Base.driver;

public class AllocatedUserSearchBasedOnVehicleNo extends Utils
{
    String lenderIDInAllocationViewText;
    String EmpIDAllocation;
    String loanNoAllocation;
    String CPNameAllocation ;
    String lenderNameInAllocationViewText;
    String customerNameInAllocationViewText;
    String contactNoInAllocationViewText;
    By SearchedDrillDownLoanNoResults = By.xpath("//div[@class='react-bootstrap-table']/table/tbody/tr/td[5]/div/span");
    By AllocationProductDetails=By.xpath("//ul[@class='nav-tabs-custom nav-justified nav']//b[text()=' Product Details ']");

    By allocatedUserSearchBar = By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/input");
    String rowValue, EmpID, CPName, ContactNO,VehicleNo;
    String Report_LenderName,Report_CPName,Report_ContactNo,Report_LenderID,Reports_LoanNo,Report_CustomerName;
    By LoanNoInAllocationView = By.xpath("//*[@role='dialog']//*[@class='card contact-bx item-content']//tr[2]//td[3]");

    By CPNameInAllocationView = By.xpath("//*[@role='dialog']//*[@class='card contact-bx item-content']//tr[7]//td[3]");
    By CustomerNameInAllocationView=By.xpath("//*[@role='dialog']//*[@class='card contact-bx item-content']//tr[3]//td[3]");
    By VehicleNoInAllocationView=By.xpath("//div[@class='card contact-bx item-content']/div/tr[1]/td[3]");
    By LenderIDInAllocationView=By.xpath("//*[@role='dialog']//*[@class='card contact-bx item-content']//tr[8]//td[3]");
    By LenderNameInAllocation=By.xpath("//*[@role='dialog']//*[@class='card contact-bx item-content']//tr[9]//td[3]");

    public void SelectVehicleNoFromXLSVFile() {
        String xlsxFilePath = "C:\\Users\\Saikiran Kondala\\Documents\\Automation\\SIa\\selenium\\src\\TestData\\CollectionAllocationForExecutive\\Collection Allocations.xlsx";
        try (FileInputStream fileInputStream = new FileInputStream(xlsxFilePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            // Assuming you are working with the first sheet (index 0)
            Sheet sheet = workbook.getSheetAt(0);
            // Assuming you want to read the first row (header row)
            Row firstRow = sheet.getRow(1);
            if (firstRow != null) {
                // Assuming you want to read the first cell (field)

                Cell Vehicle_NO = firstRow.getCell(51);
                if (Vehicle_NO != null) {
                    VehicleNo=Vehicle_NO.toString();
                    test().log(Status.PASS,"Value of the Sixth field(VehicleNo): " + VehicleNo);
                                   }
                else
                {
                    test().log(Status.FAIL,"cells is null in uploaded allocation file.");
                }
            }
            else
            {
                test().log(Status.FAIL,"First row is null cells is null in uploaded allocation fil.");
            }

        } catch (IOException e) {
            // e.printStackTrace();
        }

    }
    public void ClickOnSearchBarAndEnterVehicleNo()
    {
        waitforElementToBePresent(allocatedUserSearchBar);
        waitforElementToBeClickable(allocatedUserSearchBar);
        WebElement element = driver.get().findElement(allocatedUserSearchBar);
        element.sendKeys(VehicleNo);
        wait(5);
        By listOfCPName = By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[1]/div");
        waitforElementToBePresent(listOfCPName);
        //JustFor search we are clicking 2 time cpname
        waitforElementToBeClickable(listOfCPName);
        jsClick(listOfCPName);
        wait(2);
        jsClick(listOfCPName);

    }

    public void ClickOnAllocatedUserSearchListView() {
        /*
        Select the loan no from the resulted search in allocated users
         */
        By AllocatedUserSearchResultView = By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div/div[2]/div/div/div/div/div/div[3]/div/table/tbody/tr[1]/td[9]/div/a");
        waitforElementToBePresent(AllocatedUserSearchResultView);
        waitforElementToBeClickable(AllocatedUserSearchResultView);
        jsClick(AllocatedUserSearchResultView);
    }



    public void FetchVehicleNoandSearchInDrilldownSearch() {

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
            element.sendKeys(VehicleNo);
            wait(2);
            jsClick(CPNameInListedCustomerAtAllocatedUser);
            wait(2);
            jsClick(CPNameInListedCustomerAtAllocatedUser);


    }

    public void SelectResultList()
    {
        waitforElementToBeClickable(SearchedDrillDownLoanNoResults);
        jsClick(SearchedDrillDownLoanNoResults);
        wait(2);
    }

    public void VerifyVehicleNoInAllocationDetails()
    {
        waitforElementToBeClickable(AllocationProductDetails);
        jsClick(AllocationProductDetails);

        waitforElementToBeVisible(VehicleNoInAllocationView);
        waitforElementToBePresent(VehicleNoInAllocationView);
        waitforElementToBeClickable(VehicleNoInAllocationView);
        WebElement vehicleNoInAllocationView = driver.get().findElement(VehicleNoInAllocationView);
        String VehicleNoInAllocationViewProductDetails = vehicleNoInAllocationView.getText();


        /*
        Loan No verification
         */
        if (VehicleNoInAllocationViewProductDetails.equalsIgnoreCase(VehicleNo)) {
            test().log(Status.PASS, "Searched Loan No in allocation details  " + VehicleNo + "  is Validated in allocation Details in Listed Customer tab " + VehicleNoInAllocationViewProductDetails);
        } else {
            test().log(Status.FAIL, "Searched Loan No in allocation details  " + VehicleNo + "  is Validated in allocation Details in Listed Customer tab " + VehicleNoInAllocationViewProductDetails);
        }
    }
}
