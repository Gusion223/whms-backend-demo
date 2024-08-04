package com.whms.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.whms.entity.User;

import java.util.Date;

public class TokenUtil {
    private static final long EXPIRE_TIME= 3*60*60*1000; // 3小时
    private static final String TOKEN_SECRET="123456";  //密钥

    private static final String Issuer="whms backend";

    public static String sign(User user){
        String token = null;
        try {
            // 使用了HMAC256加密算法。
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer(Issuer)
                    .withClaim("userName", user.getUserName())
                    .withExpiresAt(expiresAt)
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }

    public static boolean verify(String token){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer(Issuer).build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("认证通过：");
            System.out.println("userName:" + jwt.getClaim("userName").asString());
            System.out.println("过期时间： " + jwt.getExpiresAt());
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
