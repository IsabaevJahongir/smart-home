package com.jahon.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jahon.server.model.Payload;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

@Service
public class TokenChecker {
    private static final ObjectMapper mapper = new ObjectMapper();

    @Value("${secretKey}")
    private String secretKey;


    public boolean check(String accessToken) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), HS256.getJcaName());
        DefaultJwtSignatureValidator validator = new DefaultJwtSignatureValidator(HS256, secretKeySpec);

        String[] chunks = accessToken.split("\\.");

        String tokenWithoutSignature = chunks[0] + "." + chunks[1];
        String signature = chunks[2];

        return validator.isValid(tokenWithoutSignature, signature);
    }


    public Payload getPayload(String accessToken) throws IOException {
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String[] chunks = accessToken.split("\\.");

        String payloadStr = new String(decoder.decode(chunks[1]), StandardCharsets.UTF_8);

        Payload payload = mapper.readValue(payloadStr, Payload.class);

        return payload;
    }


    public boolean isNotExpire(long expireTime) {
        return System.currentTimeMillis() >= expireTime;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
