package org.example.dto;

public class XmlField03 {

    private String cClaimSequence;
    private String cClaimNumber;
    private String cTotalCharge;
    private String cDiscount;
    private String cAllowed;
    private String cDeductible;
    private String cCopay;
    private String cCoinsurance;
    private String cPayment;
    private String cPatientResponsibility;
    private String cClaimRelationString;

    public XmlField03(String cClaimSequence, String cClaimNumber, String cTotalCharge, String cDiscount, String cAllowed, String cDeductible, String cCopay, String cCoinsurance, String cPayment, String cPatientResponsibility, String cClaimRelationString) {
        this.cClaimSequence = cClaimSequence;
        this.cClaimNumber = cClaimNumber;
        this.cTotalCharge = cTotalCharge;
        this.cDiscount = cDiscount;
        this.cAllowed = cAllowed;
        this.cDeductible = cDeductible;
        this.cCopay = cCopay;
        this.cCoinsurance = cCoinsurance;
        this.cPayment = cPayment;
        this.cPatientResponsibility = cPatientResponsibility;
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

    public String getcTotalCharge() {
        return cTotalCharge;
    }

    public void setcTotalCharge(String cTotalCharge) {
        this.cTotalCharge = cTotalCharge;
    }

    public String getcDiscount() {
        return cDiscount;
    }

    public void setcDiscount(String cDiscount) {
        this.cDiscount = cDiscount;
    }

    public String getcAllowed() {
        return cAllowed;
    }

    public void setcAllowed(String cAllowed) {
        this.cAllowed = cAllowed;
    }

    public String getcDeductible() {
        return cDeductible;
    }

    public void setcDeductible(String cDeductible) {
        this.cDeductible = cDeductible;
    }

    public String getcCopay() {
        return cCopay;
    }

    public void setcCopay(String cCopay) {
        this.cCopay = cCopay;
    }

    public String getcCoinsurance() {
        return cCoinsurance;
    }

    public void setcCoinsurance(String cCoinsurance) {
        this.cCoinsurance = cCoinsurance;
    }

    public String getcPayment() {
        return cPayment;
    }

    public void setcPayment(String cPayment) {
        this.cPayment = cPayment;
    }

    public String getcPatientResponsibility() {
        return cPatientResponsibility;
    }

    public void setcPatientResponsibility(String cPatientResponsibility) {
        this.cPatientResponsibility = cPatientResponsibility;
    }

    public String getcClaimRelationString() {
        return cClaimRelationString;
    }

    public void setcClaimRelationString(String cClaimRelationString) {
        this.cClaimRelationString = cClaimRelationString;
    }
}
