package cooccurence;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

public class Cooccurence {

	public static void main(String[] args) throws ClassNotFoundException, IOException{
		
		
		SortedMap<String, Set<String>> hashen = ReadMap.hashReader("../TepacDocs/hashmaps/article3_en_hashmap.ser");
		
		SortedMap<String, Set<String>> hashtr = ReadMap.hashReader("../TepacDocs/hashmaps/article3_tr_hashmap.ser");
        
		
		//Intersections
		for (Entry<String, Set<String>> entry: hashen.entrySet()) {

			if (hashtr.containsKey(entry.getKey())){
				System.out.println("Match! : " + entry.getKey() + " - " + entry.getValue());
				//hMap3.put(entry.getKey(), entry.getValue());
			}
		}
		
		
	}
	
}
