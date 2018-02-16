package sample;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;

import java.io.IOException;

public class SampleSerializer extends JsonSerializer<String> implements ContextualSerializer {

    private String name;

    @Override
    public void serialize(String sample, JsonGenerator gen, SerializerProvider provider) throws IOException {
        //gen.writeStartObject();
        gen.writeString(name + ":" + sample);
        //gen.writeEndObject();
    }

    //通过字段已知的上下文信息定制JsonSerializer
    @Override
    public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty property) throws JsonMappingException {
        if (property != null) {
            if (property.getType().getRawClass() == String.class) {
                //该序列器只对String属性有用
                SampleAnnotation annotation = property.getAnnotation(SampleAnnotation.class);
                if (annotation != null) {
                    this.name = annotation.value();
                }
                return this;
            }
            return provider.findValueSerializer(property.getType());
        }
        return provider.findNullValueSerializer(property);
    }
}
