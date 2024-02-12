package util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Rerunautomation implements IRetryAnalyzer {
    /**
     * Returns true if the test method has to be retried, false otherwise.
     *
     * @param result The result of the test method that just ran.
     * @return true if the test method has to be retried, false otherwise.
     */
    private int retryCount=0;
private static final int maxCount=5;
    @Override
    public boolean retry(ITestResult result) {
        if(retryCount<maxCount){
            retryCount++;
            return true;
        }
        return false;
    }
}
