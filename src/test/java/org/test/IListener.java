package org.test;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.utils.CaptureScreenShots;
import java.sql.Timestamp;

/**
 * This is the testng listener class that invokes capturing of a screenshot on test failure
 * This logic saves the captures with the timestamp.
 * This will enable multiple screen captures to be available for debugging purposes as they will not be overriden.
 * This listener is used in the testng.xml
 */
public class IListener extends CaptureScreenShots implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            captureScreenShot(result.getMethod().getMethodName()
                    + timestamp.toString().replace(":", "_").replace(" ", "_")
                    + ".jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
