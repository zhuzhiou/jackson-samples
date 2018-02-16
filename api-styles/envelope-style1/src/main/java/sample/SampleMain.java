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
        Wrapper<Sample> beanWrapper = new Wrapper<>(0, "done");
        Sample sample = new Sample("sample");
        beanWrapper.setContent(sample);
        System.out.println(objectMapper.writeValueAsString(beanWrapper));

        //数组
        Wrapper<List<Sample>> listWrapper = new Wrapper<>(0, "done");
        List<Sample> samples = new ArrayList<>();
        samples.add(sample);
        listWrapper.setContent(samples);
        System.out.println(objectMapper.writeValueAsString(listWrapper));

        //分页
        Wrapper<Page<Sample>> pagedWrapper = new Wrapper<>(0, "done");
        Page<Sample> page = new PageImpl<>(samples, new PageRequest(1, 9), 81);
        pagedWrapper.setContent(page);
        objectMapper.addMixIn(Page.class, PageMixin.class);
        System.out.println(objectMapper.writeValueAsString(pagedWrapper));
    }
}
