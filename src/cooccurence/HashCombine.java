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
		
		SortedMap<String, HashMap<String, Integer>> ar1entr = ReadMaps.coocHashReader("../BMTDocs/coocurence/maps/article1_en_tr_hashmap_RESULT.ser");

		//SortedMap<String, HashMap<String, Integer>> ar1tren = ReadMaps.coocHashReader("../BMTDocs/coocurence/maps/article1_tr_en_hashmap_RESULT.ser");

		SortedMap<String, HashMap<String, Integer>> ar2entr = ReadMaps.coocHashReader("../BMTDocs/coocurence/maps/article2_en_tr_hashmap_RESULT.ser");

		SortedMap<String, HashMap<String, Integer>> ar2tren = ReadMaps.coocHashReader("../BMTDocs/coocurence/maps/article2_tr_en_hashmap_RESULT.ser");

		SortedMap<String, HashMap<String, Integer>> ar3entr = ReadMaps.coocHashReader("../BMTDocs/coocurence/maps/article3_en_tr_hashmap_RESULT.ser");

		SortedMap<String, HashMap<String, Integer>> ar3tren = ReadMaps.coocHashReader("../BMTDocs/coocurence/maps/article3_tr_en_hashmap_RESULT.ser");

		
		SortedMap<String, HashMap<String, Integer>> totalhash = new TreeMap<String, HashMap<String, Integer>>();
		
		totalhash.putAll(ar1entr);
		//totalhash.putAll(ar1tren);
		totalhash.putAll(ar2entr);
		totalhash.putAll(ar2tren);
		totalhash.putAll(ar3entr);
		totalhash.putAll(ar3tren);
		
		
		String outputfile = "../BMTDocs/totalhash.txt";
		String outputhash = "../BMTDocs/totalhash.ser";
		
		PrintMaps.printCoocMap(totalhash, outputfile, outputhash);
		
		
		System.out.println("All hashmaps are combined in totalhash.ser");
	}

}
