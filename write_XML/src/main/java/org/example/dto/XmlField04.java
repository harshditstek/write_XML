package org.example.dto;

public class XmlField04 {

    private String cClaimSequence;
    private String cClaimNumber;
    private String cLineNumbers;
    private String cDescription;

    public XmlField04(String cClaimSequence, String cClaimNumber, String cLineNumbers, String cDescription) {
        this.cClaimSequence = cClaimSequence;
        this.cClaimNumber = cClaimNumber;
        this.cLineNumbers = cLineNumbers;
        this.cDescription = cDescription;
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

    public String getcLineNumbers() {
        return cLineNumbers;
    }

    public void setcLineNumbers(String cLineNumbers) {
        this.cLineNumbers = cLineNumbers;
    }

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription;
    }
}
