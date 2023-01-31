package org.wsn.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
//import org.wsn.entity.LoginUser;

import java.util.Date;

/**
 * @project:wsnblog
 * @file:TokenUtil
 * @author:wsn
 * @create:2023/1/18-10:50
 */
public class TokenUtil {
    private static final long EXPIRE_TIME= 10*60*60*1000;//token到期时间10小时
    private static final String TOKEN_SECRET="ljdyaishijin**3nkjnj??";  //密钥盐

    //生成token
//    public static String sign(LoginUser user){
//
//        String token=null;
//        try {
//            Date expireAt=new Date(System.currentTimeMillis()+EXPIRE_TIME);
//            token = JWT.create()
//                    .withIssuer("auth0")//发行人
//                    .withClaim("nickname",user.getNickname())//存放数据
//                    .withExpiresAt(expireAt)//过期时间
//                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
//        } catch (IllegalArgumentException | JWTCreationException je) {
//
//        }
//        return token;
//    }


    //验证token
    public static Boolean verify(String token){
        try {
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();//创建token验证器
            DecodedJWT decodedJWT=jwtVerifier.verify(token);
            System.out.println("认证通过：");
            System.out.println("nickname: " + decodedJWT.getClaim("nickname").asString());
            System.out.println("过期时间：      " + decodedJWT.getExpiresAt());
        } catch (IllegalArgumentException | JWTVerificationException e) {
            //抛出错误即为验证不通过
            return false;
        }
        return true;
    }

    public static int getUid(String token){
        try {
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();//创建token验证器
            DecodedJWT decodedJWT=jwtVerifier.verify(token);
            System.out.println("认证通过：");
            String id = decodedJWT.getClaim("id").asString();
            System.out.println("userId: " + decodedJWT.getClaim("id").asString());
            System.out.println("过期时间：      " + decodedJWT.getExpiresAt());
            return Integer.parseInt(id);
        } catch (IllegalArgumentException | JWTVerificationException e) {
            //抛出错误即为验证不通过
            return -1;
        }
    }
}
