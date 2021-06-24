package com.gdpu.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtil {

    private static final String ISSUER = "linjia";
    private static final String SECRET = "recuitment";

    private static final long EXPIRATION_ACCESS = 3600L;    // 1h = 3600s
    private static final long EXPIRATION_REFRESH = 7200L;   // 7d = 604800s

    // generate token
    public static String generateToken(String subject) {
        String expiration = Long.toString(System.currentTimeMillis() + EXPIRATION_ACCESS * 1000);
        Map<String, String> claims = new HashMap<>();
        claims.put("iss", ISSUER);
        claims.put("sub", subject);
        claims.put("exp", expiration);
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(claims);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return JwtHelper.encode(json, new MacSigner(SECRET)).getEncoded();
    }


    // parse token
    public static Map<String, String> parseToken(String token) {
        String json = JwtHelper.decodeAndVerify(token, new MacSigner(SECRET)).getClaims();
        Map<String, String> claims = null;
        try {
            claims = new ObjectMapper().readValue(json, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return claims;
    }

    // get subject
    public static String getSubject(String token) {
        return parseToken(token).get("sub");
    }

    public static String getSubject(Map<String, String> claims) {
        return claims.get("sub");
    }


}
