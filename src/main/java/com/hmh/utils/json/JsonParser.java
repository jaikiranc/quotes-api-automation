package com.hmh.utils.json;

/**
 * 
 * @author Ranjeet
 *
 */
import java.util.Map;

public interface JsonParser {

	public Map<String, Object> jsonToMap(String json);

	public String mapToJson(Map<String, Object> inputMap);
}
