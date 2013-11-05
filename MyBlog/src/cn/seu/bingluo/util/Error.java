package cn.seu.bingluo.util;

import org.json.simple.JSONObject;

public class Error {
	public static String KESuccess(String url) {
		JSONObject obj = new JSONObject();
		obj.put("error", 0);
		obj.put("url", url);
		return obj.toJSONString();
	}

	public static String KEError(String message) {
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		return obj.toJSONString();
	}
}
