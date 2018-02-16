package sample;

import java.io.Serializable;

public class Sample implements Serializable {

    @SampleAnnotation("sample")
    private String value;

    public Sample() {
    }

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
