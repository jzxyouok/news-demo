package com.zhm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhm.model.CommonResponse;

import java.io.IOException;
import java.util.Map;

/**
 * Created by zhm on 17-1-1.
 */
public class BaseController {
    private final ObjectMapper mapper = new ObjectMapper();
    public final JsonNode parseStringToJson(String data){
        try {
            return mapper.readValue(data,JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public final Map<String,Object> parseJsonToMap(JsonNode json) {
        return mapper.convertValue(json, Map.class);
    }
    public final String parseJsonToString(Object data){
        try {
            return mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public final boolean checkJson(JsonNode json) {
        if(json.get("page")==null){
            return false;
        }if(json.get("size")==null){
            return false;
        }
        return true;
    }
    public final CommonResponse buildResponse(Object data) {
        return new CommonResponse(10000,data);
    }
}
