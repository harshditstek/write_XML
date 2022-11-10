package org.example.record;

import org.example.Main;
import org.example.beans.iSeries;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Record02 {

    public static Element getRecord02(Document doc, String[] clmdetData, String[] headerData, String cliamNumber) {
        Element record02 = doc.createElement("record");
        Attr attrType = doc.createAttribute("recordType");
        attrType.setValue(String.valueOf("02"));
        record02.setAttributeNode(attrType);

        Element field01 = doc.createElement("field");
        field01.setAttribute("fieldName", "cClaimSequence");
        field01.setTextContent("001");
        record02.appendChild(field01);

        Element field2 = doc.createElement("field");
        field2.setAttribute("fieldName", "cClaimNumber");
        field2.setTextContent(cliamNumber);
        record02.appendChild(field2);

        Element field3 = doc.createElement("field");
        field3.setAttribute("fieldName", "cServiceLineSequence");
        field3.setTextContent("000" + clmdetData[1].trim());
        record02.appendChild(field3);

        Element field4 = doc.createElement("field");
        field4.setAttribute("fieldName", "cLineNumber");
        field4.setTextContent(clmdetData[1].trim());
        record02.appendChild(field4);

        String dprc = clmdetData[8].trim();
        String cPlaceofService = null;
        if (dprc.length() < 7) {
            Element field5 = doc.createElement("field");//dprc
            field5.setAttribute("fieldName", "cProcedureCode");
            field5.setTextContent(" ");
            record02.appendChild(field5);

            Element field6 = doc.createElement("field");
            field6.setAttribute("fieldName", "cPlaceofService");
            field6.setTextContent("");
            record02.appendChild(field6);
        } else {
            String cProcedureCode = dprc.substring(0, Math.min(dprc.length(), 5));
            cPlaceofService = dprc.substring(5, dprc.length());

            Element field5 = doc.createElement("field");//dprc
            field5.setAttribute("fieldName", "cProcedureCode");
            field5.setTextContent(cProcedureCode);
            record02.appendChild(field5);

            Element field6 = doc.createElement("field");
            field6.setAttribute("fieldName", "cPlaceofService");
            field6.setTextContent(cPlaceofService);
            record02.appendChild(field6);
        }

        Element field7 = doc.createElement("field");
        field7.setAttribute("fieldName", "cUnits");
        field7.setTextContent(clmdetData[9].trim());
        record02.appendChild(field7);

        Element field8 = doc.createElement("field");
        field8.setAttribute("fieldName", "cServiceDateStart");
        //field8.setTextContent(CLMHDR.formattedDate(clmdetDate[6].trim()));
        field8.setTextContent(clmdetData[6].trim());
        record02.appendChild(field8);

        Element field9 = doc.createElement("field");
        field9.setAttribute("fieldName", "cServiceDateEnd");
        if (cPlaceofService.equalsIgnoreCase("FR")){
            //field9.setTextContent(clmdetData2[6].trim());
            field9.setTextContent("");
        }else{
            field9.setTextContent(clmdetData[6].trim());
        }
        record02.appendChild(field9);

        Element field10 = doc.createElement("field");
        field10.setAttribute("fieldName", "cTotalCharge");
        field10.setTextContent(clmdetData[10].trim());
        record02.appendChild(field10);

        Element field11 = doc.createElement("field");
        field11.setAttribute("fieldName", "cDiscount");
        String dvencd = clmdetData[26].trim();
        if (!dvencd.equals("")) {
            double discount = Double.valueOf(clmdetData[10]) - Double.valueOf(clmdetData[11]);
            field11.setTextContent(String.valueOf(discount));
        } else {
            field11.setTextContent("00");
        }
        record02.appendChild(field11);

        Element field12 = doc.createElement("field");
        field12.setAttribute("fieldName", "cIneligible");
        field12.setTextContent(" ");
        record02.appendChild(field12);

        Element field13 = doc.createElement("field");
        field13.setAttribute("fieldName", "cAllowed");
        field13.setTextContent(clmdetData[11].trim());
        record02.appendChild(field13);

        Element field14 = doc.createElement("field");
        field14.setAttribute("fieldName", "cNotesCode1");
        field14.setTextContent(clmdetData[13].trim());
        record02.appendChild(field14);

        Element field15 = doc.createElement("field");
        field15.setAttribute("fieldName", "cNotesCode2");
        field15.setTextContent(clmdetData[14].trim());
        record02.appendChild(field15);

        Element field16 = doc.createElement("field");
        field16.setAttribute("fieldName", "cNotesCode3");
        field16.setTextContent("");
        record02.appendChild(field16);

        Element field17 = doc.createElement("field");
        field17.setAttribute("fieldName", "cDeductible");
        field17.setTextContent(clmdetData[18].trim());
        record02.appendChild(field17);

        Element field18 = doc.createElement("field");
        field18.setAttribute("fieldName", "cCopay");
        field18.setTextContent(clmdetData[30].trim());
        record02.appendChild(field18);

        Element field19 = doc.createElement("field");
        field19.setAttribute("fieldName", "cCoinsurance");
        field19.setTextContent(clmdetData[20].trim());
        record02.appendChild(field19);

        Element field20 = doc.createElement("field");
        field20.setAttribute("fieldName", "cPayment");
        field20.setTextContent("");
        record02.appendChild(field20);

        Element field21 = doc.createElement("field");
        field21.setAttribute("fieldName", "cPatientResponsibility");
        String cPatientResponsibility = iSeries.generatePatientResponsibility(Main.member, clmdetData[0].trim());
        field21.setTextContent(cPatientResponsibility);
        record02.appendChild(field21);

        Element field22 = doc.createElement("field");
        field22.setAttribute("fieldName", "cDescription");
        field22.setTextContent("");
        record02.appendChild(field22);

        if (headerData[12].equalsIgnoreCase("D")) {
            Element field23 = doc.createElement("field");//
            field23.setAttribute("fieldName", "cToothNumber");
            field23.setTextContent(dprc.substring(2, 4));
            record02.appendChild(field23);
        }

        Element field24 = doc.createElement("field");
        field24.setAttribute("fieldName", "cToothSurface");
        field24.setTextContent(clmdetData[29].trim());
        record02.appendChild(field24);

        Element field25 = doc.createElement("field");
        field25.setAttribute("fieldName", "cClaimRelationString");
        field25.setTextContent(cliamNumber);
        record02.appendChild(field25);

        Element field26 = doc.createElement("field");
        field26.setAttribute("fieldName", "cNotesCode4");
        field26.setTextContent("");
        record02.appendChild(field26);

        Element field27 = doc.createElement("field");
        field27.setAttribute("fieldName", "cNotesCode5");
        field27.setTextContent("");
        record02.appendChild(field27);

        return record02;
    }
}


