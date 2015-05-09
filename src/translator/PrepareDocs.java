package translator;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import xmlparser.ParserMain;
import cooccurence.CoocMain;
import cooccurence.HashCombine;

public class PrepareDocs {
	
	public static void main(String[] args) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, ClassNotFoundException{
		
		
		int first = 1;
		int last = 3;
		
		
		ParserMain.fileChooser(first, last);
		
		CoocMain.fileChooser(first, last);
		
		HashCombine.combineHashes();
		
	}

}
