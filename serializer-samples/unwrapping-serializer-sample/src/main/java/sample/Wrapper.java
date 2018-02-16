package sample;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.io.Serializable;

public class Wrapper implements Serializable {

    private Integer code;

    private String message;

    @JsonUnwrapped
    private Sample content;

    public Wrapper(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Wrapper(Integer code, String message, Sample content) {
        this(code, message);
        this.content = content;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Sample getContent() {
        return content;
    }

    public void setContent(Sample content) {
        this.content = content;
    }
}
