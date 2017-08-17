package com.example.nedvy.fsm.model.parser;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.nedvy.fsm.model.ActionBody;
import com.example.nedvy.fsm.model.enums.State;
import com.example.nedvy.fsm.model.parser.converter.Converter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class JsonParser {

    public static Map<State, List<ActionBody>> fsmParser(@NonNull Context context) {
        Converter converter = new Converter(context);
        Gson gson = new Gson();
        Type type = new TypeToken<Map<State, List<ActionBody>>>() {
        }.getType();
        Map<State, List<ActionBody>> config = gson.fromJson(converter.jsonParser(), type);
        return config;
    }
}
