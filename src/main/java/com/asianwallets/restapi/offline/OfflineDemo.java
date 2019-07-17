package com.asianwallets.restapi.offline;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.asianwallets.restapi.dto.OfflineLoginDTO;
import com.asianwallets.restapi.dto.PlaceOrderDTO;
import com.asianwallets.restapi.utils.HttpClientUtils;
import com.asianwallets.restapi.vo.HttpResponse;
import com.asianwallets.restapi.utils.SignUtils;

/**
 * Offline trading demo
 * The input parameters of this demo call API are required parameters.
 * Please refer to the offline documentation for non-required parameters of API
 * We offline document address:  https://pag.asianwallets.com/api/offline/zh-cn/
 *
 * @Author red
 * @Date: 2019/7/17 10:55
 * @Description: Offline trading demo
 */
public class OfflineDemo {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String MD5KEY = "";

    public static void main(String[] args) {
        //First you need to call the login interface to get the token
        OfflineLoginDTO offlineLoginDTO = new OfflineLoginDTO();
        //Your merchant number
        offlineLoginDTO.setInstitutionId("");
        //Your terminal number
        offlineLoginDTO.setTerminalId("");
        //Your operator id
        offlineLoginDTO.setOperatorId("");
        //Your password
        offlineLoginDTO.setPassword("");
        //Just log in once and save the token in your cache
        String token = login(offlineLoginDTO);

        //Next You can then invoke the offline trading interface,as shown here invoking the offline CSB interface
        PlaceOrderDTO placeOrderDTO = new PlaceOrderDTO();
        //Your merchant number
        placeOrderDTO.setInstitutionId("");
        //Your terminal number
        placeOrderDTO.setTerminalId("");
        //Your operator id
        placeOrderDTO.setOperatorId("");
        //The order currency
        placeOrderDTO.setOrderCurrency("");
        //The order time
        placeOrderDTO.setOrderTime(sdf.format(new Date()));
        //The order number
        placeOrderDTO.setOrderNo("");
        //The order amount
        placeOrderDTO.setOrderAmount(new BigDecimal("1"));
        //The product code
        placeOrderDTO.setProductCode(19);
        //The token obtained by calling the login interface
        placeOrderDTO.setToken(token);
        //Create signature,Please find your md5key in the merchant backstage
        String sign = SignUtils.createOfflineSign(placeOrderDTO, MD5KEY);
        placeOrderDTO.setSign(sign);
        //In response to the results
        String response = offlineCSB(placeOrderDTO);
    }

    /**
     * Offline login
     *
     * @return token
     */
    public static String login(OfflineLoginDTO offlineLoginDTO) {
        //Post requests are sent using HTTP,and the request header sets the content-type to application/json
        HttpResponse httpResponse = HttpClientUtils.reqPost("https://pag.asianwallets.com/aw/auth/terminalLogin", offlineLoginDTO, null);
        JSONObject response = httpResponse.getJsonObject();
        System.out.println("login response:" + response.toJSONString());
        JSONObject data = response.getJSONObject("data");
        return data.getString("token");
    }

    /**
     * Offline CSB code scanning transactions
     *
     * @return QrCode
     */
    public static String offlineCSB(PlaceOrderDTO placeOrderDTO) {
        //Post requests are sent using HTTP,and the request header sets the content-type to application/json
        HttpResponse httpResponse = HttpClientUtils.reqPost("https://pag.asianwallets.com/tra/trade/csbScan", placeOrderDTO, null);
        JSONObject response = httpResponse.getJsonObject();
        System.out.println("csb response:" + response.toJSONString());
        return response.toJSONString();
    }
}
