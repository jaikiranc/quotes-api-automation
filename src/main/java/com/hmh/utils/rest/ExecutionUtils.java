package com.hmh.utils.rest;


import java.io.FileInputStream;
import java.util.Properties;

public class ExecutionUtils {

    private static String url=System.getProperty("axonurl");

    public static String getUrl() {
        return setUrl();
    }

    public static String setUrl() {
        if(url==null) {
            url = getPropUrl();
            if(url.endsWith("/"))
                return url;
            else
                return url+"/";
        }else {
            if(url.endsWith("/"))
                return url;
            else
                return url+"/";
        }

    }

    private static String getPropUrl(){
        try{
                Properties prop = new Properties();
                FileInputStream input = new FileInputStream((System.getProperty("user.dir")+"/src/main/resources/config/config.properties")) ;
                prop.load(input);
                return prop.getProperty("url");

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
