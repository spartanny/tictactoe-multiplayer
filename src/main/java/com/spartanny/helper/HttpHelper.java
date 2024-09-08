package com.spartanny.helper;

import java.util.HashMap;
import java.util.Map;

public class HttpHelper {

    public static Map<String, Object> getQueryParams(String query) {
        Map<String, Object> params = new HashMap<>();
        if (query != null && !query.isEmpty()) {
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                if (keyValue.length == 2) {
                    params.put(keyValue[0], keyValue[1]);
                }
            }
        }
        return params;
    }
}
