package sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SampleMain {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        //对象
        Sample sample = new Sample("sample");
        Resource<Sample> resource = Resource.wrapper(sample);
        System.out.println(objectMapper.writeValueAsString(resource));

        //数组
        List<Sample> samples = new ArrayList<>();
        samples.add(sample);
        Resources<Sample> resources = Resources.wrapper(samples);
        System.out.println(objectMapper.writeValueAsString(resources));

        //分页
        Page<Sample> page = new PageImpl<>(samples, new PageRequest(1, 9), 81);
        resources = Resources.wrapper(page);
        System.out.println(objectMapper.writeValueAsString(resources));
    }
}
