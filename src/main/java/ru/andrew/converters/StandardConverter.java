package ru.andrew.converters;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public interface StandardConverter {
    void convert(List <Map<String, String>> collectionToConvert, OutputStream outputStream);
}
