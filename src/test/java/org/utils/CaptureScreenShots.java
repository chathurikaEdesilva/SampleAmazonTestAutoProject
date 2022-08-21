package org.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.test.BaseClass;
import java.io.File;


/**
 * This class contains the logic for screen capturing.
 */
public class CaptureScreenShots extends BaseClass {

    public void captureScreenShot(String fileName) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) webDriver;
            System.out.println(webDriver.getCurrentUrl());
            File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(".//screenshots//" + fileName);
            System.out.println(destFile);
            FileUtils.copyFile(srcfile, destFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
