package com.asianwallets.restapi.utils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.asianwallets.restapi.vo.HttpResponse;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


/**
 * HTTP invokes the client
 *
 * @Author red
 * @Date: 2019/7/17 10:55
 * @Description: HTTP invokes the client
 */
public class HttpClientUtils {

    private static final Logger log = LoggerFactory.getLogger(HttpClientUtils.class);

    /**
     * post request
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
            } else {
                httpResponse.setHttpStatus(httpStatus);
                return httpResponse;
            }
        } catch (Exception e) {
            log.error("[HttpClientUtils-reqPost]==>异常：{}", e.getMessage());
        }
        return httpResponse;
    }


}
