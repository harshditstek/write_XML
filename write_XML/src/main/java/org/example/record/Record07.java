package org.example.record;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Record07 {
    public static Element getRecord07(Document doc) {
        Element record07 = doc.createElement("record");
        Attr attrType = doc.createAttribute("recordType");
        attrType.setValue(String.valueOf("07"));
        record07.setAttributeNode(attrType);

        Element field01 = doc.createElement("field");
        field01.setAttribute("fieldName", "cClaimSequence");
        field01.setTextContent("001");
        record07.appendChild(field01);

        Element field2 = doc.createElement("field");
        field2.setAttribute("fieldName", "cAccumulatorDescription");
        field2.setTextContent("");
        record07.appendChild(field2);

        Element field3 = doc.createElement("field");
        field3.setAttribute("fieldName", "cAmountMet");
        field3.setTextContent("");
        //field3.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        record07.appendChild(field3);

        Element field4 = doc.createElement("field");
        field4.setAttribute("fieldName", "cAmountRemaining");
        field4.setTextContent("");
        record07.appendChild(field4);

        Element field5 = doc.createElement("field");
        field5.setAttribute("fieldName", "cAmountToMeet");
        field5.setTextContent("");
        record07.appendChild(field5);

        Element field6 = doc.createElement("field");
        field6.setAttribute("fieldName", "cClaimYear");
        field6.setTextContent("");
        record07.appendChild(field6);

        Element field7 = doc.createElement("field");
        field7.setAttribute("fieldName", "cIndividual");
        field7.setTextContent("");
        record07.appendChild(field7);

        Element field8 = doc.createElement("field");
        field8.setAttribute("fieldName", "cRelationshipToInsured");
        field8.setTextContent("");
        record07.appendChild(field8);
        return record07;

    }
}
