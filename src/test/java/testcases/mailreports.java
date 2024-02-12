package testcases;

import org.testng.annotations.AfterSuite;
import pages.CustomException;
import util.Pages;
import util.Reporter.Reporter;

public class mailreports {
    @AfterSuite
    public void Reports() throws Exception, CustomException
    {
        Pages.mailSending().Report();
        Reporter.log("Step 1: Reports send over the mail", true);


    }
}
