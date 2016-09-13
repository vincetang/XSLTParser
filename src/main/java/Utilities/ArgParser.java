package Utilities;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
/**
 * Created by Vince on 2016-09-12.
 * Parses arguments for ParseXSLT
 */
public class ArgParser {

    public Namespace createArgsNamespace(String[] args) {
        ArgumentParser parser = ArgumentParsers.newArgumentParser("XSLT Parser")
                .defaultHelp(true)
                .description("Transforms an XML file to CSV using an XSLT");
        parser.addArgument("-s", "--xslt")
                .help("The XSLT stylesheet")
                .required(true);
        parser.addArgument("-x", "--xml")
                .help("The XML file to transform")
                .required(true);
        parser.addArgument("-o", "--outfile")
                .help("The output file")
                .setDefault("output.csv");

        Namespace ns;
        try {
            ns = parser.parseArgs(args);
            return ns;
        } catch (ArgumentParserException e) {
            System.err.println("Error parsing arguments");
            parser.handleError(e);
            System.exit(1);
        }
        return null;
    }

}
