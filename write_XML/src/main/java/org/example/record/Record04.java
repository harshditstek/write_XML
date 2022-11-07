package org.example.record;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Record04 {
    public static Element getRecord04(Document doc) {
        Element record04 = doc.createElement("record");
        Attr attrType = doc.createAttribute("recordType");
        attrType.setValue(String.valueOf("04"));
        record04.setAttributeNode(attrType);

        Element field01 = doc.createElement("field");
        field01.setAttribute("fieldName", "cClaimSequence");
        field01.setTextContent("001");
        record04.appendChild(field01);

        Element field2 = doc.createElement("field");//clmnot
        field2.setAttribute("fieldName", "cClaimNumber");
        field2.setTextContent(" ");
        record04.appendChild(field2);

        Element field3 = doc.createElement("field");
        field3.setAttribute("fieldName", "cLineNumbers");
        field3.setTextContent(" ");
        //field3.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        record04.appendChild(field3);

        Element field4 = doc.createElement("field");
        field4.setAttribute("fieldName", "cDescription");
        field4.setTextContent(" ");
        record04.appendChild(field4);

        return record04;

    }
}
