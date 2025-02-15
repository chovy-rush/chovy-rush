package io.chovy.rush.common.lang.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    public static <T> T jsonToObject(String json, Class<T> classType) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            T t = objectMapper.readValue(json, classType);
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
