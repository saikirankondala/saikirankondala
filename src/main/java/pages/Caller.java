package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Utils;

import static util.Base.driver;

public class Caller extends Utils
{
   // By My_Alloccations=By.xpath("//*[@id=\"main-wrapper\"]/div[3]/div[1]/div[1]/ul/li[4]/ul/li[3]/a/span");

    By My_Alloccations=By.xpath("//span[@class='nav-text'][text()='My Allocations']");
    By CallerSymbol=By.xpath("//i[@class='fas fa-phone-alt']");
    By CallEnd=By.xpath("//i[@class=\"fa fa-phone fa-2x fa-rotate-270\"]");
    By CallConnected=By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div/div/div[1]/div/div/div[1]/div");
    By CallNotConnected=By.xpath("//*[text()='Call Not Connected']");
    By SubStatus=By.xpath("//*[text()='Select...']");

    By SubStatusType=By.xpath("/html/body/div[4]/div/div/div[2]/div/div[1]/div/div/div/div[2]/div/div/div[1]/div");
    By Submit_Remarks=By.xpath("//button[@type='submit']");
    By AddRemarks=By.xpath("//textarea[@placeholder='Enter Remarks...']");

    By ClickOK=By.xpath("/html/body/div[3]/div/div[3]/div/button");

    By Rinigng=By.xpath("//*[text()='Ringing']");

    public void SelectMyAllocation()
    {
        waitforElementToBeVisible(My_Alloccations);
        waitforElementToBeClickable(My_Alloccations);
        click(My_Alloccations);
    }

    public void ClickOnDail()
    {
        wait(50);
        int i=0;
        while(i<1000)
        {
            wait(3);
            waitforElementToBeVisible(CallerSymbol);
            waitforElementToBeClickable(CallerSymbol);
            wait(1);
            click(CallerSymbol);
            wait(20);

            waitforElementToBeVisible(CallEnd);
            waitforElementToBeVisible(CallEnd);
            waitforElementToBeClickable(CallEnd);
            wait(1);
            click(CallEnd);

            waitforElementToBeVisible(ClickOK);
            waitforElementToBeClickable(ClickOK);
            click(ClickOK);

            waitforElementToBeVisible(CallConnected);
            waitforElementToBeClickable(CallConnected);
            click(CallConnected);

            waitforElementToBeVisible(CallNotConnected);
            waitforElementToBeClickable(CallNotConnected);
            click(CallNotConnected);

            waitforElementToBeVisible(SubStatus);
            waitforElementToBeClickable(SubStatus);
            click(SubStatus);
            waitforElementToBeVisible(Rinigng);
            waitforElementToBeClickable(Rinigng);
            click(Rinigng);


            waitforElementToBeVisible(AddRemarks);
            waitforElementToBeClickable(AddRemarks);
            String allocationFileName="Testing:-"+i;
            System.out.println(allocationFileName);
            WebElement fileInput = driver.get().findElement(AddRemarks);
            fileInput.sendKeys(allocationFileName);
            wait(2);

            waitforElementToBeVisible(Submit_Remarks);
            waitforElementToBeClickable(Submit_Remarks);
            click(Submit_Remarks);
            wait(5);
            By Ok=By.xpath("//*[@class=\"swal-button swal-button--confirm\"]");
            jsClick(Ok);
            i++;
            wait(2);


        }
        wait(10000);
    }
}
