package com.asianwallets.restapi.online;

import com.alibaba.fastjson.JSONObject;
import com.asianwallets.restapi.dto.PlaceOrderDTO;
import com.asianwallets.restapi.utils.HttpClientUtils;
import com.asianwallets.restapi.utils.SignUtils;
import com.asianwallets.restapi.vo.HttpResponse;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Online trading demo
 * The input parameters of this demo call API are required parameters.
 * Please refer to the online documentation for non-required parameters of API
 * We online document address:  https://pag.asianwallets.com/api/zh-cn/
 *
 * @Author blue
 * @Date: 2019/7/17 10:55
 * @Description: Online trading demo
 */
public class OnlineDemo {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //Here is the private key that needs to be the merchant
    private static final String RSA_PRIVATE_KEY = "";

    public static void main(String[] args) {
        //You can then invoke the online trading interface
        PlaceOrderDTO placeOrderDTO = new PlaceOrderDTO();
        //Your merchant number
        placeOrderDTO.setInstitutionId("");
        //The order currency
        placeOrderDTO.setOrderCurrency("");
        //The issuerId
        placeOrderDTO.setIssuerId("");
        //The product name
        placeOrderDTO.setProductName("");
        //The order time
        placeOrderDTO.setOrderTime(sdf.format(new Date()));
        //The order number
        placeOrderDTO.setOrderNo("");
        //The order amount
        placeOrderDTO.setOrderAmount(new BigDecimal("1"));
        //The product code
        placeOrderDTO.setProductCode(1);
        //The sign type
        placeOrderDTO.setSignType("");
        //The server url
        placeOrderDTO.setServerUrl("http://xxx");
        //The payer email
        placeOrderDTO.setPayerEmail("");
        //Create signature
        String sign = SignUtils.createOnelineSign(placeOrderDTO, RSA_PRIVATE_KEY);
        placeOrderDTO.setSign(sign);
        //In response to the results
        String response = onlineTrade(placeOrderDTO);
    }

    /**
     * online transactions
     *
     * @return form
     */
    public static String onlineTrade(PlaceOrderDTO placeOrderDTO) {
        //Post requests are sent using HTTP,and the request header sets the content-type to application/json
        HttpResponse httpResponse = HttpClientUtils.reqPost("https://pag.asianwallets.com/tra/onlineacquire/gateway", placeOrderDTO, null);
        JSONObject response = httpResponse.getJsonObject();
        System.out.println("online trade response:" + response.toJSONString());
        return response.toJSONString();
    }
}
