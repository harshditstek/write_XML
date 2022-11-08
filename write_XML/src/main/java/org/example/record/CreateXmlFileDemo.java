package org.example.record;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.example.beans.CLMHDR;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateXmlFileDemo {
    public static void writeXml(List<String[]> headerGroup) {
        try {
            List<String[]> clmnotList = new ArrayList<String[]>();
            List<String[]> insureList = new ArrayList<String[]>();
            List<String[]> providerList = new ArrayList<String[]>();
            List<String[]> clmdetList = new ArrayList<String[]>();
            String pprovn = "", hassgn = "", ssn = "", hclmno = "";

            String[] providerData,clmnotData,insureData,headerData,clmdetData;

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            // doc.setXmlStandalone(true);
            Element document = null;
            Element formatId = null;

            Element rootElement = doc.createElement("file");
            doc.appendChild(rootElement);

            formatId = doc.createElement("formatId");
            formatId.setTextContent("001");
            rootElement.appendChild(formatId);
            for (int ih = 0; ih < headerGroup.size(); ih++) {
                headerData = headerGroup.get(ih);
                hassgn = headerData[0].trim();
                pprovn = headerData[1].trim();
                ssn = headerData[2].trim();
                hclmno = headerData[3].trim();
                if (hassgn.equalsIgnoreCase("Y")) {
                    providerList = CLMHDR.getProvider(pprovn);

                } else {

                }
                if (!hclmno.equals("")) {
                    clmnotList = CLMHDR.getClmnot(hclmno);
                }
                if (!ssn.equals("")) {
                    insureList = CLMHDR.getInsure(ssn);
                }
                clmdetList = CLMHDR.getClmdet(hclmno);

                for (int ip = 0; ip < providerList.size(); ip++) {
                    providerData = providerList.get(ip);
                    document = doc.createElement("document");
                    rootElement.appendChild(document);

                    Attr attr = doc.createAttribute("inboundDocumentIdentifier");
                    attr.setValue(String.valueOf(ih));
                    document.setAttributeNode(attr);

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
                    field9.setTextContent("MED");
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

                    document.appendChild(record);
                }

                for (int i = 0; i < insureList.size(); i++) {
                    for (int i2 = 0; i2 < providerList.size(); i2++) {
                        providerData = providerList.get(i2);
                        insureData = insureList.get(i);

                        Element record01 = doc.createElement("record");
                        Attr attrType = doc.createAttribute("recordType");
                        attrType.setValue(String.valueOf("01"));
                        record01.setAttributeNode(attrType);

                        Element field01 = doc.createElement("field");
                        field01.setAttribute("fieldName", "cClaimSequence");
                        field01.setTextContent("001");
                        record01.appendChild(field01);

                        Element field2 = doc.createElement("field");
                        field2.setAttribute("fieldName", "cClaimNumber");
                        field2.setTextContent("");
                        record01.appendChild(field2);

                        Element field3 = doc.createElement("field");
                        field3.setAttribute("fieldName", "cEnrolleeName");
                        field3.setTextContent(insureData[3].trim());
                        //field3.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
                        record01.appendChild(field3);

                        Element field4 = doc.createElement("field");
                        field4.setAttribute("fieldName", "cEnrolleeLastName");
                        field4.setTextContent(insureData[4].trim());
                        record01.appendChild(field4);

                        Element field5 = doc.createElement("field");
                        field5.setAttribute("fieldName", "cEnrolleeId");
                        field5.setTextContent(insureData[2].trim());
                        record01.appendChild(field5);

                        Element field6 = doc.createElement("field");
                        field6.setAttribute("fieldName", "cPatientName");
                        field6.setTextContent(" ");
                        record01.appendChild(field6);

                        String processDate = headerData[4].trim();
                        if (processDate.length() == 5) {
                            processDate = "0" + processDate;
                        }
                        Date d = new SimpleDateFormat("MMddyy").parse(processDate);
                        SimpleDateFormat d2 = new SimpleDateFormat("yyyyMMdd");
                        String formattedProcessDate = d2.format(d).toString();

                        Element field7 = doc.createElement("field");
                        field7.setAttribute("fieldName", "cProcessedDate");
                        field7.setTextContent(formattedProcessDate);
                        record01.appendChild(field7);

                        Element field9 = doc.createElement("field");
                        field9.setAttribute("fieldName", "cGroupHierarchy1");
                        field9.setTextContent("CC6518");
                        record01.appendChild(field9);

                        Element field10 = doc.createElement("field");
                        field10.setAttribute("fieldName", "cGroupHierarchy2");
                        field10.setTextContent("HSB3");
                        record01.appendChild(field10);

                        Element field11 = doc.createElement("field");
                        field11.setAttribute("fieldName", "cProviderTaxId");
                        field11.setTextContent(providerData[0].trim());
                        record01.appendChild(field11);

                        Element field12 = doc.createElement("field");
                        field12.setAttribute("fieldName", "cProviderName");
                        field12.setTextContent(providerData[1].trim());
                        record01.appendChild(field12);

                        Element field13 = doc.createElement("field");
                        field13.setAttribute("fieldName", "cProviderAddress1");
                        field13.setTextContent(providerData[2].trim());
                        record01.appendChild(field13);

                        Element field14 = doc.createElement("field");
                        field14.setAttribute("fieldName", "cProviderAddress2");
                            field14.setTextContent(providerData[3].trim());
                        record01.appendChild(field14);

                        Element field15 = doc.createElement("field");
                        field15.setAttribute("fieldName", "cClaimRelationString");
                        field15.setTextContent("");
                        record01.appendChild(field15);

                        document.appendChild(record01);
                    }
                }
                for (int i = 0; i < clmdetList.size(); i++) {
                    clmdetData = clmdetList.get(i);
                    Element record02 = Record02.getRecord02(doc, clmdetData);
                    document.appendChild(record02);
                }

                Element record03 = Record03.getRecord03(doc, headerData);
                document.appendChild(record03);

                Element record04 = Record04.getRecord04(doc);
                document.appendChild(record04);

                if (headerData[0].trim().equalsIgnoreCase("Y")) {
                    Element record06 = Record06.getRecord06(doc, headerData);
                    document.appendChild(record06);
                } else {

                }

                Element record07 = Record07.getRecord07(doc);
                document.appendChild(record07);

                for (int i = 0; i < clmdetList.size(); i++) {
                    clmdetData = clmdetList.get(i);
                    Element record17 = Record17.getRecord17(doc, headerData, clmdetList.get(0));
                    document.appendChild(record17);
                }
            }

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmmss");
            LocalDateTime now = LocalDateTime.now();
            String filePath = "/tmp/" + "3556BH20220722R01E559D11_" + dtf.format(now) + ".xml";

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setParameter(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "html");
            transformer.transform(source, result);
            //StreamResult consoleResult = new StreamResult(System.out);
            //transformer.transform(source, consoleResult);
            System.out.println("file saved in this location: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}