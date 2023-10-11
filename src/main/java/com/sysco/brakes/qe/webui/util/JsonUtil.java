package com.sysco.brakes.qe.webui.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

public class JsonUtil {
    private static final Gson GSON = new Gson();

    public static JsonObject getJsonData(String filename) throws IOException {
        try (FileReader reader = new FileReader(filename)) {
            JsonParser parser = new JsonParser();
            return parser.parse(reader).getAsJsonObject();
        }
    }

    public static JsonObject getIndexDataFromJsonArray(String filename, int index, String arrayName) throws IOException {
        JsonObject data = getJsonData(filename);
        return data.getAsJsonObject(arrayName).getAsJsonObject(String.valueOf(index));
    }
}