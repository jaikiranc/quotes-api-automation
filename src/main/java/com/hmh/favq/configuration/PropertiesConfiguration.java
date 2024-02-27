package com.hmh.favq.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfiguration {
    private String filepath;

    public PropertiesConfiguration(String propertiesPath) {
        this.filepath = propertiesPath;
    }

    public String getStringValue(String key) {
        return this.readPropertyValue(key);
    }

    public int getIntegerValue(String key) throws Exception {
        return Integer.parseInt(this.readPropertyValue(key));
    }

    private String readPropertyValue(String key){
                  Properties prop = new Properties();
            InputStream input = null;
            String result = null;

        try {
                input = this.getClass().getResourceAsStream(this.filepath);
                prop.load(input);
                result = prop.getProperty(key);
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
            try {
                input.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return result;
    }
}