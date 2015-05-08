package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws XPathExpressionException,
			SAXException, IOException, ParserConfigurationException {

		fileChooser(3, 3);

		System.out.println("Done");

	}

	public static void fileChooser(int first, int last) throws IOException,
			XPathExpressionException, SAXException,
			ParserConfigurationException {

		List<String> langs = new ArrayList<String>();
		langs.add("en");
		langs.add("tr");

		String inputfile = " ";
		String outputfile = " ";

		for (int i = first; i <= last; i++) {

			for(String lang : langs){

				inputfile = "../TepacDocs/corpora/article" + i + "_" + lang + ".xml";
				outputfile = "../TepacDocs/hashes/article" + i + "_" + lang	+ "_hash.txt";

				System.out.println(inputfile);
				System.out.println(outputfile);

				XMLParser.parser(inputfile, outputfile, lang);

			}
		}

	}

}
