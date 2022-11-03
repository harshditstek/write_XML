package org.example.XML;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;

public class CreateXmlFileDemo {

    public static void main(String argv[]) {
        try {
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

            for (int i = 1; i < 5; i++) {
                document = doc.createElement("document");
                rootElement.appendChild(document);

                Attr attr = doc.createAttribute("inboundDocumentIdentifier");
                attr.setValue(String.valueOf(i));
                document.setAttributeNode(attr);

                for(int i1=1;i1<5;i1++) {
                    Element record = doc.createElement("record");
                    Attr attrType = doc.createAttribute("recordType");
                    attrType.setValue(String.valueOf(i1));
                    record.setAttributeNode(attrType);

                    Element field1 = doc.createElement("field");
                    field1.setAttribute("fieldName", "cName");
                    field1.setTextContent("Sun Hodgson");
                    record.appendChild(field1);

                    Element field2 = doc.createElement("field");
                    field2.setAttribute("fieldName", "cAddress1");
                    field2.setTextContent("2736 Angus Cir");
                    record.appendChild(field2);

                    Element field3 = doc.createElement("field");
                    field3.setAttribute("fieldName", "cEnrolleeName");
                    field3.setTextContent(" ");
                    record.appendChild(field3);

                    Element field4 = doc.createElement("field");
                    field4.setAttribute("fieldName", "cCity");
                    field4.setTextContent("Molino");
                    record.appendChild(field4);

                    document.appendChild(record);
                }
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\File.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}