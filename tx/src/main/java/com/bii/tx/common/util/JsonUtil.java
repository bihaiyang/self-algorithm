package com.bii.tx.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author bihaiyang
 * @desc
 * @since 2022/01/19
 */
public abstract class JsonUtil {
    
    private static final ObjectMapper INDENT_OBJECT_MAPPER_NON_EMPTY = new ObjectMapper();
    private static final ObjectMapper INDENT_OBJECT_MAPPER = new ObjectMapper();
    private static final ObjectMapper NON_INDENT_OBJECT_MAPPER = new ObjectMapper();
    private static final ObjectMapper OBJECT_FIELDS_TO_STRING_OBJECT_MAP_MAPPER = new ObjectMapper();
    
    public JsonUtil() {
    }
    
    public static String getIndentNonEmptyJsonString(Object o) {
        if (Objects.isNull(o)) {
            return "";
        } else {
            try {
                return INDENT_OBJECT_MAPPER.writeValueAsString(o);
            } catch (Exception var2) {
                return doToStringException(o, var2);
            }
        }
    }
    
    public static String getIndentJsonString(Object o) {
        if (Objects.isNull(o)) {
            return "";
        } else {
            try {
                return INDENT_OBJECT_MAPPER.writeValueAsString(o);
            } catch (Exception var2) {
                return doToStringException(o, var2);
            }
        }
    }
    
    public static String getNonIndentJsonString(Object o) {
        if (Objects.isNull(o)) {
            return "";
        } else {
            try {
                return NON_INDENT_OBJECT_MAPPER.writeValueAsString(o);
            } catch (Exception var2) {
                return doToStringException(o, var2);
            }
        }
    }
    
    public static String getNonEmptyJsonString(Object o) {
        if (Objects.isNull(o)) {
            return "";
        } else {
            try {
                return INDENT_OBJECT_MAPPER_NON_EMPTY.writeValueAsString(o);
            } catch (Exception var2) {
                return doToStringException(o, var2);
            }
        }
    }
    
    public static <T> T getObject(String jsonSting, Class<T> beanClass) {
        if (Objects.nonNull(jsonSting) && Objects.nonNull(beanClass)) {
            try {
                return INDENT_OBJECT_MAPPER.readValue(jsonSting, beanClass);
            } catch (IOException var3) {
                return null;
            }
        } else {
            return null;
        }
    }
    
    
    public static <T> T getObject(String jsonSting, TypeReference<T> typeReference) {
        if (Objects.nonNull(jsonSting)) {
            try {
                return INDENT_OBJECT_MAPPER.readValue(jsonSting, typeReference);
            } catch (IOException var3) {
                return null;
            }
        } else {
            return null;
        }
    }
    
    
    public static Map<String, Object> objectFieldsToStringObjectMap(Object obj) {
        return (Map) OBJECT_FIELDS_TO_STRING_OBJECT_MAP_MAPPER.convertValue(obj, Map.class);
    }
    
    public static Map<String, Object> fileToStringObjectMap(File file) {
        try {
            return (Map) OBJECT_FIELDS_TO_STRING_OBJECT_MAP_MAPPER.readValue(file, Map.class);
        } catch (IOException e) {
            return new HashMap<>();
        }
    }
    
    
    private static String doToStringException(Object o, Exception e) {
        return "[Object toString() cause Jackson Serialization Failed] [" + o.getClass().getName()
                + "] " + e.getMessage();
    }
    
    
    static {
        INDENT_OBJECT_MAPPER_NON_EMPTY.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        INDENT_OBJECT_MAPPER_NON_EMPTY.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        INDENT_OBJECT_MAPPER_NON_EMPTY.enable(SerializationFeature.INDENT_OUTPUT);
        INDENT_OBJECT_MAPPER_NON_EMPTY.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        INDENT_OBJECT_MAPPER.registerModule(new JavaTimeModule());
        INDENT_OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        INDENT_OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        INDENT_OBJECT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
        NON_INDENT_OBJECT_MAPPER.registerModule(new JavaTimeModule());
        NON_INDENT_OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        NON_INDENT_OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        OBJECT_FIELDS_TO_STRING_OBJECT_MAP_MAPPER
                .setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        OBJECT_FIELDS_TO_STRING_OBJECT_MAP_MAPPER
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        OBJECT_FIELDS_TO_STRING_OBJECT_MAP_MAPPER
                .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
}
