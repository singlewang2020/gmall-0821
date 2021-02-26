package com.atguigu.gmall.auth;

import com.atguigu.gmall.common.utils.JwtUtils;
import com.atguigu.gmall.common.utils.RsaUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    // 别忘了创建D:\\project\rsa目录
    private static final String pubKeyPath = "E:\\workspace\\project-0821\\rsa\\rsa.pub";
    private static final String priKeyPath = "E:\\workspace\\project-0821\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    @BeforeEach
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("id", "11");
        map.put("username", "liuyan");
        // 生成token
        String token = JwtUtils.generateToken(map, privateKey, 2);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6IjExIiwidXNlcm5hbWUiOiJsaXV5YW4iLCJleHAiOjE2MTQxNzAyMjV9.MUKbMdqWmV4A-_TVJom0kwxnL4nhzEE72Gf_47wn09rRdi6OLJ9xb7OPsduF6_mRVD2kObI83U0umIpxMQUQ8zMLIucJQHiNnB-fp1fCX5f1mOyfRM0OQatOb-9cpgIwnBZmTJnEyXo-Qjiwhrmy1xgb5-h_WaUYpRM7bjGBm2q15p_bxVvZdsd2cXG1ZZ-p24YfqFL_VV3ltsmHigLKH4R1eyFwl56Lgu_rugmvTjPMnoi25Z7ZDQ-npblB8WXKGh7OrtwXU5vhklBLCxIsz7d8mK2C00DC9FNGHP_CW_9tcFqljDbphImFRvKa-dosRE2TJlxZAOjwRCxEETLV3Q";

        // 解析token
        Map<String, Object> map = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + map.get("id"));
        System.out.println("userName: " + map.get("username"));
    }
}