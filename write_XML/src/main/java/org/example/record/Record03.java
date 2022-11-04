package org.example.record;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Record03 {

    public static Element getRecord03(Document doc) {
        Element record03 = doc.createElement("record");
        Attr attrType = doc.createAttribute("recordType");
        attrType.setValue(String.valueOf("03"));
        record03.setAttributeNode(attrType);

        Element field01 = doc.createElement("field");
        field01.setAttribute("fieldName", "cClaimSequence");
        field01.setTextContent("001");
        record03.appendChild(field01);

        Element field2 = doc.createElement("field");
        field2.setAttribute("fieldName", "cClaimNumber");
        field2.setTextContent(" ");
        record03.appendChild(field2);

        Element field3 = doc.createElement("field");
        field3.setAttribute("fieldName", "cTotalCharge");
        field3.setTextContent(" ");
        //field3.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        record03.appendChild(field3);

        Element field4 = doc.createElement("field");
        field4.setAttribute("fieldName", "cDiscount");
        field4.setTextContent(" ");
        record03.appendChild(field4);

        Element field5 = doc.createElement("field");
        field5.setAttribute("fieldName", "cAllowed");
        field5.setTextContent(" ");
        record03.appendChild(field5);

        Element field6 = doc.createElement("field");
        field6.setAttribute("fieldName", "cDeductible");
        field6.setTextContent(" ");
        record03.appendChild(field6);

        Element field7 = doc.createElement("field");
        field7.setAttribute("fieldName", "cCopay");
        field7.setTextContent("I");
        record03.appendChild(field7);

        Element field8 = doc.createElement("field");
        field8.setAttribute("fieldName", "cCoinsurance");
        field8.setTextContent("009");
        record03.appendChild(field8);

        Element field9 = doc.createElement("field");
        field9.setAttribute("fieldName", "cPayment");
        field9.setTextContent("MED");
        record03.appendChild(field9);

        Element field10 = doc.createElement("field");
        field10.setAttribute("fieldName", "cPatientResponsibility");
        field10.setTextContent(" ");
        record03.appendChild(field10);

        Element field11 = doc.createElement("field");
        field11.setAttribute("fieldName", "cClaimRelationString");
        field11.setTextContent(" ");
        record03.appendChild(field11);

        return record03;

    }
}
