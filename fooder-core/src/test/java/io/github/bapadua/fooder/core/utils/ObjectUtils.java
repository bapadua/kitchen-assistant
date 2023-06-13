package io.github.bapadua.fooder.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectUtils {

    public static final ObjectMapper mapper = new ObjectMapper();
    public static <T> T convert (String json, Class<T> clazz) throws JsonProcessingException {
        return mapper.readValue(json, clazz);
    }
}
