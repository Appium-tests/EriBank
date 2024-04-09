package qa.listeners;

import io.qameta.allure.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    private final Logger logger = LoggerFactory.getLogger(Listener.class);

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {

        return message;
    }

    @Override
    public void onStart(ITestContext iTestContext) {

        logger.info("-".repeat(50));
        logger.info("Suite: " + iTestContext.getSuite().getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

        logger.info("-".repeat(50));
        logger.info("Test finish");
        logger.info("-".repeat(50));
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

        logger.info("-".repeat(50));
        logger.info("Test start on method: " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        logger.info("Test PASSED");
        logger.info("-".repeat(50));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        logger.error("Test FAILED");
        logger.info("-".repeat(50));
        saveTextLog(iTestResult.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        logger.warn("Test SKIPPED");
        logger.info("-".repeat(50));
    }
}
