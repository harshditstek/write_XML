package org.example.record;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Record02 {

    public static Element getRecord02(Document doc) {
        Element record01 = doc.createElement("record");
        Attr attrType = doc.createAttribute("recordType");
        attrType.setValue(String.valueOf("02"));
        record01.setAttributeNode(attrType);

        Element field01 = doc.createElement("field");
        field01.setAttribute("fieldName", "cClaimSequence");
        field01.setTextContent(" ");
        record01.appendChild(field01);

        Element field2 = doc.createElement("field");
        field2.setAttribute("fieldName", "cClaimNumber");
        field2.setTextContent(" ");
        record01.appendChild(field2);

        Element field3 = doc.createElement("field");
        field3.setAttribute("fieldName", "cServiceLineSequence");
        field3.setTextContent(" ");
        //field3.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        record01.appendChild(field3);

        Element field4 = doc.createElement("field");
        field4.setAttribute("fieldName", "cLineNumber");
        field4.setTextContent(" ");
        record01.appendChild(field4);

        Element field5 = doc.createElement("field");
        field5.setAttribute("fieldName", "cProcedureCode");
        field5.setTextContent(" ");
        record01.appendChild(field5);

        Element field6 = doc.createElement("field");
        field6.setAttribute("fieldName", "cPlaceofService");
        field6.setTextContent(" ");
        record01.appendChild(field6);

        Element field7 = doc.createElement("field");
        field7.setAttribute("fieldName", "cUnits");
        field7.setTextContent("I");
        record01.appendChild(field7);

        Element field8 = doc.createElement("field");
        field8.setAttribute("fieldName", "cServiceDateStart");
        field8.setTextContent("009");
        record01.appendChild(field8);

        Element field9 = doc.createElement("field");
        field9.setAttribute("fieldName", "cServiceDateEnd");
        field9.setTextContent("MED");
        record01.appendChild(field9);

        Element field10 = doc.createElement("field");
        field10.setAttribute("fieldName", "cTotalCharge");
        field10.setTextContent(" ");
        record01.appendChild(field10);

        Element field11 = doc.createElement("field");
        field11.setAttribute("fieldName", "cDiscount");
        field11.setTextContent(" ");
        record01.appendChild(field11);

        Element field12 = doc.createElement("field");
        field12.setAttribute("fieldName", "cIneligible");
        field12.setTextContent(" ");
        record01.appendChild(field12);

        Element field13 = doc.createElement("field");
        field13.setAttribute("fieldName", "cAllowed");
        field13.setTextContent(" ");
        record01.appendChild(field13);

        Element field14 = doc.createElement("field");
        field14.setAttribute("fieldName", "cNotesCode1");
        field14.setTextContent(" ");
        record01.appendChild(field14);

        Element field15 = doc.createElement("field");
        field15.setAttribute("fieldName", "cNotesCode2");
        field15.setTextContent(" ");
        record01.appendChild(field15);

        Element field16 = doc.createElement("field");
        field16.setAttribute("fieldName", "cNotesCode3");
        field16.setTextContent(" ");
        record01.appendChild(field16);

        Element field17 = doc.createElement("field");
        field16.setAttribute("fieldName", "cDeductible");
        field16.setTextContent(" ");
        record01.appendChild(field16);

        Element field18 = doc.createElement("field");
        field16.setAttribute("fieldName", "cCopay");
        field16.setTextContent(" ");
        record01.appendChild(field16);

        Element field19 = doc.createElement("field");
        field16.setAttribute("fieldName", "cCoinsurance");
        field16.setTextContent(" ");
        record01.appendChild(field16);

        Element field20 = doc.createElement("field");
        field16.setAttribute("fieldName", "cPayment");
        field16.setTextContent(" ");
        record01.appendChild(field16);

        Element field21 = doc.createElement("field");
        field16.setAttribute("fieldName", "cPatientResponsibility");
        field16.setTextContent(" ");
        record01.appendChild(field16);

        Element field22 = doc.createElement("field");
        field16.setAttribute("fieldName", "cDescription");
        field16.setTextContent(" ");
        record01.appendChild(field16);

        Element field23 = doc.createElement("field");
        field16.setAttribute("fieldName", "cToothNumber");
        field16.setTextContent(" ");
        record01.appendChild(field16);

        Element field24 = doc.createElement("field");
        field16.setAttribute("fieldName", "cToothSurface");
        field16.setTextContent(" ");
        record01.appendChild(field16);

        Element field25 = doc.createElement("field");
        field16.setAttribute("fieldName", "cClaimRelationString");
        field16.setTextContent(" ");
        record01.appendChild(field16);

        Element field26 = doc.createElement("field");
        field16.setAttribute("fieldName", "cNotesCode4");
        field16.setTextContent(" ");
        record01.appendChild(field16);

        Element field27 = doc.createElement("field");
        field16.setAttribute("fieldName", "cNotesCode5");
        field16.setTextContent(" ");
        record01.appendChild(field16);

       // doc.appendChild(record01);
        return record01;
    }
}


