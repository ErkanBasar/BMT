package cooccurence;

import java.io.IOException;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import common.PrintMaps;
import common.ReadMaps;

public class HashCombine {
	
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		
		combineHashes();
		
		System.out.println("All hashmaps are combined in totalhash.ser");
		
	}
	
	public static void combineHashes() throws IOException, ClassNotFoundException{
		
		SortedMap<String, HashMap<String, Integer>> ar1entr = ReadMaps.coocHashReader("../TepacDocs/coocurence/maps/article1_en_tr_hashmap_RESULT.ser");

		//SortedMap<String, HashMap<String, Integer>> ar1tren = ReadMaps.coocHashReader("../TepacDocs/coocurence/maps/article1_tr_en_hashmap_RESULT.ser");

		SortedMap<String, HashMap<String, Integer>> ar2entr = ReadMaps.coocHashReader("../TepacDocs/coocurence/maps/article2_en_tr_hashmap_RESULT.ser");

		SortedMap<String, HashMap<String, Integer>> ar2tren = ReadMaps.coocHashReader("../TepacDocs/coocurence/maps/article2_tr_en_hashmap_RESULT.ser");

		SortedMap<String, HashMap<String, Integer>> ar3entr = ReadMaps.coocHashReader("../TepacDocs/coocurence/maps/article3_en_tr_hashmap_RESULT.ser");

		SortedMap<String, HashMap<String, Integer>> ar3tren = ReadMaps.coocHashReader("../TepacDocs/coocurence/maps/article3_tr_en_hashmap_RESULT.ser");

		
		SortedMap<String, HashMap<String, Integer>> totalhash = new TreeMap<String, HashMap<String, Integer>>();
		
		totalhash.putAll(ar1entr);
		//totalhash.putAll(ar1tren);
		totalhash.putAll(ar2entr);
		totalhash.putAll(ar2tren);
		totalhash.putAll(ar3entr);
		totalhash.putAll(ar3tren);
		
		PrintMaps.printCoocMap(totalhash, "../TepacDocs/totalhash.txt", "../TepacDocs/totalhash.ser");
		
		
		System.out.println("All hashmaps are combined in totalhash.ser");
	}

}
