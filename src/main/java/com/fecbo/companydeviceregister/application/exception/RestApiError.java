package com.fecbo.companydeviceregister.application.exception;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
@JsonSerialize(using = RestApiError.RestErrorSerializer.class)
public record RestApiError(@Getter String errorDetail) {

    private static final String JSON_PROP_NAME_ERROR_DETAIL = "errorDetail";

    public static class RestErrorSerializer extends StdSerializer<RestApiError> {
        public RestErrorSerializer() {
            this(null);
        }

        public RestErrorSerializer(Class<RestApiError> t) {
            super(t);
        }

        @Override
        public void serialize(RestApiError restApiError, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeStartObject();
            if (restApiError.errorDetail() != null) {
                jsonGenerator.writeStringField(JSON_PROP_NAME_ERROR_DETAIL, restApiError.errorDetail());
            }
            jsonGenerator.writeEndObject();
        }
    }
}
