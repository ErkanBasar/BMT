package nlp;

import java.util.ArrayList;
import java.util.List;

import net.zemberek.erisim.Zemberek;
import net.zemberek.tr.yapi.TurkiyeTurkcesi;

public class ZemberekStemmer {
	
	public static List<String> stem(List<String> tokens){
		
		Zemberek zemberek = new Zemberek(new TurkiyeTurkcesi());
		
		List<String> stems = new ArrayList<String>();
		
		for(String token : tokens){
			//String kok = zemberek.kelimeCozumle(token)[0].kok().icerik();
			String[] stemsArray = zemberek.kokBulucu().stringKokBul(token);
	        
	        if (stemsArray.length != 0){
	        	stems.add(stemsArray[0]);
	        }
		}
		
		return stems;
	}	

}