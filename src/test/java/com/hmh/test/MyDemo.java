package com.hmh.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hmh.favq.configuration.Constants;
import com.hmh.utils.json.GetJson;
import com.hmh.utils.json.JsonParserImpl;
import com.hmh.utils.rest.RestAPIRequestImpl;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MyDemo implements TestConstants {

    protected static String AUTH_SUADM_1 = null;
    protected static String AUTH_SUADM_2 = null;
    protected static String AUTH_SUADM_3 = null;
    protected static String AUTH_ADMIN_3 = null;
    protected static String AUTH_ADMIN_4 = null;
    protected static String AUTH_TEUSR_5 = null;
    protected static String AUTH_TEUSR_6 = null;
    protected static String AUTH_MPUSR_7 = null;
    protected static String AUTH_MPUSR_8 = null;
    protected static String AUTH_MPUSR_9 = null;
    private static final Logger LOGGER = LogManager.getLogger(MyDemo.class);
    protected String custRefId;
    protected String userID;
    protected Constants constants;
    protected Response response;
    protected RestAPIRequestImpl request;

    protected GetJson json = new GetJson();
    Gson gson = new GsonBuilder().create();
    protected JsonParserImpl jsonParserImpl = new JsonParserImpl();

    public MyDemo() {
        response = new RestAssuredResponseImpl();
        request = new RestAPIRequestImpl();


    }

    private Map<String, ?> setHeaderMap(String auth) {
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", auth);
        header.put("Accept", "application/json");
        header.put("Content-Type", "application/json");
        return header;
    }

    protected String getUniqueId() {
        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss:SSS");
        Date date = new Date();
        String dateTime = dateFormat.format(date);
        return dateTime.replace("-", "").replace(":", "").replace(" ", "");
    }

    protected String getJson(Object obj) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(obj);

        JSONObject jsonObj = new JSONObject(json);

        return jsonObj.toString();
    }
    /*
  This method takes an object as input and convert that to a Json object and returns that Json object.
     */
    public JSONObject getJsonFromObject(Object object) {
        return new JSONObject(gson.toJson(object));
    }

     protected String getCurrentDateTimeInDDMMYYYYHHMMSS() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy hh:mm:ss");
        Date date = new Date();
        String dateTime[] = dateFormat.format(date).split("-");
        return dateTime[0]+"-"+dateTime[1].substring(0,3)+"-"+dateTime[2];
    }



}
