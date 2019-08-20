package com.asianwallets.restapi.dto;

import java.util.List;

/**
 * @description: Payment list request
 **/
public class PayOutDTO {

    private List<PayOutRequestDTO> payOutRequestDTOs;

    private String signType;

    private String sign;


    public PayOutDTO(List<PayOutRequestDTO> payOutRequestDTOs, String signType, String sign) {
        this.payOutRequestDTOs = payOutRequestDTOs;
        this.signType = signType;
        this.sign = sign;
    }

    public PayOutDTO() {
    }

    public List<PayOutRequestDTO> getPayOutRequestDTOs() {
        return payOutRequestDTOs;
    }

    public void setPayOutRequestDTOs(List<PayOutRequestDTO> payOutRequestDTOs) {
        this.payOutRequestDTOs = payOutRequestDTOs;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
