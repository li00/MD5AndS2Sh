package com.lzf.s2shMD5.util;

import java.security.MessageDigest;

/**
 * Created by Administrator on 2017/3/19.
 */
public class MD5 {

    public static String md5(String password,String token){
        String pwd ="";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] b = md.digest(password.getBytes());
            for (byte bt:b){
               String s = Integer.toHexString((token.hashCode()+bt+12/5+19) & 0xf);
                pwd +=s;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return pwd;
    }
}
