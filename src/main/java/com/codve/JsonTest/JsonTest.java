package com.codve.JsonTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JsonTest {
    public static void main(String[] args) {

        JsonTest jsonTest = new JsonTest();

//        jsonTest.objectToJsonString();
//        jsonTest.objectToJsonFile();
//        jsonTest.stringToObject();
//        jsonTest.fileToObject();
//        jsonTest.fileToArray();
        jsonTest.listToMap();
    }

    // 将 Java 对象转换为 json 字符串
    protected void objectToJsonString() {
        Person person = new Person("jiangyu", 24, 18000);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonStr = objectMapper.writeValueAsString(person);
            System.out.println(jsonStr);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
    }

    // 将 Java 对象转换为 json 文件
    protected void objectToJsonFile() {
        Person person = new Person("jiangyu", 24, 18000);

        ObjectMapper objectMapper = new ObjectMapper();

        String filePath = "C:\\source code\\java\\JsonTest\\src\\main\\java\\com\\codve\\JsonTest\\output.json";

        try {
            objectMapper.writeValue(new File(filePath), person);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // 将 json 字符串转换为 对象
    protected void stringToObject() {
        String jsonStr = "{\"name\":\"jiangyu\",\"age\":24,\"salary\":18000.0}";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Person person = objectMapper.readValue(jsonStr, Person.class);
            System.out.println(person.info());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // 将 json 文件转换为对象
    protected void fileToObject() {
//        String filePath = "C:\\source code\\java\\JsonTest\\src\\main\\java\\com\\codve\\JsonTest\\output.json";

        // 也可以使用格式化后的json文件
        String filePath = "C:\\source code\\java\\JsonTest\\src\\main\\java\\com\\codve\\JsonTest\\person.json";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Person person = objectMapper.readValue(new File(filePath), Person.class);
            System.out.println(person.info());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // 将 json 字符串转换为List
    protected void fileToArray() {
        String filePath = "C:\\source code\\java\\JsonTest\\src\\main\\java\\com\\codve\\JsonTest\\persons.json";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Person> persons = objectMapper.readValue(new File(filePath), new TypeReference<List<Person>>(){});
            for (Person person : persons) {
                System.out.println(person.info());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // 将 数组 转换为 Map
    protected void listToMap() {
        String filePath = "C:\\source code\\java\\JsonTest\\src\\main\\java\\com\\codve\\JsonTest\\persons.json";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Person> personList = objectMapper.readValue(new File(filePath), new TypeReference<List<Person>>(){});
            Hashtable<Integer, Person> personSet = new Hashtable<>();

            int length = personList.size();
            for (int i = 0; i < length; i++) {
                personSet.put(i, personList.get(i));
            }

            Set<Integer> keys = personSet.keySet();
            for (int key : keys) {
                Person person = personSet.get(key);
                System.out.println(person.info());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
