package sample;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.io.Serializable;

public class Resource<T> extends ResourceSupport implements Serializable {

    @JsonUnwrapped
    private T content;

    public Resource(Integer code, String message) {
        super(code, message);
    }
    public Resource(Integer code, String message, T content) {
        super(code, message);
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public static <T> Resource<T> wrapper(T content) {
        return new Resource<>(0, "ok", content);
    }
}
