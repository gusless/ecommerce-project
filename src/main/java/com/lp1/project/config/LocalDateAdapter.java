package com.lp1.project.config;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;

public class LocalDateAdapter extends TypeAdapter<LocalDate> {

    @Override
    public void write(JsonWriter writer, LocalDate data) throws IOException {
        if (data == null) {
            writer.nullValue();
        } else {
            writer.value(data.toString());
        }
    }

    @Override
    public LocalDate read(JsonReader scanner) throws IOException {
        String date = scanner.nextString();
        return LocalDate.parse(date);
    }
}