package com.duck.airline.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    private static final String SECRET = "77397A244326462948404D635166546A576E5A7234753778214125442A472D4B";

    public String generateToken(String email) {
        return Jwts
                .builder()
                .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET)))
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24 * 3))
                .compact();
    }

    public Claims decode(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET)))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Boolean isExpired(String token) {
        return decode(token).getExpiration().before(new Date(System.currentTimeMillis()));
    }

    public static String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public static Date extractExpiration(String token) {
        return extractClaims(token).getExpiration();
    }

    private static Claims extractClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(token).getBody();
    }

    public static boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            return false;
        }
    }
}
