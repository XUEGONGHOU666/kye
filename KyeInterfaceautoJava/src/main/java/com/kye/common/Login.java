package com.kye.common;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.testng.annotations.Test;

import javax.xml.stream.events.EntityDeclaration;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Login {
    public static void main(String[] args) throws IOException {
        HttpGet httpGet=new HttpGet("https://api.jisuapi.com/shouji/query?appkey=ab497b6a513101df&shouji=17875469790");
        CloseableHttpClient httpclient=HttpClients.createDefault();
        HttpResponse httpResponse=httpclient.execute(httpGet);
        HttpEntity httpEntity=httpResponse.getEntity();
        String hps=EntityUtils.toString(httpEntity);
        System.out.println(hps);
        //json格式
        com.alibaba.fastjson.JSONObject tk=com.alibaba.fastjson.JSON.parseObject(hps);
        System.out.println(tk);
    }
    @Test
    public void posttest() throws IOException {
        String url="https://www.jisuapi.com/my/login.php";
        HttpPost httppost=new HttpPost(url);
        //添加请求头
        httppost.setHeader("Content-Type","application/x-www-form-urlencoded");
        //请求内容
        List<NameValuePair> parameters=new ArrayList<>();
        //parameters.add(new BasicNameValuePair("",""));
        parameters.add(new BasicNameValuePair("password","Aa123456"));
        parameters.add(new BasicNameValuePair("mobile","17875469790"));
        parameters.add(new BasicNameValuePair("act","login"));
        parameters.add(new BasicNameValuePair("password","Aa123456"));
        parameters.add(new BasicNameValuePair("rtype","json"));
        HttpEntity httpEntity=new UrlEncodedFormEntity(parameters);
        httppost.setEntity(httpEntity);
        CloseableHttpClient httpclient=HttpClients.createDefault();
        CloseableHttpResponse response=httpclient.execute(httppost);
        HttpEntity httpEntity1=response.getEntity();
        String  httpEntity1String=EntityUtils.toString(httpEntity1);
        System.out.println(httpEntity1String);

    }

}
