package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is used to read the configurations from the Configuration.properties file. This exposes methods
 * to access the configuration values
 */
public class ConfigFileReader {
    Properties properties;
    String propertyFilePath = "src/main/configs/Configuration.properties";
    BufferedReader reader;

    public ConfigFileReader() {
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            properties.load(reader);
            reader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Configuration file does not exist in the specified path");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDriverPath() {
        String path = properties.getProperty("driverPath");
        if (path != null) {
            return path;
        } else {
            throw new RuntimeException("Driver path is not specified in the file");
        }
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if (browser != null) {
            return browser;
        } else {
            throw new RuntimeException("Browser is not specified in the file");
        }
    }

    public String getBaseURL() {
        String baseURL = properties.getProperty("baseURL");
        if (baseURL != null) {
            return baseURL;
        } else {
            throw new RuntimeException("Base URL is not specified in the file");
        }
    }
}
