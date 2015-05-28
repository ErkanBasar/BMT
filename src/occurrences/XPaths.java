package occurrences;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPaths {

	public static Document docFactory(String filename) throws SAXException,
			IOException, ParserConfigurationException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;

		builder = factory.newDocumentBuilder();
		doc = builder.parse(filename);

		return doc;

	}

	public static NodeList xpathCompiler(Document doc, String pattern)
			throws SAXException, IOException, ParserConfigurationException,
			XPathExpressionException {

		XPathFactory xpathFactory = XPathFactory.newInstance();

		XPath xpath = xpathFactory.newXPath();

		XPathExpression expr;
		Object result;

		expr = xpath.compile(pattern);
		result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes = (NodeList) result;

		return nodes;

	}

	public static Double xpathCounter(Document doc, String pattern)
			throws SAXException, IOException, ParserConfigurationException,
			XPathExpressionException {

		XPathFactory xpathFactory = XPathFactory.newInstance();

		XPath xpath = xpathFactory.newXPath();

		XPathExpression expr;
		Object result;

		expr = xpath.compile(pattern);
		result = expr.evaluate(doc, XPathConstants.NUMBER);
		Double count = (Double) result;

		return count;

	}

}
