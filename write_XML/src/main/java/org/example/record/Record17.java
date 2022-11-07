package org.example.record;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

public class Record17 {
    public static Element getRecord17(Document doc, List<String[]> headerGroup) {

    String[] headerData;
     Element record17 = null;

        for(int i=0;i<headerGroup.size();i++) {
            headerData = headerGroup.get(i);

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
            field3.setTextContent("0");
            //field3.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            record17.appendChild(field3);

            Element field4 = doc.createElement("field");
            field4.setAttribute("fieldName", "cPayment");
            field4.setTextContent(headerData[11].trim());
            record17.appendChild(field4);

            Element field5 = doc.createElement("field");
            field5.setAttribute("fieldName", "cPatientResponsibility");
            field5.setTextContent(" ");
            record17.appendChild(field5);
        }

        return record17;
    }


}
