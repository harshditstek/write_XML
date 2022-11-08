package org.example.record;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

public class Record06 {
    public static Element getRecord06(Document doc, String[] headerData) {
        Element record06 = null;
      //  String[] headerData;
        //for(int i=0;i<headerGroup.size();i++) {
            //headerData = headerGroup.get(i);
            record06 = doc.createElement("record");
            Attr attrType = doc.createAttribute("recordType");
            attrType.setValue(String.valueOf("06"));
            record06.setAttributeNode(attrType);

            Element field01 = doc.createElement("field");
            field01.setAttribute("fieldName", "cBank1");
            field01.setTextContent("");
            record06.appendChild(field01);

            Element field2 = doc.createElement("field");
            field2.setAttribute("fieldName", "cTextAmount");
            field2.setTextContent(NumToWords.changeNumberToString(headerData[7].trim()));
            record06.appendChild(field2);

            Element field3 = doc.createElement("field");
            field3.setAttribute("fieldName", "cMicrline");
            field3.setTextContent("");
            //field3.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            record06.appendChild(field3);

            Element field4 = doc.createElement("field");
            field4.setAttribute("fieldName", "cCheckAmount");
            field4.setTextContent("");
            record06.appendChild(field4);

            Element field5 = doc.createElement("field");
            field5.setAttribute("fieldName", "cPayeeName");
            field5.setTextContent("");
            record06.appendChild(field5);

            Element field6 = doc.createElement("field");
            field6.setAttribute("fieldName", "cCheckDate");
            field6.setTextContent(headerData[7].trim());
            record06.appendChild(field6);

            Element field7 = doc.createElement("field");
            field7.setAttribute("fieldName", "cCheckNumber");
            field7.setTextContent("I");
            record06.appendChild(field7);

            Element field8 = doc.createElement("field");
            field8.setAttribute("fieldName", "c835PaymentType");
            field8.setTextContent("");
            record06.appendChild(field8);

            Element field9 = doc.createElement("field");
            field9.setAttribute("fieldName", "cAchPaymentFormat");
            field9.setTextContent("");
            record06.appendChild(field9);

            Element field10 = doc.createElement("field");
            field10.setAttribute("fieldName", "cPayerRouting");
            field10.setTextContent("");
            record06.appendChild(field10);

            Element field11 = doc.createElement("field");
            field11.setAttribute("fieldName", "cPayerAccount");
            field11.setTextContent("");
            record06.appendChild(field11);

            Element field12 = doc.createElement("field");
            field12.setAttribute("fieldName", "cOriginatingCompanyId");
            field12.setTextContent("");
            record06.appendChild(field12);

            Element field13 = doc.createElement("field");
            field13.setAttribute("fieldName", "cOriginatingCompanySuppCode");
            field13.setTextContent("");
            record06.appendChild(field13);

            Element field14 = doc.createElement("field");
            field14.setAttribute("fieldName", "cReassociationId");
            field14.setTextContent("");
            record06.appendChild(field14);

        return record06;
    }
}
