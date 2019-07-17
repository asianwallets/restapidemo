package com.asianwallets.restapi.dto;

/**
 * Input parameters for offline login
 *
 * @Author red
 * @Date: 2019/7/17 10:55
 * @Description: Input parameters for offline login
 */
public class OfflineLoginDTO {

    private String institutionId;

    private String terminalId;

    private String operatorId;

    private String password;

    private String language;

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "OfflineLoginDTO{" +
                "institutionId='" + institutionId + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", password='" + password + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    public OfflineLoginDTO() {
    }
}
