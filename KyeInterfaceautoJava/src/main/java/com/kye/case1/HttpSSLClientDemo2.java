package com.kye.case1;

import com.sun.istack.internal.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpSSLClientDemo2 {

    public static String postWithJSON() throws Exception {
        HttpPost post = new HttpPost("http://cas-uat.kye-erp.com/cas_server/v2/oauth/token");
        CloseableHttpClient client = HttpClients.createDefault();
        String responseBody = null;//响应体
        String param = "{\"password\":\"UfXY0Jp0bo+1AA+kXrgarIKO8Kpt4PBi/7o+6kZ6GeRt76xlUko4v2BpRMUiLEZaGcYPT9cVPBPTsy5gCOKDYRgeOvP//qjUUIbEQ+HBJbHfwJBN4CUVdggQgUOslhr6h6BzP6xrON3h5lHzTZKYqXoOwQGS1k5ez0u77Yh7WeI\\u003d\",\"temp_device\":\"false\",\"device_id\":\"ffffffff-e3a2-658c-0000-0000463f2bf8\",\"device_ip\":\"10.32.73.204\",\"encryption\":\"true\",\"device_model\":\"HLTE200T\",\"app_id\":\"tVEkqtdCfN_wiu180fQ0Hg\\u003d\\u003d\",\"account\":\"581424\",\"device_brand\":\"Hisense\",\"grant_type\":\"password\"}";
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
