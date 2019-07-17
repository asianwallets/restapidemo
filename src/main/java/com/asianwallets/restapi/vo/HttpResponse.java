package com.asianwallets.restapi.vo;

import com.alibaba.fastjson.JSONObject;

/**
 * In response to the results
 *
 * @Author red
 * @Date: 2019/7/17 10:55
 * @Description: In response to the results
 */
public class HttpResponse {

    private JSONObject jsonObject;
    private Integer httpStatus;

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }
}
