package util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static util.PropertiesUtil.getProp;

public class TestRetry implements IRetryAnalyzer {
    private int count = 0;
    private final int retryCount = Integer.parseInt(getProp("failed_test_retries"));

    @Override
    public boolean retry(ITestResult result) {
        return !result.isSuccess() && count++ < retryCount;
    }
}
