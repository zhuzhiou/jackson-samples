package sample;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class SampleMain {

    //Jackson使用ContextualSerializer在序列化时获取字段注解的属性
    public static void main(String[] args) throws IOException {
        Sample sample = new Sample("sample");

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(sample));
    }
}
