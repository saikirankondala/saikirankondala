package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import util.Utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Home_DashboardCounts extends Utils {

    By PTPCountOfDashboard=By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div[4]/div/div/div/div/div/h3");
    By TodayPTPCounts=By.xpath("//*[@id=\"ptpDateSelection\"]//*[text()='Today']");

    By TommorrowPTPCounts=By.xpath("//*[@id=\"ptpDateSelection\"]//*[text()='Tomorrow']");

    By Next7DaysPTPCounts=By.xpath("//*[@id=\"ptpDateSelection\"]//*[text()='Next 7 Days']");

    By Sales_Count = By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div[2]/div[1]/div/div/div/div/h3");
    By Collections_Count = By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div[2]/div[2]/div/div/div/div/h3");
    By Close_button = By.xpath("//*[@class='btn-close btn']");
     By Collection_next_page = By.xpath("//button[@class='page-link'][text()='Next']");
   // By Collection_next_page=By.xpath("/html/body/div[3]/div/div/div[2]/div/div/div[3]/nav/ul/li[4]");
    By Today_DropDown = By.xpath("//*[@id='dateSelection']//*[text()='Today']");
    By Last_7_Days_DropDown = By.xpath("//*[@id='dateSelection']//*[text()='Last 7 Days']");
    By Last_1Month_DropDown = By.xpath("//*[@id='dateSelection']//*[text()='Last 30 Days']");
    By Custom_Dropdown = By.xpath("//*[@id='dateSelection']//*[text()='Custom']");
    By Custom_Date = By.xpath("//*[@id='customDatePicker']");
    By Start_End_Date = By.xpath("//*[@id='customDatePicker']");
    By FieldInvestigation = By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div[2]/div[3]/div/div/div/div/h3");
    By Collection_menu = By.xpath("/html/body/div/div[1]/div[4]/div/div/div[3]/div/div[2]/div/div/div/div/div[3]/div[1]");
    By Collection_7Days_Trends = By.xpath("//*[@id=\"collectionsDateRange\"]//*[text()='Last 7 Days']");
    By Collections_Current_Month_Trends = By.xpath("//*[@id=\"collectionsDateRange\"]//*[text()='Current Month']");
    By Collectionss_Last_Month_Trends = By.xpath("//*[@id=\"collectionsDateRange\"]//*[text()='Last Month']");
    By Collections_Last_6Months_Trends = By.xpath("//*[@id=\"collectionsDateRange\"]//*[text()='Last 6 Months']");
    By COllections_Custom_Months = By.xpath("//*[@id=\"collectionsDateRange\"]//*[text()='Custom Month']");
By BackButton=By.xpath("//*[@class='modal-title h4']//button[@type='button']");
    static final String FAIL_CSS_START = "<font color='red'>";
    static final String FAIL_CSS_END = "</font>";
//    WebDriver driver = new ChromeDriver();
//
    public void salesDashboard()
    {
        waitforPageToFinishLoading();
        waitforElementToBePresent(Sales_Count);
        wait(2);
        WebElement e = getElement(Sales_Count);
        int count = Integer.parseInt(e.getText());
        int V1 = 0, V2 = 0;
        jsClick(Sales_Count);
        int count1=0,count2 = 0;
        WebElement e1, e_1, e_2 = null;
        if (count > 0)
        {
            int i = 1, tablesize = 1; int j=2;
            ;
            while (i <= tablesize)
            {
                List<WebElement> rows = getElementsList(By.xpath("//*[@id='subordinatemanagervisitcount']/tbody/tr"));
                tablesize = rows.size();
                wait(2);
                String dynamicXPath = "//*[@id=\"subordinatemanagervisitcount\"]/tbody/tr[" + i + "]/td[4]";
                By Drill_Sales_count = By.xpath(dynamicXPath);
                e1 = getElement(Drill_Sales_count);
                count1 = count1 + Integer.parseInt(e1.getText());
                if (i == 10)
                {
                    waitforElementToBeVisible(Collection_next_page);
                    try
                    {
                        String NextPage="//*[@id='pagebutton"+j+"']//button[@class='page-link']";
                        j++;
                        By ClickOnNext=By.xpath(NextPage);
                        jsClick((ClickOnNext));
                        wait(1);
                        //jsClick(Collection_next_page);
                        List<WebElement> rows1 = getElementsList(By.xpath("//*[@id='subordinatemanagervisitcount']/tbody/tr"));
                        tablesize = rows1.size();
                        i=1;

                    }
                    catch (NoSuchElementException ey)
                    {
                        break;
                    }
                }
                else
                {
                    i++;
                }
            }
            if (count == count1)
            {
                System.out.println("Dashboard count of Sales visit:- " + count + " is matched with drill count:- " + count1);
                test().log(Status.PASS, "=====>Dashboard count Sales visit " + count + " is matched with drill count " + count1);
            }
            else
            {
                System.out.println("Dashboard count Sales visit:- " + count + " is not matched with drill count :-" + count1);
                test().log(Status.FAIL, "=====>Dashboard count Sales visit " + count + " is not matched with drill count " + count1);
                //throw new ConditionNotSatisfiedException("Value should be not matched");
            }
        }

        else
        {
                System.out.println("No data available in Sales visit :- " + count);
                test().log(Status.PASS, "=====>No data available in Sales visit " + count);
        }
        try
        {
               jsClick(Close_button);
        }
        catch (NoSuchElementException m)
        {
                // Handle NoSuchElementException for the fourth element (optional)
        }
    }




    public void collectionsDashboard()
    {
        waitforElementToBePresent(Collections_Count);
        WebElement e = getElement(Collections_Count);
        int count = Integer.parseInt(e.getText());
        int count1=0,count2 = 0;
        WebElement e1, e_1, e_2 = null;
        if (count > 0)
        {
            int i = 1, tablesize = 1;
            while (i <= tablesize)
            {

                jsClick(Collections_Count);
                List<WebElement> rows = getElementsList(By.xpath("//*[@id='subordinatemanagercollectioncount']/tbody/tr"));
                tablesize = rows.size();
                String dynamicXPath = "//*[@id='subordinatemanagercollectioncount']/tbody/tr[" + i + "]/td[4]";
                By Drill_Sales_count = By.xpath(dynamicXPath);
                waitforElementToBePresent(Drill_Sales_count);
                e1 = getElement(Drill_Sales_count);
                count1 = count1 + Integer.parseInt(e1.getText());
                if (i == 10)
                {
                    waitforElementToBeClickable(Collection_next_page);
                    e_1=getElement(Collection_next_page);
                   boolean value= isClickableElement(e_1);

                        try
                        {
                        click(Collection_next_page);
                        wait(1);
                        List<WebElement> rows1 = getElementsList(By.xpath("//*[@id='subordinatemanagercollectioncount']/tbody/tr"));
                        tablesize = rows1.size();
                        i=1;
                        }
                       catch (Exception ee)
                        {
                            break;
                        }
                }
                else
                {
                    i++;
                }
            }
            if (count == count1)
            {
                System.out.println("Dashboard count of collections visit:- " + count + " is matched with drill count:- " + count1);
                test().log(Status.PASS, "=====>Dashboard count collections visit " + count + " is matched with drill count " + count1);
            }
            else
            {
                System.out.println("Dashboard count collections visit:- " + count + " is not matched with drill count :-" + count1);
                test().log(Status.FAIL, "=====>Dashboard count collections visit " + count + " is not matched with drill count " + count1);

            }
        }
        else
        {
            System.out.println("No data available in Collections visit :- " + count);
            test().log(Status.PASS, "=====>No data available in Collections visit " + count);
        }
        try
        {
            jsClick(Close_button);
        }
        catch (NoSuchElementException m)
        {
            // Handle NoSuchElementException for the fourth element (optional)
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }



    public void FieldInvestigationDashboard()
    {
        wait(5);
        waitforPageToFinishLoading();
        waitforElementToBePresent(FieldInvestigation);
        WebElement e = getElement(FieldInvestigation);
        int count = Integer.parseInt(e.getText());
        int count1=0,count2 = 0;
        WebElement e1, e_1, e_2 = null;
        if (count > 0)
        {
            int i = 1, tablesize = 1;
            while (i <= tablesize)
            {
                jsClick(FieldInvestigation);
                List<WebElement> rows = getElementsList(By.xpath("//*[@id='subordinatemanagervisitcount']/tbody/tr"));
                tablesize = rows.size();
                wait(2);
                String dynamicXPath = "//*[@id=\"subordinatemanagervisitcount\"]/tbody/tr[" + i + "]/td[4]";
                By Drill_Sales_count = By.xpath(dynamicXPath);
                e1 = getElement(Drill_Sales_count);
                count1 = count1 + Integer.parseInt(e1.getText());
                if (i == 10)
                {
                    waitforElementToBeClickable(Collection_next_page);
                    try
                    {
                        jsClick(Collection_next_page);
                        wait(1);
                        //jsClick(Collection_next_page);
                        List<WebElement> rows1 = getElementsList(By.xpath("//*[@id='subordinatemanagervisitcount']/tbody/tr"));
                        tablesize = rows1.size();
                        i=1;
                    }
                    catch (NoSuchElementException ey)
                    {
                        break;
                    }
                }
                else
                {
                    i++;
                }
            }
            if (count == count1)
            {
                System.out.println("Dashboard count of FI visit:- " + count + " is matched with drill count:- " + count1);
                test().log(Status.PASS, "=====>Dashboard count FI visit " + count + " is matched with drill count " + count1);
            }
            else
            {
                System.out.println("Dashboard count FI visit:- " + count + " is not matched with drill count :-" + count1);
                test().log(Status.FAIL, "=====>Dashboard count FI visit " + count + " is not matched with drill count " + count1);

            }
        }
        else
        {
            System.out.println("No data available in FI visit :- " + count);
            test().log(Status.PASS, "=====>No data available in FI visit " + count);
        }
        try
        {
            jsClick(Close_button);
        }
        catch (NoSuchElementException m)
        {
            // Handle NoSuchElementException for the fourth element (optional)
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }
    public void Last7DaysDashboard()
    {
        wait(5);
        waitforPageToFinishLoading();
        waitforElementToBeClickable(Today_DropDown);
        click(Today_DropDown);
        waitforElementToBeClickable(Last_7_Days_DropDown);
        jsClick(Last_7_Days_DropDown);
    }

    public void Last30DaysDashboard()
    {
        wait(5);
        waitforPageToFinishLoading();
        waitforElementToBeClickable(Last_7_Days_DropDown);
        click(Last_7_Days_DropDown);
        waitforElementToBeClickable(Last_1Month_DropDown);
        click(Last_1Month_DropDown);
    }

    public void CustomFilterInCollectionCountDashboard()
    {
        wait(5);
        waitforPageToFinishLoading();
        waitforElementToBeClickable(Last_1Month_DropDown);
        click(Last_1Month_DropDown);
        wait(5);
        waitforElementToBeClickable(Custom_Dropdown);
        click(Custom_Dropdown);
        jsClick(Start_End_Date);
    }

    public void CustomDatePicker()
    {
        LocalDate currentDateof6month = LocalDate.now();
        List<String> lastSixMonthsNames = new ArrayList<>();
        String Month_6 = null;
        for (int i = 0; i < 6; i++)
        {
            Month month = currentDateof6month.minusMonths(i).getMonth();
            String monthName = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
            lastSixMonthsNames.add(monthName);
        }
        for (int i = 1; i < lastSixMonthsNames.size(); i++)
        {
            String name = lastSixMonthsNames.get(1);
            Month_6 = name;
        }
        String last_month = Month_6;
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        DateTimeFormatter months = DateTimeFormatter.ofPattern("MM");
        String formattedDate = currentDate.format(formatter);
        String currentMonth = currentDate.format(months);
        int currentday = Integer.parseInt(formattedDate);
        List<WebElement> rows1 = getElementsList(By.xpath("//*[@class='flatpickr-monthDropdown-month']"));
        int size1 = rows1.size();
        WebElement e1;
        for (int j = 1; j <= size1; j++)
        {
            String dynamicXPathofdate = "//*[@class='flatpickr-monthDropdown-month'][" + j + "]";
            By Drill_Collection_count1 = By.xpath(dynamicXPathofdate);
            String month = getText(Drill_Collection_count1);
            String Current_month = "//*[@class='flatpickr-monthDropdown-month'][" + currentMonth + "]";
            By current_monthNo = By.xpath(Current_month);
            if (month.equalsIgnoreCase(last_month))
            {
                By date_Click = By.xpath("//*[@class=\"flatpickr-monthDropdown-months\"]");
                click(date_Click);
                waitforElementToBeClickable(Drill_Collection_count1);
                click(Drill_Collection_count1);
                String day = "//*[@class=\"flatpickr-day\"][" + currentday + "]";
                By todayday = By.xpath(day);
                waitforElementToBePresent(todayday);
                waitforElementToBeClickable(todayday);
                jsClick(todayday);
                wait(3);
                By date_Click1 = By.xpath("//*[@class=\"flatpickr-monthDropdown-months\"]");
                click(date_Click1);
                waitforElementToBeClickable(current_monthNo);
                click(current_monthNo);
                wait(2);
                click(current_monthNo);
                String day1 = "//*[@class=\"flatpickr-day today\"]";
                By todayday1 = By.xpath(day1);
                waitforElementToBeClickable(todayday1);
                click(todayday1);
                j = size1;
            }
        }
    }
    public void CollectionTrend() throws InterruptedException, IOException
    {
        // Add your code to interact with the collection trend here.
    }

    public void CurrentMonth_Filter()
    {
        waitforElementToBeClickable(Collection_7Days_Trends);
        click(Collection_7Days_Trends);
        waitforElementToBeClickable(Collections_Current_Month_Trends);
        click(Collections_Current_Month_Trends);
    }

    public void LastMonth_Filter()
    {
        waitforElementToBeClickable(Collections_Current_Month_Trends);
        click(Collections_Current_Month_Trends);
        waitforElementToBeClickable(Collectionss_Last_Month_Trends);
        click(Collectionss_Last_Month_Trends);
    }

    public void Last6Month_Filter()
    {
        waitforElementToBeClickable(Collectionss_Last_Month_Trends);
        click(Collectionss_Last_Month_Trends);
        waitforElementToBeClickable(Collections_Last_6Months_Trends);
        click(Collections_Last_6Months_Trends);
    }

    public void CustomMonths_Collection_Trends_Filter()
    {
        waitforElementToBeClickable(Collections_Last_6Months_Trends);
        click(Collections_Last_6Months_Trends);
        waitforElementToBeClickable(COllections_Custom_Months);
        click(COllections_Custom_Months);
    }

    public void removeDownloadedPNGFiles()
    {
        String fileToDelete = "Preview Graph.png";
        String path = "src/file_download";
        String filePath = path + File.separator + fileToDelete;
        File file = new File(filePath);
        try {
            if (file.exists())
            {
                if (file.delete())
                {
                    System.out.println("File '" + fileToDelete + "' deleted successfully.");
                }
                else
                {
                    System.out.println("Unable to delete '" + fileToDelete + "'.");
                }
            }
        }
        catch (NoSuchElementException m)
        {
            System.out.println("**********************No file to delete ***********************************");
            return;
        }
    }

    public void removeDownloadedSVGFiles()
    {
        String fileToDelete = "Preview Graph.svg";
        String path = "src/file_download";
        String filePath = path + File.separator + fileToDelete;
        File file = new File(filePath);
        try
        {
            if (file.exists())
            {
                if (file.delete())
                {
                    System.out.println("File '" + fileToDelete + "' deleted successfully.");
                }
                else
                {
                    System.out.println("Unable to delete '" + fileToDelete + "'.");
                }
            }
        } catch (NoSuchElementException m)
        {
            System.out.println("**********************No file to delete ***********************************");
            return;
        }
    }

    public void removeDownloadedCSVFiles()
    {
        String fileToDelete = "Collections Trend.csv";
        String path = "src/file_download";
        String filePath = path + File.separator + fileToDelete;
        File file = new File(filePath);
        try
        {
            if (file.exists())
            {
                if (file.delete())
                {
                    System.out.println("File '" + fileToDelete + "' deleted successfully.");
                }
                else
                {
                    System.out.println("Unable to delete '" + fileToDelete + "'.");
                }
            }
        } catch (NoSuchElementException m)
        {
            System.out.println("**********************No file to delete ***********************************");
            return;
        }
    }

    public void TodayPTPCounts()
    {


    }

    public void TommorrowPTPCounts()
    {
        waitforElementToBeVisible(TodayPTPCounts);
        waitforElementToBeClickable(TodayPTPCounts);
        click(TodayPTPCounts);
        waitforElementToBeVisible(TommorrowPTPCounts);
        waitforElementToBePresent(TommorrowPTPCounts);
        waitforElementToBeClickable(TommorrowPTPCounts);
        jsClick(TommorrowPTPCounts);

    }

    public void Next7DaysPTPCounts()
    {
        waitforElementToBeVisible(TommorrowPTPCounts);
        waitforElementToBeClickable(TommorrowPTPCounts);
        click(TommorrowPTPCounts);
        waitforElementToBeVisible(Next7DaysPTPCounts);
        waitforElementToBePresent(Next7DaysPTPCounts);
        waitforElementToBeClickable(Next7DaysPTPCounts);
        jsClick(Next7DaysPTPCounts);

    }



    public void PTPCountsMethod()
    {
        wait(2);
        waitforElementToBeVisible(PTPCountOfDashboard);
        waitforElementToBePresent(PTPCountOfDashboard);
        WebElement e = getElement(PTPCountOfDashboard);
        int count = Integer.parseInt(e.getText());
        wait(2);
        waitforElementToBeClickable(PTPCountOfDashboard);
        if (count > 0)
        {
            waitforElementToBeClickable(PTPCountOfDashboard);
            jsClick(PTPCountOfDashboard);
            wait(5);

            int count2 = 0;
            WebElement e1 = null;
            List<WebElement> rows = getElementsList(By.xpath("//*[@id='subordinateexecutivevisitcount']/tbody/tr"));
            int size = rows.size();

            for (int i = 1; i <= size; i++)
            {
                String dynamicXPath = "//*[@id='subordinateexecutivevisitcount']/tbody/tr[" + i + "]/td[3]";
                By Drill_Collection_count = By.xpath(dynamicXPath);
                e1 = getElement(Drill_Collection_count);
                count2 = count2 + Integer.parseInt(e1.getText());
                if (i == 10)
                {
                    boolean isClickable = navigateToNextPage(Collection_next_page);
                    if(isClickable)
                    {
                        waitforPageToFinishLoading();
                        wait(5);
                        List<WebElement> rows1 = getElementsList(By.xpath("//*[@id='subordinateexecutivevisitcount']/tbody/tr"));
                        int size1 = rows1.size();
                        for (int j = 1; j <= size1; j++)
                        {
                            String dynamicXPath1 = "//*[@id='subordinateexecutivevisitcount']/tbody/tr[" + j + "]/td[3]";
                            By Drill_Collection_count1 = By.xpath(dynamicXPath1);
                            e1 = getElement(Drill_Collection_count1);
                            count2 = count2 + Integer.parseInt(e1.getText());
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (j == 10)
                            {
                                wait(5);
                                boolean isClickable1 = navigateToNextPage(Collection_next_page);
                                if(isClickable1)
                                {
                                    waitforPageToFinishLoading();
                                    wait(5);
                                    List<WebElement> rows12 = getElementsList(By.xpath("//*[@id='subordinateexecutivevisitcount']/tbody/tr"));
                                    int size12 = rows12.size();
                                    for (int k = 1; k <= size12; k++)
                                    {
                                        String dynamicXPath12 = "//*[@id='subordinateexecutivevisitcount']/tbody/tr[" + k + "]/td[3]";
                                        By Drill_Collection_count12 = By.xpath(dynamicXPath12);
                                        e1 = getElement(Drill_Collection_count12);
                                        count2 = count2 + Integer.parseInt(e1.getText());
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (count == count2)
            {
                System.out.println("Dashboard count of PTP visit:- " + count + " is matched with drill count:- " + count2);
                test().log(Status.PASS, "Dashboard count PTP visit " + count + " is matched with drill count " + count2);
            }
            else
            {
                System.out.println("Dashboard count PTP visit:- " + count + " is not matched with drill count:- " + count2);
                test().log(Status.FAIL, "Dashboard count PTP visit " + count + " is not matched with drill count " + count2);
                //throw a ConditionNotSatisfiedException("Value should be not matched");
            }
        }
        else
        {
            System.out.println("No data available in PTP visit :- " + count);
            test().log(Status.PASS, "No data available in PTP visit " + count);
        }

        try
        {
            jsClick(Close_button);
        }
        catch (NoSuchElementException m)
        {
            // Handle NoSuchElementException for the fourth element (optional)
        }

    }

}

