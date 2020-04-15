package com.kye.case1;

import com.kye.util.EncryDecryption;
import com.sun.istack.internal.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class HttpSSLClientDemo2 {

    public static String postWithJSON() throws Exception {
        //获取properties内容
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/userpass.properties"));
        //调用解密方法
        EncryDecryption encryDecryption=new EncryDecryption();
        String password=encryDecryption.decrypt(prop.get("userpass")+"");
       // System.out.println(password);
        //
        HttpPost post = new HttpPost("http://cas-uat.kye-erp.com/cas_server/v2/oauth/token");
        CloseableHttpClient client = HttpClients.createDefault();
        String responseBody = null;//响应体
        String param = password;
        StringEntity entity = new StringEntity(param,"utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        if(response.getStatusLine().getStatusCode() == 200) {
            HttpEntity he = response.getEntity();
            responseBody = EntityUtils.toString(he,"UTF-8");
        }
        return responseBody;
    }

    public static void main(String[] args) throws Exception {
        String result = postWithJSON();
        System.out.println(result);
    }
}
