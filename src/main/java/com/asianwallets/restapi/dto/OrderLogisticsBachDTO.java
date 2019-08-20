package com.asianwallets.restapi.dto;

import java.util.List;

/**
 * Batch Update Order Logistics Information Input Parameters
 */

public class OrderLogisticsBachDTO {

    List<LogisticsBachDTO> logisticsBachDTOs;

    private String signType;

    private String institutionId;

    private String sign;

    public OrderLogisticsBachDTO(List<LogisticsBachDTO> logisticsBachDTOs, String signType, String institutionId, String sign) {
        this.logisticsBachDTOs = logisticsBachDTOs;
        this.signType = signType;
        this.institutionId = institutionId;
        this.sign = sign;
    }

    public OrderLogisticsBachDTO() {
    }

    public List<LogisticsBachDTO> getLogisticsBachDTOs() {
        return logisticsBachDTOs;
    }

    public void setLogisticsBachDTOs(List<LogisticsBachDTO> logisticsBachDTOs) {
        this.logisticsBachDTOs = logisticsBachDTOs;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
