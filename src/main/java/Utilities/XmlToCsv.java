package Utilities;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * Created by Vince on 2016-09-12.
 * This class converts XML to CSV
 */
public class XmlToCsv {

    public static void convertXmlToCsv(File xml, File stylesheet, File outFile) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xml);

        StreamSource styleSource = new StreamSource(stylesheet);
        Transformer transformer = TransformerFactory.newInstance().newTransformer(styleSource);
        Source source = new DOMSource(document);
        Result outputTarget = new StreamResult(outFile);
        transformer.transform(source, outputTarget);
    }
}
