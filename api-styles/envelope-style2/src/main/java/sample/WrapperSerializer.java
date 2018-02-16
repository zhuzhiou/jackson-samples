package sample;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.util.NameTransformer;

import java.io.IOException;

/**
 * 该类在该示例中并未起作用，保留代码供参考。
 */
public class WrapperSerializer extends StdSerializer<Wrapper> {

    protected WrapperSerializer() {
        super(Wrapper.class);
    }

    @Override
    public void serialize(Wrapper wrapper, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject(wrapper);
        gen.writeNumberField("code", wrapper.getCode());
        gen.writeStringField("message", wrapper.getMessage());
        if (wrapper.getContent() != null) {
            JsonSerializer serializer = provider.findValueSerializer(wrapper.getContent().getClass());
            if (serializer instanceof BeanSerializer) {
                if (!serializer.isUnwrappingSerializer()) {
                    serializer = serializer.unwrappingSerializer(NameTransformer.NOP);
                }
            }
            if (!serializer.isUnwrappingSerializer()){
                gen.writeFieldName("content");
            }
            serializer.serialize(wrapper.getContent(), gen, provider);
        }
        gen.writeEndObject();
    }
}
