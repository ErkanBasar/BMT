package nlp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

public class OpenTokenizer {
	
	public static List<String> Tokenize(String sentence) throws InvalidFormatException, IOException {
		
		InputStream is = new FileInputStream("../TepacDocs/models/en-token.bin");
	 
		TokenizerModel model = new TokenizerModel(is);
	 
		Tokenizer tokenizer = new TokenizerME(model);
	 
		String tokens[] = tokenizer.tokenize(sentence);
		
		List<String> list1 = new ArrayList<String>();
	 
		for (String a : tokens)
			list1.add(a);
	 
		is.close();
		
		return list1;
	}
	
	public static void main(String[] args) throws InvalidFormatException, IOException{
		
		System.out.println(Tokenize("hede hodo"));
	}

}
