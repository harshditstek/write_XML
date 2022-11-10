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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CreateXmlFileDemo {
    public static void writeXml(List<String[]> headerGroup) {
        try {
            List<String[]> clmnotList = new ArrayList<String[]>();
            List<String[]> clmdetList = new ArrayList<String[]>();

            String hprovd = "", hassgn = "", ssn = "", hclmno = "", cliamNumber = "", clmnot2 = "", hfill7 = "", hdep = "";
            String[] insdepData=null, providerData = null, clmnotData, insureData = null, headerData, clmdetData;

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
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
                hprovd = headerData[1].trim();
                ssn = headerData[2].trim();
                hclmno = headerData[3].trim();
                hfill7 = headerData[12].trim();
                hdep = headerData[13].trim();

                providerData = CLMHDR.getProvider(hprovd);
                if (!hclmno.equals("")) {
                    clmnotList = CLMHDR.getClmnot(hclmno);
                }
                if (clmnotList.size() > 0) {
                    cliamNumber = CLMHDR.getClaimNumber(clmnotList.get(0)[1].trim());
                    clmnot2 = clmnotList.get(0)[2].trim();
                }
                if (!ssn.equals("")) {
                    insureData = CLMHDR.getInsure(ssn);
                }
                clmdetList = CLMHDR.getClmdet(hclmno);

                document = doc.createElement("document");
                rootElement.appendChild(document);

                Attr attr = doc.createAttribute("inboundDocumentIdentifier");
                attr.setValue(String.valueOf(ih+1));
                document.setAttributeNode(attr);

                if (hassgn.equalsIgnoreCase("Y")) {
                    Element record00 = Record00.getRecord00(doc, providerData, hfill7);
                    document.appendChild(record00);
                } else {
                    Element record00 = Record00.getRecordInsure00(doc, insureData, hfill7);
                    document.appendChild(record00);
                }

                Element record01 = doc.createElement("record");
                Attr attrType = doc.createAttribute("recordType");
                attrType.setValue("01");
                record01.setAttributeNode(attrType);

                Element field01 = doc.createElement("field");
                field01.setAttribute("fieldName", "cClaimSequence");
                field01.setTextContent("001");
                record01.appendChild(field01);

                Element field2 = doc.createElement("field");
                field2.setAttribute("fieldName", "cClaimNumber");
                field2.setTextContent(cliamNumber);
                record01.appendChild(field2);

                Element field3 = doc.createElement("field");
                field3.setAttribute("fieldName", "cEnrolleeName");
                field3.setTextContent(insureData[0].trim());
                //field3.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
                record01.appendChild(field3);

                Element field4 = doc.createElement("field");
                field4.setAttribute("fieldName", "cEnrolleeLastName");
                field4.setTextContent(insureData[1].trim());
                record01.appendChild(field4);

                Element field5 = doc.createElement("field");
                field5.setAttribute("fieldName", "cEnrolleeId");
                field5.setTextContent(insureData[2].trim());
                record01.appendChild(field5);

                Element field6 = doc.createElement("field");
                field6.setAttribute("fieldName", "cPatientName");
                if (hdep.equalsIgnoreCase("02")) {
                    insdepData = CLMHDR.getInsdep(ssn);
                }
                if (insdepData!=null) {
                    field6.setTextContent(insdepData[6].trim() + " " + insdepData[5].trim());
                } else {
                    field6.setTextContent("");
                }
                record01.appendChild(field6);

                Element field7 = doc.createElement("field");
                field7.setAttribute("fieldName", "cProcessedDate");
                field7.setTextContent(CLMHDR.formattedDate(headerData[4].trim()));
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
                field15.setTextContent(cliamNumber);
                record01.appendChild(field15);

                document.appendChild(record01);

                for (int i = 0; i < clmdetList.size(); i++) {
                    clmdetData = clmdetList.get(i);
                    Element record02 = Record02.getRecord02(doc, clmdetData, headerData, cliamNumber, clmdetList.get(i+1));
                    document.appendChild(record02);
                }

                Element record03 = Record03.getRecord03(doc, headerData, cliamNumber);
                document.appendChild(record03);

                Element record04 = Record04.getRecord04(doc, cliamNumber, clmnot2);
                document.appendChild(record04);

                if (headerData[0].trim().equalsIgnoreCase("Y")) {
                    Element record06 = Record06.getRecordHeader06(doc, headerData, providerData);
                    document.appendChild(record06);
                } else {
                    Element record06 = Record06.getRecord06(doc, headerData, insureData);
                    document.appendChild(record06);
                }

                Element record07 = Record07.getRecord07(doc);
                document.appendChild(record07);

                Element record17 = Record17.getRecord17(doc, headerData, clmdetList.get(0));
                document.appendChild(record17);
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