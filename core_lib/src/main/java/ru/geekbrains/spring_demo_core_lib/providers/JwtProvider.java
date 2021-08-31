package ru.geekbrains.spring_demo_core_lib.providers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_demo_core_lib.classes.JwtPayload;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;

@Slf4j
@Service
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    public String createToken(JwtPayload payload) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return Jwts.builder()
                .setSubject(mapper.writeValueAsString(payload))
                .setExpiration(Date.from(LocalDate.now().plusDays(2).atStartOfDay(ZoneId.systemDefault()).toInstant())) //TODO перевести в секунды и переместить в параметры
                .signWith(getKey())
                .compact();
    }

    private Key getKey() {
        if (secretKey != null) {
            byte[] decodeKey = Base64.getDecoder().decode(secretKey);
            return new SecretKeySpec(decodeKey, 0, decodeKey.length, SignatureAlgorithm.HS256.getJcaName());
        }
        else {
            return Keys.secretKeyFor(SignatureAlgorithm.HS256);
        }
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    public JwtPayload getPayloadFromToken(String token) {
        try {
            String subject = Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(subject, JwtPayload.class);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
