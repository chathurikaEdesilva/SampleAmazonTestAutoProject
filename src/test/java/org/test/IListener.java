package org.test;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.utils.CaptureScreenShots;
import java.sql.Timestamp;

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
