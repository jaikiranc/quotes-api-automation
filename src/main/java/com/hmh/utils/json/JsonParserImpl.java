package com.hmh.utils.json;

/**
 * 
 * @author Ranjeet
 *
 */

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonParserImpl implements JsonParser,Serializable {

	private static final Logger logger = LogManager.getLogger(JsonParserImpl.class);

	private Map<String, Object> jsonMap = new HashMap<>();

	private Map<String, Object> parseToMap(JsonNode node) throws JsonProcessingException, IOException {

		Iterator<Map.Entry<String, JsonNode>> fieldsIterator = node.fields();
		while (fieldsIterator.hasNext()) {
			Map.Entry<String, JsonNode> field = fieldsIterator.next();
			String keyName = field.getKey();
			JsonNode newNode = field.getValue();

			if (newNode.isObject()) {
				parseToMap(newNode);
			}else if (newNode.isValueNode()) {
				if (newNode.isInt()) {
					jsonMap.put(keyName, newNode.asInt());
				} else if (newNode.isDouble()) {
					jsonMap.put(keyName, newNode.asDouble());
				} else if (newNode.isBoolean()) {
					jsonMap.put(keyName, newNode.asBoolean());
				} else if (newNode.isLong()) {
					jsonMap.put(keyName, newNode.asLong());
				} else {
					jsonMap.put(keyName, newNode.asText());
				}

			}

		}

		return jsonMap;
	}

	public Map<String, Object> jsonParser(String json) {
		JsonFactory factory = new JsonFactory();
		Map<String, Object> jsonMap = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper(factory);
		JsonNode rootNode = null;
		try {
			rootNode = mapper.readTree(json);
		} catch (JsonProcessingException e) {
			logger.error("Json Mapping Exception ", e);
		} catch (IOException e) {
			logger.error("IOException ", e);
		}
		try {
			jsonMap = parseToMap(rootNode);
		} catch (JsonProcessingException e) {
			logger.error("Json Mapping Exception ", e);
		} catch (IOException e) {
			logger.error("IOException ", e);
		}
		return jsonMap;
	}

	public Map<String, Object> jsonToMap(String json) {
		Map<String, Object> map = new HashMap<>();
		try {

			ObjectMapper mapper = new ObjectMapper();
			// convert JSON string to Map
			map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
			});

		} catch (JsonGenerationException e) {
			logger.error("Json Generation Exception ", e);

		} catch (JsonMappingException e) {
			logger.error("Json Mapping Exception ", e);

		} catch (IOException e) {
			logger.fatal("IOException ", e);

		}
		return map;
	}

	public String mapToJson(Map<String, Object> inputMap) {
		String jsonResp = null;
		ObjectMapper mapperObj = new ObjectMapper();
		// convert map to JSON String
		try {
			jsonResp = mapperObj.writeValueAsString(inputMap);
		} catch (IOException e) {
			logger.error("Error in converting map to json String ", e);
		}
		return jsonResp;
	}

	public String getValueFromJsonArray(String json, String key, String innerKey) {
		JSONObject jsonObject = new JSONObject(json);
		JSONObject response = jsonObject.getJSONObject(key);
		
		String value = (String) response.get(innerKey);
		
		return value;
	}
	
	public Object getArrayValueFromJsonArray(String json, String key, String innerKey) {
		JSONObject jsonObject = new JSONObject(json);
		JSONObject response = jsonObject.getJSONObject(key);
		Object value =  response.get(innerKey);
		return value;
	}
		
	public String getValueFromJson(String json, String key) {
		JSONObject jsonObject = new JSONObject(json);
		JSONObject response = jsonObject.getJSONObject(key);
		String value = response.toString();
		return value;		

	}
	
	public JSONArray getJSONArrayFromJson(String json, String key) {
		JSONObject jsonObject = new JSONObject(json);
		JSONArray response = jsonObject.getJSONArray(key);
		
		return response;		

	}
	public JSONObject objectToJSONObject(Object object){
	    Object json = null;
	    JSONObject jsonObject = null;
	    try {
	        json = new JSONTokener(object.toString()).nextValue();
	    } catch (JSONException e) {
	        e.printStackTrace();
	    }
	    if (json instanceof JSONObject) {
	        jsonObject = (JSONObject) json;
	    }
	    return jsonObject;
	}

	public JSONArray objectToJSONArray(Object object){
	    Object json = null;
	    JSONArray jsonArray = null;
	    try {
	        json = new JSONTokener(object.toString()).nextValue();
	    } catch (JSONException e) {
	        e.printStackTrace();
	    }
	    if (json instanceof JSONArray) {
	        jsonArray = (JSONArray) json;
	    }
	    return jsonArray;
	}

}
