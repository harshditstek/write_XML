package org.example.record;

import org.example.beans.iSeries;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

public class Record17 {
    public static Element getRecord17(Document doc, String[] headerData, String[] clmdetData) {
        Element record17 = null;
        record17 = doc.createElement("record");
        Attr attrType = doc.createAttribute("recordType");
        attrType.setValue(String.valueOf("17"));
        record17.setAttributeNode(attrType);

        Element field01 = doc.createElement("field");
        field01.setAttribute("fieldName", "cClaimSequence");
        field01.setTextContent("001");
        record17.appendChild(field01);

        Element field2 = doc.createElement("field");
        field2.setAttribute("fieldName", "cTotalCharge");
        field2.setTextContent(headerData[5].trim());
        record17.appendChild(field2);

        Element field3 = doc.createElement("field");
        field3.setAttribute("fieldName", "cDiscount");
        String dvencd = clmdetData[26].trim();
        if (!dvencd.equals("")) {
            double discount = Double.valueOf(headerData[5]) - Double.valueOf(headerData[7]);
            field3.setTextContent(String.valueOf(discount));
        } else {
            field3.setTextContent("00");
        }
        record17.appendChild(field3);

        Element field4 = doc.createElement("field");
        field4.setAttribute("fieldName", "cPayment");
        field4.setTextContent(headerData[11].trim());
        record17.appendChild(field4);

        Element field5 = doc.createElement("field");
        field5.setAttribute("fieldName", "cPatientResponsibility");
        String cPatientResponsibility = iSeries.generatePatientResponsibility("TRT",headerData[3].trim());
        field5.setTextContent(cPatientResponsibility);
        record17.appendChild(field5);

        return record17;
    }


}
