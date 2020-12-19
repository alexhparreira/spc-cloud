package com.spcbrasil.api.util;

import io.jsonwebtoken.Jwts;
import org.springframework.util.StringUtils;

public class TokenUtil {


    public static String getUserId(String token,String tokenSecret){

        token =  getJwtFromString(token);
        return Jwts.parser()
                .setSigningKey(tokenSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

    }

    public static String getJwtFromString(String bearerToken) {

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }

        return bearerToken;

    }
}
