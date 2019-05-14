package com.asianwallets.restapi.other;

import com.alibaba.fastjson.JSONObject;

/**
 * @description:
 * @author: YangXu
 * @create: 2019-03-20 17:10
 **/

public class HttpResponse {

    public JSONObject jsonObject;
    public Integer httpStatus;

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
