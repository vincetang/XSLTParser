package XSLT;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import Utilities.ArgParser;
import Utilities.XmlToCsv;
import net.sourceforge.argparse4j.inf.Namespace;

/**
 * Created by Vince on 2016-09-12.
 * This app transforms an XML to CSV using a XSLT stylesheet
 */
public class ParseXSLT {

    public static void main (String args[]) throws Exception {
        ArgParser argParser = new ArgParser();

        Namespace ns = argParser.createArgsNamespace(args);

        try {
            Path xml = Paths.get(ns.getString("xml"));
            Path xslt = Paths.get(ns.getString("xslt"));
            String outFileString = ns.getString("outfile");
            Path outFile = Paths.get(outFileString);

            try {
                Files.createFile(outFile);
                System.out.println("Created file: " + outFileString);
            } catch (FileAlreadyExistsException e) {
                System.out.println("Found file: " + outFileString);
            }

            XmlToCsv.convertXmlToCsv(xml.toFile(), xslt.toFile(), outFile.toFile());
        } catch (Exception e) {
            System.err.println("Error parsing arguments");
            System.exit(1);
        }


    }
}
