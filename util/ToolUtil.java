package com.baiwang.bophttpapi.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.*;

public class ToolUtil {

    /**
     * 获取token请求URL
     * 注：获取后，可发送HTTP请求获取token
     * @return
     */
    public static String getTokenRequestURL(String appkey,String appSecret,String userName,String password,String userSalt,String url)
    {
        Long time = new Date().getTime()
                ;
        StringBuilder sburl = new StringBuilder(url);
        sburl.append("?method=baiwang.oauth.token");
        sburl.append("&username="+userName);
        sburl.append("&password="+getUuidPasswd(password, userSalt));
        sburl.append("&client_id="+appkey);
        sburl.append("&client_secret="+appSecret);
        sburl.append("&grant_type=password");
        sburl.append("&version=2.1");
        sburl.append("&timestamp="+time);
        return sburl.toString();
    }

    /**
     * 获取请求路径
     * @param url
     * @param apiName
     * @param appKey
     * @param appSecret
     * @param token
     * @return
     */
    public static String getAPIRequestURL(String url, String apiName,String appKey,String appSecret,String token,String body)
    {
        // 添加协议级请求参数
        long time = new Date().getTime();
        StringBuilder sburl = new StringBuilder(url);
        sburl.append("?method="+apiName);
        sburl.append("&version=2.1");
        sburl.append("&appKey="+appKey);
        sburl.append("&format=json");
        sburl.append("&timestamp="+time);
        sburl.append("&token="+token);
        sburl.append("&type=sync");
        // 添加签名参数
        try
        {
            Map textParams = new HashMap();
            // 添加协议级请求参数
            textParams.put("method", apiName);
            textParams.put("version", "2.1");
            textParams.put("appKey", appKey);
            textParams.put("format", "json");
            textParams.put("timestamp", time+"");
            textParams.put("token", token);
            textParams.put("type", "sync");
            sburl.append("&sign="+signTopRequest(textParams, appSecret, body));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sburl.toString();
    }

    /**
     * 给BOP请求签名。
     *
     * @param params 所有字符型的BOP请求参数
     * @param secret 签名密钥
     * @param body 请求业务JSON数据
     * @return 签名
     */
    public static String signTopRequest(Map<String, String> params, String secret, String body) throws IOException
    {
        // 第一步：检查参数是否已经排序
        ArrayList<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        // 第二步：把所有参数名和参数值串在一起
        StringBuilder query = new StringBuilder();
        query.append(secret);
        for (String key : keys)
        {
            String value = params.get(key);
            if (!StrUtils.isEmpty(key) && !StrUtils.isEmpty(value))
            {
                query.append(key).append(value);
            }
        }
        body.replaceAll("\n","");
        body.replaceAll("\t","");
        body.replaceAll("\r","");
        query.append(body);
        query.append(secret);
        // 第三步：使用MD5加密
        byte[] bytes;
        MessageDigest md5 = null;
        try
        {
            md5 = MessageDigest.getInstance("MD5");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        bytes = md5.digest(query.toString().getBytes("UTF-8"));
        // 第四步：把二进制转化为大写的十六进制
        StringBuilder sign = new StringBuilder();
        for (byte b : bytes)
        {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1)
            {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }

    public static String getUuidPasswd(String passwd, String uuid) {
        if (!StrUtils.isEmpty(uuid)) {
            return Encrypt.md5AndSha(passwd + uuid);
        } else {
            return Encrypt.md5AndSha(passwd);
        }
    }

}
