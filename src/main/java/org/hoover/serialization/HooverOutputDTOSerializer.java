package org.hoover.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.hoover.dto.HooverOutputDTO;

import java.io.IOException;

public class HooverOutputDTOSerializer extends StdSerializer<HooverOutputDTO> {

    public HooverOutputDTOSerializer() {
        this(null);
    }

    protected HooverOutputDTOSerializer(Class<HooverOutputDTO> t) {
        super(t);
    }

    @Override
    public void serialize(HooverOutputDTO hooverOutputDTO, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeArrayFieldStart("coords");
        jsonGenerator.writeNumber(hooverOutputDTO.coords().x());
        jsonGenerator.writeNumber(hooverOutputDTO.coords().y());
        jsonGenerator.writeEndArray();
        jsonGenerator.writeNumberField("patches", hooverOutputDTO.patches());
        jsonGenerator.writeEndObject();
    }
}
