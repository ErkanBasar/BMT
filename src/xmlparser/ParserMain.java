package xmlparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

public class ParserMain {

	public static void main(String[] args) throws XPathExpressionException,
			SAXException, IOException, ParserConfigurationException {

		fileChooser(1, 3);

	}

	public static void fileChooser(int first, int last) throws IOException,
			XPathExpressionException, SAXException,
			ParserConfigurationException {

		List<String> langs = new ArrayList<String>();
		langs.add("en");
		langs.add("tr");

		String inputfile;
		String outputfile;
		String outputhash;

		for (int i = first; i <= last; i++) {

			for(String lang : langs){

				inputfile = "../BMTDocs/corpora/article" + i + "_" + lang + ".xml";
				
				outputfile = "../BMTDocs/xmlparsed/texts/article" + i + "_" + lang + "_hash.txt";
				
				outputhash = "../BMTDocs/xmlparsed/maps/article" + i + "_" + lang	+ "_hashmap.ser";

				XMLtoHash.parser(inputfile, outputfile, outputhash, lang);

			}
		}
		
		System.out.println("All corpora(xml) parsed as hashmaps");

	}

}
