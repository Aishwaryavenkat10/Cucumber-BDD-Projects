package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;

    /**
     * This method is used to load the properties from config.properties.file
     * @return prop object
     */
    public Properties init_prop(){
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/test/resources/Config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
