package org.example.record;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Record00 {

    public static Element getRecord00(Document doc, String[] providerData, String hfill7) {
        Element record = doc.createElement("record");
        Attr attrType = doc.createAttribute("recordType");
        attrType.setValue(String.valueOf("00"));
        record.setAttributeNode(attrType);

        Element field1 = doc.createElement("field");
        field1.setAttribute("fieldName", "cName");
        field1.setTextContent(providerData[1].trim());
        record.appendChild(field1);

        Element field2 = doc.createElement("field");
        field2.setAttribute("fieldName", "cAddress1");
        field2.setTextContent(providerData[2].trim());
        record.appendChild(field2);

        Element field3 = doc.createElement("field");
        field3.setAttribute("fieldName", "cAddress2");
        field3.setTextContent(providerData[3].trim());
        //field3.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        record.appendChild(field3);

        Element field4 = doc.createElement("field");
        field4.setAttribute("fieldName", "cCity");
        field4.setTextContent(providerData[4].trim());
        record.appendChild(field4);

        Element field5 = doc.createElement("field");
        field5.setAttribute("fieldName", "cState");
        field5.setTextContent(providerData[5].trim());
        record.appendChild(field5);

        Element field6 = doc.createElement("field");
        field6.setAttribute("fieldName", "cZip");
        field6.setTextContent(providerData[6].trim());
        record.appendChild(field6);

        Element field7 = doc.createElement("field");
        field7.setAttribute("fieldName", "cRecipientCode");
        field7.setTextContent("I");
        record.appendChild(field7);

        Element field8 = doc.createElement("field");
        field8.setAttribute("fieldName", "cDocumentType");
        field8.setTextContent("009");
        record.appendChild(field8);

        Element field9 = doc.createElement("field");
        field9.setAttribute("fieldName", "cClaimType");
        if(hfill7.equalsIgnoreCase("M") || hfill7.equalsIgnoreCase("H"))
            field9.setTextContent("MED");
        else if(hfill7.equalsIgnoreCase("D"))
            field9.setTextContent("DENTAL");
        else if(hfill7.equalsIgnoreCase("V"))
            field9.setTextContent("VISION");
        else
            field9.setTextContent("");
        record.appendChild(field9);

        Element field10 = doc.createElement("field");
        field10.setAttribute("fieldName", "cPayerName");
        field10.setTextContent("");
        record.appendChild(field10);

        Element field11 = doc.createElement("field");
        field11.setAttribute("fieldName", "cPayerTin");
        field11.setTextContent("");
        record.appendChild(field11);

        Element field12 = doc.createElement("field");
        field12.setAttribute("fieldName", "cPayerAddress");
        field12.setTextContent("");
        record.appendChild(field12);

        Element field13 = doc.createElement("field");
        field13.setAttribute("fieldName", "cPayerCity");
        field13.setTextContent("");
        record.appendChild(field13);

        Element field14 = doc.createElement("field");
        field14.setAttribute("fieldName", "cPayerState");
        field14.setTextContent("");
        record.appendChild(field14);

        Element field15 = doc.createElement("field");
        field15.setAttribute("fieldName", "cPayerZip");
        field15.setTextContent("");
        record.appendChild(field15);

        Element field16 = doc.createElement("field");
        field16.setAttribute("fieldName", "cPayerTechContactName");
        field16.setTextContent("");
        record.appendChild(field16);

        return record;
    }

    public static Element  getRecordInsure00(Document doc, String[] insureData, String hfill7) {
        Element record = doc.createElement("record");
        Attr attrType = doc.createAttribute("recordType");
        attrType.setValue(String.valueOf("00"));
        record.setAttributeNode(attrType);

        Element field1 = doc.createElement("field");
        field1.setAttribute("fieldName", "cName");
        field1.setTextContent("");
        record.appendChild(field1);

        Element field2 = doc.createElement("field");
        field2.setAttribute("fieldName", "cAddress1");
        field2.setTextContent("");
        record.appendChild(field2);

        Element field3 = doc.createElement("field");
        field3.setAttribute("fieldName", "cAddress2");
        field3.setTextContent("");
        //field3.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        record.appendChild(field3);

        Element field4 = doc.createElement("field");
        field4.setAttribute("fieldName", "cCity");
        field4.setTextContent("");
        record.appendChild(field4);

        Element field5 = doc.createElement("field");
        field5.setAttribute("fieldName", "cState");
        field5.setTextContent("");
        record.appendChild(field5);

        Element field6 = doc.createElement("field");
        field6.setAttribute("fieldName", "cZip");
        field6.setTextContent("");
        record.appendChild(field6);

        Element field7 = doc.createElement("field");
        field7.setAttribute("fieldName", "cRecipientCode");
        field7.setTextContent("I");
        record.appendChild(field7);

        Element field8 = doc.createElement("field");
        field8.setAttribute("fieldName", "cDocumentType");
        field8.setTextContent("009");
        record.appendChild(field8);

        Element field9 = doc.createElement("field");
        field9.setAttribute("fieldName", "cClaimType");
        if(hfill7.equalsIgnoreCase("M") || hfill7.equalsIgnoreCase("H"))
            field9.setTextContent("MED");
        else if(hfill7.equalsIgnoreCase("D"))
            field9.setTextContent("DENTAL");
        else if(hfill7.equalsIgnoreCase("V"))
            field9.setTextContent("VISION");
        else
            field9.setTextContent("");
        record.appendChild(field9);

        Element field10 = doc.createElement("field");
        field10.setAttribute("fieldName", "cPayerName");
        field10.setTextContent(insureData[0].trim()+ " " +insureData[1].trim());
        record.appendChild(field10);

        Element field11 = doc.createElement("field");
        field11.setAttribute("fieldName", "cPayerTin");
        field11.setTextContent("");
        record.appendChild(field11);

        Element field12 = doc.createElement("field");
        field12.setAttribute("fieldName", "cPayerAddress");
        field12.setTextContent(insureData[3].trim());
        record.appendChild(field12);

        Element field13 = doc.createElement("field");
        field13.setAttribute("fieldName", "cPayerCity");
        field13.setTextContent(insureData[4].trim());
        record.appendChild(field13);

        Element field14 = doc.createElement("field");
        field14.setAttribute("fieldName", "cPayerState");
        field14.setTextContent(insureData[5].trim());
        record.appendChild(field14);

        Element field15 = doc.createElement("field");
        field15.setAttribute("fieldName", "cPayerZip");
        field15.setTextContent(insureData[6].trim());
        record.appendChild(field15);

        Element field16 = doc.createElement("field");
        field16.setAttribute("fieldName", "cPayerTechContactName");
        field16.setTextContent("");
        record.appendChild(field16);

        return record;
    }
}
