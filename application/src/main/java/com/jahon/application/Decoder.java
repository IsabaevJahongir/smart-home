package com.jahon.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jahon.application.model.Payload;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Decoder {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Base64.Decoder decoder = Base64.getUrlDecoder();


    public static Payload getPayload(String accessToken) throws IOException {
        String[] chunks = accessToken.split("\\.");

        String payloadStr = new String(decoder.decode(chunks[1]), StandardCharsets.UTF_8);

        Payload payload = mapper.readValue(payloadStr, Payload.class);

        return payload;
    }
}
