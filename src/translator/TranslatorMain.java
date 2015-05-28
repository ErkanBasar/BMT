package translator;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class TranslatorMain {

	public static void main(String args[]) throws ClassNotFoundException,
			IOException {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter a word : ");

		String input = in.nextLine().toLowerCase();

		Set<String> translations = Translator.translate(input);

		if(translations!= null){
			
			System.out.println("Possible Translations  ; ");
			
			for(String word : translations){
				System.out.println(word);
			}
			
		}else{
			System.out.println("Not exist in our dictionary, try another word");
		}
		
		
		in.close();

	}

}
