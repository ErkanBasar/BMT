package translator;

import java.io.IOException;
import java.util.Scanner;

public class TranslatorMain {

	public static void main(String args[]) throws ClassNotFoundException,
			IOException {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter a word : ");

		String input = in.nextLine();

		String translation = Translator.translate(input);

		if(translation!= null){
			System.out.println("translation  : " + translation);
		}else{
			System.out.println("Not exist in our dictionary, try another word");
		}
		
		
		in.close();

	}

}
