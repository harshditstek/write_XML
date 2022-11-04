package org.example.dto;

public class XmlField07 {

    private String cClaimSequence;
    private String cAccumulatorDescription;
    private String cAmountMet;
    private String cAmountRemaining;
    private String cAmountToMeet;
    private String cClaimYear;
    private String cIndividual;
    private String cRelationshipToInsured;

    public XmlField07(String cClaimSequence, String cAccumulatorDescription, String cAmountMet, String cAmountRemaining, String cAmountToMeet, String cClaimYear, String cIndividual, String cRelationshipToInsured) {
        this.cClaimSequence = cClaimSequence;
        this.cAccumulatorDescription = cAccumulatorDescription;
        this.cAmountMet = cAmountMet;
        this.cAmountRemaining = cAmountRemaining;
        this.cAmountToMeet = cAmountToMeet;
        this.cClaimYear = cClaimYear;
        this.cIndividual = cIndividual;
        this.cRelationshipToInsured = cRelationshipToInsured;
    }

    public String getcClaimSequence() {
        return cClaimSequence;
    }

    public void setcClaimSequence(String cClaimSequence) {
        this.cClaimSequence = cClaimSequence;
    }

    public String getcAccumulatorDescription() {
        return cAccumulatorDescription;
    }

    public void setcAccumulatorDescription(String cAccumulatorDescription) {
        this.cAccumulatorDescription = cAccumulatorDescription;
    }

    public String getcAmountMet() {
        return cAmountMet;
    }

    public void setcAmountMet(String cAmountMet) {
        this.cAmountMet = cAmountMet;
    }

    public String getcAmountRemaining() {
        return cAmountRemaining;
    }

    public void setcAmountRemaining(String cAmountRemaining) {
        this.cAmountRemaining = cAmountRemaining;
    }

    public String getcAmountToMeet() {
        return cAmountToMeet;
    }

    public void setcAmountToMeet(String cAmountToMeet) {
        this.cAmountToMeet = cAmountToMeet;
    }

    public String getcClaimYear() {
        return cClaimYear;
    }

    public void setcClaimYear(String cClaimYear) {
        this.cClaimYear = cClaimYear;
    }

    public String getcIndividual() {
        return cIndividual;
    }

    public void setcIndividual(String cIndividual) {
        this.cIndividual = cIndividual;
    }

    public String getcRelationshipToInsured() {
        return cRelationshipToInsured;
    }

    public void setcRelationshipToInsured(String cRelationshipToInsured) {
        this.cRelationshipToInsured = cRelationshipToInsured;
    }
}
