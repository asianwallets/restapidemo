package com.asianwallets.restapi.dto;

import java.math.BigDecimal;

/**
 * @description: Payment request DTO
 **/
public class PayOutRequestDTO {

    private String institutionBatchNo;

    private String institutionId;

    private String orderTime;

    private String orderNo;

    private String orderCurrency;

    private BigDecimal orderAmount;

    private String paymentCurrency;

    private BigDecimal paymentAmount;

    private String bankAccountName;

    private String bankAccountNumber;

    private String cardholder;

    private String serverUrl;

    private String browserUrl;

    private String issuerId;

    private String country;

    private String adress;

    private String description;

    public PayOutRequestDTO() {
    }

    public PayOutRequestDTO(String institutionBatchNo, String institutionId, String orderTime, String orderNo, String orderCurrency, BigDecimal orderAmount, String paymentCurrency, BigDecimal paymentAmount, String bankAccountName, String bankAccountNumber, String cardholder, String serverUrl, String browserUrl, String issuerId, String country, String adress, String description) {
        this.institutionBatchNo = institutionBatchNo;
        this.institutionId = institutionId;
        this.orderTime = orderTime;
        this.orderNo = orderNo;
        this.orderCurrency = orderCurrency;
        this.orderAmount = orderAmount;
        this.paymentCurrency = paymentCurrency;
        this.paymentAmount = paymentAmount;
        this.bankAccountName = bankAccountName;
        this.bankAccountNumber = bankAccountNumber;
        this.cardholder = cardholder;
        this.serverUrl = serverUrl;
        this.browserUrl = browserUrl;
        this.issuerId = issuerId;
        this.country = country;
        this.adress = adress;
        this.description = description;
    }

    public String getInstitutionBatchNo() {
        return institutionBatchNo;
    }

    public void setInstitutionBatchNo(String institutionBatchNo) {
        this.institutionBatchNo = institutionBatchNo;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
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

    public String getOrderCurrency() {
        return orderCurrency;
    }

    public void setOrderCurrency(String orderCurrency) {
        this.orderCurrency = orderCurrency;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getPaymentCurrency() {
        return paymentCurrency;
    }

    public void setPaymentCurrency(String paymentCurrency) {
        this.paymentCurrency = paymentCurrency;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getCardholder() {
        return cardholder;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
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

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
