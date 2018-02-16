package sample;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import samples.annotation.unwrapped.ser.SampleSerializer;

import java.io.Serializable;

@JsonSerialize(using = SampleSerializer.class)
public class Sample implements Serializable {

    private String value;

    public Sample(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
