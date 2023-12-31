package qa.listener;

import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {


    private static String getTestMethodName(ITestResult iTestResult) {

        return iTestResult.getMethod().getMethodName();
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {

        return message;
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {


    }

    @Override
    public void onTestStart(ITestResult iTestResult) {


    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        saveTextLog(getTestMethodName(iTestResult) + "- PASSED");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        saveTextLog(getTestMethodName(iTestResult) + "- FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        saveTextLog(getTestMethodName(iTestResult) + "- SKIPPED");
    }
}
