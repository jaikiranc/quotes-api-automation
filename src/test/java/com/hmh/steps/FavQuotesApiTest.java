package com.hmh.steps;

import com.hmh.test.TestBase;
import com.hmh.utils.rest.UrlResources;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.LinkedHashMap;
import java.util.Map;

public class FavQuotesApiTest extends TestBase {
    private static final Logger LOGGER = LogManager.getLogger(FavQuotesApiTest.class);
    Map<String, String> queryParams = new LinkedHashMap<>();

    private void setQueryParams(String key, String value) {
        queryParams.put(key, value);
    }

    @Given("Get a random list of quotes by user (.+)")
    public void getARandomListOfQuotesByUser(String user) {
        response = request.get(UrlResources.getFavQuotes(), getUserSession(user));
        Assert.assertEquals(response.getStatusCode(), SUCCESS);
        LOGGER.info(response.getBody().asString());
    }

    @Then("Verify that the list has (.+) quotes")
    public void verifyThatTheListHasQuotes(String count) {
        Assert.assertEquals(getAllQuotes(response).getQuotes().size(),Integer.parseInt(count));
    }
    @Given("^Mark a quote with id (.+) as favourite by user (.+)$")
    public void mark_a_quote_with_id_as_favourite_by_user_(String id, String user) {
        response = request.put(UrlResources.markAsUsersFavorite(id), getUserSession(user));
        LOGGER.info(response.getBody().asString());

    }

    @Then("^Validate that the status code is SUCCESS")
    public void validate_that_the_status_code_is() {
        Assert.assertEquals(response.getStatusCode(), SUCCESS);
    }

    @Then("^Check that the quote with (.+) has been marked as favourite by user (.+)$")
    public void verify_that_the_quote_with_id_has_been_marked_as_favourite(String id,String user) {
        response = request.get(UrlResources.getQuoteById(id), getUserSession(user));
        LOGGER.info(response.getBody().asString());
    }


    @Then("Get all Data provisioning formats offset as (.+) limit as (.+) sort field as (.+) and sort order as (.+)")
    public void getQuotesByParameters(String filter, String type, String privateQuotes, String hidden,String user) {
        if (!filter.equalsIgnoreCase("NULL")) {
            setQueryParams("filter", filter);
        }
    }

    @Given("Get quotes containing the filter for word (.+) by user (.+)")
    public void getQuotesContainingTWordFunny(String filter, String user) {
        if (!filter.equalsIgnoreCase("NULL")) {
            setQueryParams("filter", filter);
        }

        response = request.get(UrlResources.getFavQuotes(), getUserSession(user), queryParams);
        LOGGER.info(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), SUCCESS);
    }

    @And("Verify that the list of quotes has word (.+)")
    public void verifyThatTheListOfQuotesHasWord(String word) {
        Assert.assertTrue(getAllQuotes(response).getQuotes().get(0).getBody().contains(word));

    }

    @Given("Get quotes containing the filter (.+) for type (.+) user (.+)")
    public void getQuotesContainingTheFilterForType(String filter, String type,String user) {
        setQueryParams("filter", filter);
        setQueryParams("type", type);
        response = request.get(UrlResources.getFavQuotes(), getUserSession(user), queryParams);
        LOGGER.info(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), SUCCESS);
    }

    @Given("Get Quotes with filter as (.+) type as (.+) hiddenFlag as (.+) by user (.+)")
    public void getQuotesByQueryParams(String filter, String type, String pvt, String hidden, String user) {
        if (!filter.equalsIgnoreCase("NULL")) {
            setQueryParams("filter", filter);
        }
        if (!type.equalsIgnoreCase("NULL")) {
            switch (type.toUpperCase()) {
                case "TAG":
                case "AUTHOR":
                case "USER":
                    setQueryParams("type", type);
                    break;

                default:
                    System.out.println("Wrong Query Param value provided : " + type);
            }
        }
        if (!pvt.equalsIgnoreCase("NULL")) {
            setQueryParams("private", pvt);
        }
        if (!hidden.equalsIgnoreCase("NULL")) {
            setQueryParams("hidden", hidden);

        }
        response = request.get(UrlResources.getFavQuotes(), getUserSession(user), queryParams);
        LOGGER.info(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), SUCCESS);
    }
}
