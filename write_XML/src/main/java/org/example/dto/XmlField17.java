package org.example.dto;

public class XmlField17 {

    private String cClaimSequence;
    private String cTotalCharge;
    private String cDiscount;
    private String cPayment;
    private String cPatientResponsibility;

    public XmlField17(String cClaimSequence, String cTotalCharge, String cDiscount, String cPayment, String cPatientResponsibility) {
        this.cClaimSequence = cClaimSequence;
        this.cTotalCharge = cTotalCharge;
        this.cDiscount = cDiscount;
        this.cPayment = cPayment;
        this.cPatientResponsibility = cPatientResponsibility;
    }

    public String getcClaimSequence() {
        return cClaimSequence;
    }

    public void setcClaimSequence(String cClaimSequence) {
        this.cClaimSequence = cClaimSequence;
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
}
