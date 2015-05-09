package translator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.SortedMap;

import common.ReadMaps;

public class Translator {

	public static String translate(String input) throws ClassNotFoundException,
			IOException {
		
		SortedMap<String, HashMap<String, Integer>> totalhash = ReadMaps.coocHashReader("../TepacDocs/totalhash.ser");
		
		if (totalhash.containsKey(input)) {

			HashMap<String, Integer> valuehash = totalhash.get(input);

			String maxKey = null;
			Integer maxValue = 0;

			for (Entry<String, Integer> entry : valuehash.entrySet()) {
				if (entry.getValue() > maxValue) {
					maxValue = entry.getValue();
					maxKey = entry.getKey();
				}
			}

			return maxKey;
			
		}else{
			return null;
		}
	
	}
}
