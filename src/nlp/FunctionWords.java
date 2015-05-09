package nlp;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

public class FunctionWords {
	
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public static List<String> remove(List<String> tokens, String lang) throws IOException{
		
		String funcwordsfile = "../BMTDocs/funcwords/functionwords_" + lang + ".txt";
		
		String punctuationfile = "../BMTDocs/funcwords/punctuations.txt";
		
		List<String> funcWordsList = LineReader.readLines(funcwordsfile);
		
		List<String> punctuationList = LineReader.readLines(punctuationfile);
		
		tokens.removeAll(funcWordsList);
		
		tokens.removeAll(punctuationList);
		
		String pattern = "^[0-9]*$";
		for (Iterator<String> iter = tokens.listIterator(); iter.hasNext(); ) {
		    String token = iter.next();
		    if (token.matches(pattern)) {
		        iter.remove();
		    }
		}
		
		return tokens;
			
	}

}
