package cooccurence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Cooccurence {

	public static void main(String[] args) throws ClassNotFoundException, IOException{
		
		String outputfile = "../TepacDocs/hashes/article3_en_hash_RESULT.txt";
		String outputhash = "../TepacDocs/hashmaps/article3_en_hashmap_RESULT.ser";
		
		SortedMap<String, Set<String>> hashmap1 = ReadMap.hashReader("../TepacDocs/hashmaps/article3_en_hashmap.ser");
		
		SortedMap<String, Set<String>> hashmap2 = ReadMap.hashReader("../TepacDocs/hashmaps/article3_tr_hashmap.ser");
		
		SortedMap<String, HashMap<String, Integer>> hashresult = new TreeMap<String, HashMap<String, Integer>>();
		
		HashMap<String, Integer> values = new HashMap<String, Integer>();
        
		List<String> intersections = new ArrayList<String>();
		
		//Intersections (mostly names)
		for (Entry<String, Set<String>> entry: hashmap1.entrySet()) {
			String key = entry.getKey();
			if (hashmap2.containsKey(key)){
				intersections.add(key);
			}
		}
		//Delete intersections
		for(String key : intersections){
			hashmap1.remove(key);
			hashmap2.remove(key);
		}
		
		
		for(Entry<String, Set<String>> entry1: hashmap1.entrySet()) {
			
			   String key1 = entry1.getKey();
			   Set<String> value1 = entry1.getValue();
			   
			   for(Entry<String, Set<String>> entry2: hashmap2.entrySet()) {
				   
				   String key2 = entry2.getKey();
				   Set<String> value2 = entry2.getValue();
				   
				   int i = 0;
				   
				   for(String s1 : value1){
				        for(String s2 : value2){
				        	if(s1.equals(s2)){
				        		i++;
				        	}   	
				        }
				   }
				   
				   if(i != 0){
					   values.put(key2, i);
					   hashresult.put(key1, values);
				   }
				   
				   
			   }
		}
		

		System.out.println("Done");
		
		PrintCoocMap.printMap(hashresult, outputfile, outputhash);
		
	}
	
}
