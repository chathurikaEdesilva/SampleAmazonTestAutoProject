/**
 * This java class reads test data from TestData.properties file.
 * This class contains methods that can be used to access the test data
 */

package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestDataFileReader {
    Properties properties;
    String propertyFilePath = "src/main/resources/TestData.properties";
    BufferedReader reader;

    public TestDataFileReader() {
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

    public String getSearchItem() {
        String searchItem = properties.getProperty("searchItem");
        if (searchItem != null) {
            return searchItem;
        } else {
            throw new RuntimeException("Search item is not specified in the file");
        }
    }

    public String getCartURL() {
        String cartURL = properties.getProperty("cartURL");
        if (cartURL != null) {
            return cartURL;
        } else {
            throw new RuntimeException("Search item is not specified in the file");
        }
    }

    public String getUserGivenName() {
        String name = properties.getProperty("userGivenName");
        if (name != null) {
            return name;
        } else {
            throw new RuntimeException("Search item is not specified in the file");
        }
    }
    public String getUserName() {
        String username = properties.getProperty("username");
        if (username != null) {
            return username;
        } else {
            throw new RuntimeException("Username is not specified in the file");
        }
    }

    public String getPassword() {
        String password = properties.getProperty("password");
        if (password != null) {
            return password;
        } else {
            throw new RuntimeException("Password is not specified in the file");
        }
    }

}
