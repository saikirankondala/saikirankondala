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

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllocationSummary  extends Utils {
    ArrayList<String> stringList = new ArrayList<>();
    ArrayList<String> stringList2 = new ArrayList<>();
    String EmpIDofXLSX,rowValue,CPName,EmpID,ContactNO,contactno;
    String VehicleNo;

    public void SelectEmpIDXLSVFile()
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


    public void StoreWorkallocationsummaryreports()
    {
        wait(5);
        int i = 1, rowSize = 1;
        WebElement e1;
        while (i <= rowSize)
        {
            wait(1);
            String totalrowsintable = "//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr/td[1]";
            List<WebElement> rows = getElementsList(By.xpath(totalrowsintable));
            rowSize = rows.size();

            String EmpID = "//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr[" + i + "]/td[2]";
            By ID_Summary = By.xpath(EmpID);
            waitforElementToBeVisible(ID_Summary);
            waitforElementToBePresents(ID_Summary);
            waitforElementToBeClickable(ID_Summary);
            e1 = getElement(ID_Summary);
            wait(1);
            String EmpID_Summary = e1.getText();

            wait(1);

            if (EmpID_Summary.equalsIgnoreCase(EmpIDofXLSX))
            {
                /*
               Storing Employee Name from Summary report
                 */
                String EmpName = ("//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr[" + i + "]/td[1]");
                By Name_summary = By.xpath(EmpName);
                waitforElementToBePresent(Name_summary);
                e1 = getElement(Name_summary);
                String EmpName_Summary = e1.getText();
                wait(1);

                /*
                Storing  TotalAllocated Count from Summary reports
                 */
                String TotalAllocated = "//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr[" + i + "]/td[3]";
                By Total_Summary = By.xpath(TotalAllocated);
                waitforElementToBePresents(Total_Summary);
                e1 = getElement(Total_Summary);
                wait(1);
                String TotalAllocated_Summary = e1.getText();
                wait(1);

                /*
                Storing Open counts from Summary Reports
                 */

                String Open = "//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr[" + i + "]/td[4]";
                By Open_sum = By.xpath(Open);
                waitforElementToBePresents(Open_sum);
                e1 = getElement(Open_sum);
                wait(1);
                String Open_Summary = e1.getText();
                wait(1);

                /*
                Storing Inprogress counts from Summary Reports
                 */
                String Inprogress_ = "//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr[" + i + "]/td[5]";
                By Drill_Sales_count = By.xpath(Inprogress_);
                waitforElementToBePresents(Drill_Sales_count);
                e1 = getElement(Drill_Sales_count);
                wait(1);
                String Inprogress_Summary = e1.getText();
                wait(1);

                /*
                Storing Completed counts from Summary Reports
                 */

                String Completed = "//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr[" + i + "]/td[6]";
                By completed_summary = By.xpath(Completed);
                waitforElementToBePresents(completed_summary);
                e1 = getElement(completed_summary);
                wait(1);
                String Completed_Summary = e1.getText();
                wait(1);

                /*
                Storing Resolution_percantage counts from Summary Reports
                 */
                String Resolution_Percantage = "//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr[" + i + "]/td[7]";
                By resolution_per = By.xpath(Resolution_Percantage);
                waitforElementToBePresents(resolution_per);
                e1 = getElement(resolution_per);
                wait(1);
                String Resolution_Percantage_Summary = e1.getText();
                wait(1);

                /*
                Storing UniqueVisits counts from Summary Reports
                 */

                String Unique_visits = "//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr[" + i + "]/td[8]";
                By Unique_visits__Summary = By.xpath(Unique_visits);
                waitforElementToBePresents(Unique_visits__Summary);
                e1 = getElement(Unique_visits__Summary);
                waitforElementToBePresents(Unique_visits__Summary);
                String Unique_visits_Summary = e1.getText();
                wait(1);

                stringList = new ArrayList<String>();
                String[] values = {EmpName_Summary, EmpID_Summary, TotalAllocated_Summary, Open_Summary, Inprogress_Summary, Completed_Summary, Resolution_Percantage_Summary, Unique_visits_Summary};
//               String[] values = {EmpName_Summary, EmpID_Summary, TotalAllocated_Summary};
                stringList.add(Arrays.toString(values));
                wait(1);
            }
            if (i == 10)
            {
                try
                {
                    By Next = By.xpath("//*[@id=\"main-wrapper\"]//li[@class='page-item']//*[text()='Next']");
                    waitforElementToBePresent(Next);
                    waitforElementToBeClickable(Next);
                    jsClick(Next);
                    i = 1;
                }
                catch (NoSuchElementException e)
                {
//                    System.exit(1);
                    break;

                }
            }
            else
            {
                i++;
            }
        }
        for (String element2 : stringList)
        {
            System.out.println(element2);
        }
    }

    public void StoreWorkallocationsummaryreports2() {
        wait(5);
        int i = 1, rowSize = 1;
        WebElement e1;
        while (i <= rowSize)
        {
            wait(1);
            String totalrowsintable = "//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr/td[1]";
            List<WebElement> rows = getElementsList(By.xpath(totalrowsintable));
            rowSize = rows.size();

            String EmpID = "//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr[" + i + "]/td[2]";
            By ID_Summary = By.xpath(EmpID);
            waitforElementToBeVisible(ID_Summary);
            waitforElementToBePresents(ID_Summary);
            waitforElementToBeClickable(ID_Summary);
            e1 = getElement(ID_Summary);
            wait(1);
            String EmpID_Summary2 = e1.getText();
            if (EmpID_Summary2.equalsIgnoreCase(EmpIDofXLSX))
            {
                String EmpName = ("//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr[" + i + "]/td[1]");
                By Name_summary = By.xpath(EmpName);
                waitforElementToBePresent(Name_summary);
                e1 = getElement(Name_summary);
                String EmpName_Summary = e1.getText();
                wait(1);

                String TotalAllocated = "//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr[" + i + "]/td[3]";
                By Total_Summary = By.xpath(TotalAllocated);
                waitforElementToBePresents(Total_Summary);
                e1 = getElement(Total_Summary);
                wait(1);
                String TotalAllocated_Summary = e1.getText();
                wait(1);

                String Open = "//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr[" + i + "]/td[4]";
                By Open_sum = By.xpath(Open);
                waitforElementToBePresents(Open_sum);
                e1 = getElement(Open_sum);
                wait(1);
                String Open_Summary = e1.getText();
                wait(1);

                String Inprogress_ = "//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr[" + i + "]/td[5]";
                By Drill_Sales_count = By.xpath(Inprogress_);
                waitforElementToBePresents(Drill_Sales_count);
                e1 = getElement(Drill_Sales_count);
                wait(1);
                String Inprogress_Summary = e1.getText();
                wait(1);

                String Completed = "//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr[" + i + "]/td[6]";
                By completed_summary = By.xpath(Completed);
                waitforElementToBePresents(completed_summary);
                e1 = getElement(completed_summary);
                wait(1);
                String Completed_Summary = e1.getText();
                wait(1);

                String Resolution_Percantage = "//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr[" + i + "]/td[7]";
                By resolution_per = By.xpath(Resolution_Percantage);
                waitforElementToBePresents(resolution_per);
                e1 = getElement(resolution_per);
                wait(1);
                String Resolution_Percantage_Summary = e1.getText();
                wait(1);

                String Unique_visits = "//*[@id=\"main-wrapper\"]/div[4]//table[@class='table table-bordered']/tbody/tr[" + i + "]/td[8]";
                By Unique_visits__Summary = By.xpath(Unique_visits);
                waitforElementToBePresents(Unique_visits__Summary);
                e1 = getElement(Unique_visits__Summary);
                waitforElementToBePresents(Unique_visits__Summary);
                String Unique_visits_Summary = e1.getText();
                wait(1);
                stringList2 = new ArrayList<String>();
                String[] values = {EmpName_Summary, EmpID_Summary2, TotalAllocated_Summary, Open_Summary, Inprogress_Summary, Completed_Summary, Resolution_Percantage_Summary, Unique_visits_Summary};
//            String[] values = {EmpName_Summary, EmpID_Summary, TotalAllocated_Summary};
                stringList2.add(Arrays.toString(values));
                wait(1);
            }


            if (i == 10) {
                try {
                    By Next = By.xpath("//*[@id=\"main-wrapper\"]//li[@class='page-item']//*[text()='Next']");
                    waitforElementToBePresent(Next);
                    waitforElementToBeClickable(Next);
                    jsClick(Next);
                    i = 1;
                } catch (NoSuchElementException e) {
                    break;

                }

            } else {
                i++;
            }


        }
        for (String element : stringList2) {
            System.out.println(element);
        }
    }
    public void compareList()
    {
        // Assuming stringList and stringList2 are already defined
//        List<String> stringList = new ArrayList<>();
//        List<String> stringList2 = new ArrayList<>();

        // Populate stringList and stringList2 with your data

        // Get the first element from stringList
        String elementToCompare = stringList2.get(0);

        // Split the element into an array using the appropriate delimiter (if any)
        String[] elementArray = elementToCompare.split(", "); // Assuming elements are separated by a comma and space

        // Now, you can iterate through the elements in stringList2 and compare them
        for (String element : stringList) {
            // Split the element in stringList2 in the same way
            String[] element2Array = element.split(", ");

            // Compare the elements in the arrays
            if (Arrays.equals(elementArray, element2Array))
            {
                test().log(Status.FAIL,"The elements are equal.");
            }
            else
            {
                test().log(Status.PASS,"The elements are not equal.");
            }
        }
    }
}
