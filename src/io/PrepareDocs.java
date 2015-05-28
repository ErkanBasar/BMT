package io;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import occurrences.OccurMain;

import org.xml.sax.SAXException;

public class PrepareDocs {
	
	public static void main(String[] args) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException, ClassNotFoundException{
		
		
		int first = 1;
		int last = 3;
		
		
		OccurMain.fileChooser(first, last);
		
		HashCombine.combineOccur(first, last);
		
		
	}

}
