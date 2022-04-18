package ru.andrew.converters;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StandardConverterImpl implements StandardConverter {
    @Override
    public void convert(List<Map<String, String>> collectionToConvert, OutputStream outputStream) {
        String value = "";
        value = collectionToConvert.stream()
                .flatMap( ls -> ls.entrySet().stream())
                .map( e -> e.getKey() + "," + e.getValue())
                .collect(Collectors.joining(";"));

        byte[] buffer = value.getBytes();
        try {
            outputStream.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
