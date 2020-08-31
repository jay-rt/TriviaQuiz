package com.example.triviaquiz.util;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Converters {
    JsonAdapter<List<String>> adapter;

    public Converters() {
        Moshi moshi = new Moshi.Builder().build();
        Type conversionTypes = Types.newParameterizedType(List.class, String.class);
        adapter = moshi.adapter(conversionTypes);
    }

    public String listToString (List<String> input) {
        return adapter.toJson(input);
    }

    public List<String> stringToList (String value) {
        try {
            return adapter.fromJson(value);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
