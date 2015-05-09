package cooccurence;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

public class CoocMain {

	public static void main(String[] args) throws XPathExpressionException,
			SAXException, IOException, ParserConfigurationException, ClassNotFoundException {

		fileChooser(1, 3);

		System.out.println("Done");

	}

	public static void fileChooser(int first, int last) throws IOException,
			XPathExpressionException, SAXException,
			ParserConfigurationException, ClassNotFoundException {

		String inputfile1 = " ";
		String inputfile2 = " ";
		String outputfile = " ";
		String outputhash = " ";

		for (int i = first; i <= last; i++) {

			inputfile1 = "../TepacDocs/xmlparsed/maps/article" + i + "_en_hashmap.ser";
			
			inputfile2 = "../TepacDocs/xmlparsed/maps/article" + i + "_tr_hashmap.ser";

			outputfile = "../TepacDocs/coocurence/texts/article" + i + "_en_tr_hash_RESULT.txt";
			
			outputhash = "../TepacDocs/coocurence/maps/article" + i + "_en_tr_hashmap_RESULT.ser";

			System.out.println(inputfile1);
			System.out.println(inputfile2);
			System.out.println(outputfile);
			System.out.println(outputhash);

			Cooccurence.findCooc(inputfile1, inputfile2, outputfile, outputhash);

		}

	}

}