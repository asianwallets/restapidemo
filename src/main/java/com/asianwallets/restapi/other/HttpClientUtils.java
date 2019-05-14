package com.asianwallets.restapi.other;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.security.KeyStore;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


/**
 *
 * @version v1.0.0
 * @classDesc: 功能描述: HTTP 请求客户端
 * @createTime 2018年7月10日 上午10:43:39
 * @copyright: 上海众哈网络技术有限公司
 */

public class HttpClientUtils {

    private static final Logger log = LoggerFactory.getLogger(HttpClientUtils.class);

    /**
     * get请求
     */
    public static JSONObject reqGet(String url, Map<String, Object> params, Map<String, Object> headMap) {
        HttpClient client = new HttpClient();
        if (params != null && params.size() > 0) {
            url += "?";
            for (Entry<String, Object> entry : params.entrySet()) {
                url += entry.getKey() + "=" + entry.getValue() + "&";
            }
        }

        log.info(String.format("[HttpClientUtils-reqGet]==>请求参数, url: %s, params: %s, headMap: %s", url, params, headMap));
        GetMethod method = new GetMethod(url);
        method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        method.addRequestHeader("Content-Type", "application/json");
        if (headMap != null && headMap.size() > 0) {
            for (Entry<String, Object> entry : headMap.entrySet()) {
                method.addRequestHeader(entry.getKey(), entry.getValue().toString());
            }
        }
        try {
            int httpStatus = client.executeMethod(method);
            InputStream stream = method.getResponseBodyAsStream();
            byte[] cache = new byte[1024];
            int length = -1;
            StringBuffer sb = new StringBuffer("");
            while ((length = stream.read(cache)) != -1) {
                sb.append(new String(cache, 0, length));
            }
            stream.close();
            log.info("[HttpClientUtils-reqGet]==> httpStatus:{},response::{}", httpStatus, sb);
            if (httpStatus == HttpStatus.SC_OK) {
                JSONObject retJson = JSONObject.parseObject(sb.toString());
                return retJson;
            }
        } catch (HttpException e) {
            log.error("[HttpClientUtils-reqGet]==>异常：{}", e.getMessage());
        } catch (IOException e) {
            log.error("[HttpClientUtils-reqGet]==>异常：{}", e.getMessage());
        }
        return null;
    }

    /**
     * post请求
     */
    @SuppressWarnings("deprecation")
    public static HttpResponse reqPost(String url, Object params, Map<String, Object> headMap) {
        HttpResponse httpResponse = new HttpResponse();
        HttpClient client = new HttpClient();
        log.info("HttpClientUtils-reqPost]==>请求参数, url: {}, params: {}, headMap: {}", url, params, headMap);

        try {
            PostMethod method = new PostMethod(url);
            method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
            method.addRequestHeader("Content-Type", "application/json");
            if (headMap != null && headMap.size() > 0) {
                for (Entry<String, Object> entry : headMap.entrySet()) {
                    method.addRequestHeader(entry.getKey(), entry.getValue().toString());
                }
            }
            if (params != null) {
                if (params instanceof List<?>) {
                    method.setRequestBody(JSONArray.toJSON(params).toString());
                } else {
                    method.setRequestBody(JSONObject.toJSON(params).toString());
                }
            }
            int httpStatus = client.executeMethod(method);
            InputStream stream = method.getResponseBodyAsStream();
            byte[] cache = new byte[1024];
            int length = -1;
            StringBuffer sb = new StringBuffer("");
            while ((length = stream.read(cache)) != -1) {
                sb.append(new String(cache, 0, length));
            }
            stream.close();
            log.info("[HttpClientUtils-reqPost]==> httpStatus:{},response::{}", httpStatus, sb);
            if (httpStatus == HttpStatus.SC_OK) {
                JSONObject retJson = JSONObject.parseObject(sb.toString());
                httpResponse.setHttpStatus(httpStatus);
                httpResponse.setJsonObject(retJson);
                return httpResponse;
            }else{
                httpResponse.setHttpStatus(httpStatus);
                return httpResponse;
            }
        } catch (HttpException e) {
            log.error("[HttpClientUtils-reqPost]==>异常：{}", e.getMessage());
        } catch (IOException e) {
            log.error("[HttpClientUtils-reqPost]==>异常：{}", e.getMessage());
        }
        return httpResponse;
    }

    /**
     * reqFormData
     */
    public static JSONObject reqFormData(String url, Map<String, Object> params, Map<String, Object> headMap) {
        PostMethod post = new PostMethod();
        post.addRequestHeader("Content-Type", "application/json");
        try {
            NameValuePair[] pairs = new NameValuePair[params.size()];          //设置FORM表单里各项内容
            if (headMap != null && headMap.size() > 0) {
                int i = 0;
                for (Entry<String, Object> entry : headMap.entrySet()) {
                    pairs[i] = new NameValuePair(entry.getKey(), entry.getValue().toString());
                    i++;
                }
            }
            post.setRequestBody(pairs);                           //将设置好的表单提交上去
            HttpClient client = new HttpClient();
            int httpStatus = client.executeMethod(post);                      //执行，模拟POST方法提交到服务器
            InputStream stream = post.getResponseBodyAsStream();
            byte[] cache = new byte[1024];
            int length = -1;
            StringBuffer sb = new StringBuffer("");
            while ((length = stream.read(cache)) != -1) {
                sb.append(new String(cache, 0, length));
            }
            stream.close();
            log.info("[HttpClientUtils-reqPost]==> httpStatus:{},response::{}", httpStatus, sb);
            if (httpStatus == HttpStatus.SC_OK) {
                JSONObject retJson = JSONObject.parseObject(sb.toString());
                return retJson;
            }
        } catch (HttpException e) {
            log.error("[HttpClientUtils-reqPost]==>异常：{}", e.getMessage());
        } catch (IOException e) {
            log.error("[HttpClientUtils-reqPost]==>异常：{}", e.getMessage());
        }
        return null;
    }


    /**
     * put请求
     */
    @SuppressWarnings("deprecation")
    public static JSONObject reqPut(String url, Object params, Map<String, Object> headMap) {
        HttpClient client = new HttpClient();
        log.info(String.format("HttpClientUtils-reqPut]==>请求参数, url: %s, params: %s, headMap: %s", url, params, headMap));

        try {
            PutMethod method = new PutMethod(url);
            method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
            method.addRequestHeader("Content-Type", "application/json");
            if (headMap != null && headMap.size() > 0) {
                for (Entry<String, Object> entry : headMap.entrySet()) {
                    method.addRequestHeader(entry.getKey(), entry.getValue().toString());
                }
            }
            if (params != null) {
                if (params instanceof List<?>) {
                    method.setRequestBody(JSONArray.toJSON(params).toString());
                } else {
                    method.setRequestBody(JSONObject.toJSON(params).toString());
                }
            }
            int httpStatus = client.executeMethod(method);
            InputStream stream = method.getResponseBodyAsStream();
            byte[] cache = new byte[1024];
            int length = -1;
            StringBuffer sb = new StringBuffer("");
            while ((length = stream.read(cache)) != -1) {
                sb.append(new String(cache, 0, length));
            }
            stream.close();
            log.info("[HttpClientUtils-reqPut]==> httpStatus:{},response::{}", httpStatus, sb);
            if (httpStatus == HttpStatus.SC_OK) {
                JSONObject retJson = JSONObject.parseObject(sb.toString());
                return retJson;
            }
        } catch (HttpException e) {
            log.error("[HttpClientUtils-reqPut]==>异常：{}", e.getMessage());
        } catch (IOException e) {
            log.error("[HttpClientUtils-reqPut]==>异常：{}", e.getMessage());
        }
        return null;
    }

    /**
     * delete请求
     */
    public static JSONObject reqDelete(String url, Map<String, Object> params, Map<String, Object> headMap) {

        HttpClient client = new HttpClient();
        if (params != null && params.size() > 0) {
            url += "?";
            for (Entry<String, Object> entry : params.entrySet()) {
                url += entry.getKey() + "=" + entry.getValue() + "&";
            }
        }

        log.info(String.format("HttpClientUtils-reqDelete]==>请求参数, url: %s, params: %s, headMap: %s", url, params, headMap));
        DeleteMethod method = new DeleteMethod(url);
        method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        method.addRequestHeader("Content-Type", "application/json");
        if (headMap != null && headMap.size() > 0) {
            for (Entry<String, Object> entry : headMap.entrySet()) {
                method.addRequestHeader(entry.getKey(), entry.getValue().toString());
            }
        }
        try {
            int httpStatus = client.executeMethod(method);
            InputStream stream = method.getResponseBodyAsStream();
            byte[] cache = new byte[1024];
            int length = -1;
            StringBuffer sb = new StringBuffer("");
            while ((length = stream.read(cache)) != -1) {
                sb.append(new String(cache, 0, length));
            }
            stream.close();
            log.info("[HttpClientUtils-reqDelete]==> httpStatus:{},response::{}", httpStatus, sb);
            if (httpStatus == HttpStatus.SC_OK) {
                JSONObject retJson = JSONObject.parseObject(sb.toString());
                return retJson;
            }
        } catch (HttpException e) {
            log.error("[HttpClientUtils-reqDelete]==>异常：{}", e.getMessage());
        } catch (IOException e) {
            log.error("[HttpClientUtils-reqDelete]==>异常：{}", e.getMessage());
        }
        return null;
    }

    @SuppressWarnings("deprecation")
    public static String reqPostWithCA(String url, String xml, String filePath, String secondMchId) throws Exception {

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        FileInputStream instream = new FileInputStream(new File(filePath));
        try {
            keyStore.load(instream, secondMchId.toCharArray());
        } finally {
            instream.close();
        }

        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, secondMchId.toCharArray()).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        try {

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new StringEntity(xml, "utf-8"));
            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent(), "utf-8"));
                    StringBuffer retSb = new StringBuffer("");
                    String text;
                    while ((text = bufferedReader.readLine()) != null) {
                        retSb.append(text);
                    }
                    return retSb.toString();
                }
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
        return null;
    }

}
