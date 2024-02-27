package com.hmh.utils.rest;

import io.restassured.config.DecoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAPIRequestImpl {

	RequestSpecification requestSpec = null;

	private static final Logger LOGGER = LogManager.getLogger(RestAPIRequestImpl.class);

	public void setHeader(String auth) {
		requestSpec = given().relaxedHTTPSValidation();
		requestSpec.header("Authorization", auth);
	}
	public void setHeaders(String auth, String userToken) {
		requestSpec = given().relaxedHTTPSValidation();
		requestSpec.header("Authorization", auth);
		requestSpec.header("User-Token", userToken);
	}

	public void setHeader() {
		requestSpec = given().relaxedHTTPSValidation();
	}

	public void setHeaders(Map<String, ?> headermap) {
		requestSpec = given().relaxedHTTPSValidation();
		requestSpec.headers(headermap);
	}

	public Response post(String json, String url, String auth) {
		Response response = null;
		response = given().header("Authorization", auth)
				.config(RestAssuredConfig.config()
						.decoderConfig(DecoderConfig.decoderConfig().defaultContentCharset("UTF-8")).and()
						.sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.contentType(ContentType.JSON).body(json).when().post(url).then().extract().response();
		LOGGER.info(response.getBody().asString());
		return response;
	}


	public Response get(String url, String sessionId) {
		Response response = null;
		this.setHeader(sessionId);
		response = requestSpec.config(RestAssuredConfig.config().decoderConfig(DecoderConfig.decoderConfig().defaultContentCharset("UTF-8")).and().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.contentType(ContentType.JSON).when().get(url).then().extract().response();
		return response;
	}

	public Response get(String url, Map<String, ?> headerMap, Map<String, String> queryParams) {
		Response response = null;
		this.setHeaders(headerMap);
		response = given().headers(headerMap)
				.config(RestAssuredConfig.config().decoderConfig(DecoderConfig.decoderConfig().defaultContentCharset("UTF-8")).and().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.contentType(ContentType.JSON) .queryParams(queryParams)
				.when().get(url).then().extract().response();

		return response;
	}

	public Response get(String url, Map<String, String> headerMap) {
		Response response = null;
		this.setHeaders(headerMap);
		response = given().headers(headerMap)
				.config(RestAssuredConfig.config().decoderConfig(DecoderConfig.decoderConfig().defaultContentCharset("UTF-8")).and().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.contentType(ContentType.JSON)
				.when().get(url).then().extract().response();
		LOGGER.info(response.getBody().asString());
		return response;
	}

	public Response put( String url, Map<String, String> headermap) {
		Response response = null;
		this.setHeaders(headermap);
		response = requestSpec
				.config(RestAssuredConfig.config().decoderConfig(DecoderConfig.decoderConfig().defaultContentCharset("UTF-8")).and().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
				.contentType(ContentType.JSON).when().put(url).then().extract().response();
		return response;
	}

}
