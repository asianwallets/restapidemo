package com.asianwallets.restapi.dto;


import java.math.BigDecimal;

/**
 * Input parameters for  Place Order
 *
 * @Author red
 * @Date: 2019/7/17 10:55
 * @Description: Input parameters for  Place Order
 */
public class PlaceOrderDTO {

    private String institutionId;

    private String orderCurrency;

    private String orderTime;

    private String orderNo;

    private BigDecimal orderAmount;

    private String sign;

    private Integer productCode;

    private String token;

    private String issuerId;

    private String authCode;

    private String terminalId;

    private String operatorId;

    private String serverUrl;

    private String browserUrl;

    private String tradeCurrency;

    private String signType;

    private String institutionName;

    private String subInstitutionName;

    private String subInstitutionCode;

    private String productName;

    private String productDescription;

    private String payerName;

    private String payerAccount;

    private String payerBank;

    private String payerEmail;

    private String payerPhone;

    private String remark1;

    private String remark2;

    private String remark3;

    private String language;

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getOrderCurrency() {
        return orderCurrency;
    }

    public void setOrderCurrency(String orderCurrency) {
        this.orderCurrency = orderCurrency;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getBrowserUrl() {
        return browserUrl;
    }

    public void setBrowserUrl(String browserUrl) {
        this.browserUrl = browserUrl;
    }

    public String getTradeCurrency() {
        return tradeCurrency;
    }

    public void setTradeCurrency(String tradeCurrency) {
        this.tradeCurrency = tradeCurrency;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getSubInstitutionName() {
        return subInstitutionName;
    }

    public void setSubInstitutionName(String subInstitutionName) {
        this.subInstitutionName = subInstitutionName;
    }

    public String getSubInstitutionCode() {
        return subInstitutionCode;
    }

    public void setSubInstitutionCode(String subInstitutionCode) {
        this.subInstitutionCode = subInstitutionCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerAccount() {
        return payerAccount;
    }

    public void setPayerAccount(String payerAccount) {
        this.payerAccount = payerAccount;
    }

    public String getPayerBank() {
        return payerBank;
    }

    public void setPayerBank(String payerBank) {
        this.payerBank = payerBank;
    }

    public String getPayerEmail() {
        return payerEmail;
    }

    public void setPayerEmail(String payerEmail) {
        this.payerEmail = payerEmail;
    }

    public String getPayerPhone() {
        return payerPhone;
    }

    public void setPayerPhone(String payerPhone) {
        this.payerPhone = payerPhone;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "OfflineDemoDTO{" +
                "institutionId='" + institutionId + '\'' +
                ", orderCurrency='" + orderCurrency + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", orderAmount=" + orderAmount +
                ", sign='" + sign + '\'' +
                ", productCode=" + productCode +
                ", token='" + token + '\'' +
                ", issuerId='" + issuerId + '\'' +
                ", authCode='" + authCode + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", serverUrl='" + serverUrl + '\'' +
                ", browserUrl='" + browserUrl + '\'' +
                ", tradeCurrency='" + tradeCurrency + '\'' +
                ", signType='" + signType + '\'' +
                ", institutionName='" + institutionName + '\'' +
                ", subInstitutionName='" + subInstitutionName + '\'' +
                ", subInstitutionCode='" + subInstitutionCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", payerName='" + payerName + '\'' +
                ", payerAccount='" + payerAccount + '\'' +
                ", payerBank='" + payerBank + '\'' +
                ", payerEmail='" + payerEmail + '\'' +
                ", payerPhone='" + payerPhone + '\'' +
                ", remark1='" + remark1 + '\'' +
                ", remark2='" + remark2 + '\'' +
                ", remark3='" + remark3 + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    public PlaceOrderDTO() {
    }


}
