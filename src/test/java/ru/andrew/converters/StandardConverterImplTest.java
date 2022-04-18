package ru.andrew.converters;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class StandardConverterImplTest {

    @Test
    public void convert() {

        Map<String, String> mapOne = new HashMap<>();
        mapOne.put("1", "A");
        mapOne.put("2", "B");
        List<Map<String, String>> listOfMap = new ArrayList<Map<String, String>>();
        listOfMap.add(mapOne);

        PrintStream originalOut = System.out;
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);

        StandardConverterImpl standardConverter = new StandardConverterImpl();
        standardConverter.convert(listOfMap, ps);

        String result = os.toString();
        System.setOut(originalOut);

        String expect = "1,A;2,B";
        Assert.assertEquals(expect, result);
    }
}