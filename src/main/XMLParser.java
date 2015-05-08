package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import nlp.FunctionWords;
import nlp.OpenTokenizer;
import nlp.StanfordLemmatizer;
import nlp.ZemberekStemmer;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser {

	
	public static HashMap<String, Set<String>> parser(String inputfile, String outputfile, String lang)
			throws XPathExpressionException, SAXException, IOException,
			ParserConfigurationException {
		
		StanfordLemmatizer slem = new StanfordLemmatizer();

		Document doc = XPaths.docFactory(inputfile);

		HashMap<String, Set<String>> hash = new HashMap<>();
		
		List<String> puretokens = new ArrayList<String>();
		List<String> tokenlist = new ArrayList<String>();
		List<String> stems = new ArrayList<String>();

		Double count1 = XPaths.xpathCounter(doc, "count(/article/pr)");

		for (int pr = 1; pr < count1 + 1; pr++) {

			Double count2 = XPaths.xpathCounter(doc, "count(/article/pr[" + pr+ "]/s)");

			for (int j = 1; j < count2 + 1; j++) {

				String sid = "s" + pr + "." + j;

				NodeList nodes = XPaths.xpathCompiler(doc, "/article/pr[" + pr+ "]/s[" + j + "]/text/text()");
				

				if (lang == "en") {

					tokenlist = slem.lemmatize(nodes.item(0).getNodeValue().toLowerCase());
					
					puretokens = FunctionWords.remove(tokenlist, lang);
					
				}
				
				else if(lang == "tr"){
					
					tokenlist = OpenTokenizer.Tokenize(nodes.item(0).getNodeValue().toLowerCase());
					
					stems = ZemberekStemmer.stem(tokenlist);
					
					puretokens = FunctionWords.remove(stems, lang);
					
				}

				for (String token : puretokens) {
				
					Set<String> list = new HashSet<String>();

					if (hash.containsKey(token)) {
						Set<String> list2 = hash.get(token);
						list2.add(sid);
					} else {
						list.add(sid);
						hash.put(token, list);
					}

				}

			}

		}

		PrintMap.printMap(hash, outputfile);

		return hash;

	}



}