package sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;

import java.io.IOException;

public class SampleProgram {

    public static void main(String[] args) throws IOException {
        Sample sample = new Sample();
        sample.setValue("sample");

        HandlerInstantiator handlerInstantiator = new SampleHandlerInstantiator();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setHandlerInstantiator(handlerInstantiator);
        System.out.println(objectMapper.writeValueAsString(sample));
    }
}
