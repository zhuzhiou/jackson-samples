package sample.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.util.NameTransformer;
import sample.Sample;

import java.io.IOException;

public class SampleSerializer extends StdSerializer<Sample> {

    protected SampleSerializer() {
        super(Sample.class);
    }

    @Override
    public void serialize(Sample sample, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject(sample);
        gen.writeStringField("value", sample.getValue());
        gen.writeEndObject();
    }

    @Override
    public JsonSerializer<Sample> unwrappingSerializer(NameTransformer unwrapper) {
        return new UnwrappingSampleSerializer();
    }

    @Override
    public boolean isUnwrappingSerializer() {
        return false;
    }
}
