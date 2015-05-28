package translator;

import io.ReadMaps;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;
import java.util.SortedMap;

public class Translator {
	
	public static Set<String> translate(String input) throws ClassNotFoundException, IOException {
		
		Set<String> coocs = langCheck(input);
		
		return coocs;
		
	}
	
	public static Set<String> langCheck(String input) throws ClassNotFoundException, IOException{
		
		SortedMap<String, Set<String>> hashmap_en = ReadMaps.readerOccur("../BMTDocs/occurrence/maps/article3_en_hashmap.ser");

		SortedMap<String, Set<String>> hashmap_tr = ReadMaps.readerOccur("../BMTDocs/occurrence/maps/article3_tr_hashmap.ser");
		
		Set<String> coocs = new HashSet<String>();
		
		if (hashmap_en.containsKey(input)){
			
			SortedMap<String, Set<String>> hashmap1 = hashmap_en;
			
			SortedMap<String, Set<String>> hashmap2 = hashmap_tr;
		
			coocs =  singleCooccurrence(input, hashmap1, hashmap2);
			
			return coocs;
			
		}
		
		else if (hashmap_tr.containsKey(input)){
			
			SortedMap<String, Set<String>> hashmap1 = hashmap_tr;
			
			SortedMap<String, Set<String>> hashmap2 = hashmap_en;
		
			coocs = singleCooccurrence(input, hashmap1, hashmap2);	
			
			return coocs;
			
		}
		else {
			
			return null;
		}
		
		
	}

	public static Set<String> singleCooccurrence(String input, SortedMap<String, Set<String>> hashmap1, SortedMap<String, Set<String>> hashmap2) 
			throws ClassNotFoundException, IOException {

		HashMap<String, Integer> values = new HashMap<String, Integer>();
		
		Set<String> value_input = hashmap1.get(input);

		for (Entry<String, Set<String>> entry : hashmap2.entrySet()) {

			String key2 = entry.getKey();
			Set<String> value2 = entry.getValue();

			int inter = 0;
			for (String s1 : value_input) {
				for (String s2 : value2) {
					if (s1.equals(s2)) {
						inter++;
					}
				}
			}

			if (inter != 0) {
				values.put(key2, inter);
			}

		}

		Set<String> maxvalue = findMax(values);

		return maxvalue;

	}

	public static Set<String> findMax(HashMap<String, Integer> hashmap)
			throws ClassNotFoundException, IOException {

		String maxKey = null;
		Integer maxValue = 0;

		Set<String> word_list = new HashSet<String>();

		for (Entry<String, Integer> entry : hashmap.entrySet()) {
			if (entry.getValue() > maxValue) {
				maxValue = entry.getValue();
				maxKey = entry.getKey();
				word_list.clear();
				word_list.add(maxKey);
			}
			if (entry.getValue() == maxValue) {
				maxKey = entry.getKey();
				word_list.add(maxKey);
			}
		}

		return word_list;

	}

}
