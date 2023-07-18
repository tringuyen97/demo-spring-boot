package com.example.common.util;

import com.example.common.exception.CommonException;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Chau
 * Date: 4/19/19
 * Time: 1:44 PM
 */
public class JsonConverter {

    private static Gson gson = new GsonBuilder()
            .disableHtmlEscaping()
            .setDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
            .registerTypeHierarchyAdapter(byte[].class, new ByteArrayToBase64TypeAdapter())
            .create();
    private static JsonParser parser = new JsonParser();

    public static Gson getGson() {

        if (gson == null) {
            gson = new GsonBuilder().disableHtmlEscaping().create();
        }
        return gson;
    }

    public static JsonParser getParser() {
        if (parser == null) {
            parser = new JsonParser();
        }
        return parser;
    }

    public static JsonElement toJsonElement(Object object) {
        return getGson().toJsonTree(object);
    }

    public static String toJson(Object object) {
        return getGson().toJson(object);
    }

    public static JsonElement toJsonElement(String json) {
        return getParser().parse(json);
    }

    public static JsonObject toJson(String json) {
//        return gson.fromJson(json, com.google.gson.JsonObject.class);
        return getParser().parse(json).getAsJsonObject();
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return getGson().fromJson(json, clazz);
    }

    public static <T> T fromJson(String json, Type type) {
        return getGson().fromJson(json, type);
    }

    public static <T> T fromJson(JsonObject json, Type type) {
        return getGson().fromJson(json, type);
    }

    public static <T> T fromJson(JsonObject jsonObject, Class<T> clazz) {
        return getGson().fromJson(jsonObject, clazz);
    }

    public static <T> T fromJson(JsonElement jsonObject, Class<T> clazz) {
        return getGson().fromJson(jsonObject, clazz);
    }

    public static <T> List<T> fromJsonToList(JsonElement jsonElement, Class<T[]> clazz) throws CommonException.UnsupportException {
        T[] array = new Gson().fromJson(jsonElement, clazz);
        return Arrays.asList(array);
    }

    public static <T> List<T> fromJsonToList(String jsonString, Class<T[]> clazz) throws CommonException.UnsupportException {
        T[] array = new Gson().fromJson(jsonString, clazz);
        return Arrays.asList(array);
    }

    public static <T> Set<T> fromJsonToSet(String jsonString, Class<T[]> clazz) throws CommonException.UnsupportException {
        T[] array = new Gson().fromJson(jsonString, clazz);
        return new HashSet<>(Arrays.asList(array));
    }

    public static String toString(JsonElement json) {
        return getGson().toJson(json);
    }

    //todo implement function queryDsl to json
//    @SuppressWarnings({"all"})
//    public static String recordToJson(Record record) {
//        HashMap h = new HashMap();
//        for (Field f : record.fields()) {
//            if (record.get(f) == null) {
//                continue;
//            }
//            if (f.getType().equals(Timestamp.class)) {
//                h.put(f.getName(), ((Timestamp) record.get(f)).getTime());
//                continue;
//            }
//            if (f.getType().equals(Date.class)) {
//                h.put(f.getName(), ((Date) record.get(f)).getTime());
//                continue;
//            }
//            if (f.getType().equals(java.sql.Date.class)) {
//                h.put(f.getName(), ((java.sql.Date) record.get(f)).getTime());
//                continue;
//            }
//            h.put(f.getName(), record.get(f));
//        }
//        return toJson(h);
//    }

    //use for generic class
    @SuppressWarnings({"all"})
    public static <OUT,IN> OUT fromJson(String json,Class<OUT> out,Class<IN> in){
        //Example: ABC<DEF> -> OUT = ABC.class and IN = DEF.class
        Type type = TypeToken.getParameterized(out,in).getType();
        return (OUT)(getGson().fromJson(json,type));
    }

    @SuppressWarnings({"all"})
    public static <OUT,IN> OUT fromJson(JsonElement json,Class<OUT> out,Class<IN> in){
        Type type = TypeToken.getParameterized(out,in).getType();
        return (OUT)(new Gson().fromJson(json,type));
    }

    public static String fromMap(Map<String, Object> map) {
        return new Gson().toJson(map);
    }

    public static JsonElement fromMapToJson(Map<String, Object> map) {
        return new Gson().toJsonTree(map);
    }

    private static class ByteArrayToBase64TypeAdapter implements JsonSerializer<byte[]>, JsonDeserializer<byte[]> {
        public byte[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return Base64.getDecoder().decode(json.getAsString());
        }

        public JsonElement serialize(byte[] src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(Base64.getEncoder().encodeToString(src));
        }
    }

    public static <OUT> OUT mapToObject(Object object, Class<OUT> out) {
        return gson.fromJson(getGson().toJson(object), out);
    }
    
}
