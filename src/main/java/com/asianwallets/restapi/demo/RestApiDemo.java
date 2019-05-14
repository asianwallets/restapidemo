package com.asianwallets.restapi.demo;


import com.asianwallets.restapi.other.DemoDTO;
import com.asianwallets.restapi.other.HttpClientUtils;
import com.asianwallets.restapi.other.HttpResponse;

public class RestApiDemo {
    public static void main(String[] args) {
        //构建请求参数
        DemoDTO demoDTO = new DemoDTO();
        //请求URL，获取响应数据
        HttpResponse httpResponse = HttpClientUtils.reqPost("http://xxxx.xx", demoDTO, null);
    }
}
