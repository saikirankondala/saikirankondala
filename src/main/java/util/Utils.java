package util;

import com.aventstack.extentreports.Status;
import enums.Constants;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.output.WriterOutputStream;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.io.PrintStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static util.Base.driver;

public class Utils extends ExtentReportITestListener {

    protected Base baseInstance = Base.getInstance();

    protected int timeOutInMilliSeconds = Integer.parseInt(Constants.MAX_WAIT.getValue());
    protected int pollingTimeInMillieSeconds = Integer.parseInt(Constants.POLLING_TIME.getValue());
    static String pattern = "ddMMyyHHmmss";
    String downloadFilepath = System.getProperty("user.dir") + Constants.DOWBLOADED_FILE.getValue();

    @SuppressWarnings("static-access")
    protected void loadUrl(String url) {
        try {
            baseInstance.getDriver().get(url);
            test().log(Status.PASS, "=====> Loaded URL: " + url);

        } catch (Exception e) {
            test().log(Status.FAIL, "=====> Exception Occurred");
            throw e;
        }
    }

    @SuppressWarnings("static-access")
    protected void jsloadUrl(String url) {
        try {
            baseInstance.getDriver().switchTo().newWindow(WindowType.TAB).get(url);
            baseInstance.getDriver().navigate().refresh();
            test().log(Status.PASS, "Loaded URL: " + url);

        } catch (Exception e) {
            test().log(Status.FAIL, "Exception Occured");
            throw e;
        }
    }

    public String getUniqueString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return randomAlphabeticString() + dateFormat.format(new Date());
    }

    public static int toIpInt(String ipStr) {
        String[] temp = ipStr.split("\\.");
        int b0 = Integer.parseInt(temp[0]);
        int b1 = Integer.parseInt(temp[1]);
        int b2 = Integer.parseInt(temp[2]);
        int b3 = Integer.parseInt(temp[3]);
        int ip = (int) (b0 << 24) + (int) (b1 << 16) + (int) (b2 << 8) + b3;
        return ip;
    }

    protected void pressESC() {
        Actions action = new Actions(Base.getDriver());
        action.sendKeys(Keys.ESCAPE).build().perform();
    }

    public String getInventoryFileName() {
        File folder = new File(System.getProperty("user.dir") + "/src/file_download/");
        File[] listOfFiles = folder.listFiles();
        String fileName = "";
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && listOfFiles[i].getName().contains("Inventory")) {
                System.out.println("File " + listOfFiles[i].getName());
                fileName = listOfFiles[i].getName();
                break;
            }
        }
        return fileName;
    }
    // *************************
    // WAITS
    // *************************

    /**
     * wait in Seconds
     *
     * @param waitInSeconds
     */
    public void wait(int waitInSeconds) {
        try {
            Thread.sleep(waitInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementVisible(By locator) {
        if (getElementsList(locator).size()>0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isElementEnabled(By locator) {
        if (getElement(locator).isEnabled())
            return true;
        else
            return false;
    }

    /**
     * Fluent wait till the page loads completely polling for every
     * <i>pollingTimeInMillieSeconds</i>
     */
    public void waitforPageToFinishLoading() {

        try {

            ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                }
            };

            Wait<WebDriver> wait = new FluentWait<WebDriver>(Base.getDriver())
                    .withTimeout(Duration.ofMillis(timeOutInMilliSeconds))
                    .pollingEvery(Duration.ofMillis(pollingTimeInMillieSeconds)).ignoring(NoSuchElementException.class);

            wait.until(pageLoadCondition);

        } catch (Exception e) {

        }
    }

    /**
     * Fluent wait till the element is Visible polling for element every
     * <i>pollingTimeInMillieSeconds</i>
     *
     * @param driver                     WebDriver
     * @param webElement                 WebElement
     * @param timeOutInMilliSeconds      int
     * @param pollingTimeInMillieSeconds int
     */

    public void waitforElementToBeVisible(By locator) {
        try {
            WebElement webElement = getElement(locator);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(Base.getDriver())
                    .withTimeout(Duration.ofMillis(timeOutInMilliSeconds))
                    .pollingEvery(Duration.ofMillis(pollingTimeInMillieSeconds)).ignoring(NoSuchElementException.class);

            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {

        }
    }

    public void waitforElementToBeInvisible(By locator) {

        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(Base.getDriver())
                    .withTimeout(Duration.ofMillis(timeOutInMilliSeconds))
                    .pollingEvery(Duration.ofMillis(pollingTimeInMillieSeconds)).ignoring(NoSuchElementException.class);

            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {

        }
    }

    /**
     * Fluent wait till the element is Clickable polling for element every
     * <i>pollingTimeInMillieSeconds</i>
     *
     * @param driver                     WebDriver
     * @param webElement                 WebElement
     * @param timeOutInMilliSeconds      int
     * @param pollingTimeInMillieSeconds int
     */
    public static boolean isClickableElement(WebElement webe)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait((WebDriver) driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(webe));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public void waitforElementToBeClickable(By locator) {

        try {
            WebElement webElement = getElement(locator);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(Base.getDriver())
                    .withTimeout(Duration.ofMillis(timeOutInMilliSeconds))
                    .pollingEvery(Duration.ofMillis(pollingTimeInMillieSeconds)).ignoring(NoSuchElementException.class);

            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Exception e) {

        }
    }

    public boolean waitforElementToBeClickable1(By locator) {

        try {
            WebElement webElement = getElement(locator);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(Base.getDriver())
                    .withTimeout(Duration.ofMillis(timeOutInMilliSeconds))
                    .pollingEvery(Duration.ofMillis(pollingTimeInMillieSeconds)).ignoring(NoSuchElementException.class);

            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Exception e) {

        }
        return true;
    }
    public static boolean navigateToNextPage(By collection_next_page) throws NoSuchElementException,ElementClickInterceptedException {
        try {
            // Find and interact with the "Next" button or pagination link
            WebElement nextPageButton = driver.get().findElement(collection_next_page); // Replace with your element locator
            nextPageButton.click();

            // Optionally, you can add verification logic here to ensure you're on the next page
            // For example, you can check for specific elements on the new page.

            return true; // Return true if navigation was successful
        } catch (Exception e) {
            // Handle any exceptions that may occur during navigation
            //e.printStackTrace();
            return false; // Return false if navigation failed
        }
    }


    public void waitforElementToBeNotClickable(By locator) {

        try {
            WebElement webElement = getElement(locator);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(Base.getDriver())
                    .withTimeout(Duration.ofMillis(timeOutInMilliSeconds))
                    .pollingEvery(Duration.ofMillis(pollingTimeInMillieSeconds)).ignoring(NoSuchElementException.class);

            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Exception e) {

        }
    }

    public void waitforElementToBeClickable(WebElement webElement) {

        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(Base.getDriver())
                    .withTimeout(Duration.ofMillis(timeOutInMilliSeconds))
                    .pollingEvery(Duration.ofMillis(pollingTimeInMillieSeconds)).ignoring(NoSuchElementException.class);

            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Exception e) {

        }

    }



    public void waitforElementToBePresent(By by) {

        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(Base.getDriver())
                    .withTimeout(Duration.ofMillis(timeOutInMilliSeconds))
                    .pollingEvery(Duration.ofMillis(pollingTimeInMillieSeconds)).ignoring(NoSuchElementException.class);

            wait.until(ExpectedConditions.presenceOfElementLocated(by));

        } catch (Exception e) {

        }

    }
    public boolean waitforElementToBePresents(By by) {

        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(Base.getDriver())
                    .withTimeout(Duration.ofMillis(timeOutInMilliSeconds))
                    .pollingEvery(Duration.ofMillis(pollingTimeInMillieSeconds)).ignoring(NoSuchElementException.class);

            wait.until(ExpectedConditions.presenceOfElementLocated(by));

        } catch (Exception e) {

        }

        return true;
    }
    public String randomAlphabeticString() {
        return RandomStringUtils.randomAlphabetic(4);
    }

    /**
     * Returns the WebElement
     *
     * @param by (By) <em>The value of the element to be located</em>
     * @return webElement (WebElement)
     */
    public WebElement getElement(By locator) {
        return Base.getDriver().findElement(locator);
    }

    /**
     * Returns the WebElement List
     *
     * @param by (By) <em>The value of the element to be located</em>
     * @return elementList (List of the WebElements)
     */
    public List<WebElement> getElementsList(By locator) {
        return Base.getDriver().findElements(locator);
    }

    /**
     * Enter String to a regular text field
     *
     * @param webElement WebElement
     * @param fieldValue String
     */
    protected void enterString(WebElement webElement, String fieldValue) {
        webElement.clear();
        webElement.sendKeys(fieldValue);
    }

    protected void enterString(By locator, String fieldValue) {
        WebElement webElement = getElement(locator);
        webElement.clear();
        webElement.sendKeys(fieldValue);
    }

    protected void enterString(By locator, Keys keys) {
        WebElement webElement = getElement(locator);
        webElement.sendKeys(keys);
    }

    /**
     * Clicks an element
     *
     * @param webElement WebElement
     */
    protected void click(WebElement webElement) {
        webElement.click();
    }

    /**
     * Clicks an element
     *
     * @param locator By
     */
    protected void click(By locator) {
        WebElement webElement = getElement(locator);
        webElement.click();
    }

    /**
     * Clicks an element
     *
     * @param locator By
     */

    protected void jsClick(By locator) {
        WebElement webElement = getElement(locator);
        try {
            JavascriptExecutor executor = (JavascriptExecutor) Base.getDriver();
            executor.executeScript("arguments[0].click();", webElement);
        } catch (WebDriverException wd) {
            throw wd;
        }
    }

    /**
     * Verify Element presence
     *
     * @param locator By
     * @return Boolean
     */
    protected Boolean verifyElementPresent(By locator) {
        WebElement element = getElement(locator);
        return element.isDisplayed();
    }

    protected Boolean verifyElementPresent(WebElement element) {
        return element.isDisplayed();
    }

    public static float getRandomNumber(double min, double max) {
        return (float) (Math.round(((Math.random() * (max - min)) + min) * 10000.0) / 10000.0);
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public static void scrollDown(WebDriver driver)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);"); // Adjust the scroll distance as needed
    }

    protected List<String> stringToList(String string) {
        String[] convertedStringArray = string.split(",");

        List<String> convertedStringList = new ArrayList<>();

        for (String word : convertedStringArray) {
            convertedStringList.add(word.trim());
        }
        return convertedStringList;
    }

    protected Response hitFormURLEncodedPostApi(HashMap<String, String> formData, String url, String endPoint) {
        StringWriter requestWriter = new StringWriter();
        PrintStream requestCapture = new PrintStream(new WriterOutputStream(requestWriter, Charset.defaultCharset()));

        Response response = RestAssured.given().filter(new RequestLoggingFilter(requestCapture)).baseUri(url)
                .contentType(ContentType.URLENC.withCharset("UTF-8")).formParams(formData).post(endPoint);
        requestCapture.flush();
        test().log(Status.INFO, "Request: " + requestWriter.toString());
        test().log(Status.INFO, "Response: " + response.asString());
        return response;
    }

    protected Response hitGetApi(HashMap<String, String> params, String url, String endPoint) {
        StringWriter requestWriter = new StringWriter();
        PrintStream requestCapture = new PrintStream(new WriterOutputStream(requestWriter, Charset.defaultCharset()));

        Response response = RestAssured.given().filter(new RequestLoggingFilter(requestCapture)).baseUri(url)
                .params(params).get(endPoint);

        requestCapture.flush();
        test().log(Status.INFO, "Request: " + requestWriter.toString());
        test().log(Status.INFO, "Response: " + response.asString());
        return response;
    }

    protected String getText(By locator) {
        return getElement(locator).getText();
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    /**
     * Clicks the checkbox
     *
     * @param element WebElement
     */
    protected void clickCheckbox(WebElement element) {
        if (!element.isSelected())
            element.click();
    }

    protected void clickCheckbox(By locator) {
        WebElement element = getElement(locator);
        if (!element.isSelected())
            element.click();
    }

    protected void jsClickCheckbox(By locator) {
        {
            WebElement element = getElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) Base.getDriver();
            executor.executeScript("arguments[0].click();", element);
        }
    }

    /**
     * Scrolls to the webelement
     */

    protected void scrollElementIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
        js.executeScript("arguments[0].scrollIntoView()", element);
    }

    protected void scrollElementIntoView(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", getElement(locator));
    }

    /**
     * Scrolls to the bottom of the page
     */
    protected void scrollDownToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * Scrolls to the top of the page
     */
    protected void scrollUpToTop() {
        JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
    }

    /**
     * Scrolls to the middle of the page
     */

    protected void scrollToMiddle() {
        JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight/3)");
    }

    /**
     * Scrolls to visible the page
     */

    protected void scrollToVisible() {
        JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight/2)");
    }

    /**
     * Selects an element from the dropdown by Visible Text
     *
     * @param locator         By
     * @param elementToSelect String
     */
    protected void selectByVisibleText(By locator, String elementToSelect) {
        Select dropdown = new Select(getElement(locator));
        dropdown.selectByVisibleText(elementToSelect);
    }

    protected Boolean verifyElementEnabled(By locator) {
        WebElement element = getElement(locator);
        return element.isEnabled();
    }

    public void moveToElement(By locator) {
        Actions action = new Actions(Base.getDriver());
        action.moveToElement(getElement(locator)).perform();
    }

    public void moveToElement(WebElement e) {
        Actions action = new Actions(Base.getDriver());
        action.moveToElement(e).perform();
    }

    public void moveToElementAndClick(WebElement e) {
        Actions action = new Actions(Base.getDriver());
        action.moveToElement(e).contextClick().perform();
    }

    public void moveToElementAndClick(By locator) {
        Actions action = new Actions(Base.getDriver());
        action.moveToElement(getElement(locator)).click().perform();
    }

    public void moveToElementAndRightClick(By element) {
        Actions action = new Actions(Base.getDriver());
        action.moveToElement(getElement(element)).contextClick().perform();
    }

    public void moveToElementAndDoubleClick(By element) {
        Actions action = new Actions(Base.getDriver());
        action.moveToElement(getElement(element)).doubleClick().perform();
    }

    public void switchToiframe(By locator) {
        By by = By.tagName("iframe");
        List<WebElement> ele = getElementsList(by);
        int size = ele.size();
        for (int i = 0; i < size; i++) {
            try {
                Base.getDriver().switchTo().frame(i);
                if (isElementVisible(locator)) {
                    break;
                }
            } catch (NoSuchFrameException e)
            {
                e.printStackTrace();
            }
        }
    }
    public void switchTodiv(By locator) {
        By by = By.tagName("div");
        List<WebElement> ele = getElementsList(by);
        int size = ele.size();
        for (int i = 0; i < size; i++) {
            try {
                Base.getDriver().switchTo().frame(i);
                if (isElementVisible(locator)) {
                    break;
                }
            } catch (NoSuchFrameException e)
            {
                e.printStackTrace();
            }
        }
    }
    public static boolean isElementClickable(WebDriver driver, By locator, int timeoutInSeconds) {
        try {
            WebElement element = new WebDriverWait(driver, timeoutInSeconds)
                    .until(ExpectedConditions.elementToBeClickable(locator));
            return element != null;
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public void switchToiframe1() {
            Base.getDriver().switchTo().frame(1);
    }

    public void switchToDefaultContent() {
        Base.getDriver().switchTo().defaultContent();
    }

    public void switchToWindowHandleBySize(int i) {
        List<String> s1 = new ArrayList<>();
        s1.addAll(Base.getDriver().getWindowHandles());
        Base.getDriver().switchTo().window(s1.get(i));
    }

    /**
     * @param iTestResult
     */
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    /**
     * @param iTestResult
     */
    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    /**
     * @param iTestResult
     */
    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    /**
     * @param iTestResult
     */
    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    /**
     * @param iTestResult
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    /**
     * @param iTestContext
     */
    @Override
    public void onStart(ITestContext iTestContext) {

    }

    public class ConditionNotSatisfiedException extends Exception
    {
        public ConditionNotSatisfiedException(String message) {
            super(message);
        }
    }

    public void switchToWindowHandle(By locator) {
        List<String> s1 = new ArrayList<>();
        s1.addAll(Base.getDriver().getWindowHandles());
        for (int i = 0; i < s1.size(); i++) {
            Base.getDriver().switchTo().window(s1.get(i));
            if (getElementsList(locator).size() > 0) {
                break;
            }
        }
    }
}

