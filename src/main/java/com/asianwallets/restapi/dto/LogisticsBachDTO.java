package com.asianwallets.restapi.dto;

/**
 * Detailed Input Parameters of Batch Update Order Logistics Information
 */
public class LogisticsBachDTO {

    private String id;

    private String invoiceNo;

    private String providerName;

    private String payerAddress;

    private String remark;

    public LogisticsBachDTO(String id, String invoiceNo, String providerName, String payerAddress, String remark) {
        this.id = id;
        this.invoiceNo = invoiceNo;
        this.providerName = providerName;
        this.payerAddress = payerAddress;
        this.remark = remark;
    }

    public LogisticsBachDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getPayerAddress() {
        return payerAddress;
    }

    public void setPayerAddress(String payerAddress) {
        this.payerAddress = payerAddress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
