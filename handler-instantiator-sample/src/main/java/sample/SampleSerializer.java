package sample;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class SampleSerializer extends JsonSerializer<Sample> {

    @Override
    public void serialize(Sample sample, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("sample", sample.getValue());
        gen.writeEndObject();
    }
}
