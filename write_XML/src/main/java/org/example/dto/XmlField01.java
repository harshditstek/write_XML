package org.example.dto;

public class XmlField01 {
    private String cClaimSequence;
    private String cClaimNumber;
    private String cEnrolleeName;
    private String cEnrolleeLastName;
    private String cEnrolleeId;
    private String cPatientName;
    private String cProcessedDate;
    private String cGroupHierarchy1;
    private String cGroupHierarchy2;
    private String cProviderTaxId;
    private String cProviderName;
    private String cProviderAddress1;
    private String cProviderAddress2;
    private String cClaimRelationString;

    public XmlField01(String cClaimSequence, String cClaimNumber, String cEnrolleeName, String cEnrolleeLastName,
                      String cEnrolleeId, String cPatientName, String cProcessedDate, String cGroupHierarchy1, String cGroupHierarchy2,
                      String cProviderTaxId, String cProviderName, String cProviderAddress1, String cProviderAddress2, String cClaimRelationString){
        this.cClaimSequence = cClaimSequence;
        this.cClaimNumber = cClaimNumber;
        this.cEnrolleeName = cEnrolleeName;
        this.cEnrolleeLastName= cEnrolleeLastName;
        this.cEnrolleeId = cEnrolleeId;
        this.cPatientName = cPatientName;
        this.cProcessedDate = cProcessedDate;
        this.cGroupHierarchy1 = cGroupHierarchy1;
        this.cGroupHierarchy2 = cGroupHierarchy2;
        this.cProviderTaxId = cProviderTaxId;
        this.cProviderName = cProviderName;
        this.cProviderAddress1 = cProviderAddress1;
        this.cProviderAddress2 = cProviderAddress2;
        this.cClaimRelationString = cClaimRelationString;
    }

    public String getcClaimSequence() {
        return cClaimSequence;
    }

    public void setcClaimSequence(String cClaimSequence) {
        this.cClaimSequence = cClaimSequence;
    }

    public String getcClaimNumber() {
        return cClaimNumber;
    }

    public void setcClaimNumber(String cClaimNumber) {
        this.cClaimNumber = cClaimNumber;
    }

    public String getcEnrolleeName() {
        return cEnrolleeName;
    }

    public void setcEnrolleeName(String cEnrolleeName) {
        this.cEnrolleeName = cEnrolleeName;
    }

    public String getcEnrolleeLastName() {
        return cEnrolleeLastName;
    }

    public void setcEnrolleeLastName(String cEnrolleeLastName) {
        this.cEnrolleeLastName = cEnrolleeLastName;
    }

    public String getcEnrolleeId() {
        return cEnrolleeId;
    }

    public void setcEnrolleeId(String cEnrolleeId) {
        this.cEnrolleeId = cEnrolleeId;
    }

    public String getcPatientName() {
        return cPatientName;
    }

    public void setcPatientName(String cPatientName) {
        this.cPatientName = cPatientName;
    }

    public String getcProcessedDate() {
        return cProcessedDate;
    }

    public void setcProcessedDate(String cProcessedDate) {
        this.cProcessedDate = cProcessedDate;
    }

    public String getcGroupHierarchy1() {
        return cGroupHierarchy1;
    }

    public void setcGroupHierarchy1(String cGroupHierarchy1) {
        this.cGroupHierarchy1 = cGroupHierarchy1;
    }

    public String getcGroupHierarchy2() {
        return cGroupHierarchy2;
    }

    public void setcGroupHierarchy2(String cGroupHierarchy2) {
        this.cGroupHierarchy2 = cGroupHierarchy2;
    }

    public String getcProviderTaxId() {
        return cProviderTaxId;
    }

    public void setcProviderTaxId(String cProviderTaxId) {
        this.cProviderTaxId = cProviderTaxId;
    }

    public String getcProviderName() {
        return cProviderName;
    }

    public void setcProviderName(String cProviderName) {
        this.cProviderName = cProviderName;
    }

    public String getcProviderAddress1() {
        return cProviderAddress1;
    }

    public void setcProviderAddress1(String cProviderAddress1) {
        this.cProviderAddress1 = cProviderAddress1;
    }

    public String getcProviderAddress2() {
        return cProviderAddress2;
    }

    public void setcProviderAddress2(String cProviderAddress2) {
        this.cProviderAddress2 = cProviderAddress2;
    }

    public String getcClaimRelationString() {
        return cClaimRelationString;
    }

    public void setcClaimRelationString(String cClaimRelationString) {
        this.cClaimRelationString = cClaimRelationString;
    }
}
