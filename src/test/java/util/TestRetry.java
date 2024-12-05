package util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetry implements IRetryAnalyzer {
    private int count = 0;
    private int retryCount = 2;

    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            if (count < retryCount) {
                count++;
                return true;
            }
        }
        return false;
    }
}
