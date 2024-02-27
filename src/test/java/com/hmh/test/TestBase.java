package com.hmh.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hmh.favq.model.QuoteObject;
import com.hmh.favq.model.Quotes;
import com.hmh.favq.model.User;
import com.hmh.favq.model.UserDetails;
import com.hmh.utils.rest.RestAPIRequestImpl;
import com.hmh.utils.rest.UrlResources;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class TestBase implements TestConstants {
    protected Response response;
    protected RestAPIRequestImpl request;
    public String userToken;
    public TestBase() {
        response = new RestAssuredResponseImpl();
        request = new RestAPIRequestImpl();

    }

    public String getToken() {
        if( userToken==null){
        String[] user_auth_array;
        user_auth_array = TestConstants.USER_DEFAULT.split(";;");
        User user =new User();
        user.setPassword(user_auth_array[1]);
        user.setLogin(user_auth_array[0]);
        UserDetails userDetails= new UserDetails();
                userDetails.setUser(user);

        response = request.post(getJson(userDetails), UrlResources.LOGIN,TestConstants.USER_AUTHORIZATION_HEADER);
        assertEquals(response.getStatusCode(), 200, "Failed to login");
        userToken=response.jsonPath().get("User-Token").toString();
       }
        return userToken;

    }

    public Map<String, String> getUserSession(String user) {

        Map<String, String> header = new HashMap<>();
        header.put("Authorization", TestConstants.USER_AUTHORIZATION_HEADER);
        header.put("Accept", "application/json");
        header.put("Content-Type", "application/json");
        header.put("User-Token", getToken());
        return header;
    }
    protected QuoteObject getQuoteObject(Response response) {
        return response.as(QuoteObject.class, ObjectMapperType.GSON);
    }
    protected Quotes getAllQuotes(Response response) {
        return response.as(Quotes.class, ObjectMapperType.GSON);
    }
    protected String getJson(Object obj) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(obj);

        JSONObject jsonObj = new JSONObject(json);

        return jsonObj.toString();
    }


}
