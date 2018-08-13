package sample.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import sample.Sample;

import java.io.IOException;


public class UnwrappingSampleSerializer extends StdSerializer<Sample> {

    protected UnwrappingSampleSerializer() {
        super(Sample.class);
    }

    @Override
    public void serialize(Sample sample, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStringField("value", sample.getValue());
    }

    @Override
    public boolean isUnwrappingSerializer() {
        return true;
    }
}
