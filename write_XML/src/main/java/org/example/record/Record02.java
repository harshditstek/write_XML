package org.example.record;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

public class Record02 {

    public static Element getRecord02(Document doc, List<String[]> clmdetList) {
        Element record01 =null;
        String[] clmdetDate;
        for (int i = 0; i < clmdetList.size(); i++) {
            clmdetDate = clmdetList.get(i);
            record01 = doc.createElement("record");
            Attr attrType = doc.createAttribute("recordType");
            attrType.setValue(String.valueOf("02"));
            record01.setAttributeNode(attrType);

            Element field01 = doc.createElement("field");
            field01.setAttribute("fieldName", "cClaimSequence");
            field01.setTextContent("001");
            record01.appendChild(field01);

            Element field2 = doc.createElement("field");
            field2.setAttribute("fieldName", "cClaimNumber");
            field2.setTextContent(" ");
            record01.appendChild(field2);

            Element field3 = doc.createElement("field");
            field3.setAttribute("fieldName", "cServiceLineSequence");
            field3.setTextContent("000" + clmdetDate[1].trim());
            //field3.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            record01.appendChild(field3);

            Element field4 = doc.createElement("field");
            field4.setAttribute("fieldName", "cLineNumber");
            field4.setTextContent(clmdetDate[1].trim());
            record01.appendChild(field4);

            String dprc = clmdetDate[8].trim();
            String cProcedureCode = dprc.substring(0, Math.min(dprc.length(), 5));

            String cPlaceofService = dprc.substring(5, dprc.length());

            Element field5 = doc.createElement("field");//dprc
            field5.setAttribute("fieldName", "cProcedureCode");
            field5.setTextContent(cProcedureCode);
            record01.appendChild(field5);

            Element field6 = doc.createElement("field");
            field6.setAttribute("fieldName", "cPlaceofService");
            field6.setTextContent(cPlaceofService);
            record01.appendChild(field6);

            Element field7 = doc.createElement("field");
            field7.setAttribute("fieldName", "cUnits");
            field7.setTextContent(clmdetDate[9].trim());
            record01.appendChild(field7);

            Element field8 = doc.createElement("field");
            field8.setAttribute("fieldName", "cServiceDateStart");
            field8.setTextContent(clmdetDate[6].trim());
            record01.appendChild(field8);

            Element field9 = doc.createElement("field");
            field9.setAttribute("fieldName", "cServiceDateEnd");
            field9.setTextContent(" ");
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
            field17.setAttribute("fieldName", "cDeductible");
            field17.setTextContent(" ");
            record01.appendChild(field17);

            Element field18 = doc.createElement("field");
            field18.setAttribute("fieldName", "cCopay");
            field18.setTextContent(clmdetDate[30].trim());
            record01.appendChild(field18);

            Element field19 = doc.createElement("field");
            field19.setAttribute("fieldName", "cCoinsurance");
            field19.setTextContent(clmdetDate[20].trim());
            record01.appendChild(field19);

            Element field20 = doc.createElement("field");
            field20.setAttribute("fieldName", "cPayment");
            field20.setTextContent(" ");
            record01.appendChild(field20);

            Element field21 = doc.createElement("field");
            field21.setAttribute("fieldName", "cPatientResponsibility");
            field21.setTextContent(" ");
            record01.appendChild(field21);

            Element field22 = doc.createElement("field");
            field22.setAttribute("fieldName", "cDescription");
            field22.setTextContent(" ");
            record01.appendChild(field22);

            Element field23 = doc.createElement("field");
            field23.setAttribute("fieldName", "cToothNumber");
            field23.setTextContent(" ");
            record01.appendChild(field23);

            Element field24 = doc.createElement("field");
            field24.setAttribute("fieldName", "cToothSurface");
            field24.setTextContent(" ");
            record01.appendChild(field24);

            Element field25 = doc.createElement("field");
            field25.setAttribute("fieldName", "cClaimRelationString");
            field25.setTextContent(" ");
            record01.appendChild(field25);

            Element field26 = doc.createElement("field");
            field26.setAttribute("fieldName", "cNotesCode4");
            field26.setTextContent(" ");
            record01.appendChild(field26);

            Element field27 = doc.createElement("field");
            field27.setAttribute("fieldName", "cNotesCode5");
            field27.setTextContent(" ");
            record01.appendChild(field27);
        }

        // doc.appendChild(record01);
        return record01;
    }
}


