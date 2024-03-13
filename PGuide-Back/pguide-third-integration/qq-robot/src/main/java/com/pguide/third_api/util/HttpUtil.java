package com.pguide.third_api.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author xiaoxiaoguai
 * @description http工具类
 * @since 2022/09/15 12:11
 */
public class HttpUtil {
    private static final CloseableHttpClient HTTP_CLIENT;

    static {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(100);
        cm.setDefaultMaxPerRoute(20);
        cm.setDefaultMaxPerRoute(50);
        HTTP_CLIENT = HttpClients.custom().setConnectionManager(cm).build();
    }

    public static String get(String url) {
        CloseableHttpResponse response = null;
        BufferedReader in;
        String result = "";
        try {
            HttpGet httpGet = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000).setConnectionRequestTimeout(30000).setSocketTimeout(30000).build();
            httpGet.setConfig(requestConfig);
            httpGet.setConfig(requestConfig);
            httpGet.addHeader("Content-type", "application/json; charset=utf-8");
            httpGet.setHeader("Accept", "application/json");
            response = HTTP_CLIENT.execute(httpGet);
            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder sb = new StringBuilder("");
            String line;
            String nL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line).append(nL);
            }
            in.close();
            result = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != response) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String post(String url, String jsonString) {
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        //解决中文乱码问题
        StringEntity entity = new StringEntity(jsonString, "utf-8");
        entity.setContentEncoding("utf-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        HttpResponse response;
        try {
            response = client.execute(httpPost);
            if(response.getStatusLine().getStatusCode() == 200){
                HttpEntity httpEntity = response.getEntity();
                return EntityUtils.toString(httpEntity, "utf-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}

