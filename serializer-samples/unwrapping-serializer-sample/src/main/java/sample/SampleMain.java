package sample;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class SampleMain {

    public static void main(String[] args) throws IOException {
        Wrapper wrapper = new Wrapper(0, "done");

        Sample sample = new Sample("sample");
        wrapper.setContent(sample);

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(wrapper));
    }
}
