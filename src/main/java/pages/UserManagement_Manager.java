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

public class UserManagement_Manager extends Utils
{
    WebElement EmpName,MobileNo,EmpID,Branch;
    By UserManagement= By.xpath("//*[@id=\"userMgmt1\"]/span");
    By Manager=By.xpath("//*[@id=\"managers1\"]");
    By SearchBarInManager=By.xpath("//input[@placeholder=\"Search By Name/Branch/Mobile/Emp ID\"]");
    By ManagerDownloadButton=By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div[1]/button[3]");

//    By EmpNameResultedRecord=By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div[2]/div/div[1]/div/table/tbody/tr[1]/td[1]/div/p");
    By ClickOnNext=By.xpath("//*[@id=\"main-wrapper\"]//button[@class='page-link'][text()=\"Next\"]");
    public void ClickOnUserManagement()
    {
        waitforElementToBeClickable(UserManagement);
        jsClick(UserManagement);

    }
    public void ClickOnManagerTab()
    {
        waitforElementToBeClickable(Manager);
        jsClick(Manager);
    }

    public void FetchEmployeeName()
    {
        //*[@id="main-wrapper"]/div[4]/div/div/div[2]/div/div[1]/div/table/tbody/tr[" + i + "]/td[1]/div/p

        List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div[2]/div/div[1]/div/table/tbody/tr"));
        int EmpNameCount= rows.size();
        int i= getRandomNumber(1,EmpNameCount);
        String EmpNameInManagerTab = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div[2]/div/div[1]/div/table/tbody/tr[" + i + "]/td[1]/div/p";
        By empNameInManagerTab = By.xpath(EmpNameInManagerTab);
        EmpName = getElement(empNameInManagerTab);



    }
    String EmployeeName;
    public void ClickOnSearchBar()
    {
        EmployeeName=EmpName.getText();
        WebElement element = driver.get().findElement(SearchBarInManager);
        element.sendKeys(EmployeeName);
        wait(10);
    }
    String ResultedEmpNameInManagerTab;
    public void FetchResultedSearch()
    {
        try
        {
           String EmpNameResultedRecord="//*[@id=\"main-wrapper\"]/div[4]/div/div/div[2]/div/div[1]/div/table/tbody/tr[1]/td[1]/div/p";
           By empNameResultedRecord=By.xpath(EmpNameResultedRecord);
           WebElement resultedEmpNameInManagerTab = getElement(empNameResultedRecord);
           ResultedEmpNameInManagerTab=resultedEmpNameInManagerTab.getText();

        }
        catch (NoSuchElementException e)
        {
            test().log(Status.FAIL,"=====>No Record matched with "+EmployeeName);
        }

        if(EmployeeName.equalsIgnoreCase(ResultedEmpNameInManagerTab))
        {
                test().log(Status.PASS,"=====>Searched Emp Name "+EmployeeName+" is matched");
        }
        else
        {
                test().log(Status.FAIL,"=====>Searched Emp Name "+EmployeeName+" is not matched");
        }


    }
    int ManagerCounts=0;
    public void ClickOnNextPage()
    {
        for(int i=1;i<1000;i++)
        {
            wait(5);
          List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div[2]/div/div[1]/div/table/tbody/tr"));
          ManagerCounts+= rows.size();
//          wait(2);
          int j=i+1;
          String NextPage="//*[@id='pagebutton"+j+"']//button[@class='page-link']";
          try
          {
                    By Next_Page=By.xpath(NextPage);
                    waitforElementToBeVisible(Next_Page);
                    waitforElementToBeClickable(Next_Page);
                    scrollDown(driver.get());
                    wait(2);
                    click(Next_Page);
          }
          catch(NoSuchElementException E)
          {
                    i=1000;
          }

        }
        System.out.println(ManagerCounts);
    }
    public void DownloadXlsvFile()
    {
        int rowCount=0;
        jsClick(ManagerDownloadButton);
        wait(5);
        String Manager_Reports = "/src/file_download/";  // Replace with the actual file name
                String downloadDirectory = System.getProperty("user.dir") + "/"+Manager_Reports;
                File dir = new File(downloadDirectory);
                File[] files = dir.listFiles();
                if (files != null) {
                    for (File file : files)
                    {
                        if (file.isFile() && file.getName().startsWith("Clu_Managers"))
                        {
                            System.out.println("Found file: " + file.getAbsolutePath());
                            test().log(Status.PASS, "=====>Manager File has been downloaded successfully.");
                        }
                    }
                }
                else
                {
                    System.out.println("No files found in the directory.");
                    test().log(Status.FAIL, "=====>Manager File download verification failed.");
                }
            }

    public void VerificationOfXlsvDownloadedFile()
    {
        int Manager_XLSVRowCount=0;
        String Manager_Reports = "/src/file_download/";  // Replace with the actual file name
        String downloadDirectory = System.getProperty("user.dir") + "/" + Manager_Reports;
        File dir = new File(downloadDirectory);
        File[] files = dir.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isFile() && file.getName().startsWith("Clu_Managers"))
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
            if(ManagerCounts==Manager_XLSVRowCount)
            {
                test().log(Status.PASS, "=====>Manager Pagenation "+ManagerCounts+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Manager Pagenation "+ManagerCounts+" count is matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
            else
            {
                test().log(Status.FAIL, "=====>Manager Pagenation "+ManagerCounts+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);
                System.out.println("Manager Pagenation "+ManagerCounts+" count is not matched with the XLS File downloaded File Row count "+Manager_XLSVRowCount);

            }
        }
        else
        {
            test().log(Status.FAIL, "Issue In the Mangers Downloaded XLSV file");

        }

    }

    public void FetchBranchName()
    {
        List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div[2]/div/div[1]/div/table/tbody/tr/td[3]"));
        int BranchNameCount= rows.size();
        int i= getRandomNumber(1,BranchNameCount);
        String BranchNameInManagerTab = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div[2]/div/div[1]/div/table/tbody/tr[" + i + "]/td[3]";
        By branchNameInManagerTab = By.xpath(BranchNameInManagerTab);
        Branch = getElement(branchNameInManagerTab);
    }
    String BranchName;
    public void ClickOnSearchBarForBranchName()
    {
        BranchName=Branch.getText();
        WebElement element = driver.get().findElement(SearchBarInManager);
        element.sendKeys(BranchName);
        wait(10);
    }
String ResultedBranchNameInManagerTab;
    public void FetchResultedSearchOfBranchName()
    {
        try
        {
            String BranchNameResultedRecord="//*[@id=\"main-wrapper\"]/div[4]/div/div/div[2]/div/div[1]/div/table/tbody/tr[1]/td[3]";
            By branchNameResultedRecord=By.xpath(BranchNameResultedRecord);
            WebElement resultedBranchNameInManagerTab = getElement(branchNameResultedRecord);
            ResultedBranchNameInManagerTab=resultedBranchNameInManagerTab.getText();

        }
        catch (NoSuchElementException e)
        {
            test().log(Status.FAIL,"=====>No Record matched with "+BranchName);
        }

        if(BranchName.equalsIgnoreCase(ResultedBranchNameInManagerTab))
        {
            test().log(Status.PASS,"=====>Searched Branch Name "+BranchName+" is matched");
        }
        else
        {
            test().log(Status.FAIL,"=====>Searched Branch Name "+BranchName+" is not matched");
        }

    }

    public void FetchEMPIDName() {
        List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div[2]/div/div[1]/div/table/tbody/tr/td[2]"));
        int EmpIdCount= rows.size();
        int i= getRandomNumber(1,EmpIdCount);
        String EmpIdInManagerTab = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div[2]/div/div[1]/div/table/tbody/tr[" + i + "]/td[2]";
        By empIdInManagerTab = By.xpath(EmpIdInManagerTab);
        EmpID = getElement(empIdInManagerTab);
    }
    String empID;
    public void ClickOnSearchBarForEMPID()
    {
        empID=EmpID.getText();
        WebElement element = driver.get().findElement(SearchBarInManager);
        element.sendKeys(empID);
        wait(10);
    }
String ResultedEmpIdInManagerTab;
    public void FetchResultedSearchOfEMPID()
    {
        try
        {
            String EmpIDResultedRecord="//*[@id=\"main-wrapper\"]/div[4]/div/div/div[2]/div/div[1]/div/table/tbody/tr[1]/td[2]";
            By empIdResultedRecord=By.xpath(EmpIDResultedRecord);
            WebElement resultedEmpIDInManagerTab = getElement(empIdResultedRecord);
            ResultedEmpIdInManagerTab=resultedEmpIDInManagerTab.getText();

        }
        catch (NoSuchElementException e)
        {
            test().log(Status.FAIL,"=====>No Record matched with "+empID);
        }

        if(empID.equalsIgnoreCase(ResultedEmpIdInManagerTab))
        {
            test().log(Status.PASS,"=====>Searched EmpId "+empID+" is matched");
        }
        else
        {
            test().log(Status.FAIL,"=====>Searched EmpId "+empID+" is not matched");
        }
    }

    public void FetchMobileNoName() {
        List<WebElement> rows = getElementsList(By.xpath("//*[@id=\"main-wrapper\"]/div[4]/div/div/div[2]/div/div[1]/div/table/tbody/tr/td[4]"));
        int MobileNoCount= rows.size();
        int i= getRandomNumber(1,MobileNoCount);
        String MobileNoInManagerTab = "//*[@id=\"main-wrapper\"]/div[4]/div/div/div[2]/div/div[1]/div/table/tbody/tr[" + i + "]/td[4]";
        By mobileNoInManagerTab = By.xpath(MobileNoInManagerTab);
        MobileNo = getElement(mobileNoInManagerTab);
    }
String Mobileno;
    public void ClickOnSearchBarForMobileNo() {
        Mobileno=MobileNo.getText();
        WebElement element = driver.get().findElement(SearchBarInManager);
        element.sendKeys(Mobileno);
        wait(10);
    }
    String ResultedMobileNoInManagerTab;
    public void FetchResultedSearchOfMobileNo() {
        try
        {
            String MobileNoInResultedRecord="//*[@id=\"main-wrapper\"]/div[4]/div/div/div[2]/div/div[1]/div/table/tbody/tr[1]/td[4]";
            By MobilenoInResultedRecord=By.xpath(MobileNoInResultedRecord);
            WebElement resultedEmpIDInManagerTab = getElement(MobilenoInResultedRecord);
            ResultedMobileNoInManagerTab=resultedEmpIDInManagerTab.getText();

        }
        catch (NoSuchElementException e)
        {
            test().log(Status.FAIL,"=====>No Record matched with "+Mobileno);
        }

        if(Mobileno.equalsIgnoreCase(ResultedMobileNoInManagerTab))
        {
            test().log(Status.PASS,"=====>Searched MobileNo "+Mobileno+" is matched");
        }
        else
        {
            test().log(Status.FAIL,"=====>Searched MobileNo "+Mobileno+" is not matched");
        }
    }
}
