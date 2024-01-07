package qa.listener;

import io.qameta.allure.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    private final Logger logger = LoggerFactory.getLogger(Listener.class);
    private static String getTestMethodName(ITestResult iTestResult) {

        return iTestResult.getMethod().getMethodName();
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {

        return message;
    }

    @Override
    public void onStart(ITestContext iTestContext) {

        logger.info("Suite: " + iTestContext.getSuite().getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

        logger.info("Test finish");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

        logger.info("Test \"" + iTestResult.getTestName() + "\" start on method: " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        logger.info("Test PASSED");
        saveTextLog(getTestMethodName(iTestResult) + "- PASSED");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        logger.error("Test FAILED");
        saveTextLog(getTestMethodName(iTestResult) + "- FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        logger.warn("Test SKIPPED");
        saveTextLog(getTestMethodName(iTestResult) + "- SKIPPED");
    }
}
